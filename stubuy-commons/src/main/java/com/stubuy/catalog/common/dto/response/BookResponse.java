package com.stubuy.catalog.common.dto.response;

import com.stubuy.catalog.common.dto.response.common.ResponseMessage;

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
public class BookResponse extends ResponseMessage {

  private Integer bookId;

  private String branchName;


}
