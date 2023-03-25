package com.ck.dao;

import java.util.List;

import com.ck.po.Borrow;

public interface BorrowDao {
	public List<Borrow> findBorrow();

	public Borrow findBorrowById(Integer id);

	public List<Borrow> findBorrowByIdList(List<Integer> list);

	public Integer addBorrow(Borrow borrow);

	public Integer delBorrow(Integer id);

	public Integer delBorrowList(List<Integer> list);

	public Integer changeBorrow(Borrow borrow);

}
