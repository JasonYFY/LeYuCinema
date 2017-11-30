package com.jason.service;

import java.util.List;

import com.jason.domain.Movie;
import com.jason.domain.PageModel;

public interface IMovieService {
	public boolean upload(Movie movie);
	public List<Movie> queryMovie(Movie movie);
	public List<Movie> queryMovieByPage(Movie movie, PageModel pageModel);
	public Integer getQueryCount(Movie movie);
	public Movie getMovieById(String id);
	public boolean update(Movie movie);

}
