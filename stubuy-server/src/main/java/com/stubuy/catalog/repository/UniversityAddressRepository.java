package com.stubuy.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stubuy.catalog.entity.UniversityAddressEntity;

public interface UniversityAddressRepository extends JpaRepository<UniversityAddressEntity, Integer> {
}
