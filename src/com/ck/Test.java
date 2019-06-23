package com.ck;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ck.service.AdminService;
import com.ck.service.BookService;
import com.ck.service.BorrowService;
import com.ck.service.ReaderService;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

		AdminService adminService = ac.getBean(AdminService.class);
		BookService bookService = ac.getBean(BookService.class);
		BorrowService borrowService = ac.getBean(BorrowService.class);
		ReaderService readerService = ac.getBean(ReaderService.class);

		System.out.println(adminService.findAdmin());
		System.out.println(bookService.findBook());
		System.out.println(borrowService.findBorrow());
		System.out.println(readerService.findReader());

		((ConfigurableApplicationContext) ac).close();
	}

}
