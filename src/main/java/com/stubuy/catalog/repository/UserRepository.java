package com.stubuy.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stubuy.catalog.entity.UserInfo;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {
}
