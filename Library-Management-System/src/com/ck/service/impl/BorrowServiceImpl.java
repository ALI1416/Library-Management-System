package com.ck.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ck.dao.BorrowDao;
import com.ck.po.Borrow;
import com.ck.service.BorrowService;

@Service
public class BorrowServiceImpl implements BorrowService {

	@Autowired
	private BorrowDao borrowDao;

	public List<Borrow> findBorrow() {
		return this.borrowDao.findBorrow();
	}

	public Borrow findBorrowById(Integer id) {
		return this.borrowDao.findBorrowById(id);
	}

	public List<Borrow> findBorrowByIdList(List<Integer> list) {
		return this.borrowDao.findBorrowByIdList(list);
	}

	public Integer addBorrow(Borrow borrow) {
		return this.borrowDao.addBorrow(borrow);
	}

	public Integer delBorrow(Integer id) {
		return this.borrowDao.delBorrow(id);
	}

	public Integer delBorrowList(List<Integer> list) {
		return this.borrowDao.delBorrowList(list);
	}

	public Integer changeBorrow(Borrow borrow) {
		return this.borrowDao.changeBorrow(borrow);
	}

}
