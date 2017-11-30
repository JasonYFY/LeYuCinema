package com.jason.dao;

import java.util.List;

import com.jason.domain.User;

public interface IUserDao {
	public void insert(User user);
	public void update(User user);
	public void remove(User user);
	public User login(User user);
	public List<User> query(User user);
}
