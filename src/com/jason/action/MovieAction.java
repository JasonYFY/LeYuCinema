package com.jason.action;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jason.domain.Category;
import com.jason.domain.Movie;
import com.jason.domain.PageModel;
import com.jason.domain.User;
import com.jason.service.ICategoryService;
import com.jason.service.IMovieService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
@Controller
@Scope(value="prototype")
public class MovieAction extends ActionSupport implements ModelDriven<Movie>{
	private Movie movie = new Movie();
	private PageModel pageModel=new PageModel();
	private String categoryId;
	@Autowired
	private IMovieService ms;
	@Autowired
	private ICategoryService categoryService;
	private File uploadFile;
	private String uploadFileContentType; //获取上传文件的类型（自动注入）
	private String uploadFileFileName;
	private File uploadPic;
	private String uploadPicContentType; //获取上传文件的类型（自动注入）
	private String uploadPicFileName;
	
	
	public PageModel getPageModel() {
		return pageModel;
	}

	public void setPageModel(PageModel pageModel) {
		this.pageModel = pageModel;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getUploadFileContentType() {
		return uploadFileContentType;
	}

	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}

	public String getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	public File getUploadPic() {
		return uploadPic;
	}

	public void setUploadPic(File uploadPic) {
		this.uploadPic = uploadPic;
	}

	public String getUploadPicContentType() {
		return uploadPicContentType;
	}

	public void setUploadPicContentType(String uploadPicContentType) {
		this.uploadPicContentType = uploadPicContentType;
	}

	public String getUploadPicFileName() {
		return uploadPicFileName;
	}

	public void setUploadPicFileName(String uploadPicFileName) {
		this.uploadPicFileName = uploadPicFileName;
	}
	
	//文件保存路径
	public String getSaveFilePath() {
		return getPojectPath()+"file";
	}
	//缩略图保存路径
	public String getSavePicPath() {
		return getPojectPath()+"pic";
	}

	@Override
	public Movie getModel() {
		return movie;
	}
	
	

	//播放页面
	public String playForm() throws Exception {
		ActionContext context = ActionContext.getContext();
		ValueStack vs = context.getValueStack();
		Map<String, Object> session = context.getSession();
		
		Movie m = ms.getMovieById(movie.getId());
		Integer t = m.getPlayTimes();
		//播放次数+1
		if(t!=null) {
			m.setPlayTimes(t+1);
		}else {
			m.setPlayTimes(1);
		}
		ms.update(m);
		vs.set("nowMovie", m);
		session.put("nowMovie", m);
		return SUCCESS;
	}
	
	//上传页面
	public String uploadFileForm() throws Exception {
		/*ValueStack vs = ActionContext.getContext().getValueStack();
		List<Category> list = categoryService.queryAllCategory();
		vs.set("categoryList", list);*/
		addcategoryListToUploadForm();
		return SUCCESS;
	}
	//搜索界面
	public String searchForm() throws Exception {
		
		return SUCCESS;
	}
	//搜索
	public String search() throws Exception {
		ActionContext context = ActionContext.getContext();
		ValueStack vs = context.getValueStack();
		
		List<Movie> list = ms.queryMovieByPage(movie, pageModel);
		
		vs.set("searchList", list);
		vs.set("count", list.size());
		return SUCCESS;
	}
	//点赞
	public String doLike() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		String pass = (String) session.get(movie.getId()+"goodCount");
		if(pass==null) {
			Movie m = ms.getMovieById(movie.getId());
			m.setGoodCount(movie.getGoodCount()+1);
			boolean update = ms.update(m);
			if(update) {
				movie.setGoodCount(movie.getGoodCount()+1);
				session.put(movie.getId()+"goodCount", "Y");
			}
		}
		return SUCCESS;
	}
	//上传
	public String uploadFile() throws Exception {
		ValueStack vs = ActionContext.getContext().getValueStack();
		Map<String, Object> session = ActionContext.getContext().getSession();
		List<Category> list = categoryService.queryAllCategory();
		vs.set("categoryList", list);
		System.out.println("上传文件类型="+getUploadFileContentType());
		System.out.println("上传文件名="+getUploadFileFileName());
		
		if(getUploadFileFileName()==null) {
			vs.set("errorU", "yes");
			return INPUT;
		}
		
		Category category = categoryService.get(categoryId);
		User user = (User) session.get("nowUser");
		FileInputStream inFile=null,inPic = null;
		FileOutputStream out=null,out2=null;
		boolean upload = false;
		try {
			inFile = new FileInputStream(getUploadFile());
			inPic = new FileInputStream(getUploadPic());
			
			
			//文件路径
			String pathFile= getSaveFilePath()+"\\"+getUploadFileFileName();
			System.out.println("文件路径："+pathFile);
			String pathPic= getSavePicPath()+"\\"+getUploadPicFileName();
			String extName = getUploadFileFileName().substring(getUploadFileFileName().lastIndexOf(".")+1, getUploadFileFileName().length());
			String imgExtName = getUploadPicFileName().substring(getUploadPicFileName().lastIndexOf(".")+1, getUploadPicFileName().length());
			System.out.println("后缀："+extName);
			
			
			movie.setExtName(extName);//文件后缀
			movie.setImgExtName(imgExtName);
			movie.setUploader(user);
			movie.setCreateDate(new Date());
			movie.setCategory(category);  //set文件类型
			movie.setFilepath("upload\\file\\"+getUploadFileFileName()); //set文件路径
			movie.setFilepic("upload\\pic\\"+getUploadPicFileName());
			movie.setPlayTimes(0);
			out = new FileOutputStream(pathFile);
			out2 = new FileOutputStream(pathPic);
			byte[] b = new byte[2024];
			int len = -1;
			while((len=inFile.read(b))!=-1) {
				out.write(b, 0, len);
			}
			len = -1;
			while((len=inPic.read(b))!=-1) {
				out2.write(b, 0, len);
			}
			movie.setUploadTime(new Date());
			upload = ms.upload(movie);
		}catch (Exception e) {
			e.printStackTrace();
			vs.set("errorU", "yes");
			return INPUT;
		}finally {
			inFile.close();
			inPic.close();
			out.close();
			out2.close();
		}
		if(upload) {
			vs.set("errorU", "no");
		}else {
			vs.set("errorU", "yes");
		}
		return SUCCESS;
		
		
	}
	//获取工程路径 D:/Frame/LeYuCinema/WebContent/
	public String getPojectPath() {
//		String u=this.getClass().getResource("/").getPath();
//		String st = u.substring(1,u.indexOf("WEB-INF"));
		/*HttpServletRequest request = ServletActionContext.getRequest();
		String realPath = request.getServletContext().getRealPath("/upload");
		System.out.println("[realPath]"+realPath);*/
		String st = "D:/LuYuUpload/";
		
		return st;
	}
	
	
	public void validateUploadFile() {
		addcategoryListToUploadForm();
	}
	
	
	public void addcategoryListToUploadForm() {
		ValueStack vs = ActionContext.getContext().getValueStack();
		List<Category> list = categoryService.queryAllCategory();
		vs.set("categoryList", list);
	}
	

}
