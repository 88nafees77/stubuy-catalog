package com.stubuy.catalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stubuy.catalog.common.dto.request.BookRegisterRequest;
import com.stubuy.catalog.common.dto.response.BookRegisterResponse;
import com.stubuy.catalog.common.dto.response.BookResponse;
import com.stubuy.catalog.service.BookService;


@RestController
@CrossOrigin("*")
public class BookApiController {

  @Autowired
  private BookService bookService;

  @RequestMapping(value = "/register/book",
                  method = RequestMethod.POST)
  public BookRegisterResponse registerBook(
      @RequestBody
          BookRegisterRequest bookRegisterRequest) {
    BookRegisterResponse bookRegisterResponse = bookService.registerBook(bookRegisterRequest);
    return bookRegisterResponse;
  }

  @RequestMapping(value = "university/books/{universityId}")
  public List<BookResponse> getBooksByUniversity(
      @PathVariable
          Integer universityId) {
    return bookService.getBooksByUniversity(universityId);
  }

  @RequestMapping(value = "/course/books/{courseId}")
  public List<BookResponse> getBooksByCourse(
      @PathVariable("courseId")
          Integer courseId) {
    bookService.getBooksByCourse(courseId);
    return null;
  }

  @RequestMapping(value = "/branch/books/{branchId}")
  public List<BookResponse> getBooksByBranch(
      @PathVariable("branchId")
          Integer branchId) {
    bookService.getBooksByBranch(branchId);
    return null;
  }

}
