package com.stubuy.catalog.dbservice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stubuy.catalog.common.dto.request.BookRegisterRequest;
import com.stubuy.catalog.common.dto.response.BookRegisterResponse;
import com.stubuy.catalog.common.dto.response.BookResponse;


@Service
public interface BookDatabaseService {
  BookRegisterResponse registerBook(BookRegisterRequest bookRegisterRequest);

  List<BookResponse> getBooksByUniversity(Integer universityId);

  List<BookResponse> getBooksByCourse(Integer courseId);

  List<BookResponse> getBooksByBranch(Integer branchId);
}
