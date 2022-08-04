package com.stubuy.catalog.dbservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stubuy.catalog.dto.request.UniversityRegisterRequest;
import com.stubuy.catalog.dto.response.GetAllUniversityResponse;
import com.stubuy.catalog.dto.response.UniversityResponse;
import com.stubuy.catalog.entity.UniversityAddressEntity;
import com.stubuy.catalog.entity.UniversityEntity;
import com.stubuy.catalog.repository.UniversityRepository;
import com.stubuy.catalog.utils.EntityToResponseConverter;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UniversityDatabaseServiceImp implements UniversityDatabaseService {

  @Autowired
  private UniversityRepository universityRepository;

  @Override
  public UniversityResponse saveUniversityInfo(
      UniversityRegisterRequest universityRegisterRequest) {
    log.info("request received to saved University info in Database {}",
        universityRegisterRequest.toString());
    UniversityEntity universityEntity = null;
    UniversityAddressEntity universityAddressEntity = null;
    try {
      ModelMapper modelMapper = new ModelMapper();
      universityEntity = modelMapper.map(universityRegisterRequest, UniversityEntity.class);
      universityAddressEntity = modelMapper.map(universityRegisterRequest.getUniversityAddress(),
          UniversityAddressEntity.class);
      universityEntity.setAddressInfo(new ArrayList<>());
      universityEntity.getAddressInfo().add(universityAddressEntity);
      universityAddressEntity.setUniversityEntity(universityEntity);
      universityEntity = universityRepository.save(universityEntity);
      UniversityResponse universityResponse =
          EntityToResponseConverter.universityEntityToUniversityResponse(universityEntity);
      log.info("University Successfully Saved in Database {}", universityResponse);
      return universityResponse;
    } catch (Exception exception) {
      log.info(" failed to saved University records in Database ", exception);
      throw new RuntimeException(exception);
    }

  }

  @Override
  public List<GetAllUniversityResponse> getAllUniversities() {
    log.info("request received to retrieve universities info from database");
    List<GetAllUniversityResponse> universityResponses = new ArrayList<>();
    List<UniversityEntity> universityEntityList = universityRepository.findAll();
    ModelMapper modelMapper = new ModelMapper();
    for (UniversityEntity info : universityEntityList) {
      GetAllUniversityResponse universityResponse =
          modelMapper.map(info, GetAllUniversityResponse.class);
      universityResponse.setUniversityId(info.getUniversity_id());
      universityResponses.add(universityResponse);
    }
    log.info("Successfully retrieve universities info from database");
    return universityResponses;
  }

  @Override
  public UniversityResponse getUniversityInfo(Integer id) throws Exception {
    log.info("request received to retrieve university info from database ", id);
    UniversityResponse universityResponse = null;
    try {
      Optional<UniversityEntity> universityEntity = universityRepository.findById(id);
      universityResponse =
          EntityToResponseConverter.universityEntityToUniversityResponse(universityEntity.get());
    } catch (Exception exception) {
      throw new Exception();
    }
    log.info("Successfully retrieve university info from database", id);
    return universityResponse;
  }
}
