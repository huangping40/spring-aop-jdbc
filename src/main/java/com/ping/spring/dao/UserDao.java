package com.ping.spring.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ping.spring.jdbc.UserRowMapper;
import com.ping.spring.model.User;

@Component
public class UserDao {
	@Autowired
	@Qualifier("pdataSource")
	DataSource dataSource;

	public void insertData(User user) {

		String sql = "INSERT INTO puser "
				+ "(first_name,last_name, gender, city) VALUES (?, ?, ?,?)";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(
				sql,
				new Object[] { user.getFirstName(), user.getLastName(),
						user.getGender(), user.getCity() });

	}

	public void insertDatafalse(User user) {

		String sql = "INSERT INTO puser_not_exist "
				+ "(first_name,last_name, gender, city) VALUES (?, ?, ?,?)";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(
				sql,
				new Object[] { user.getFirstName(), user.getLastName(),
						user.getGender(), user.getCity() });

	}

	public List<User> getUserList() {
		List userList = new ArrayList();

		String sql = "select * from puser";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		return userList;
	}

	public void deleteData(String id) {
		String sql = "delete from user where puser_id=" + id;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql);

	}

	public void updateData(User user) {

		String sql = "UPDATE puser set first_name = ?,last_name = ?, gender = ?, city = ? where user_id = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(
				sql,
				new Object[] { user.getFirstName(), user.getLastName(),
						user.getGender(), user.getCity(), user.getUserId() });

	}

	public User getUser(String id) {
		List<User> userList = new ArrayList<User>();
		String sql = "select * from user where user_id= " + id;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		return userList.get(0);
	}
}
