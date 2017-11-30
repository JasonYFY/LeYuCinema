package com.jason.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jason.dao.IUserDao;
import com.jason.domain.User;
@Repository
public class UserDao extends HibernateDaoSupport implements IUserDao {
	@Autowired
	public void setMySessionFactory(SessionFactory sf) {
		super.setSessionFactory(sf);
	}
	
	@Override
	public void insert(User user) {
		getHibernateTemplate().save(user);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> query(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User login(User user) {
		List<User> list = getHibernateTemplate().findByExample(user);
		if(list!=null&&list.size()!=0) {
			return list.get(0);
		}
		return null;
	}

}
