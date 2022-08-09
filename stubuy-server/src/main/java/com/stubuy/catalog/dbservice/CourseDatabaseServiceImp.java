package com.stubuy.catalog.dbservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.stubuy.catalog.common.dto.request.CourseRegisterRequest;
import com.stubuy.catalog.common.dto.response.CourseResponse;
import com.stubuy.catalog.common.dto.response.GetAllCourseResponse;
import com.stubuy.catalog.entity.CourseEntity;
import com.stubuy.catalog.entity.UniversityEntity;
import com.stubuy.catalog.repository.CourseRepository;
import com.stubuy.catalog.utils.EntityToResponseConverter;

@Component
public class CourseDatabaseServiceImp implements CourseDatabaseService {

  private final Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  private CourseRepository courseRepository;

  @Override
  @Transactional
  public CourseResponse saveCourseInfo(CourseRegisterRequest courseRegisterRequest)
      throws Exception {
    CourseEntity courseEntity = new CourseEntity();
    logger.info("request received to save course info into db {} ", courseRegisterRequest);
    try {
      courseEntity.setCourseName(courseRegisterRequest.getCourseName());
      courseEntity.setUniversityEntity(
          UniversityEntity.builder().universityId(courseRegisterRequest.getUniversityId())
              .build());
      courseEntity = courseRepository.save(courseEntity);
      return EntityToResponseConverter.courseEntityToCourseResponse(courseEntity);
    } catch (Exception exception) {
      logger.error("failed to save course info into db {}", exception.getMessage());
      throw exception;
    }
  }

  @Override
  public List<GetAllCourseResponse> getAllCourse() throws Exception {
    try {
      logger.info("request received retrieve all course info from db ");
      List<CourseEntity> courseEntities = courseRepository.findAll();
      List<GetAllCourseResponse> getAllCourseResponses = new ArrayList<>();
      for (CourseEntity course : courseEntities) {
        GetAllCourseResponse response =
            GetAllCourseResponse.builder().courseId(course.getCourseId())
                .courseName(course.getCourseName())
                .universityId(course.getUniversityEntity().getUniversityId())
                .universityName(course.getUniversityEntity().getUniversityName()).build();
        getAllCourseResponses.add(response);
      }
      return getAllCourseResponses;
    } catch (Exception exception) {
      logger.info("failed to retrieve all course info from db ", exception);
      throw new Exception();
    }
  }

  @Override
  public CourseResponse getCourseByID(Integer courseId) {
    logger.info("request received to retrieve course info from db");
    try {
      Optional<CourseEntity> courseEntity = courseRepository.findById(courseId);
      return EntityToResponseConverter.courseEntityToCourseResponse(courseEntity.get());
    } catch (Exception exception) {
      logger.info("failed to retrieve course info from db ", exception.getMessage());
      throw exception;
    }
  }

  @Override
  public List<GetAllCourseResponse> getAllCourseByUID(Integer uid) throws Exception {
    try {
      logger.info("request received to retrieve course info from db by university ID{} ",uid);
      List<CourseEntity> courseEntities = courseRepository.findByUniversityEntity(UniversityEntity.builder().universityId(uid).build());
      List<GetAllCourseResponse> getAllCourseResponses = new ArrayList<>();
      for (CourseEntity course : courseEntities) {
        GetAllCourseResponse response =
            GetAllCourseResponse.builder().courseId(course.getCourseId())
                .courseName(course.getCourseName())
                .universityId(course.getUniversityEntity().getUniversityId())
                .universityName(course.getUniversityEntity().getUniversityName()).build();
        getAllCourseResponses.add(response);
      }
      return getAllCourseResponses;
    } catch (Exception exception) {
      logger.info("failed to retrieve course info from db by university ID {} ", exception,uid);
      throw new Exception();
    }
  }
}
