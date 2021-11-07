package com.college.service;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.entity.User;
import com.college.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private EmailService emailService;

	public User saveUserInfo(User user, HttpServletRequest httpServletRequest) {
		user.setIsActive(false);
		user.setToken(UUID.randomUUID().toString());
		User userCreated = userRepo.save(user);
		emailService.sendMail(user, httpServletRequest);
		return userCreated;
	}

}
