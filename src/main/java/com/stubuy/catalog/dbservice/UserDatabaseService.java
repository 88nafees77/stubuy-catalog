package com.stubuy.catalog.dbservice;

import org.springframework.stereotype.Service;

import com.stubuy.catalog.dto.request.UserRegistrationRequest;
import com.stubuy.catalog.dto.response.UserRegistrationResponse;

@Service
public interface UserDatabaseService {
  UserRegistrationResponse registerUser(UserRegistrationRequest userRegistrationRequest);
}
