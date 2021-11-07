package com.college.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.college.entity.User;
import com.college.repo.UserRepo;

@Controller
public class CollegeUIController {

	@Autowired
	private UserRepo userRepo;

	@GetMapping({ "/", "/login" })
	public String getLogin() {
		return "index";
	}

	@GetMapping("/forget")
	public String getforget() {
		return "forget";
	}

	@GetMapping("/signup")
	public String getSignupPage() {
		return "signup";
	}

	@GetMapping("/{token}/activate/account")
	public String getSuccessPage(@PathVariable("token") String token) {
		Optional<User> user = userRepo.findByToken(token);
		if (user.isPresent()) {
			User user1=user.get();
			user1.setIsActive(true);
			user1.setToken(null);
			userRepo.save(user1);
			return "success";
		}
		return "errorPage";
	}

}
