package com.stubuy.catalog.dbservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stubuy.catalog.dto.request.UniversityAddress;
import com.stubuy.catalog.dto.request.UniversityRegisterRequest;
import com.stubuy.catalog.dto.response.GetAllUniversityResponse;
import com.stubuy.catalog.dto.response.UniversityResponse;
import com.stubuy.catalog.entity.UniversityAddressEntity;
import com.stubuy.catalog.entity.UniversityEntity;
import com.stubuy.catalog.repository.UniversityRepository;

@Component
public class UniversityDatabaseServiceImp implements UniversityDatabaseService {

  private final Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  private UniversityRepository universityRepository;

  @Override
  public UniversityResponse saveUniversityInfo(UniversityRegisterRequest universityRegisterRequest)
      throws Exception {
    logger.info("request received to saved University info in Database {}",
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
      UniversityAddress universityAddress = UniversityAddress.builder()
          .setAddressLine1(universityEntity.getAddressInfo().get(0).getAddressLine1())
          .setAddressLine2(universityEntity.getAddressInfo().get(0).getAddressLine2())
          .setCityName(universityEntity.getAddressInfo().get(0).getCityName())
          .setState(universityEntity.getAddressInfo().get(0).getState())
          .setZipcode(universityEntity.getAddressInfo().get(0).getZipcode()).build();
      List<UniversityAddress> universityAddressList = new ArrayList<>();
      universityAddressList.add(universityAddress);
      UniversityResponse universityResponse =
          UniversityResponse.builder().setUniversityId(universityEntity.getUniversity_id())
              .setUniversityName(universityEntity.getUniversityName())
              .setUniversityAddress(universityAddressList).build();
      logger.info("University Successfully Saved in Database {}", universityResponse);
      return universityResponse;
    } catch (Exception exception) {
      logger.info(" failed to saved University records in Database {}", exception);
      throw new Exception();
    }
  }

  @Override
  public List<GetAllUniversityResponse> getAllUniversities() {
    logger.info("request received to retrieve universities info from database");
    List<GetAllUniversityResponse> universityResponses = new ArrayList<>();
    List<UniversityEntity> universityEntityList = universityRepository.findAll();
    ModelMapper modelMapper = new ModelMapper();
    for (UniversityEntity info : universityEntityList) {
      GetAllUniversityResponse universityResponse =
          modelMapper.map(info, GetAllUniversityResponse.class);
      universityResponse.setUniversityId(info.getUniversity_id());
      universityResponses.add(universityResponse);
    }
    logger.info("Successfully retrieve universities info from database");
    return universityResponses;
  }

  @Override
  public UniversityResponse getUniversityInfo(Integer id) {
    logger.info("request received to retrieve university info from database ", id);
    Optional<UniversityEntity> universityEntity = universityRepository.findById(id);
    List<UniversityAddressEntity> universityAddressEntities =
        universityEntity.get().getAddressInfo();
    List<UniversityAddress> universityAddresses = new ArrayList<>();
    for (UniversityAddressEntity universityAddressEntity : universityAddressEntities) {
      UniversityAddress universityAddress =
          UniversityAddress.builder().setAddressLine1(universityAddressEntity.getAddressLine1())
              .setAddressLine2(universityAddressEntity.getAddressLine2())
              .setCityName(universityAddressEntity.getCityName())
              .setState(universityAddressEntity.getState())
              .setZipcode(universityAddressEntity.getZipcode()).build();
      universityAddresses.add(universityAddress);
    }
    UniversityResponse universityResponse =
        UniversityResponse.builder().setUniversityId(universityEntity.get().getUniversity_id())
            .setUniversityName(universityEntity.get().getUniversityName())
            .setUniversityAddress(universityAddresses).build();
    logger.info("Successfully retrieve university info from database", id);
    return universityResponse;
  }
}
