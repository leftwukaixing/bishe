package manage.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import manage.entity.Teacher;
import manage.service.teacherService;
import manage.util.sendMessage.Test;

import com.opensymphony.xwork2.ActionSupport;
@Controller
@Scope("prototype")
public class messageAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Teacher> teachers;
	private List<String> tnos;
	@Autowired
	private teacherService service_t;
	private String msg;
	//短信内容
	private String msgContent;

	//查询所有老师
    public String selectAllTeacher() {
    	teachers = service_t.select_all_teacher();
		return SUCCESS;
	}
    //查询所有已选老师
    public String send() throws UnsupportedEncodingException{
    	if(tnos!=null){
    		teachers = new ArrayList<Teacher>();
    		for (String tno:tnos) {
    			teachers.add(service_t.select_e_teacher(tno));
			}
    		System.out.println(msgContent);
    		for (Teacher t:teachers) {
				System.out.println(t);
			}
    		Test.sendMessage(teachers, msgContent);
    		msg = "发送成功！";
    	}else{
    		msg = "您未选中任何老师！";
    	}
		return SUCCESS;
    }
    
    
    
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	
	public List<String> getTnos() {
		return tnos;
	}
	public void setTnos(List<String> tnos) {
		this.tnos = tnos;
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String getMsgContent() {
		return msgContent;
	}
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
}
