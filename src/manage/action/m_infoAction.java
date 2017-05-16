package manage.action;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import manage.entity.E_Info;
import manage.entity.M_Info;
import manage.entity.Teacher;
import manage.service.m_infoService;
import manage.util.DateUtil;
import manage.util.ReadExcel;
import manage.util.UpdateUtil;
import manage.vo.Page;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class m_infoAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File file;
	private String fileName;
	private File newfile;
	//上传信息
	private String upload_msg;
	private HttpServletRequest request;
	//获取上下文信息
	private ServletContext sc;
	//保存文件路径
	private String uploadpath;
	//考试信息集合
	private List<M_Info> list;
	//存储页面信息
	private Page page;
	//存储该页显示的考试
	private List<M_Info> m_infos;

	@Autowired
	private m_infoService service;
	
	public String upload(){
		request = ServletActionContext.getRequest();
		try {
			request.setCharacterEncoding("UTF-8");
			Map<String,Object> map = ActionContext.getContext().getSession();
			Teacher teacher = (Teacher)map.get("teacher");
			fileName = fileName.substring(fileName.lastIndexOf("\\")+1,fileName.length());
			if (fileName.endsWith(".et") || fileName.endsWith(".xls")
					|| fileName.endsWith(".xlsx")){
		        sc = ServletActionContext.getServletContext();
		        //路径名为.../uploads/course/tno-tname.xml
				uploadpath = sc.getRealPath("/") + "uploads"
						+ File.separator+"exam_info"+File.separator
						+DateUtil.getNow()+"-"
						+teacher.getTname()+"-阶段."+fileName.split("\\.")[1];
				System.out.println("~~~~~~~"+uploadpath);
				newfile = new File(uploadpath);
				UpdateUtil.update(file,newfile);
				list = ReadExcel.readM_Info(uploadpath);
				service.insert_m_info(list);
				upload_msg = "上传成功";
			}else{
				upload_msg = "文件格式不符，请上传.et/.xls/.xlsx格式的文件";
			}
		} catch (Exception e) {
			e.printStackTrace();
			upload_msg = "上传文件异常，请检查您的课表是否正确!";
		}
		return SUCCESS;
	}
	
	public String select_all_m_info(){

		list = service.select_all_m_info();
//		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		//按考试时间倒序排列
//		Collections.sort(list,new Comparator<M_Info>() {
//			public int compare(M_Info e1, M_Info e2) {
//				long t = 0;
//				try {
//					t = sdf.parse(e1.getTimeStart().split("\\s")[0].trim()).getTime()-
//								sdf.parse(e2.getTimeStart().split("\\s")[0].trim()).getTime();
//
//				} catch (ParseException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				if(t>0){
//					return -1;
//				}else{
//					return 1;
//				}
//			}
//		});
		
		page = new Page();
		request = ServletActionContext.getRequest();
		int a = Integer.parseInt(request.getParameter("current"));
		page.setCurrent(a);
		page.setRows(list.size());
		int from = page.getPageSize()*(page.getCurrent()-1);
		int to = 	page.getPageSize()*page.getCurrent();
		m_infos = list.subList((from<list.size())?from:0
				,(to<list.size())?to:list.size());
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

	public void setUpload_msg(String uploadMsg) {
		upload_msg = uploadMsg;
	}

	public List<M_Info> getList() {
		return list;
	}

	public void setList(List<M_Info> list) {
		this.list = list;
	}

	public List<M_Info> getM_infos() {
		return m_infos;
	}

	public void setM_infos(List<M_Info> mInfos) {
		m_infos = mInfos;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
	
	
}
