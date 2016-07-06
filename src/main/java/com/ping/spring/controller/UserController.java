package com.ping.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ping.spring.model.User;
import com.ping.spring.service.UserService;

@Component
public class UserController {
	@Autowired
	UserService userService;

	public void addUser() {
		User user = new User();
		user.setCity("beijing");
		user.setFirstName("hu");
		user.setLastName("round");
		user.setGender("M");
		
		System.out.println("begin to sleep ");
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userService.getObject(user);		
//		userService.insertData(user);	
		//userService.insertDatafalse(user);
	}
}
