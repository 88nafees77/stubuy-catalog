package com.stubuy.catalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.stubuy.catalog.common.dto.request.BranchRegisterRequest;
import com.stubuy.catalog.common.dto.response.BranchResponse;
import com.stubuy.catalog.common.dto.response.GetAllBranchResponse;
import com.stubuy.catalog.dbservice.BranchDatabaseService;

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
      response.setResponseCode(HttpStatus.OK);
      response.setResponseMessage("Branch Registration Successfully Completed");
    } catch (Exception exception) {
      log.error("failed to register branch info {} ", exception.getMessage());
      response = new BranchResponse();
      response.setResponseCode(HttpStatus.BAD_REQUEST);
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

  @Override
  public List<GetAllBranchResponse> getBranchInfoByCourseId(Integer courseId) {
    return branchDatabaseService.getBranchInfoByCourseId(courseId);
  }
}
