package com.stubuy.catalog.dbservice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stubuy.catalog.common.dto.request.CourseRegisterRequest;
import com.stubuy.catalog.common.dto.response.CourseResponse;
import com.stubuy.catalog.common.dto.response.GetAllCourseResponse;

@Service
public interface CourseDatabaseService {
  CourseResponse saveCourseInfo(CourseRegisterRequest courseRegisterRequest) throws Exception;

  List<GetAllCourseResponse> getAllCourse() throws Exception;

  CourseResponse getCourseByID(Integer courseId);

  List<GetAllCourseResponse> getAllCourseByUID(Integer uid) throws Exception;
}
