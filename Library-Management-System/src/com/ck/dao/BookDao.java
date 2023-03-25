package com.ck.dao;

import java.util.List;

import com.ck.po.Book;

public interface BookDao {
	public List<Book> findBook();

	public Book findBookById(Integer id);

	public List<Book> findBookByIdList(List<Integer> list);

	public Integer addBook(Book book);

	public Integer delBook(Integer id);

	public Integer delBookList(List<Integer> list);

	public Integer changeBook(Book book);

}
