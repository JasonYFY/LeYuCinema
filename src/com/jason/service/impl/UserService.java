package com.jason.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jason.dao.IUserDao;
import com.jason.domain.User;
import com.jason.service.IUserService;
@Service
public class UserService implements IUserService{
	
	@Autowired
	private IUserDao userDao;
	
	@Transactional
	@Override
	public boolean insert(User user) {
		try {
			userDao.insert(user);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> query(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User login(User user) {
		return userDao.login(user);
	}
	

}
