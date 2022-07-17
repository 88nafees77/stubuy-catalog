package com.stubuy.catalog.service;

import java.util.List;

import com.stubuy.catalog.dto.request.UniversityRegisterRequest;
import com.stubuy.catalog.dto.response.GetAllUniversityResponse;
import com.stubuy.catalog.dto.response.UniversityResponse;

public interface UniversityService {

  UniversityResponse registerUniversity(UniversityRegisterRequest universityRegisterRequest);

  List<GetAllUniversityResponse> getAllUniversities();

  UniversityResponse getUniversityInfo(Integer id);


}
