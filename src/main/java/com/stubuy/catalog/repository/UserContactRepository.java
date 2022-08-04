package com.stubuy.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stubuy.catalog.entity.UserContactEntity;

@Repository
public interface UserContactRepository extends JpaRepository<UserContactEntity, Integer> {
}
