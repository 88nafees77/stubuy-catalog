package com.stubuy.catalog.utils;

import java.util.ArrayList;
import java.util.List;

import com.stubuy.catalog.common.dto.request.AddressRequest;
import com.stubuy.catalog.common.dto.response.BranchResponse;
import com.stubuy.catalog.common.dto.response.CourseResponse;
import com.stubuy.catalog.common.dto.response.UniversityResponse;
import com.stubuy.catalog.entity.BranchEntity;
import com.stubuy.catalog.entity.CourseEntity;
import com.stubuy.catalog.entity.UniversityAddressEntity;
import com.stubuy.catalog.entity.UniversityEntity;

public class EntityToResponseConverter {

  public static UniversityResponse universityEntityToUniversityResponse(
      UniversityEntity universityEntity) {
    List<AddressRequest> universityAddressList = new ArrayList<>();
    for (UniversityAddressEntity addressEntity : universityEntity.getAddressInfo()) {
      AddressRequest universityAddress =
          AddressRequest.builder().setAddressLine1(addressEntity.getAddressLine1())
              .setAddressLine2(addressEntity.getAddressLine2())
              .setCityName(addressEntity.getCityName()).setState(addressEntity.getState())
              .setZipcode(addressEntity.getZipcode()).build();
      universityAddressList.add(universityAddress);
    }
    return UniversityResponse.builder().setUniversityId(universityEntity.getUniversityId())
        .setUniversityName(universityEntity.getUniversityName())
        .setUniversityAddress(universityAddressList).build();
  }

  public static CourseResponse courseEntityToCourseResponse(CourseEntity courseEntity) {
    return CourseResponse.builder().courseId(courseEntity.getCourseId())
        .courseName(courseEntity.getCourseName()).build();
  }

  public static BranchResponse branchEntityToBranchResponse(BranchEntity branchEntity) {
    return BranchResponse.builder().branch_id(branchEntity.getBranchId())
        .branch_Name(branchEntity.getBranch_Name()).build();
  }
}



