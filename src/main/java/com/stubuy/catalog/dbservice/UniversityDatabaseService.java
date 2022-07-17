package com.stubuy.catalog.dbservice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stubuy.catalog.dto.request.UniversityRegisterRequest;
import com.stubuy.catalog.dto.response.GetAllUniversityResponse;
import com.stubuy.catalog.dto.response.UniversityResponse;

@Service
public interface UniversityDatabaseService {

  UniversityResponse saveUniversityInfo(UniversityRegisterRequest universityRegisterRequest)
      throws Exception;

  List<GetAllUniversityResponse> getAllUniversities();

  UniversityResponse getUniversityInfo(Integer id) throws Exception;
}
