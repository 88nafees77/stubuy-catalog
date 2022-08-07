package com.stubuy.catalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stubuy.catalog.dbservice.BookDatabaseService;
import com.stubuy.catalog.dto.request.BookRegisterRequest;
import com.stubuy.catalog.dto.response.BookRegisterResponse;
import com.stubuy.catalog.dto.response.BookResponse;

@Component
public class BookServiceImp implements BookService {

  @Autowired
  private BookDatabaseService bookDatabaseService;

  @Override
  public BookRegisterResponse registerBook(BookRegisterRequest bookRegisterRequest) {
    BookRegisterResponse bookRegisterResponse =
        bookDatabaseService.registerBook(bookRegisterRequest);
    return bookRegisterResponse;
  }

  @Override
  public List<BookResponse> getBooksByUniversity(Integer universityId) {
    return bookDatabaseService.getBooksByUniversity(universityId);
  }

  @Override
  public List<BookResponse> getBooksByCourse(Integer courseId) {
    return null;
  }

  @Override
  public List<BookResponse> getBooksByBranch(Integer branchId) {
    return null;
  }
}
