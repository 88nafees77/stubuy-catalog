package com.stubuy.catalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stubuy.catalog.dto.request.CourseRegisterRequest;
import com.stubuy.catalog.dto.response.CourseResponse;
import com.stubuy.catalog.dto.response.GetAllCourseResponse;
import com.stubuy.catalog.service.CourseService;

@RestController
@CrossOrigin("*")
public class CourseApiController {

  @Autowired
  private CourseService courseService;

  @RequestMapping(value = "/register/course",
                  method = RequestMethod.POST)
  public ResponseEntity<CourseResponse> registerCourse(
      @RequestBody
          CourseRegisterRequest courseRegisterRequest) {
    CourseResponse courseResponse = courseService.registerCourse(courseRegisterRequest);
    return new ResponseEntity<>(courseResponse, courseResponse.getResponseCode());
  }

  @RequestMapping(value = "/all/course",
                  method = RequestMethod.GET)
  public List<GetAllCourseResponse> getAllCourse() {
    return courseService.getAllCourse();
  }

  @RequestMapping(value = "/get/course/{courseID}",
                  method = RequestMethod.GET)
  public CourseResponse getCourseInfo(
      @PathVariable("courseID")
          Integer courseId) {
    return courseService.getCourseInfo(courseId);
  }

  @RequestMapping(value = "/course/{universityID}",
                  method = RequestMethod.GET)
  public List<GetAllCourseResponse> getCourseInfoByUniversity(
      @PathVariable("universityID")
          Integer universityID) {
    return courseService.getCourseInfoByUniversity(universityID);
  }


}

