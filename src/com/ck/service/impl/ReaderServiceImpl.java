package com.ck.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ck.dao.ReaderDao;
import com.ck.po.Reader;
import com.ck.service.ReaderService;

@Service
public class ReaderServiceImpl implements ReaderService {

	@Autowired
	private ReaderDao readerDao;

	public List<Reader> findReader() {
		return this.readerDao.findReader();
	}

	public Reader findReaderById(Integer id) {
		return this.readerDao.findReaderById(id);
	}

	public List<Reader> findReaderByIdList(List<Integer> list) {
		return this.readerDao.findReaderByIdList(list);
	}

	public Integer addReader(Reader reader) {
		return this.readerDao.addReader(reader);
	}

	public Integer delReader(Integer id) {
		return this.readerDao.delReader(id);
	}

	public Integer delReaderList(List<Integer> list) {
		return this.readerDao.delReaderList(list);
	}

	public Integer changeReader(Reader reader) {
		return this.readerDao.changeReader(reader);
	}

}
