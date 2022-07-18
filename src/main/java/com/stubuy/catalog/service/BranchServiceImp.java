package com.stubuy.catalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stubuy.catalog.dbservice.BranchDatabaseService;
import com.stubuy.catalog.dto.request.BranchRegisterRequest;
import com.stubuy.catalog.dto.response.BranchResponse;
import com.stubuy.catalog.dto.response.GetAllBranchResponse;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BranchServiceImp implements BranchService {

  @Autowired
  private BranchDatabaseService branchDatabaseService;

  @Override
  public BranchResponse registerBranch(BranchRegisterRequest branchRegisterRequest) {
    BranchResponse response = null;
    try {
      response = branchDatabaseService.saveBranchInfo(branchRegisterRequest);
      response.setResponseCode(200);
      response.setResponseMessage("Branch Registration Successfully Completed");
    } catch (Exception exception) {
      log.error("failed to register branch info {} ", exception.getMessage());
      response = new BranchResponse();
      response.setResponseCode(400);
      response.setResponseMessage("Failed to Register Branch Info");
    }
    return response;
  }

  @Override
  public List<GetAllBranchResponse> getAllBranch() {
    List<GetAllBranchResponse> responses = null;
    try {
      responses = branchDatabaseService.getAllBranch();
    } catch (Exception exception) {
      log.error("failed to retrieve all branch info {} ", exception.getMessage());
    }
    return responses;
  }
}
