package com.ck.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		String url = request.getServletPath();
		System.out.println("地址:" + url);
		if (!url.equals("")) {
			// 判断是否已经登录
			Integer id = (Integer) request.getSession().getAttribute("id");
			System.out.println("id:" + id);
			if (id == null) {
				// session为空
				System.out.println(">>>未登录<<<");
				response.sendRedirect("pages/login.jsp");
				return false;
			}
		}
		return true;
	}
}
