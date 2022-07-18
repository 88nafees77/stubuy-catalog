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
    logger.info("request received to get all courses ");
    List<GetAllCourseResponse> responses = null;
    try {
      responses = courseDatabaseService.getAllCourse();
    } catch (Exception exception) {
      logger.info("failed to retrieve all courses ", exception);
      return responses;
    }
    return responses;
  }

  @Override
  public CourseResponse getCourseInfo(Integer courseId) {
    logger.info("request received to get course info by id {} ", courseId);
    CourseResponse courseResponse = null;
    try {
      courseResponse = courseDatabaseService.getCourseByID(courseId);
      courseResponse.setResponseCode(200);
      courseResponse.setResponseMessage("Course Info Retrieve Successfully");
    } catch (Exception exception) {
      courseResponse = new CourseResponse();
      courseResponse.setResponseCode(400);
      courseResponse.setResponseMessage("Failed to retrieve course info, course id doesn't exists");
      logger.info("failed to retrieve course info {} ", exception.getMessage());
    }
    return courseResponse;
  }
}
