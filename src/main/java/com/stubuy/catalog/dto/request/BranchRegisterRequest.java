package com.stubuy.catalog.dto.request;

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
public class BranchRegisterRequest {

  private Integer universityId;

  private Integer courseId;

  private String branchName;

}
