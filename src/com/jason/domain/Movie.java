package com.jason.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;
/*id 	varchar(32) 	非空	主键约束	 ID 用32位随机UUID 
mvName 	varchar(32) 			电影名称
mvDesc 	varchar(32) 			电影描述
mvDuration 	varchar(32) 			电影的长度
uploader 	varchar(32) 			上传者的ID (关联到 User 表的 ID)
uploadTime 	timestamp 			上传时间
playTimes 	int(32) 			播放次数 (每次累加)
isEnabled 	varchar(2) 			是否允许播放 11, 01, 10, 00
只有: 11 才可以被其它用户播放
label 	varchar(32) 			标签
goodCount 	int(32) 			点赞数
category 	varchar(32) 			分类 (关联类别表category 的 ID)
costPoint 	int(16) 			观看此片需要花费点数(默认为 0)
extName 	varchar(16) 			影片的扩展名, 如: flv, mp4, mp3 ...
imgExtName	varchar(16) 			缩略图的扩展名, 需限定: jpg, png 两种格式, 与大小。
createDate 	timestamp 			创建记录的时间
filepath     varchar(80)                 文件路径
filepic      varchar(80)                 发布影片封面路径
*/
@Component
public class Movie implements Serializable{
	private String id;
	private String mvName;
	private String mvDesc;
	private String mvDuration;
//	上传者的ID (关联到 User 表的 ID)
	private User uploader;
	private Date uploadTime;
	private Integer playTimes;
	private String isEnabled;
	private String label;
	private Integer goodCount;
	//分类 (关联类别表category 的 ID)
	private Category category;
	private Integer costPoint;
	private String extName;
	private String imgExtName;
	private Date createDate;
	private String filepath;
	private String filepic;
	
	public String getFilepic() {
		return filepic;
	}
	public void setFilepic(String filepic) {
		this.filepic = filepic;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMvName() {
		return mvName;
	}
	public void setMvName(String mvName) {
		this.mvName = mvName;
	}
	public String getMvDesc() {
		return mvDesc;
	}
	public void setMvDesc(String mvDesc) {
		this.mvDesc = mvDesc;
	}
	public String getMvDuration() {
		return mvDuration;
	}
	public void setMvDuration(String mvDuration) {
		this.mvDuration = mvDuration;
	}
	public User getUploader() {
		return uploader;
	}
	public void setUploader(User uploader) {
		this.uploader = uploader;
	}
	public Date getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}
	public Integer getPlayTimes() {
		return playTimes;
	}
	public void setPlayTimes(Integer playTimes) {
		this.playTimes = playTimes;
	}
	public String getIsEnabled() {
		return isEnabled;
	}
	public void setIsEnabled(String isEnabled) {
		this.isEnabled = isEnabled;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Integer getGoodCount() {
		return goodCount;
	}
	public void setGoodCount(Integer goodCount) {
		this.goodCount = goodCount;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Integer getCostPoint() {
		return costPoint;
	}
	public void setCostPoint(Integer costPoint) {
		this.costPoint = costPoint;
	}
	public String getExtName() {
		return extName;
	}
	public void setExtName(String extName) {
		this.extName = extName;
	}
	public String getImgExtName() {
		return imgExtName;
	}
	public void setImgExtName(String imgExtName) {
		this.imgExtName = imgExtName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public String toString() {
		return "Movie [id=" + id + ", mvName=" + mvName + ", mvDesc=" + mvDesc + ", mvDuration=" + mvDuration
				+ ", uploader=" + uploader + ", uploadTime=" + uploadTime + ", playTimes=" + playTimes + ", isEnabled="
				+ isEnabled + ", label=" + label + ", goodCount=" + goodCount + ", category=" + category
				+ ", costPoint=" + costPoint + ", extName=" + extName + ", imgExtName=" + imgExtName + ", createDate="
				+ createDate + ", filepath=" + filepath + ", filepic=" + filepic + "]";
	}
	
	
	
}
