package com.stubuy.catalog.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stubuy.catalog.dbservice.CourseDatabaseService;
import com.stubuy.catalog.dto.request.CourseRegisterRequest;
import com.stubuy.catalog.dto.response.CourseResponse;
import com.stubuy.catalog.dto.response.GetAllCourseResponse;

@Service
public class CourseServiceImp implements CourseService {

  private final Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  private CourseDatabaseService courseDatabaseService;

  @Override
  public CourseResponse registerCourse(CourseRegisterRequest courseRegisterRequest) {
    logger.info("request received to register course {} ", courseRegisterRequest.toString());
    CourseResponse courseResponse = null;
    try {
      courseResponse = courseDatabaseService.saveCourseInfo(courseRegisterRequest);
    } catch (Exception exception) {
      logger.error("failed to register course ", exception);
      courseResponse = new CourseResponse();
      courseResponse.setResponseCode(404);
      courseResponse.setResponseMessage("Failed to register course");
      return courseResponse;
    }
    courseResponse.setResponseCode(200);
    courseResponse.setResponseMessage("Course Registration Successfully Completed");
    return courseResponse;
  }

  @Override
  public List<GetAllCourseResponse> getAllCourse() {
    List<GetAllCourseResponse> responses = null;
    try {
      responses = courseDatabaseService.getAllCourse();
    } catch (Exception exception) {
      return responses;
    }
    return responses;
  }
}
