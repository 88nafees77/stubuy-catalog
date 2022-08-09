package com.stubuy.catalog.dbservice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stubuy.catalog.common.dto.request.BranchRegisterRequest;
import com.stubuy.catalog.common.dto.response.BranchResponse;
import com.stubuy.catalog.common.dto.response.GetAllBranchResponse;

@Service
public interface BranchDatabaseService {

  BranchResponse saveBranchInfo(BranchRegisterRequest branchRegisterRequest);

  List<GetAllBranchResponse> getAllBranch();

  List<GetAllBranchResponse> getBranchInfoByCourseId(Integer courseId);
}
