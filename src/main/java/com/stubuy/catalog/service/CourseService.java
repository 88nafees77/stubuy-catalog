package com.stubuy.catalog.service;

import java.util.List;

import com.stubuy.catalog.dto.request.CourseRegisterRequest;
import com.stubuy.catalog.dto.response.CourseResponse;
import com.stubuy.catalog.dto.response.GetAllCourseResponse;

public interface CourseService {

  CourseResponse registerCourse(CourseRegisterRequest courseRegisterRequest);

  List<GetAllCourseResponse> getAllCourse();
}
