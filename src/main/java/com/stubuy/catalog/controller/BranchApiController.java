package com.stubuy.catalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stubuy.catalog.dto.request.BranchRegisterRequest;
import com.stubuy.catalog.dto.response.BranchResponse;
import com.stubuy.catalog.dto.response.GetAllBranchResponse;
import com.stubuy.catalog.service.BranchService;

@RestController
@CrossOrigin("*")
public class BranchApiController {

  @Autowired
  private BranchService branchService;

  @RequestMapping(value = "/register/branch",
                  method = RequestMethod.POST)
  public ResponseEntity<BranchResponse> registerBranch(
      @RequestBody
          BranchRegisterRequest branchRegisterRequest) {
    BranchResponse branchResponse = branchService.registerBranch(branchRegisterRequest);
    return new ResponseEntity<>(branchResponse, branchResponse.getResponseCode());
  }

  @RequestMapping(value = "/all/branch",
                  method = RequestMethod.GET)
  public List<GetAllBranchResponse> getAllBranch() {
    return branchService.getAllBranch();
  }

  @RequestMapping(value = "/branch/{branchId}",
                  method = RequestMethod.GET)
  public BranchResponse getBranchInfo(
      @PathVariable("branchId")
          Integer branchId) {
    return null;
  }

  @RequestMapping(value = "/branch/course/{courseId}",
                  method = RequestMethod.GET)
  public List<GetAllBranchResponse> getAllBranchByCourse(
      @PathVariable("courseId")
          Integer courseId) {
    return branchService.getBranchInfoByCourseId(courseId);
  }



}
