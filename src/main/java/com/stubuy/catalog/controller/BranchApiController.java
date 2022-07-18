package com.stubuy.catalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class BranchApiController {

  @Autowired
  private BranchService branchService;

  @RequestMapping(value = "/register/branch",
                  method = RequestMethod.POST)
  public BranchResponse registerBranch(
      @RequestBody
          BranchRegisterRequest branchRegisterRequest) {
    return branchService.registerBranch(branchRegisterRequest);
  }

  @RequestMapping(value = "/all/branch",
                  method = RequestMethod.GET)
  public List<GetAllBranchResponse> getAllBranch() {
    return branchService.getAllBranch();
  }

  @RequestMapping(value = "/branch/{id}",
                  method = RequestMethod.GET)
  public BranchResponse getBranchInfo(
      @PathVariable("id")
          Integer courseId) {
    return null;
  }



}
