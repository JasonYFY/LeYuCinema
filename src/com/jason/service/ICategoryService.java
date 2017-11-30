package com.jason.service;

import java.util.List;

import com.jason.domain.Category;

public interface ICategoryService {
	public Category get(String id);
	public boolean insert(Category category);
	public List<Category> queryAllCategory();

}
