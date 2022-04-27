package com.experian.studentapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentViewController {

	@RequestMapping("home")
	public String home() {
		return "home.jsp";
	}
}
