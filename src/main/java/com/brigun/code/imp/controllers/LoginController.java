package com.brigun.code.imp.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.brigun.code.imp.models.User;
import com.brigun.code.imp.models.dao.UserDao;


@Controller
public class LoginController 
{
	
	@Autowired
	protected UserDao userDao;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm()
	{
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, Model model)
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User applicant = userDao.findByUsername(username);
		
		
		return username;
		
		
	}
}
