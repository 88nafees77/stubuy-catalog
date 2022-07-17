package com.stubuy.catalog.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CourseRegisterRequest {

  private Integer courseId;

  private Integer universityId;

  private String courseName;

  @Override
  public String toString() {
    return "CourseRegisterRequest{" + "courseId=" + courseId + ", universityId=" + universityId
        + ", courseName='" + courseName + '\'' + '}';
  }
}
