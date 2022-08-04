package com.stubuy.catalog.dbservice;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.stubuy.catalog.dto.request.UserRegistrationRequest;
import com.stubuy.catalog.dto.response.UserRegistrationResponse;
import com.stubuy.catalog.entity.UserContactEntity;
import com.stubuy.catalog.entity.UserEntity;
import com.stubuy.catalog.repository.UserRepository;

@Component
public class UserDatabaseServiceImp implements UserDatabaseService {

  @Autowired
  private UserRepository userRepository;

  @Override
  @Transactional
  public UserRegistrationResponse registerUser(UserRegistrationRequest userRegistrationRequest) {
    UserEntity userEntity = null;
    UserContactEntity userContactEntity = null;
    UserRegistrationResponse userRegistrationResponse = null;
    List<UserContactEntity> userContactEntityList = new ArrayList<>();
    try {
      userContactEntity =
          UserContactEntity.builder().firstName(userRegistrationRequest.getFirstName())
              .lastName(userRegistrationRequest.getLastName())
              .time(new Timestamp(System.currentTimeMillis()))
              .AddressLine1(userRegistrationRequest.getAddressRequest().getAddressLine1())
              .AddressLine2(userRegistrationRequest.getAddressRequest().getAddressLine2())
              .CityName(userRegistrationRequest.getAddressRequest().getCityName())
              .State(userRegistrationRequest.getAddressRequest().getState())
              .Zipcode(userRegistrationRequest.getAddressRequest().getZipcode())
              .userEntity(userEntity).build();
      userContactEntityList.add(userContactEntity);
      userEntity = UserEntity.builder().email(userRegistrationRequest.getEmailAddress()).password(
              Base64.getEncoder().encodeToString(userRegistrationRequest.getUserPassword().getBytes()))
          .mobileNumber(userRegistrationRequest.getMobileNumber()).isActive(true)
          .contactEntities(userContactEntityList).build();
      userContactEntity.setUserEntity(userEntity);
      userEntity = userRepository.save(userEntity);
      userRegistrationResponse =
          UserRegistrationResponse.builder().username(userEntity.getEmail()).build();
    } catch (Exception exception) {
      throw exception;
    }
    return userRegistrationResponse;
  }
}
