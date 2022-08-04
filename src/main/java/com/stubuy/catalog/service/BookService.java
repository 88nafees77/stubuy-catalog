package com.stubuy.catalog.service;


import com.stubuy.catalog.dto.request.BookRegisterRequest;
import com.stubuy.catalog.dto.response.BookRegisterResponse;

public interface BookService {
  BookRegisterResponse registerBook(BookRegisterRequest bookRegisterRequest);
}
