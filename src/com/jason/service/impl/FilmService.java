package com.jason.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jason.dao.IFilmDao;
import com.jason.dao.IMovieDao;
import com.jason.domain.Category;
import com.jason.domain.Movie;
import com.jason.service.IFilmService;
@Service
public class FilmService implements IFilmService {
	private Integer count;
	
	@Autowired
	private IFilmDao FileDao;
	@Override
	public List<Movie> getFilmToIndex(Integer nowPage) {
		if(this.count==null) {
			getFilmCount();
		}
		return FileDao.getFilmToIndex(nowPage);
	}
	
	@Override
	public Integer getFilmCount() {
		count = FileDao.getFilmCount();
		return count;
	}

	@Override
	public Category getFilmCategory() {
		// TODO Auto-generated method stub
		return FileDao.getFilmCategory();
	}

}
