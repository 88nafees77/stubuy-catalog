package com.stubuy.catalog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stubuy.catalog.entity.CourseEntity;
import com.stubuy.catalog.entity.UniversityEntity;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {
  List<CourseEntity> findByUniversityEntity(UniversityEntity uid);
}
