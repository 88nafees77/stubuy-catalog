package com.stubuy.catalog.utils;

import java.util.ArrayList;
import java.util.List;

import com.stubuy.catalog.dto.response.BranchResponse;
import com.stubuy.catalog.dto.request.UniversityAddress;
import com.stubuy.catalog.dto.response.CourseResponse;
import com.stubuy.catalog.dto.response.UniversityResponse;
import com.stubuy.catalog.entity.BranchEntity;
import com.stubuy.catalog.entity.CourseEntity;
import com.stubuy.catalog.entity.UniversityAddressEntity;
import com.stubuy.catalog.entity.UniversityEntity;

public class EntityToResponseConverter {

  public static UniversityResponse universityEntityToUniversityResponse(
      UniversityEntity universityEntity) {
    List<UniversityAddress> universityAddressList = new ArrayList<>();
    for (UniversityAddressEntity addressEntity : universityEntity.getAddressInfo()) {
      UniversityAddress universityAddress =
          UniversityAddress.builder().setAddressLine1(addressEntity.getAddressLine1())
              .setAddressLine2(addressEntity.getAddressLine2())
              .setCityName(addressEntity.getCityName()).setState(addressEntity.getState())
              .setZipcode(addressEntity.getZipcode()).build();
      universityAddressList.add(universityAddress);
    }
    return UniversityResponse.builder().setUniversityId(universityEntity.getUniversity_id())
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



