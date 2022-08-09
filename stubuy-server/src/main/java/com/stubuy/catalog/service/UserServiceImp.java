package com.stubuy.catalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.stubuy.catalog.common.dto.request.UserRegistrationRequest;
import com.stubuy.catalog.common.dto.response.UserRegistrationResponse;
import com.stubuy.catalog.dbservice.UserDatabaseService;

@Service
public class UserServiceImp implements UserService {

  @Autowired
  private UserDatabaseService userDatabaseService;

  @Override
  public UserRegistrationResponse registerUser(UserRegistrationRequest userRegistrationRequest) {
    UserRegistrationResponse userRegistrationResponse = null;
    try {
      userRegistrationResponse = userDatabaseService.registerUser(userRegistrationRequest);
      userRegistrationResponse.setResponseCode(HttpStatus.OK);
      userRegistrationResponse.setResponseMessage("User Registration Successfully Completed");
    } catch (Exception exception) {
      userRegistrationResponse.setResponseCode(HttpStatus.BAD_REQUEST);
      userRegistrationResponse.setResponseMessage("User Registration Failed");
    }
    return userRegistrationResponse;
  }
}
