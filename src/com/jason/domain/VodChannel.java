package com.jason.domain;

import java.io.Serializable;
import java.util.Date;
/*id 	varchar(32) 	非空	主键约束	 ID 用32位随机UUID 
channel_no				频道栏的编号
imgPath1				大图地址
imgPath2				小图地址
movieId				影片的ID  (关联 Movie 表的 ID)
introduce				频道介绍
createDate 	timestamp 			创建记录的时间*/

import org.springframework.stereotype.Component;

@Component
public class VodChannel implements Serializable{
	private String id;
	private Integer channelNo;
	private String imgPath1;
	private String imgPath2;
	private Movie movieId;
	private String introduce;
	private Date createDate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getChannelNo() {
		return channelNo;
	}
	public void setChannelNo(Integer channelNo) {
		this.channelNo = channelNo;
	}
	public String getImgPath1() {
		return imgPath1;
	}
	public void setImgPath1(String imgPath1) {
		this.imgPath1 = imgPath1;
	}
	public String getImgPath2() {
		return imgPath2;
	}
	public void setImgPath2(String imgPath2) {
		this.imgPath2 = imgPath2;
	}
	public Movie getMovieId() {
		return movieId;
	}
	public void setMovieId(Movie movieId) {
		this.movieId = movieId;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "VodChannel [id=" + id + ", channelNo=" + channelNo + ", imgPath1=" + imgPath1 + ", imgPath2=" + imgPath2
				+ ", movieId=" + movieId + ", introduce=" + introduce + ", createDate=" + createDate + "]";
	}
	
	
	

}
