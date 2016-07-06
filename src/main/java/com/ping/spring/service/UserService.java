package com.ping.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ping.spring.dao.UserDao;
import com.ping.spring.model.User;

@Component
public class UserService {
	@Autowired
	UserDao userdao;

	
	public void getObject(User user) {
		userdao.insertData(user);
		userdao.insertDatafalse(user);
	}

	public void insertData(User user) {
		userdao.insertData(user);
	}

	public void insertDatafalse(User user) {
		userdao.insertData(user);
		userdao.insertDatafalse(user);
	}

	
	public List<User> getUserList() {
		return userdao.getUserList();
	}

	
	public void deleteData(String id) {
		userdao.deleteData(id);
		
	}

	
	public User getUser(String id) {
		return userdao.getUser(id);
	}

	
	public void updateData(User user) {
		userdao.updateData(user);
		
	}

}
