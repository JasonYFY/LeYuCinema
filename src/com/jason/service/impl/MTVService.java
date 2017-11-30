package com.jason.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jason.dao.IMTVDao;
import com.jason.domain.Category;
import com.jason.domain.Movie;
import com.jason.service.IMTVService;
@Service
public class MTVService implements IMTVService {
	@Autowired
	private IMTVDao mtvDao;
	
	@Override
	public List<Movie> getMTVToIndex(Integer nowPage) {
		// TODO Auto-generated method stub
		return mtvDao.getMTVToIndex(nowPage);
	}

	@Override
	public Integer getMTVCount() {
		// TODO Auto-generated method stub
		return mtvDao.getMTVCount();
	}

	@Override
	public Category getMTVCategory() {
		// TODO Auto-generated method stub
		return mtvDao.getMTVCategory();
	}

	@Override
	public List<Movie> getMTVRankingToIndex() {
		// TODO Auto-generated method stub
		return mtvDao.getMTVRanking(10);
	}

}
