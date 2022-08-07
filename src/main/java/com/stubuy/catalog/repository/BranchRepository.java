package com.stubuy.catalog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stubuy.catalog.entity.BranchEntity;
import com.stubuy.catalog.entity.CourseEntity;

@Repository
public interface BranchRepository extends JpaRepository<BranchEntity, Integer> {
  List<BranchEntity> findByCourseEntity(CourseEntity courseId);
}
