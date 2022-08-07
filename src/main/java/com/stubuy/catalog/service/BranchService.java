package com.stubuy.catalog.service;

import java.util.List;

import com.stubuy.catalog.dto.response.BranchResponse;
import com.stubuy.catalog.dto.request.BranchRegisterRequest;
import com.stubuy.catalog.dto.response.GetAllBranchResponse;

public interface BranchService {

  BranchResponse registerBranch(BranchRegisterRequest branchRegisterRequest);

  List<GetAllBranchResponse> getAllBranch();

  List<GetAllBranchResponse> getBranchInfoByCourseId(Integer courseId);
}
