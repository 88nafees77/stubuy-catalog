package com.stubuy.catalog.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stubuy.catalog.dto.request.UniversityRegisterRequest;
import com.stubuy.catalog.dto.response.GetAllUniversityResponse;
import com.stubuy.catalog.dto.response.UniversityResponse;
import com.stubuy.catalog.service.UniversityService;

@RestController
@CrossOrigin("*")
public class UniversityApiController {

  private final Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  private UniversityService universityService;

  @RequestMapping(value = "/register/university",
                  method = RequestMethod.POST)
  public ResponseEntity<UniversityResponse> registerUniversity(
      @RequestBody
          UniversityRegisterRequest universityRegisterRequest) {
    UniversityResponse universityResponse =
        universityService.registerUniversity(universityRegisterRequest);
    return new ResponseEntity<>(universityResponse, universityResponse.getResponseCode());
  }

  @RequestMapping(value = "/all/university",
                  method = RequestMethod.GET)
  public List<GetAllUniversityResponse> getAllUniversities() {
    return universityService.getAllUniversities();
  }

  @RequestMapping(value = "/university/{id}",
                  method = RequestMethod.GET)
  public UniversityResponse getUniversityInfo(
      @PathVariable("id")
          Integer id) {
    return universityService.getUniversityInfo(id);
  }


}
