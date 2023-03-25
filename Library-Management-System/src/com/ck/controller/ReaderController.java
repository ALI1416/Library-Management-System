package com.ck.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ck.po.Reader;
import com.ck.service.ReaderService;

@Controller
public class ReaderController {

	@Autowired
	private ReaderService readerService;

	@RequestMapping("/reader")
	public String reader(Model model) {
		List<Reader> list = readerService.findReader();
		model.addAttribute("list", list);
		return "/pages/reader.jsp";
	}

	@RequestMapping("/delReader/{id}")
	public String delReader(Model model, @PathVariable Integer id) {
		Integer n = 0;
		try {
			n = readerService.delReader(id);
		} catch (Exception e) {// 外键冲突
			model.addAttribute("e", "delForbid");
			return "redirect:/reader";
		}
		if (n != 0) {// 删除成功
			model.addAttribute("e", "delOk");
		} else {// 删除失败
			model.addAttribute("e", "delErr");
		}
		return "redirect:/reader";
	}

	@RequestMapping("/changeReader/{id}")
	public String changeReader(Model model, Reader reader) {
		Integer n = 0;
		try {
			n = readerService.changeReader(reader);
		} catch (Exception e) {// 输入格式错误
			model.addAttribute("e", "changeForbid");
			return "redirect:/reader";
		}
		if (n != 0) {// 成功
			model.addAttribute("e", "changeOk");
		} else {// 失败
			model.addAttribute("e", "changeErr");
		}
		return "redirect:/reader";
	}

	@RequestMapping("/addReader")
	public String addReader(Model model, Reader reader) {
		Integer n = 0;
		try {
			n = readerService.addReader(reader);
		} catch (Exception e) {// 输入格式错误
			model.addAttribute("e", "addForbid");
			return "redirect:/reader";
		}
		if (n != 0) {// 成功
			model.addAttribute("e", "addOk");
		} else {// 失败
			model.addAttribute("e", "addErr");
		}
		return "redirect:/reader";
	}

}
