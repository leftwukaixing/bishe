package manage.action;

import java.io.File;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import manage.entity.Course;
import manage.entity.Teacher;
import manage.service.courseService;
import manage.service.teacherService;
import manage.util.ReadExcel;
import manage.util.UpdateUtil;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class courseAction extends ActionSupport{
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
	@Autowired
	private courseService service;
	@Autowired
	private teacherService tservice;
	//线性表用来存储课程
	private List<Course> list;

	public String upload(){
		request = ServletActionContext.getRequest();
		Map<String,Object> map = ActionContext.getContext().getSession();
		Teacher teacher = (Teacher)map.get("teacher");
		fileName = fileName.substring(fileName.lastIndexOf("\\")+1,fileName.length());
		try {
			request.setCharacterEncoding("UTF-8");
			//查看该教师是否上传过课表
			//System.out.println(tservice.select_upload(teacher.getTno()));
			if("1".equals(tservice.select_upload(teacher.getTno()))){
				upload_msg = "您已上传过课表，无需重复上传！";
				return SUCCESS;
			}
			if (fileName.endsWith(".et") || fileName.endsWith(".xls")
					|| fileName.endsWith(".xlsx")){
		        sc = ServletActionContext.getServletContext();
		        //路径名为.../uploads/course/tno-tname.xml
				uploadpath = sc.getRealPath("/") + "uploads"
						+ File.separator+"course"+File.separator
						+teacher.getTno()+"-"+teacher.getTname()+"."
						+fileName.split("\\.")[1];
				System.out.println("#########"+uploadpath);
				//创建新文件
				newfile = new File(uploadpath);
				//上传文件
				UpdateUtil.update(file, newfile);
				//读取文件
				list = ReadExcel.readCourse(uploadpath,teacher.getTno());
				//写入数据库
				service.insert_course(list);
				//修改上传信息
				tservice.update_upload(teacher.getTno());
				upload_msg = "上传成功";
			}else{
				upload_msg = "文件格式不符，请上传.et/.xls/.xlsx格式的文件";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			upload_msg = "上传文件异常，请检查您的课表是否正确!";
		}
	
		return SUCCESS;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getUpload_msg() {
		return upload_msg;
	}
	public void setUpload_msg(String upload_msg) {
		this.upload_msg = upload_msg;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
