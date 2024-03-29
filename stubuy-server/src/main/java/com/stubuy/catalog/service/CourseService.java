package com.stubuy.catalog.service;

import java.util.List;

import com.stubuy.catalog.common.dto.request.CourseRegisterRequest;
import com.stubuy.catalog.common.dto.response.CourseResponse;
import com.stubuy.catalog.common.dto.response.GetAllCourseResponse;

public interface CourseService {

  CourseResponse registerCourse(CourseRegisterRequest courseRegisterRequest);

  List<GetAllCourseResponse> getAllCourse();

  CourseResponse getCourseInfo(Integer courseId);

  List<GetAllCourseResponse> getCourseInfoByUniversity(Integer uid);
}
