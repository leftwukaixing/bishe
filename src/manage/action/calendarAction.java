package manage.action;

import java.io.File;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import manage.entity.Teacher;
import manage.util.UpdateUtil;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class calendarAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//获取上传文件
	private File file;
	//上传文件名称
	private String fileName;

	//保存文件
	private File newfile;
	//获得请求
	private HttpServletRequest request;
	//获取上下文信息
	private ServletContext sc;
	//保存文件路径
	private String uploadpath;
	//上传信息
	private String upload_msg;
	public String upload(){
		request = ServletActionContext.getRequest();
		Map<String,Object> map = ActionContext.getContext().getSession();
		Teacher teacher = (Teacher)map.get("teacher");
		fileName = fileName.substring(fileName.lastIndexOf("\\")+1,fileName.length());
		try {
			request.setCharacterEncoding("UTF-8");
			if (fileName.endsWith(".zip") || fileName.endsWith(".rar")){
		        sc = ServletActionContext.getServletContext();
		        //路径名为.../uploads/calendar/tno-tname.xml
				uploadpath = sc.getRealPath("/") + "uploads"
						+ File.separator+"calendar"+File.separator
						+teacher.getTno()+"-"+teacher.getTname()+"."
						+fileName.split("\\.")[1];
				//创建新文件
				newfile = new File(uploadpath);
				//上传文件
				UpdateUtil.update(file, newfile);
				upload_msg = "上传成功";
			}else{
				upload_msg = "文件格式不符，请上传.zip或者.rar格式的文件";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			upload_msg = "上传文件异常，请检查您的教学日历是否正确!";
		}
		return SUCCESS;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUpload_msg() {
		return upload_msg;
	}
	public void setUpload_msg(String upload_msg) {
		this.upload_msg = upload_msg;
	}
	
}
