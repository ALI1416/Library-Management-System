package com.ck;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ck.po.Admin;
import com.ck.po.Book;
import com.ck.po.Borrow;
import com.ck.po.Reader;
import com.ck.util.MybatisUtils;

public class Test2 {
	static SqlSession sqlSession = MybatisUtils.getSession();

	public static void main(String[] args) {
		// findAdmin();
		// findAdminById(1);
		// List<Integer> list = new ArrayList<Integer>();
		// list.add(11);
		// list.add(12);
		// findAdminByIdList(list);
		// delAdmin(10);
		// delAdminList(list);
		Admin admin = new Admin();
		admin.setUser("root1");
		admin.setPwd("root");
//		addAdmin(admin);
		login(admin);
		// admin.setId(14);
		// admin.setUser("565");
		// admin.setPwd("88");
		// changeAdmin(admin);

		// findBook();
		// findBookById(4);
		// List<Integer> list = new ArrayList<Integer>();
		// list.add(6);
		// list.add(7);
		// findBookByIdList(list);
		// delBook(5);
		// delBookList(list);
		// Book book = new Book();
		// book.setName("UML系统分析与设计教程");
		// book.setAuthor("冀振燕");
		// book.setPublishing("人民邮电出版社");
		// book.setIsbn("9787115349903");
		// book.setCount(19);
		// book.setRemain(19);
		// addBook(book);
		// book.setId(8);
		// book.setCount(100);
		// changeBook(book);

		// findReader();
		// findReaderById(9);
		// List<Integer> list = new ArrayList<Integer>();
		// list.add(10);
		// list.add(11);
		// findReaderByIdList(list);
		// delReader(12);
		// delReaderList(list);
		// Reader reader = new Reader();
		// reader.setName("yjm");
		// reader.setGender(0);
		// reader.setYear(1997);
		// reader.setIdCard("370811199703110000");
		// reader.setTel("13300000000");
		// reader.setAddr("山东济南");
		// addReader(reader);
		// reader.setId(12);
		// reader.setIdCard("3708");
		// reader.setYear(1996);
		// changeReader(reader);

		// findBorrow();
		// findBorrowById(22);
		// List<Integer> list = new ArrayList<Integer>();
		// list.add(21);
		// list.add(22);
		// findBorrowByIdList(list);
		// delBorrow(23);
		// delBorrowList(list);
		// Borrow borrow = new Borrow();
		// borrow.setReaderId(3);
		// borrow.setBookId(4);
		// addBorrow(borrow);
		// borrow.setId(23);
		// borrow.setReturnBorrow(0);
		// changeBorrow(borrow);

		sqlSession.close();
	}

	static int login(Admin admin) {
		Integer a = sqlSession.selectOne("com.ck.dao" + ".AdminDao.login", admin);
		System.out.println((a == null) ? 0 : a);
		return (a == null) ? 0 : a;
	}

	static int findAdmin() {
		List<Admin> a = sqlSession.selectList("com.ck.dao" + ".AdminDao.findAdmin");
		System.out.println(a);
		System.out.println(a.size());
		return a.size();
	}

	static int findAdminById(Integer id) {
		Admin a = sqlSession.selectOne("com.ck.dao" + ".AdminDao.findAdminById", id);
		System.out.println(a);
		System.out.println((a == null) ? 0 : 1);
		return (a == null) ? 0 : 1;
	}

	static int findAdminByIdList(List<Integer> list) {
		List<Admin> a = sqlSession.selectList("com.ck.dao" + ".AdminDao.findAdminByIdList", list);
		System.out.println(a);
		System.out.println(a.size());
		return a.size();
	}

	static int addAdmin(Admin admin) {
		int a = 0;
		try {
			a = sqlSession.insert("com.ck.dao" + ".AdminDao.addAdmin", admin);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
		}
		System.out.println(a);
		return a;
	}

	static int delAdmin(Integer id) {
		int a = 0;
		try {
			a = sqlSession.delete("com.ck.dao" + ".AdminDao.delAdmin", id);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
		}
		System.out.println(a);
		return a;
	}

	static int delAdminList(List<Integer> list) {
		int a = 0;
		try {
			a = sqlSession.delete("com.ck.dao" + ".AdminDao.delAdminList", list);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
		}
		System.out.println(a);
		return a;
	}

	static int changeAdmin(Admin admin) {
		int a = 0;
		try {
			a = sqlSession.update("com.ck.dao" + ".AdminDao.changeAdmin", admin);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
		}
		System.out.println(a);
		return a;
	}

	static int findBook() {
		List<Book> a = sqlSession.selectList("com.ck.dao" + ".BookDao.findBook");
		System.out.println(a);
		System.out.println(a.size());
		return a.size();
	}

	static int findBookById(Integer id) {
		Book a = sqlSession.selectOne("com.ck.dao" + ".BookDao.findBookById", id);
		System.out.println(a);
		System.out.println((a == null) ? 0 : 1);
		return (a == null) ? 0 : 1;
	}

	static int findBookByIdList(List<Integer> list) {
		List<Book> a = sqlSession.selectList("com.ck.dao" + ".BookDao.findBookByIdList", list);
		System.out.println(a);
		System.out.println(a.size());
		return a.size();
	}

	static int addBook(Book book) {
		int a = 0;
		try {
			a = sqlSession.insert("com.ck.dao" + ".BookDao.addBook", book);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
		}
		System.out.println(a);
		return a;
	}

	static int delBook(Integer id) {
		int a = 0;
		try {
			a = sqlSession.delete("com.ck.dao" + ".BookDao.delBook", id);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
		}
		System.out.println(a);
		return a;
	}

	static int delBookList(List<Integer> list) {
		int a = 0;
		try {
			a = sqlSession.delete("com.ck.dao" + ".BookDao.delBookList", list);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
		}
		System.out.println(a);
		return a;
	}

	static int changeBook(Book book) {
		int a = 0;
		try {
			a = sqlSession.update("com.ck.dao" + ".BookDao.changeBook", book);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
		}
		System.out.println(a);
		return a;
	}

	static int findReader() {
		List<Reader> a = sqlSession.selectList("com.ck.dao" + ".ReaderDao.findReader");
		System.out.println(a);
		System.out.println(a.size());
		return a.size();
	}

	static int findReaderById(Integer id) {
		Reader a = sqlSession.selectOne("com.ck.dao" + ".ReaderDao.findReaderById", id);
		System.out.println(a);
		System.out.println((a == null) ? 0 : 1);
		return (a == null) ? 0 : 1;
	}

	static int findReaderByIdList(List<Integer> list) {
		List<Admin> a = sqlSession.selectList("com.ck.dao" + ".ReaderDao.findReaderByIdList", list);
		System.out.println(a);
		System.out.println(a.size());
		return a.size();
	}

	static int addReader(Reader reader) {
		int a = 0;
		try {
			a = sqlSession.insert("com.ck.dao" + ".ReaderDao.addReader", reader);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
		}
		System.out.println(a);
		return a;
	}

	static int delReader(Integer id) {
		int a = 0;
		try {
			a = sqlSession.delete("com.ck.dao" + ".ReaderDao.delReader", id);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
		}
		System.out.println(a);
		return a;
	}

	static int delReaderList(List<Integer> list) {
		int a = 0;
		try {
			a = sqlSession.delete("com.ck.dao" + ".ReaderDao.delReaderList", list);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
		}
		System.out.println(a);
		return a;
	}

	static int changeReader(Reader reader) {
		int a = 0;
		try {
			a = sqlSession.update("com.ck.dao" + ".ReaderDao.changeReader", reader);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
		}
		System.out.println(a);
		return a;
	}

	static int findBorrow() {
		List<Borrow> a = sqlSession.selectList("com.ck.dao" + ".BorrowDao.findBorrow");
		System.out.println(a);
		System.out.println(a.size());
		return a.size();
	}

	static int findBorrowById(Integer id) {
		Borrow a = sqlSession.selectOne("com.ck.dao" + ".BorrowDao.findBorrowById", id);
		System.out.println(a);
		System.out.println((a == null) ? 0 : 1);
		return (a == null) ? 0 : 1;
	}

	static int findBorrowByIdList(List<Integer> list) {
		List<Borrow> a = sqlSession.selectList("com.ck.dao" + ".BorrowDao.findBorrowByIdList", list);
		System.out.println(a);
		System.out.println(a.size());
		return a.size();
	}

	static int addBorrow(Borrow borrow) {
		int a = 0;
		try {
			a = sqlSession.insert("com.ck.dao" + ".BorrowDao.addBorrow", borrow);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
		}
		System.out.println(a);
		return a;
	}

	static int delBorrow(Integer id) {
		int a = 0;
		try {
			a = sqlSession.delete("com.ck.dao" + ".BorrowDao.delBorrow", id);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
		}
		System.out.println(a);
		return a;
	}

	static int delBorrowList(List<Integer> list) {
		int a = 0;
		try {
			a = sqlSession.delete("com.ck.dao" + ".BorrowDao.delBorrowList", list);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
		}
		System.out.println(a);
		return a;
	}

	static int changeBorrow(Borrow borrow) {
		int a = 0;
		try {
			a = sqlSession.update("com.ck.dao" + ".BorrowDao.changeBorrow", borrow);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
		}
		System.out.println(a);
		return a;
	}
}