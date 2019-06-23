package com.ck.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ck.dao.BookDao;
import com.ck.po.Book;
import com.ck.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;

	public List<Book> findBook() {
		return this.bookDao.findBook();
	}

	public Book findBookById(Integer id) {
		return this.bookDao.findBookById(id);
	}

	public List<Book> findBookByIdList(List<Integer> list) {
		return this.bookDao.findBookByIdList(list);
	}

	public Integer addBook(Book book) {
		return this.bookDao.addBook(book);
	}

	public Integer delBook(Integer id) {
		return this.bookDao.delBook(id);
	}

	public Integer delBookList(List<Integer> list) {
		return this.bookDao.delBookList(list);
	}

	public Integer changeBook(Book book) {
		return this.bookDao.changeBook(book);
	}

}
