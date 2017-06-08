package manage.action;

import java.util.Map;

import manage.entity.Student;
import manage.entity.Teacher;
import manage.entity.UserD;
import manage.service.loginService;
import manage.service.studentService;
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
public class loginAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	@Autowired
	private loginService service;
	@Autowired
	private teacherService tservice;
	@Autowired
	private studentService sservice;
	@Autowired
	private userService uservice;
	
	private User user;
	private String oldPW;
	
	private UserD userd;
	private Teacher teacher;
	private Student student;
	/**
	 * 输出错误信息，必须写get/set方法
	 */
	private String error_msg;
	/**
	 * session为Map类型，此值存储session
	 */
	private Map<String, Object> session;
	
	/**
	 * 用户登录
	 * @return
	 */
	public String selectUser(){
		userd = service.select_user(user);
		if(userd!=null && userd.getPwd().equals(user.getPassword())){
			//登陆成功 ，将用户信息保存至session中
			session =  ActionContext.getContext().getSession();
			if(userd.getProxy().equals("1")){
				teacher = tservice.select_Teacher(userd.getUserid());
				session.put("user", teacher);
				return SUCCESS;
			}else if(userd.getProxy().equals("0")){
				student = sservice.select_Student(userd.getUserid());
				session.put("user", student);
			}
			return "success1";
		}else{
			error_msg = "对不起！用户名或密码错误，请重新输入。^_^";
			return ERROR;
		}	
	}
	
	public String updatePW(){
		Map<String,Object> amap = ActionContext.getContext().getSession();
		Object obj = amap.get("user");
		UserD ud = new UserD();
		if (obj instanceof Student) {
			Student stu = (Student)obj;
			ud = service.select_user(new User(stu.getSno(),""));
		} else {
			Teacher tea = (Teacher)obj;
			ud = service.select_user(new User(tea.getTno(),""));
		}
		if (ud.getPwd().equals(oldPW)) {
			try {
				ud.setPwd(user.getPassword());
				System.out.println(ud.toString());
				uservice.update_PW(ud);
			} catch (Exception e){
				e.printStackTrace();
				error_msg = "对不起！密码修改失败，可能是原始密码错误，请确认。^_^";
				return ERROR;
			}
		} else {
			error_msg = "对不起！密码修改失败，可能是原始密码错误，请确认。^_^";
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
	public String getError_msg() {
		return error_msg;
	}
	public void setError_msg(String error_msg) {
		this.error_msg = error_msg;
	}

	public String getOldPW() {
		return oldPW;
	}

	public void setOldPW(String oldPW) {
		this.oldPW = oldPW;
	}
	
}
