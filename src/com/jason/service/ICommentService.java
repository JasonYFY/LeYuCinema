package com.jason.service;

import java.util.List;

import com.jason.domain.Comment;
import com.jason.domain.PageModel;

public interface ICommentService {
	public List<Comment> queryByPage(Comment comment,PageModel pageModel);
	public Long getCount(Comment comment);
	public boolean insert(Comment comment);
}
