package com.stubuy.catalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class CourseApiController {

  @Autowired
  private CourseService courseService;

  @RequestMapping(value = "/register/course",
                  method = RequestMethod.POST)
  public CourseResponse registerCourse(
      @RequestBody
          CourseRegisterRequest courseRegisterRequest) {
    return courseService.registerCourse(courseRegisterRequest);
  }

  @RequestMapping(value = "/all/course",
                  method = RequestMethod.GET)
  public List<GetAllCourseResponse> getAllCourse() {
    return courseService.getAllCourse();
  }

  @RequestMapping(value = "/course/{cid}",
                  method = RequestMethod.GET)
  public CourseResponse getCourseInfo(
      @PathVariable("cid")
          Integer courseId) {
    return courseService.getCourseInfo(courseId);
  }



}

