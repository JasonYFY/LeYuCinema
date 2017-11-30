package com.jason.service;

import java.util.List;

import com.jason.domain.Category;
import com.jason.domain.Movie;

public interface IMTVService {
	public List<Movie> getMTVToIndex(Integer nowPage);
	public Integer getMTVCount();
	public Category getMTVCategory();
	public List<Movie> getMTVRankingToIndex(); //排行榜
}
