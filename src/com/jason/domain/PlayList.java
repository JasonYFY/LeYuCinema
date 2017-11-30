package com.jason.domain;

import java.io.Serializable;
import java.util.Date;

public class PlayList implements Serializable{
	private String id;
	private String listName;
	private String listNo;
	private Movie movieId;
	private User creator;
	private Date createDate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public String getListNo() {
		return listNo;
	}
	public void setListNo(String listNo) {
		this.listNo = listNo;
	}
	public Movie getMovieId() {
		return movieId;
	}
	public void setMovieId(Movie movieId) {
		this.movieId = movieId;
	}
	public User getCreator() {
		return creator;
	}
	public void setCreator(User creator) {
		this.creator = creator;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "PlayList [id=" + id + ", listName=" + listName + ", listNo=" + listNo + ", movieId=" + movieId
				+ ", creator=" + creator + ", createDate=" + createDate + "]";
	}
	
	

}
