package com.stubuy.catalog.service;

import com.stubuy.catalog.dto.request.UserRegistrationRequest;
import com.stubuy.catalog.dto.response.UserRegistrationResponse;

public interface UserService {

  UserRegistrationResponse registerUser(UserRegistrationRequest userRegistrationRequest);
}
