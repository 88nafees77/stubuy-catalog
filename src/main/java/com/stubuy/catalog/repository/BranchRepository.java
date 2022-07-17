package com.stubuy.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stubuy.catalog.entity.BranchInfo;

@Repository
public interface BranchRepository extends JpaRepository<BranchInfo, String> {

}
