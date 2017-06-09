package manage.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import manage.entity.Chat;
import manage.entity.Student;
import manage.entity.Teacher;
import manage.entity.UserD;
import manage.service.chatService;
import manage.service.loginService;
import manage.service.studentService;
import manage.service.teacherService;
import manage.vo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class chatAction extends ActionSupport{
	private Chat chat;
	private List<Chat> list;
	private Map<String,String> map;
	
	@Autowired
	private loginService lservice;
	
	@Autowired
	private chatService cservice;
	
	@Autowired
	private teacherService tservice;
	
	@Autowired
	private studentService sservice;
	
	/**
	 * 列出聊天信息记录
	 * @return
	 */
	public String listChat(){
		UserD ud = new UserD();
		Teacher teacher = new Teacher();
		Student student = new Student();
		map = new HashMap<String,String>();
		try {
			list = cservice.select_Chats();
			for (Chat ch : list) {
				ud = lservice.select_user(new User(ch.getUno(),""));
				if (ud.getProxy().equals("1")) {
					teacher = tservice.select_Teacher(ud.getUserid());
					map.put(ud.getUserid(), teacher.getTname());
				} else if (ud.getProxy().equals("0")) {
					student = sservice.select_Student(ud.getUserid());
					map.put(ud.getUserid(), student.getSname());
				} else {
					return ERROR;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 聊天消息写入数据库
	 * @return
	 */
	public String addChat(){
		SimpleDateFormat myFmt=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");  
		Map<String,Object> amap = ActionContext.getContext().getSession();
		Object obj = amap.get("user");
		if (obj instanceof Student) {
			Student stu = (Student)obj;
			chat.setUno(stu.getSno());
		} else if (obj instanceof Teacher) {
			Teacher tea = (Teacher)obj;
			chat.setUno(tea.getTno());
		}
		//设置时间
		Date now = new Date();
		chat.setChat_time(myFmt.format(now).toString());
		//写入数据库
		try {
			cservice.add_Chat(chat);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	public Chat getChat() {
		return chat;
	}
	public void setChat(Chat chat) {
		this.chat = chat;
	}
	public List<Chat> getList() {
		return list;
	}
	public void setList(List<Chat> list) {
		this.list = list;
	}
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	
}
