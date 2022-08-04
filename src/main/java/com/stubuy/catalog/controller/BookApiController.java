package com.stubuy.catalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stubuy.catalog.dto.request.BookRegisterRequest;
import com.stubuy.catalog.dto.response.BookRegisterResponse;
import com.stubuy.catalog.service.BookService;


@RestController
public class BookApiController {

  @Autowired
  private BookService bookService;

  @RequestMapping(value = "/upload/book",
                  method = RequestMethod.POST)
  public BookRegisterResponse registerBook(
      @RequestBody
          BookRegisterRequest bookRegisterRequest) {
    BookRegisterResponse bookRegisterResponse = bookService.registerBook(bookRegisterRequest);
    return bookRegisterResponse;
  }

}
