package com.stubuy.catalog;

import java.util.Base64;

import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.stubuy.catalog.dto.request.AddressRequest;
import com.stubuy.catalog.dto.request.UserRegistrationRequest;

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
    UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest();
    userRegistrationRequest.setEmailAddress("contact.nafees12@gamil.com");
    userRegistrationRequest.setFirstName("Nafees");
    userRegistrationRequest.setLastName("Ansari");
    userRegistrationRequest.setUserPassword(
        Base64.getEncoder().encodeToString("nafees@123".getBytes()));
    userRegistrationRequest.setMobileNumber("6393545132");
    userRegistrationRequest.setUniversityName("INTEGRAL UNIVERSITY");
    AddressRequest addressRequest =
        AddressRequest.builder().setAddressLine1("Zamania Dist Ghazipur")
            .setAddressLine2("Near Transformer").setCityName("Ghazipur").setState("uttar pradesh")
            .setZipcode(232329).build();
    userRegistrationRequest.setAddressRequest(addressRequest);
    System.out.println(gson.toJson(userRegistrationRequest));
  }
}
