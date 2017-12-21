package com.lonelybit.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lonelybit.user.ApplicationUser;
import com.lonelybit.user.repository.ApplicationUserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired	
	private ApplicationUserRepository applicationUserRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping(value = "/sign-up", method = RequestMethod.POST)
	public void signup(@RequestBody ApplicationUser user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		applicationUserRepository.save(user);
	}
}
