package com.stubuy.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stubuy.catalog.entity.UniversityEntity;

@Repository
public interface UniversityRepository extends JpaRepository<UniversityEntity, Integer> {
	public UniversityEntity findByUniversityId(Integer universityId);
}
