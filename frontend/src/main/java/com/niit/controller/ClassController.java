package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class ClassController {
	@RequestMapping("/")
	public String Home()
	{
		return "index";
		
		
	}
	@RequestMapping("/contactus")
	public String ContactUs()
	{
		return "Contactus";
		
		
	}
	
	@RequestMapping("/logo")
	public String Logo()
	{
		return "Logo";
		
		
	}

	@RequestMapping("/aboutus")
	public String AboutUs()
	{
		return "Aboutus";
		
		
	}

	@RequestMapping("/register")
	public String Register()
	{
		return"Register";
	}
	@RequestMapping("/login")
	public String login(HttpSession Session)
	{
		return "Login";
	}
	@RequestMapping("/header")
	public String showHeaderPage()
	{
		return "header";
	}
	@RequestMapping("/header_1")
	public String showHeader_1Page()
	{
		return "Header1";
	}
	
	@RequestMapping("/footer")
	public String showFooterPage()
	{
		return "footer";
	}
	@RequestMapping("/home")
	public String showHomePage()
	{
		return "UserHome";
	}
	@RequestMapping("/admin")
	public String showAdminHomePage()
	{
		return "AdminHome";
	}

}
