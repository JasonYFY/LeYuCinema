package com.jason.dao;

import java.util.List;

import com.jason.domain.Movie;
import com.jason.domain.PageModel;

public interface IMovieDao {
	public List<Movie> queryMovie(Movie movie);
	public List<Movie> queryMovieByPage(Movie movie, PageModel pageModel);
	public Integer getQueryCount(Movie movie);
	public Movie getMovieById(String id);
	public void insert(Movie movie);
	public void update(Movie movie);

}
