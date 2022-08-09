package com.stubuy.catalog.service;

import java.util.List;

import com.stubuy.catalog.common.dto.request.BranchRegisterRequest;
import com.stubuy.catalog.common.dto.response.BranchResponse;
import com.stubuy.catalog.common.dto.response.GetAllBranchResponse;

public interface BranchService {

  BranchResponse registerBranch(BranchRegisterRequest branchRegisterRequest);

  List<GetAllBranchResponse> getAllBranch();

  List<GetAllBranchResponse> getBranchInfoByCourseId(Integer courseId);
}
