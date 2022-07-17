package com.stubuy.catalog;

import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.stubuy.catalog.dto.request.CourseRegisterRequest;

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
    CourseRegisterRequest courseRegisterRequest =
        CourseRegisterRequest.builder().courseName("B-Tech").universityId(1).build();

    System.out.println(gson.toJson(courseRegisterRequest));
  }
}
