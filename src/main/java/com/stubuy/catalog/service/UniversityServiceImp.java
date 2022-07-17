package com.stubuy.catalog.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stubuy.catalog.dbservice.UniversityDatabaseService;
import com.stubuy.catalog.dto.request.UniversityRegisterRequest;
import com.stubuy.catalog.dto.response.GetAllUniversityResponse;
import com.stubuy.catalog.dto.response.UniversityResponse;

@Service
public class UniversityServiceImp implements UniversityService {

  private final Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  private UniversityDatabaseService universityDatabaseService;

  @Override
  public UniversityResponse registerUniversity(
      UniversityRegisterRequest universityRegisterRequest) {
    logger.info("request received to register university {} ",
        universityRegisterRequest.toString());
    ModelMapper modelMapper = new ModelMapper();
    UniversityResponse universityResponse = null;
    try {
      universityResponse = universityDatabaseService.saveUniversityInfo(universityRegisterRequest);
    } catch (Exception exception) {
      universityResponse.setResponseCode(404);
      universityResponse.setResponseMessage("University Registration Failed");
      logger.error("Failed to register university {}", exception);
      return universityResponse;
    }
    universityResponse.setResponseCode(200);
    universityResponse.setResponseMessage("University Registration Successfully Completed");
    return universityResponse;
  }

  @Override
  public List<GetAllUniversityResponse> getAllUniversities() {
    logger.info("request received to retrieve all university {}");
    List<GetAllUniversityResponse> getAllUniversityResponses = null;
    try {
      getAllUniversityResponses = universityDatabaseService.getAllUniversities();
    } catch (Exception exception) {
      logger.error("failed to retrieve all university {}", exception);
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
      logger.error("failed to retrieve university {}", exception);
      universityResponse.setResponseCode(404);
      universityResponse.setResponseMessage("Failed To Retrieve University Info");
      return universityResponse;
    }
    universityResponse.setResponseCode(200);
    universityResponse.setResponseMessage("University Retrieve Successfully");
    return universityResponse;
  }

}
