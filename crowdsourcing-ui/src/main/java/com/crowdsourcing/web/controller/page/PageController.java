package com.crowdsourcing.web.controller.page;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	private static final String TYPE_KEY = "type";
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		Map<String,Object> model = new HashMap<String,Object>();
		Cookie[] cookies = request.getCookies();
		boolean fileName = false;
		if(cookies != null){
		for (Cookie cookie : cookies) {
			if(TYPE_KEY.equals(cookie.getName())){
				fileName = true;
				session.setAttribute("fileName", cookie.getValue());
			}
		}
		}
		if(!fileName)
		session.setAttribute("fileName", "details-view.jsp");
		return new ModelAndView("index", model);
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		session.invalidate();
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("message",
				"User loggged out successfully.");
		session.setAttribute("fileName", "details-view.jsp");
		Cookie[] cookies = request.getCookies();
	    if (cookies != null)
	        for (int i = 0; i < cookies.length; i++) {
	            cookies[i].setValue("");
	            cookies[i].setPath("/");
	            cookies[i].setMaxAge(0);
	            response.addCookie(cookies[i]);
	        }
	    return "login";
	}
}
