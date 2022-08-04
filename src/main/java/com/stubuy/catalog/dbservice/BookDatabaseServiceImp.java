package com.stubuy.catalog.dbservice;


import org.springframework.stereotype.Component;

import com.stubuy.catalog.dto.request.BookRegisterRequest;
import com.stubuy.catalog.dto.response.BookRegisterResponse;

@Component
public class BookDatabaseServiceImp implements BookDatabaseService {

  @Override
  public BookRegisterResponse registerBook(BookRegisterRequest bookRegisterRequest) {
    return null;
  }
}
