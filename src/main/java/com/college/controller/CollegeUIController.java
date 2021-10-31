package com.college.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CollegeUIController {

	@GetMapping({ "/", "/login" })
	public String getLogin() {
		return "index";
	}

	@GetMapping("/forget")
	public String getforget() {
		return "forget";
	}
}
