package com.jason.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jason.dao.ICategoryDao;
import com.jason.domain.Category;
import com.jason.service.ICategoryService;
@Service
public class CategoryService implements ICategoryService {
	
	@Autowired
	private ICategoryDao categoryDao;
	
	
	@Override
	public Category get(String id) {
		
		return categoryDao.get(id);
	}
	@Transactional
	@Override
	public boolean insert(Category category) {
		try{
			categoryDao.insert(category);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}
	@Override
	public List<Category> queryAllCategory() {
		// TODO Auto-generated method stub
		return categoryDao.queryAllCategory();
	}

}
