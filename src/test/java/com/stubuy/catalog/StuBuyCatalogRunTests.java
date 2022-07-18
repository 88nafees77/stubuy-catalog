package com.stubuy.catalog;

import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.stubuy.catalog.dto.request.BranchRegisterRequest;

//@SpringBootTest(classes = {StuBuyCatalogRun.class})
class StuBuyCatalogRunTests {

  //  @Autowired
  //  UniversityRepository universityRepository;
  //  @Autowired
  //  CourseRepository courseRepository;
  //  @Autowired
  //  BranchRepository branchRepository;

  @Test
  void generateJSON() {
    Gson gson = new Gson();
    BranchRegisterRequest branchRegisterRequest =
        BranchRegisterRequest.builder().courseId(6).universityId(1).branchName("CSE").build();

    System.out.println(gson.toJson(branchRegisterRequest));
  }
}
