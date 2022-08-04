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
public class BookRegisterRequest {

  private String universityID;

  private String courseID;

  private String branchID;

  private String bookName;

  private Integer bookPrice;

}
