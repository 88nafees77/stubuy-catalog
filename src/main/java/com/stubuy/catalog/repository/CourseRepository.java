package com.stubuy.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stubuy.catalog.entity.CourseInfo;

@Repository
public interface CourseRepository extends JpaRepository<CourseInfo, Integer> {
}
