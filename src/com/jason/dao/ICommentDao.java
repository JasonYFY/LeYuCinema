package com.jason.dao;

import java.util.List;

import com.jason.domain.Comment;
import com.jason.domain.PageModel;

public interface ICommentDao{
	public List<Comment> queryByPage(Comment comment,PageModel pageModel);
	public Long getCount(Comment comment);
	public void insert(Comment comment);
}
