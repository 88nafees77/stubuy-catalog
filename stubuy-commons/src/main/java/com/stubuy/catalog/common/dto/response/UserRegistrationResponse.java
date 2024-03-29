package com.stubuy.catalog.common.dto.response;

import com.stubuy.catalog.common.dto.response.common.ResponseMessage;

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
public class UserRegistrationResponse extends ResponseMessage {

  private String username;

}
