package com.stubuy.catalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stubuy.catalog.dto.request.UserRegistrationRequest;
import com.stubuy.catalog.dto.response.UserRegistrationResponse;
import com.stubuy.catalog.service.UserService;

@RestController
@CrossOrigin("*")
public class UserApiController {

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/user/register",
                  method = RequestMethod.POST)
  public ResponseEntity<UserRegistrationResponse> registerUser(
      @RequestBody
          UserRegistrationRequest userRegistrationRequest) {
    UserRegistrationResponse userRegistrationResponse =
        userService.registerUser(userRegistrationRequest);
    return new ResponseEntity<>(userRegistrationResponse,
        userRegistrationResponse.getResponseCode());
  }
}
