package com.ck.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ck.po.Borrow;
import com.ck.service.BorrowService;

@Controller
public class BorrowController {

	@Autowired
	private BorrowService borrowService;

	@RequestMapping("/borrow")
	public String borrow(Model model) {
		List<Borrow> list = borrowService.findBorrow();
		model.addAttribute("list", list);
		return "/pages/borrow.jsp";
	}

	@RequestMapping("/delBorrow/{id}")
	public String delBorrow(Model model, @PathVariable Integer id) {
		Integer n = borrowService.delBorrow(id);
		if (n != 0) {// 删除成功
			model.addAttribute("e", "delOk");
		} else {// 删除失败
			model.addAttribute("e", "delErr");
		}
		return "redirect:/borrow";
	}

	@RequestMapping("/changeBorrow/{id}")
	public String changeBorrow(Model model, Borrow borrow) {
		Integer n = borrowService.changeBorrow(borrow);
		if (n != 0) {// 成功
			model.addAttribute("e", "changeOk");
		} else {// 失败
			model.addAttribute("e", "changeErr");
		}
		return "redirect:/borrow";
	}

	@RequestMapping("/addBorrow")
	public String addBorrow(Model model, Borrow borrow) {
		Integer n = 0;
		try {
			n = borrowService.addBorrow(borrow);
		} catch (Exception e) {// 外键冲突
			model.addAttribute("e", "addForbid");
			return "redirect:/borrow";
		}
		if (n != 0) {// 成功
			model.addAttribute("e", "addOk");
		} else {// 失败
			model.addAttribute("e", "addErr");
		}
		return "redirect:/borrow";
	}

}
