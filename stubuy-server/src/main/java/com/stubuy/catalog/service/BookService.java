package com.stubuy.catalog.service;


import java.util.List;

import com.stubuy.catalog.common.dto.request.BookRegisterRequest;
import com.stubuy.catalog.common.dto.response.BookRegisterResponse;
import com.stubuy.catalog.common.dto.response.BookResponse;

public interface BookService {

  BookRegisterResponse registerBook(BookRegisterRequest bookRegisterRequest);

  List<BookResponse> getBooksByUniversity(Integer universityId);

  List<BookResponse> getBooksByCourse(Integer courseId);

  List<BookResponse> getBooksByBranch(Integer branchId);
}
