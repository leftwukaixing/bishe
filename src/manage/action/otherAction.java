package manage.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import manage.entity.Teacher;
import manage.service.courseService;
import manage.service.e_infoService;
import manage.service.e_manageService;
import manage.service.m_infoService;
import manage.service.m_manageService;
import manage.service.teacherService;
import manage.vo.Page;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class otherAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private e_infoService service_i;
	@Autowired
	private m_infoService service_l;
	@Autowired
	private m_manageService service_m;
	@Autowired
	private e_manageService service_e;
	@Autowired
	private teacherService service_t;
	@Autowired
	private courseService service_c;

	private List<Teacher> teachers;
	private Page page;
	private HttpServletRequest request;
	private Teacher teacher;

	public String updateTerm(){
		service_i.delete_all_e_info();
		service_l.delete_all_m_info();
		service_e.delete_all_e_manage();
		service_m.delete_all_m_manage();
		service_t.update_count_zero();
		service_t.update_upload_zero();
		service_c.delete_all_course();
		return SUCCESS;
	}
	public String showTeacher(){
		teachers = service_t.select_all_teacher();
		page = new Page();
		request = ServletActionContext.getRequest();
		int a = Integer.parseInt(request.getParameter("current"));
		page.setCurrent(a);
		page.setRows(teachers.size());
		int from = page.getPageSize()*(page.getCurrent()-1);
		int to = 	page.getPageSize()*page.getCurrent();
		teachers = teachers.subList((from<teachers.size())?from:0
				,(to<teachers.size())?to:teachers.size());
		return SUCCESS;
	}
	public String updateTeacher(){
		request = ServletActionContext.getRequest();
		String tno = request.getParameter("tno");
		teacher = service_t.select_e_teacher(tno);
		return SUCCESS;
	}
	public String update(){
		service_t.update_teacher_info(teacher);
		if(teacher!=null&&teacher.getUpload().equals("0")){
			service_t.delete_all_course_by_tno(teacher.getTno());
		}
		return SUCCESS;
	}
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
}
