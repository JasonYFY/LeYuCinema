package com.jason.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.springframework.stereotype.Component;
//类别表
@Component
public class Category implements Serializable{
	private String id;
	private String categoryName;
	private Date createDate;
	public Category() {
	}
	
	public Category(String categoryName, Date createDate) {
		this.categoryName = categoryName;
		this.createDate = createDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	

	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryName=" + categoryName + ", createDate=" + createDate + "]";
	}
	
	

}
