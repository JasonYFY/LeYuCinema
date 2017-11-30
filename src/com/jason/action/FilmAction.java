package com.jason.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jason.domain.Category;
import com.jason.domain.Movie;
import com.jason.domain.PageModel;
import com.jason.service.IFilmService;
import com.jason.service.IMovieService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 电影栏
 * @author jason
 *
 */
@Controller
@Scope(value="prototype")
public class FilmAction extends ActionSupport{
	private PageModel pageModel=new PageModel();
	private Integer filmPage;
	@Autowired
	private IFilmService filemService;
	@Autowired
	private IMovieService movieService;
	
	public Integer getFilmPage() {
		return filmPage;
	}

	public void setFilmPage(Integer filmPage) {
		this.filmPage = filmPage;
	}
	
	
	public IFilmService getFilemService() {
		return filemService;
	}

	public void setFilemService(IFilmService filemService) {
		this.filemService = filemService;
	}
	
	
	
	public PageModel getPageModel() {
		return pageModel;
	}

	public void setPageModel(PageModel pageModel) {
		this.pageModel = pageModel;
	}

	//电影栏目
	public String filmForm() throws Exception {
		return SUCCESS;
	}
	//电影栏目显示
	public String filmFormResult() throws Exception {
		ActionContext context = ActionContext.getContext();
		ValueStack vs = context.getValueStack();
		Category filmCategory = filemService.getFilmCategory();
		Movie movie = new Movie();
		movie.setCategory(filmCategory);
		List<Movie> list = movieService.queryMovieByPage(movie, pageModel);
		vs.set("filmList", list);
		return SUCCESS;
	}

	//主页显示的电影栏目
	public String filmRefresh() throws Exception {
		ActionContext context = ActionContext.getContext();
		ValueStack vs = context.getValueStack();
		Map<String, Object> session = context.getSession();
		Integer page = (Integer) session.get("filmPage");
		Integer count = filemService.getFilmCount();
		List<Movie> filmList = null;
		if(page==null) {
			filmList = filemService.getFilmToIndex(0);
			if(count!=null&&count<=5) {
				session.put("filmPage", 0);
			}else
				session.put("filmPage", 5);
		}else {
			if(count!=null&&count>0) {
				if(page+5>count&&count>page&&count>5) {
					page = count-5;
				}else {
					page = page%count;
				}
				filmList = filemService.getFilmToIndex(page);
				if(count<=5) {
					session.put("filmPage", page);
				}else
					session.put("filmPage", page+5);
			}
		}
		
		vs.set("filmList", filmList);
		return SUCCESS;
	}

}
