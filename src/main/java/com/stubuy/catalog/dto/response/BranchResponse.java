package com.stubuy.catalog.dto.response;

import com.stubuy.catalog.dto.response.common.ResponseMessage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BranchResponse extends ResponseMessage {

  private Integer branch_id;
  private String branch_Name;

}
