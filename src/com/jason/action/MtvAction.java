package com.jason.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jason.domain.Category;
import com.jason.domain.Movie;
import com.jason.domain.PageModel;
import com.jason.service.IMTVService;
import com.jason.service.IMovieService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

@Controller
@Scope(value="prototype")
public class MtvAction extends ActionSupport{
	private PageModel pageModel=new PageModel();
	
	private Integer mtvPage;
	@Autowired
	private IMTVService mtvService;
	@Autowired
	private IMovieService movieService;
	
	public PageModel getPageModel() {
		return pageModel;
	}

	public void setPageModel(PageModel pageModel) {
		this.pageModel = pageModel;
	}

	public Integer getMtvPage() {
		return mtvPage;
	}

	public void setMtvPage(Integer mtvPage) {
		this.mtvPage = mtvPage;
	}

	//mtv栏目
	public String mtvForm() throws Exception {
		return SUCCESS;
	}
	
	//mtv首页排行榜
	public String mtvIndexRanking() throws Exception {
		ActionContext context = ActionContext.getContext();
		ValueStack vs = context.getValueStack();
		List<Movie> list = mtvService.getMTVRankingToIndex();
		vs.set("mtvIndexRanking", list);
		return SUCCESS;
	}
	
	//mtv栏目结果显示
	public String mtvFormResult() throws Exception {
		ActionContext context = ActionContext.getContext();
		ValueStack vs = context.getValueStack();
		Category mvtCategory = mtvService.getMTVCategory();
		Movie movie = new Movie();
		movie.setCategory(mvtCategory);
		List<Movie> list = movieService.queryMovieByPage(movie, pageModel);
		vs.set("mtvList", list);
		return SUCCESS;
	}

	//主页显示的mtv栏目
	public String mvtRefresh() throws Exception {
		ActionContext context = ActionContext.getContext();
		ValueStack vs = context.getValueStack();
		Map<String, Object> session = context.getSession();
		Integer page = (Integer) session.get("mtvPage");
		List<Movie> mtvList = null;
		Integer count = mtvService.getMTVCount();
		if(page==null) {
			mtvList = mtvService.getMTVToIndex(0);
			if(count!=null&&count<=11) {
				session.put("mtvPage", 0);
			}else
				session.put("mtvPage", 11);
			
		}else {
			if(count!=null&&count>0) {
				if(page+11>count&&count>page&&count>10) {
					page = count-11;
				}else {
					page = page%count;
				}
				mtvList = mtvService.getMTVToIndex(page);
				if(count<=11){
					session.put("mtvPage", page);
				}else
					session.put("mtvPage", page+11);
			}
		}
		
		vs.set("mtvList", mtvList);
		return SUCCESS;
	}

}
