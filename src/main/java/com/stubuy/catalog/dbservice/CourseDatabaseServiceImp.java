package com.stubuy.catalog.dbservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stubuy.catalog.dto.request.CourseRegisterRequest;
import com.stubuy.catalog.dto.response.CourseResponse;
import com.stubuy.catalog.dto.response.GetAllCourseResponse;
import com.stubuy.catalog.dto.response.UniversityResponse;
import com.stubuy.catalog.entity.CourseEntity;
import com.stubuy.catalog.entity.UniversityEntity;
import com.stubuy.catalog.repository.CourseRepository;
import com.stubuy.catalog.service.UniversityService;

@Component
public class CourseDatabaseServiceImp implements CourseDatabaseService {

  @Autowired
  private UniversityService universityService;

  @Autowired
  private CourseRepository courseRepository;

  @Override
  public CourseResponse saveCourseInfo(CourseRegisterRequest courseRegisterRequest)
      throws Exception {
    CourseEntity courseEntity = new CourseEntity();
    try {
      courseEntity.setCourseName(courseRegisterRequest.getCourseName());
      UniversityResponse universityResponse =
          universityService.getUniversityInfo(courseRegisterRequest.getUniversityId());
      UniversityEntity universityEntity =
          UniversityEntity.builder().university_id(universityResponse.getUniversityId())
              .universityName(universityResponse.getUniversityName())
              .courseEntities(Arrays.asList(courseEntity)).addressInfo(null).build();
      courseEntity.setUniversityEntity(universityEntity);
      CourseEntity courseSaved = courseRepository.save(courseEntity);
      CourseResponse courseResponse = CourseResponse.builder().courseId(courseSaved.getCourseId())
          .universityId(universityEntity.getUniversity_id()).courseName(courseSaved.getCourseName())
          .build();
      return courseResponse;
    } catch (Exception exception) {
      throw new Exception();
    }
  }

  @Override
  public List<GetAllCourseResponse> getAllCourse() throws Exception {
    try {
      List<CourseEntity> courseEntities = courseRepository.findAll();
      List<GetAllCourseResponse> getAllCourseResponses = new ArrayList<>();
      for (CourseEntity course : courseEntities) {
        GetAllCourseResponse getAllCourseResponse =
            GetAllCourseResponse.builder().courseId(course.getCourseId())
                .courseName(course.getCourseName())
                .universityId(course.getUniversityEntity().getUniversity_id()).build();
        getAllCourseResponses.add(getAllCourseResponse);
      }
      return getAllCourseResponses;
    } catch (Exception exception) {
      throw new Exception();
    }
  }
}
