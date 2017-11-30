package com.jason.dao;

import java.util.List;

import com.jason.domain.Category;
import com.jason.domain.Movie;

public interface ICartoonDao {
	public List<Movie> getCartoonToIndex(Integer nowPage);
	public Integer getCartoonCount();
	public Category getCartoonCategory();
	public List<Movie> getCartoonRanking(Integer count); //排行榜
}
