package org.joel.content.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joel.content.constants.UserType;
import org.joel.content.dto.UserData;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class BuyerInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse Response, Object arg2) throws Exception {
		
		UserData user = (UserData)request.getSession().getAttribute("user");
		//当前用户不是买家，跳转到登录页
		if(user == null || user.getUsertype() != UserType.BUYER){
			Response.sendRedirect("/login");
			return false;
		}
		
		return true;
	}

}
