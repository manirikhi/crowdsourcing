package com.crowdsourcing.web.controller.ajax;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.crowdsourcing.exception.CoreException;
import com.crowdsourcing.service.ClientService;
import com.crowdsourcing.service.WorkerService;


@Controller
public class UserLoginController {

	private static final String WORKER = "worker";
	private static final String CLIENT = "client";
	@Autowired
	WorkerService workerService;	

	@Autowired
	ClientService clientService;
	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public String validateUser(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		String type = request.getParameter("userType");
		String email = request.getParameter("email");
		String password = request.getParameter("password");				
		String clientId = "";
		String workerId = "";
		try {
			if(CLIENT.equalsIgnoreCase(type)){
				clientId = clientService.signIn(email, password);
			}
			if(WORKER.equalsIgnoreCase(type)){
				workerId = workerService.signIn(email, password);
			}
				
			if (StringUtils.isNotBlank(workerId)) {
				storeCookies(email,workerId,"details-worker.jsp",response);
				session.setAttribute("fileName", "details-worker.jsp");							
			}else if (StringUtils.isNotBlank(clientId)) {
				storeCookies(email,clientId,"details-client.jsp",response);
				session.setAttribute("fileName", "details-client.jsp");				
			} else{
				session.setAttribute("message", "Wrong user email or password!");
				storeCookies(null,null,"details-view.jsp",response);
				session.setAttribute("fileName", "details-view.jsp");
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
		}	
		return "redirect:/";
	}	
	

	/**
	 * Store user information in cookies
	 * 
	 * @param user
	 */
	private void storeCookies(String email,String userId,String type, HttpServletResponse response) {

		Cookie emailCookie = new Cookie("email", email);
		emailCookie.setMaxAge(3600);
		Cookie typeCookie = new Cookie("type", type);
		typeCookie.setMaxAge(3600);
		Cookie userIdCookie = new Cookie("userId", userId);
		userIdCookie.setMaxAge(3600);
		
		response.addCookie(typeCookie);
		response.addCookie(emailCookie);
		response.addCookie(userIdCookie);
		
	}

}
