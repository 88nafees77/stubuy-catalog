package com.stubuy.catalog.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.stubuy.catalog.common.dto.request.UniversityRegisterRequest;
import com.stubuy.catalog.common.dto.response.GetAllUniversityResponse;
import com.stubuy.catalog.common.dto.response.UniversityResponse;
import com.stubuy.catalog.dbservice.UniversityDatabaseService;


@Service
public class UniversityServiceImp implements UniversityService {

  private final Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  private UniversityDatabaseService universityDatabaseService;

  @Override
  public UniversityResponse registerUniversity(
      UniversityRegisterRequest universityRegisterRequest) {
    logger.info("request received to register university {} ", universityRegisterRequest);
    UniversityResponse universityResponse = null;
    try {
      universityResponse = universityDatabaseService.saveUniversityInfo(universityRegisterRequest);
    } catch (Exception exception) {
      assert false;
      universityResponse.setResponseCode(HttpStatus.BAD_REQUEST);
      universityResponse.setResponseMessage("University Registration Failed");
      logger.error("Failed to register university {}", exception.getMessage());
      return universityResponse;
    }
    universityResponse.setResponseCode(HttpStatus.OK);
    universityResponse.setResponseMessage("University Registration Successfully Completed");
    return universityResponse;
  }

  @Override
  public List<GetAllUniversityResponse> getAllUniversities() {
    logger.info("request received to retrieve all university");
    List<GetAllUniversityResponse> getAllUniversityResponses = null;
    try {
      getAllUniversityResponses = universityDatabaseService.getAllUniversities();
    } catch (Exception exception) {
      logger.error("failed to retrieve all university {}", exception.getMessage());
    }
    return getAllUniversityResponses;
  }

  @Override
  public UniversityResponse getUniversityInfo(Integer id) {
    logger.info("request received to retrieve university by id {} ", id);
    UniversityResponse universityResponse = null;
    try {
      universityResponse = universityDatabaseService.getUniversityInfo(id);
    } catch (Exception exception) {
      universityResponse = new UniversityResponse();
      logger.error("failed to retrieve university {}", exception.getMessage());
      universityResponse.setResponseCode(HttpStatus.BAD_REQUEST);
      universityResponse.setResponseMessage("Failed To Retrieve University Info");
      return universityResponse;
    }
    universityResponse.setResponseCode(HttpStatus.OK);
    universityResponse.setResponseMessage("University Retrieve Successfully");
    return universityResponse;
  }

}
