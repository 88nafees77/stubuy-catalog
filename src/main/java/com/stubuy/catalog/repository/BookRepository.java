package com.stubuy.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stubuy.catalog.entity.BooksInfo;

@Repository
public interface BookRepository extends JpaRepository<BooksInfo, Long> {
}
