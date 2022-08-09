package com.stubuy.catalog.common.dto.request;

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
public class UserRegistrationRequest {

  private String emailAddress;
  private String userPassword;

  private String firstName;

  private String lastName;

  private String mobileNumber;

  private String universityName;

  private AddressRequest addressRequest;

}
