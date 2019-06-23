package com.ck.dao;

import java.util.List;

import com.ck.po.Reader;

public interface ReaderDao {
	public List<Reader> findReader();

	public Reader findReaderById(Integer id);

	public List<Reader> findReaderByIdList(List<Integer> list);

	public Integer addReader(Reader reader);

	public Integer delReader(Integer id);

	public Integer delReaderList(List<Integer> list);

	public Integer changeReader(Reader reader);

}
