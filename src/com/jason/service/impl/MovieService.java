package com.jason.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jason.dao.IMovieDao;
import com.jason.domain.Movie;
import com.jason.domain.PageModel;
import com.jason.service.IMovieService;
@Service
public class MovieService implements IMovieService{
	@Autowired
	private IMovieDao movieDao;
	
	@Transactional
	@Override
	public boolean upload(Movie movie) {
		try {
			movieDao.insert(movie);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}

	@Override
	public List<Movie> queryMovie(Movie movie) {
		// TODO Auto-generated method stub
		return movieDao.queryMovie(movie);
	}

	@Override
	public Movie getMovieById(String id) {
		
		return movieDao.getMovieById(id);
	}

	@Transactional
	@Override
	public boolean update(Movie movie) {
		if(movie!=null) {
			try {
				movieDao.update(movie);
			}catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			return true;
			
		}
		return false;
	}

	@Override
	public List<Movie> queryMovieByPage(Movie movie, PageModel pageModel) {
		Integer count = getQueryCount(movie);
		pageModel.setTotalRecordSum(count);
		return movieDao.queryMovieByPage(movie, pageModel);
	}

	@Override
	public Integer getQueryCount(Movie movie) {
		// TODO Auto-generated method stub
		return movieDao.getQueryCount(movie);
	}

}
