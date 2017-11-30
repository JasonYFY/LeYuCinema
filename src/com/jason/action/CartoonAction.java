package com.jason.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jason.domain.Category;
import com.jason.domain.Movie;
import com.jason.domain.PageModel;
import com.jason.service.ICartoonService;
import com.jason.service.IMovieService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 动漫栏目
 * @author jason
 *
 */
@Controller
@Scope(value="prototype")
public class CartoonAction extends ActionSupport{
	private PageModel pageModel=new PageModel();
	
	private Integer cartoonPage;
	@Autowired
	private ICartoonService cartoonService;
	@Autowired
	private IMovieService movieService;
	public PageModel getPageModel() {
		return pageModel;
	}
	public void setPageModel(PageModel pageModel) {
		this.pageModel = pageModel;
	}
	public Integer getCartoonPage() {
		return cartoonPage;
	}
	public void setCartoonPage(Integer cartoonPage) {
		this.cartoonPage = cartoonPage;
	}
	
	//动漫栏目
	public String cartoonForm() throws Exception {
		return SUCCESS;
	}
	
	//动漫栏目结果显示
	public String cartoonFormResult() throws Exception {
		ActionContext context = ActionContext.getContext();
		ValueStack vs = context.getValueStack();
		Category cartoonCategory = cartoonService.getCartoonCategory();
		Movie movie = new Movie();
		movie.setCategory(cartoonCategory);
		List<Movie> list = movieService.queryMovieByPage(movie, pageModel);
		vs.set("cartoonList", list);
		return SUCCESS;
	}
	
	//动漫首页排行榜
	public String cartoonIndexRanking() throws Exception {
		ActionContext context = ActionContext.getContext();
		ValueStack vs = context.getValueStack();
		List<Movie> list = cartoonService.getCartoonRankingToIndex();
		vs.set("cartoonIndexRanking", list);
		return SUCCESS;
	}
	
	//主页显示的动漫栏目
	public String cartoonRefresh() throws Exception {
		ActionContext context = ActionContext.getContext();
		ValueStack vs = context.getValueStack();
		Map<String, Object> session = context.getSession();
		Integer page = (Integer) session.get("cartoonPage");
		List<Movie> cartoonList = null;
		Integer count = cartoonService.getCartoonCount();
		if(page==null) {
			cartoonList = cartoonService.getCartoonToIndex(0);
			if(count!=null&&count<=10) {
				session.put("cartoonPage", 0);
			}else
				session.put("cartoonPage", 10);
			
			
		}else {
			if(count!=null&&count>0) {
				if(page+10>count&&count>page&&count>10) {
					page = count-10;
				}else {
					page = page%count;
				}
				cartoonList = cartoonService.getCartoonToIndex(page);
				if(count<=10){
					session.put("cartoonPage", page);
				}else
					session.put("cartoonPage", page+10);
			}
		}
		
		vs.set("cartoonList", cartoonList);
		return SUCCESS;
	}

}
