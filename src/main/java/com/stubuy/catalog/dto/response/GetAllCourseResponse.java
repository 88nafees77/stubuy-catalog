package com.stubuy.catalog.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetAllCourseResponse {

  private Integer courseId;

  private Integer universityId;

  private String courseName;

  private UniversityResponse universityResponse;
}
