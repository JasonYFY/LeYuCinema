package com.jason.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jason.dao.ICommentDao;
import com.jason.domain.Comment;
import com.jason.domain.PageModel;
import com.jason.service.ICommentService;
@Service
public class CommentService implements ICommentService {

	@Autowired
	private ICommentDao commentDao;
	
	@Override
	public List<Comment> queryByPage(Comment comment, PageModel pageModel) {
		Long count = getCount(comment);
		Integer c = Integer.parseInt(count+"");
		pageModel.setTotalRecordSum(c);
		List<Comment> list = commentDao.queryByPage(comment, pageModel);
		return list;
	}

	@Override
	public Long getCount(Comment comment) {
		return commentDao.getCount(comment);
	}

	@Transactional
	@Override
	public boolean insert(Comment comment) {
		try {
			commentDao.insert(comment);
		}catch (Exception e) {
			e.printStackTrace();
			return false;    
		}
		return true;
	}

}
