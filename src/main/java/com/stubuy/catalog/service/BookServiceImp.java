package com.stubuy.catalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stubuy.catalog.dbservice.BookDatabaseService;
import com.stubuy.catalog.dto.request.BookRegisterRequest;
import com.stubuy.catalog.dto.response.BookRegisterResponse;

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
}
