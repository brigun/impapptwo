package com.brigun.code.imp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController 
{
	@RequestMapping(value = "/")
	String index()
	{
		return "index";
	}
	
	
	
}