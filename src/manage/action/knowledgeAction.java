package manage.action;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import manage.entity.Knowledge;
import manage.entity.Teacher;
import manage.service.knowledgeService;
import manage.service.watchLogService;
import manage.util.UpdateUtil;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class knowledgeAction extends ActionSupport{
	//获取上传文件
	private File file;
	//上传文件名称
	private String fileName;
	//知识点信息
	private Knowledge klg;
	//教师查看知识点list
	private List<Knowledge> list;
	//教师查看时观看状态记录<kno,number>
	private Map<String,String> map;
	
	@Autowired
	private knowledgeService service;
	
	@Autowired
	private watchLogService wservice;
	
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
	
	/**
	 * 上传视频并添加知识点信息
	 * @return
	 */
	public String uploadKnowledge(){
		request = ServletActionContext.getRequest();
		Map<String,Object> map = ActionContext.getContext().getSession();
		Teacher teacher = (Teacher)map.get("user");
		fileName = fileName.substring(fileName.lastIndexOf("\\")+1,fileName.length());
		try {
			//request.setCharacterEncoding("UTF-8");
			if (fileName.endsWith(".mp4") || fileName.endsWith(".rmvb") || 
					fileName.endsWith(".3GP") || fileName.endsWith(".AVI") 
					|| fileName.endsWith(".wma") || fileName.endsWith(".flash") 
					|| fileName.endsWith(".rm") || fileName.endsWith(".mid")){
		        sc = ServletActionContext.getServletContext();
		        //路径名为.../media/tno-tname.xml
				uploadpath = sc.getRealPath("/") + "media/"
						+klg.getChapter()+"-"+klg.getContent()+"."
						+fileName.split("\\.")[1];
				//创建新文件
				newfile = new File(uploadpath);
				//上传文件
				UpdateUtil.update(file, newfile);
				service.add_Knowledge(klg);
				upload_msg = "上传成功";
			}else{
				upload_msg = "文件格式不符，请上传.mp4/.rmvb/.3GP等视频格式的文件";
				return ERROR;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			upload_msg = "上传文件异常，请检查您的视频文件是否正确!";
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String listTeaKnowledge(){
		list = service.select_Knowledges();
		for(Knowledge obj:list){
			wservice.select_WatchLogs(obj.getKno());
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
	public Knowledge getKlg() {
		return klg;
	}
	public void setKlg(Knowledge klg) {
		this.klg = klg;
	}

	public List<Knowledge> getList() {
		return list;
	}

	public void setList(List<Knowledge> list) {
		this.list = list;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}
}
