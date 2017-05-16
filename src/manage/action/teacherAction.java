package manage.action;

import javax.servlet.http.HttpServletRequest;

import manage.entity.Teacher;
import manage.service.teacherService;
import manage.vo.User;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class teacherAction extends ActionSupport{
	private User user;
	private Teacher t;
	private HttpServletRequest request;
	@Autowired
	private teacherService service;
	private String update_pwd_msg;
	
	/**
	 * 添加教师
	 * @return
	 */
	public String add_teacher(){
//		System.out.println(t.toString());
		try{
			service.add_Teacher(t);
			update_pwd_msg = "添加成功！";
		} catch (Exception e) {
			e.printStackTrace();
			update_pwd_msg = "添加失败！";
		}
		return SUCCESS;
	}
	
	/**
	 * 删除教师
	 * @return
	 */
	public String del_Teacher(){
		request = ServletActionContext.getRequest();
		String tno = request.getParameter("tno");
//		System.out.println(tno);
		try{
			service.del_Teacher(tno);
			update_pwd_msg = "删除成功";
		}catch(Exception e){
			e.printStackTrace();
			update_pwd_msg = "删除失败";
		}
		return SUCCESS;
	}
	
	/**
	 * 修改密码
	 * @return
	 */
	public String updatePwd(){
		try {
			service.update_pwd(user);
			update_pwd_msg = "修改成功！";
			
		} catch (Exception e) {
			e.printStackTrace();
			update_pwd_msg = "修改失败！";
		}
		
		return SUCCESS;
	}
	
	/**
	 * 修改信息
	 * @return
	 */
	public String updateInfo(){
		try {
			service.update_info(t);
			System.out.println(t.toString());
			update_pwd_msg = "修改成功！";
		} catch (Exception e) {
			e.printStackTrace();
			update_pwd_msg = "修改失败！";
		}	
		return SUCCESS;
	}

	public String addteacher(){
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
	public Teacher getT() {
		return t;
	}
	public void setT(Teacher t) {
		this.t = t;
	}
}