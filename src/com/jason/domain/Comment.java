package com.jason.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;
/*id 	varchar(32) 	非空	主键约束	 ID 用32位随机UUID 
movieId    	varchar(32)			清单的名称
content    	varchar(512)		看片者对影片的评语
createDate	timestamp			创建日期
creator    	varchar(32)			创建者(评论人)*/
@Component
public class Comment implements Serializable{
	private String id;
	private Movie movieId;
	private String content;
	private Date createDate;
	private User creator;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Movie getMovieId() {
		return movieId;
	}
	public void setMovieId(Movie movieId) {
		this.movieId = movieId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public User getCreator() {
		return creator;
	}
	public void setCreator(User creator) {
		this.creator = creator;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", movieId=" + movieId + ", content=" + content + ", createDate=" + createDate
				+ ", creator=" + creator + "]";
	}
	
	

}
