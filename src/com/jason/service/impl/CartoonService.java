package com.jason.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jason.dao.ICartoonDao;
import com.jason.domain.Category;
import com.jason.domain.Movie;
import com.jason.service.ICartoonService;
@Service
public class CartoonService implements ICartoonService {
	
	@Autowired
	private ICartoonDao cartoonDao;
	@Override
	public List<Movie> getCartoonToIndex(Integer nowPage) {
		return cartoonDao.getCartoonToIndex(nowPage);
	}
	
	@Override
	public Integer getCartoonCount() {
		return cartoonDao.getCartoonCount();
	}

	@Override
	public Category getCartoonCategory() {
		return cartoonDao.getCartoonCategory();
	}

	@Override
	public List<Movie> getCartoonRankingToIndex() {
		return cartoonDao.getCartoonRanking(5);
	}

	

}
