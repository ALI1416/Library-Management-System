package com.ck.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ck.po.Book;
import com.ck.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	@RequestMapping("/book")
	public String book(Model model) {
		List<Book> list = bookService.findBook();
		model.addAttribute("list", list);
		return "/pages/book.jsp";
	}

	@RequestMapping("/delBook/{id}")
	public String delBook(Model model, @PathVariable Integer id) {
		Integer n = 0;
		try {
			n = bookService.delBook(id);
		} catch (Exception e) {// 外键冲突
			model.addAttribute("e", "delForbid");
			return "redirect:/book";
		}
		if (n != 0) {// 删除成功
			model.addAttribute("e", "delOk");
		} else {// 删除失败
			model.addAttribute("e", "delErr");
		}
		return "redirect:/book";
	}

	@RequestMapping("/changeBook/{id}")
	public String changeBook(Model model, Book book) {
		Integer n = 0;
		try {
			n = bookService.changeBook(book);
		} catch (Exception e) {// 输入格式错误
			model.addAttribute("e", "changeForbid");
			return "redirect:/book";
		}
		if (n != 0) {// 成功
			model.addAttribute("e", "changeOk");
		} else {// 失败
			model.addAttribute("e", "changeErr");
		}
		return "redirect:/book";
	}

	@RequestMapping("/addBook")
	public String addBook(Model model, Book book) {
		Integer n = 0;
		try {
			n = bookService.addBook(book);
		} catch (Exception e) {// 输入格式错误
			model.addAttribute("e", "addForbid");
			return "redirect:/book";
		}
		if (n != 0) {// 成功
			model.addAttribute("e", "addOk");
		} else {// 失败
			model.addAttribute("e", "addErr");
		}
		return "redirect:/book";
	}

}
