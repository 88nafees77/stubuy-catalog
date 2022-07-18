package com.stubuy.catalog.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stubuy.catalog.dbservice.UniversityDatabaseService;
import com.stubuy.catalog.dto.request.UniversityRegisterRequest;
import com.stubuy.catalog.dto.response.GetAllUniversityResponse;
import com.stubuy.catalog.dto.response.UniversityResponse;

import brave.ScopedSpan;
import brave.Tracer;
import brave.Tracing;

@Service
public class UniversityServiceImp implements UniversityService {

  private final Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  private UniversityDatabaseService universityDatabaseService;

  @Override
  public UniversityResponse registerUniversity(
      UniversityRegisterRequest universityRegisterRequest) {
    Tracer tracer = Tracing.currentTracer();
    ScopedSpan scopedSpan = tracer.startScopedSpan("service");
    logger.info("request received to register university {} ", universityRegisterRequest);
    UniversityResponse universityResponse = null;
    try {
      universityResponse = universityDatabaseService.saveUniversityInfo(universityRegisterRequest);
      scopedSpan.tag("response", universityResponse.toString());
    } catch (Exception exception) {
      assert false;
      universityResponse.setResponseCode(404);
      universityResponse.setResponseMessage("University Registration Failed");
      logger.error("Failed to register university {}", exception.getMessage());
      return universityResponse;
    }
    universityResponse.setResponseCode(200);
    universityResponse.setResponseMessage("University Registration Successfully Completed");
    scopedSpan.finish();
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
      universityResponse.setResponseCode(404);
      universityResponse.setResponseMessage("Failed To Retrieve University Info");
      return universityResponse;
    }
    universityResponse.setResponseCode(200);
    universityResponse.setResponseMessage("University Retrieve Successfully");
    return universityResponse;
  }

}
