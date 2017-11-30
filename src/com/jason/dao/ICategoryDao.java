package com.jason.dao;

import java.util.List;

import com.jason.domain.Category;

public interface ICategoryDao {
	public Category get(String id);
	public void insert(Category category);
	public List<Category> query(Category category);
	public List<Category> queryAllCategory();

}
