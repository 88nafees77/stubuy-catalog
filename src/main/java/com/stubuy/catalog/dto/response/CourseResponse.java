package com.stubuy.catalog.dto.response;

import com.stubuy.catalog.dto.response.common.ResponseMessage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseResponse extends ResponseMessage {

  private Integer courseId;

  private Integer universityId;

  private String courseName;

}
