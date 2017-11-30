package com.jason.service;

import java.util.List;

import com.jason.domain.User;

public interface IUserService {
	public boolean insert(User user);
	public boolean update(User user);
	public boolean remove(User user);
	public User login(User user);
	public List<User> query(User user);
}
