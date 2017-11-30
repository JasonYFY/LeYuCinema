package com.jason.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jason.domain.Comment;
import com.jason.domain.Movie;
import com.jason.domain.PageModel;
import com.jason.domain.User;
import com.jason.service.ICommentService;
import com.jason.service.IMovieService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

@Controller
@Scope(value="prototype")
public class CommentAction extends ActionSupport implements ModelDriven<Comment>{
	
	private Comment comment = new Comment();
	private String movieIdOther;
	@Autowired
	private IMovieService ms;
	@Autowired
	private ICommentService commentService;
	
	private PageModel pageModel = new PageModel();
	
	
	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	

	public String getMovieIdOther() {
		return movieIdOther;
	}

	public void setMovieIdOther(String movieIdOther) {
		this.movieIdOther = movieIdOther;
	}

	public PageModel getPageModel() {
		return pageModel;
	}

	public void setPageModel(PageModel pageModel) {
		this.pageModel = pageModel;
	}

	@Override
	public Comment getModel() {
		// TODO Auto-generated method stub
		return comment;
	}
	//评论界面，获取评论内容
	public String commentForm() throws Exception {
		ActionContext context = ActionContext.getContext();
		ValueStack vs = context.getValueStack();
		Map<String, Object> session = context.getSession();
		Movie movie = (Movie) session.get("nowMovie");
		pageModel.setPageSize(5);
		if(movie!=null) {
			comment.setMovieId(movie);
		}
		List<Comment> list = commentService.queryByPage(comment, pageModel);
		vs.set("commentList", list);
		return SUCCESS;
	}
	
	public String doComment() throws Exception {
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		ValueStack vs = context.getValueStack();
		User user = (User) session.get("nowUser");
		if(user!=null) {
			if(!comment.getContent().trim().equals("")) {
				comment.setCreateDate(new Date());
				comment.setCreator(user);
				Movie movie = ms.getMovieById(movieIdOther);
				comment.setMovieId(movie);
				boolean insert = commentService.insert(comment);
			}else {
				vs.set("playMsg", "N");
			}
		}else {
			vs.set("playMsg", "L");  //表示未登录
		}
		return SUCCESS;
	}
	

}
