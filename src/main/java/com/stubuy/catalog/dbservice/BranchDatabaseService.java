package com.stubuy.catalog.dbservice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stubuy.catalog.dto.response.BranchResponse;
import com.stubuy.catalog.dto.request.BranchRegisterRequest;
import com.stubuy.catalog.dto.response.GetAllBranchResponse;

@Service
public interface BranchDatabaseService {

  BranchResponse saveBranchInfo(BranchRegisterRequest branchRegisterRequest);

  List<GetAllBranchResponse> getAllBranch();
}
