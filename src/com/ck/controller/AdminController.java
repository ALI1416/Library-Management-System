package com.ck.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ck.po.Admin;
import com.ck.service.AdminService;

@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;

	@RequestMapping("/login")
	public String login(Model model, HttpSession session, Admin admin) {
		Integer id = adminService.login(admin);
		if (id != null) {// 登录成功
			session.setAttribute("id", id);
			session.setAttribute("user", admin.getUser());
			return "redirect:/book";
		} else {// 账号或密码错误
			return "/pages/login.jsp?e=loginErr";
		}
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "/pages/login.jsp";
	}

	@RequestMapping("/user")
	public String user(HttpSession session) {
		Integer id = (Integer) session.getAttribute("id");
		if (id != null) {
			if (id == 1) {
				return "redirect:/admin";
			} else {
				return "/pages/changePwd.jsp";
			}
		} else {
			return "/pages/login.jsp?e=loginErr";
		}
	}

	@RequestMapping("/changePwd/{id}")
	public String changePwd(Model model, HttpSession session, Admin admin, String newPwd) {
		admin.setUser((String) session.getAttribute("user"));
		// pwd自动放入admin中，不必重复放入
		Integer id = adminService.login(admin);
		// 再次调用adminService的登录方法，检测旧密码是否正确
		if (id != null) {// 密码正确
			admin.setPwd(newPwd);// 设置新密码
			adminService.changeAdmin(admin);
			// 修改后登录状态依然存在，不需再次设置session
			model.addAttribute("e", "pwdOk");
		} else {// 密码错误
			model.addAttribute("e", "pwdErr");
		}
		return "redirect:/user";
		// 不能直接返回，否则前端无法接受参数
	}

	@RequestMapping("/admin")
	public String admin(Model model) {
		List<Admin> list = adminService.findAdmin();
		model.addAttribute("list", list);
		return "/pages/admin.jsp";
	}

	@RequestMapping("/delAdmin/{id}")
	public String delAdmin(Model model, @PathVariable Integer id) {
		// 此处id需要@PathVariable Integer接收
		if (id == 1) {// 禁止删除
			model.addAttribute("e", "delForbid");
		} else {
			Integer n = adminService.delAdmin(id);
			if (n != 0) {// 删除成功
				model.addAttribute("e", "delOk");
			} else {// 删除失败
				model.addAttribute("e", "delErr");
			}
		}
		return "redirect:/admin";
	}

	@RequestMapping("/changeAdmin/{id}")
	public String changeAdmin(Model model, Admin admin) {
		// 此处id被自动放入post里面（被admin接收了），不需要单独接收id
		if (admin.getId() == 1) {// 禁止修改
			return "redirect:/admin";
		} // 注释掉上面这3行，可以修改root用户
		Integer n = 0;
		try {
			n = adminService.changeAdmin(admin);
		} catch (Exception e) {// 主键冲突
			model.addAttribute("e", "changeForbid");
			return "redirect:/admin";
		}
		if (n != 0) {// 成功
			model.addAttribute("e", "changeOk");
		} else {// 失败
			model.addAttribute("e", "changeErr");
		}
		return "redirect:/admin";
	}

	@RequestMapping("/addAdmin")
	public String addAdmin(Model model, Admin admin) {
		Integer n = 0;
		try {
			n = adminService.addAdmin(admin);
		} catch (Exception e) {// 主键冲突
			model.addAttribute("e", "addForbid");
			return "redirect:/admin";
		}
		if (n != 0) {// 成功
			model.addAttribute("e", "addOk");
		} else {// 失败
			model.addAttribute("e", "addErr");
		}
		return "redirect:/admin";
	}

}
