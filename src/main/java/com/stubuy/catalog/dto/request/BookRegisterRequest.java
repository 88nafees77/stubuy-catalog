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

  private Integer universityId;

  private Integer courseId;

  private Integer branchId;

  private String userId;

  private String bookName;

  private Integer bookPrice;

}
