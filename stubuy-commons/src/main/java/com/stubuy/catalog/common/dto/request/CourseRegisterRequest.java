package com.stubuy.catalog.common.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CourseRegisterRequest {

  private Integer universityId;

  private String courseName;

  @Override
  public String toString() {
    return "CourseRegisterRequest{" + "universityId=" + universityId + ", courseName='" + courseName
        + '\'' + '}';
  }
}
