package com.jason.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jason.dao.ICategoryDao;
import com.jason.domain.Category;
@Repository
public class CategoryDao extends HibernateDaoSupport implements ICategoryDao {
	
	
	@Autowired
	public void setMySessionFactory(SessionFactory sf) {
		super.setSessionFactory(sf);
	}

	@Override
	public Category get(String id) {
		Category category = getHibernateTemplate().get(Category.class, id);
		
		return category;
	}

	@Override
	public void insert(Category category) {
		getHibernateTemplate().save(category);
	}

	@Override
	public List<Category> query(Category category) {
		return null;
	}

	@Override
	public List<Category> queryAllCategory() {
		List<Category> list = (List<Category>) getHibernateTemplate().find("from Category", null);
		return list;
	}

}
