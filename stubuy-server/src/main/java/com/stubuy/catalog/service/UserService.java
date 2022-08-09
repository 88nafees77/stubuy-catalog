package com.stubuy.catalog.service;

import com.stubuy.catalog.common.dto.request.UserRegistrationRequest;
import com.stubuy.catalog.common.dto.response.UserRegistrationResponse;

public interface UserService {

  UserRegistrationResponse registerUser(UserRegistrationRequest userRegistrationRequest);
}
