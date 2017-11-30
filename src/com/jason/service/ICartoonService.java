package com.jason.service;

import java.util.List;

import com.jason.domain.Category;
import com.jason.domain.Movie;

public interface ICartoonService {
	public List<Movie> getCartoonToIndex(Integer nowPage);
	public Integer getCartoonCount();
	public Category getCartoonCategory();
	public List<Movie> getCartoonRankingToIndex(); //排行榜
}
