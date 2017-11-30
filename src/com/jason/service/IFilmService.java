package com.jason.service;

import java.util.List;

import com.jason.domain.Category;
import com.jason.domain.Movie;

public interface IFilmService {
	public List<Movie> getFilmToIndex(Integer nowPage);
	public Integer getFilmCount();
	public Category getFilmCategory();
}
