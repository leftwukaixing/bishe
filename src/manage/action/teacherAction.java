package manage.action;

import java.util.Map;

import manage.entity.Teacher;
import manage.entity.UserD;
import manage.service.teacherService;
import manage.service.userService;
import manage.vo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class teacherAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private User user;
	private Teacher tea;
	private Map<String, Object> session;
	@Autowired
	private teacherService tservice;
	
	@Autowired
	private userService uservice;
	
	private String update_pwd_msg;
	
	/**
	 * 添加Teacher用户，用户注册。
	 * @return
	 */
	public String addTeacher(){
		try {
			UserD userd = new UserD(tea.getTno(),user.getPassword(),"1");
			uservice.add_UserD(userd);
			tservice.add_Teacher(tea);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 修改Teacher个人信息。
	 * @return
	 */
	public String updateTeacher() {
		try {
			tservice.update_Teacher(tea);
			session =  ActionContext.getContext().getSession();
			session.put("user", tea);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public String getUpdate_pwd_msg() {
		return update_pwd_msg;
	}
	public void setUpdate_pwd_msg(String update_pwd_msg) {
		this.update_pwd_msg = update_pwd_msg;
	}
	public Teacher getTea() {
		return tea;
	}
	public void setTea(Teacher tea) {
		this.tea = tea;
	}
}
