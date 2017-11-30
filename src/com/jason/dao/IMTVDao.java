package com.jason.dao;

import java.util.List;

import com.jason.domain.Category;
import com.jason.domain.Movie;

public interface IMTVDao {
	public List<Movie> getMTVToIndex(Integer nowPage);
	public Integer getMTVCount();
	public Category getMTVCategory();
	public List<Movie> getMTVRanking(Integer count); //排行榜
}
