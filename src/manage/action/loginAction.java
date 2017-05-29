package manage.action;

import java.util.Map;
import manage.entity.Student;
import manage.entity.Teacher;
import manage.entity.UserD;
import manage.service.loginService;
import manage.service.studentService;
import manage.service.teacherService;
import manage.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class loginAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	@Autowired
	private loginService service;
	private teacherService tservice;
	private studentService sservice;
	private User user;
	private UserD userd;
	private Teacher teacher;
	private Student student;
	/**
	 * 输出错误信息，必须写get/set方法
	 */
	private String error_msg;
	/**
	 * 教师权限信息，必须写get/set方法
	 */
	private String proy_info;
	/**
	 * session为Map类型，此值存储session
	 */
	private Map<String, Object> session;

	public String selectUser(){
		System.out.println("----hahaha-----");
			userd = service.select_user(user);
			if(userd!=null && userd.getPassword().equals(user.getPassword())){
				//登陆成功 ，将用户信息保存至session中
				session =  ActionContext.getContext().getSession();
				if(userd.getProy().equals("1")){
					proy_info = "教师用户";
					teacher = tservice.select_Teacher(userd.getUid());
					session.put("user", teacher);
					return SUCCESS;
				}else if(userd.getProy().equals("0")){
					proy_info = "学生用户";
					student = sservice.select_Student(userd.getUid());
					session.put("user", student);
				}
				return "success1";
			}else{
				error_msg = "用户名或密码错误！";
				return ERROR;
			}	
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getError_msg() {
		return error_msg;
	}
	public void setError_msg(String error_msg) {
		this.error_msg = error_msg;
	}

	public String getProy_info() {
		return proy_info;
	}
	public void setProy_info(String proy_info) {
		this.proy_info = proy_info;
	}
}
