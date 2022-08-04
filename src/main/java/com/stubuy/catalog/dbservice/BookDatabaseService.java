package com.stubuy.catalog.dbservice;

import org.springframework.stereotype.Service;

import com.stubuy.catalog.dto.request.BookRegisterRequest;
import com.stubuy.catalog.dto.response.BookRegisterResponse;


@Service
public interface BookDatabaseService {
  BookRegisterResponse registerBook(BookRegisterRequest bookRegisterRequest);
}
