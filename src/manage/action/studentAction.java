package manage.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import manage.entity.Knowledge;
import manage.entity.Student;
import manage.entity.UserD;
import manage.entity.WatchLog;
import manage.service.knowledgeService;
import manage.service.studentService;
import manage.service.userService;
import manage.service.watchLogService;
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
	//学生知识点list
	private List<Knowledge> list;
	//学生观看状态记录<sno,status>
	private Map<String,String> map;
	
	@Autowired
	private studentService sservice;
	@Autowired
	private userService uservice;
	@Autowired
	private watchLogService wservice;
	@Autowired
	private knowledgeService kservice;
	
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
	
	public String Start(){
		map = new HashMap<String,String>();
		Map<String,Object> amap = ActionContext.getContext().getSession();
		Student student = (Student)amap.get("user");
		try {
			list = kservice.select_Knowledges();
			for(Knowledge obj:list){
				List<WatchLog> wlist = new ArrayList<WatchLog>();
				wlist = wservice.select_WatchLogs_By_Sno(student.getSno());
				for (WatchLog wo : wlist){
					if (obj.getKno().equals(wo.getKno())) {
						map.put(obj.getKno(), wo.getStatus());
					}
				}
			}
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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
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
