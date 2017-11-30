package com.jason.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jason.domain.Movie;
import com.jason.domain.User;
import com.jason.service.IFilmService;
import com.jason.service.IUserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
@Controller
@Scope(value="prototype")
public class UserAction extends ActionSupport implements ModelDriven<User>{
	
	private User user = new User();
	@Autowired
	private IUserService us;
	@Autowired
	private IFilmService filemService;
	//电影栏目当前页数
	private Integer filmPage;
	

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public User getModel() {
		return user;
	}
	
	public Integer getFilmPage() {
		return filmPage;
	}


	public void setFilmPage(Integer filmPage) {
		this.filmPage = filmPage;
	}


	//首页界面
	public String indexForm() throws Exception {
		/*ValueStack vs = ActionContext.getContext().getValueStack();
		//获取电影
		if(getFilmPage()==null) {
			setFilmPage(0);
		}
		List<Movie> filmList = filemService.getFilmToIndex(filmPage);
		System.out.println("[filmList]:"+filmList.size());
		vs.set("filmList", filmList);*/
		return SUCCESS;
	}
	
	//登录界面
	public String loginForm() throws Exception {
		return SUCCESS;
	}
	//注册界面
	public String registerForm() throws Exception {
		return SUCCESS;
	}
	//登录处理
	public String loginUser() throws Exception {
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		ValueStack vs = context.getValueStack();
		User u = us.login(user);
		if(u!=null) {
			session.put("nowUser", u);
			return SUCCESS;
		}else {
			vs.set("errorL", "yes");
			return INPUT;
		}
		
	}
	//添加用户
	public String addUser() throws Exception {
		user.setCreateDate(new Date());
		boolean insert = us.insert(user);
		ValueStack vs = ActionContext.getContext().getValueStack();
		if (insert) {
			vs.set("errorA", "no");
		} else {
			vs.set("errorA", "yes");
		}
		return SUCCESS;
	}
	//用户退出登录
	public String loginoutUser() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("nowUser");
		return SUCCESS;
	}

}
