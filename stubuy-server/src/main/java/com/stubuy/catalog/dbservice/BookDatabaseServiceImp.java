package com.stubuy.catalog.dbservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stubuy.catalog.common.dto.request.BookRegisterRequest;
import com.stubuy.catalog.common.dto.response.BookRegisterResponse;
import com.stubuy.catalog.common.dto.response.BookResponse;
import com.stubuy.catalog.entity.BooksEntity;
import com.stubuy.catalog.entity.BranchEntity;
import com.stubuy.catalog.entity.UniversityEntity;
import com.stubuy.catalog.repository.BookRepository;
import com.stubuy.catalog.repository.BranchRepository;
import com.stubuy.catalog.repository.CourseRepository;
import com.stubuy.catalog.repository.UniversityRepository;
import com.stubuy.catalog.repository.UserRepository;

@Component
public class BookDatabaseServiceImp implements BookDatabaseService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BranchRepository branchRepository;

	@Autowired
	private UniversityRepository universityRepository;

	@Autowired
	private CourseRepository courseRepository;

	public BookDatabaseServiceImp() {
	}

	@Override
	public BookRegisterResponse registerBook(BookRegisterRequest bookRegisterRequest) {
		BranchEntity branchEntity =
				branchRepository.getReferenceById(bookRegisterRequest.getBranchId());
		UniversityEntity universityEntity =
				universityRepository.getReferenceById(bookRegisterRequest.getUniversityId());
		BooksEntity bookEntity = BooksEntity.builder()
				.userEntity(userRepository.getReferenceById(bookRegisterRequest.getUserId()))
				.bookPrice(bookRegisterRequest.getBookPrice()).bookStatus(true)
				.booksName(bookRegisterRequest.getBookName()).branchEntity(branchEntity).build();
		branchEntity.setEntityList(Arrays.asList(bookEntity));

		bookRepository.save(bookEntity);
		return null;
	}

	@Override
	public List<BookResponse> getBooksByUniversity(Integer universityId) {
		List<BookResponse> res = new ArrayList<BookResponse>();
		UniversityEntity universityRecord = universityRepository.findByUniversityId(universityId);
		universityRecord.getCourseEntities().forEach(course -> {
			course.getBranchEntity().forEach(branch -> {
				branch.getEntityList().forEach(book -> {
					BookResponse bookRes = BookResponse.builder().bookId(book.getBook_id())
							.branchName(branch.getBranch_Name()).build();
					res.add(bookRes);
				});
			});
		});

		return res;
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
