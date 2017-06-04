package manage.action;

import java.util.Map;

import manage.entity.Student;
import manage.entity.UserD;
import manage.service.studentService;
import manage.service.userService;
import manage.vo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class studentAction extends ActionSupport{
	private User user;
	private Student student;
	private Map<String, Object> session;
	
	@Autowired
	private studentService sservice;
	
	@Autowired
	private userService uservice;
	
	/**
	 * 添加Student用户，用户注册。
	 * @return
	 */
	public String addStudent(){
		try {
			UserD userd = new UserD(student.getSno(),user.getPassword(),"0");
			uservice.add_UserD(userd);
			sservice.add_Student(student);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 修改Student信息。
	 * @return
	 */
	public String updateStudent() {
		try{
			sservice.update_Student(student);
			session =  ActionContext.getContext().getSession();
			session.put("user", student);
		} catch(Exception e){
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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
