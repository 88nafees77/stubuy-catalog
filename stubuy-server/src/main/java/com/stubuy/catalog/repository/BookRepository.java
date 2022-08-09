package com.stubuy.catalog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stubuy.catalog.entity.BooksEntity;
import com.stubuy.catalog.entity.BranchEntity;

@Repository
public interface BookRepository extends JpaRepository<BooksEntity, Integer> {
  List<BooksEntity> findByBranchEntity(BranchEntity branchId);
}
