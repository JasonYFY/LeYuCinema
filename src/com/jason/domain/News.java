package com.jason.domain;

import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class News {
	private String id;
	private String newsNo;
	private String newsName;
	private String imgPath;
	private Movie movieId;
	private Date createDate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNewsNo() {
		return newsNo;
	}
	public void setNewsNo(String newsNo) {
		this.newsNo = newsNo;
	}
	public String getNewsName() {
		return newsName;
	}
	public void setNewsName(String newsName) {
		this.newsName = newsName;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public Movie getMovieId() {
		return movieId;
	}
	public void setMovieId(Movie movieId) {
		this.movieId = movieId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "News [id=" + id + ", newsNo=" + newsNo + ", newsName=" + newsName + ", imgPath=" + imgPath
				+ ", movieId=" + movieId + ", createDate=" + createDate + "]";
	}
	
	

}
