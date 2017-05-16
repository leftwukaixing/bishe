package manage.action;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import manage.entity.Course;
import manage.entity.E_Manage;
import manage.entity.M_Info;
import manage.entity.M_Manage;
import manage.entity.SelectM_info;
import manage.entity.Teacher;
import manage.service.courseService;
import manage.service.m_infoService;
import manage.service.m_manageService;
import manage.service.teacherService;
import manage.util.DayOfWeek;
import manage.util.countNumber;
import manage.util.getWeeks;
import manage.vo.Page;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class m_manageAction extends ActionSupport{
	
	private static final long serialVersionUID = 2L;
	@Autowired
	private m_infoService service;
	@Autowired
	private teacherService service_t;
	@Autowired
	private courseService service_c;
	@Autowired
	private m_manageService service_m;
	//存储考试信息
	private List<M_Info> m_infos;
	//存储其他科目考试信息
	private List<M_Info> others;
	//存放教师信息
	private List<Teacher> teachers;
	//存放课程信息
	private List<Course> courses;
	//存放查询的监考信息,设置为static为了在修改时实现次数的修改
	private static M_Manage m_manage;
	//存放考试日期时间
	private String datetime = null;
	//存放考试第几节
	private String time = null;
	//存放考试是周几
	private String day_of_week = null;
	//存放考试是第几周
	private String week = null;
	//存放考场个数			
	private int num;
	//判断教师被剔除标志
	private boolean flag;
	//教师迭代器
	private Iterator<Teacher> iterator;
	//分配信息
	private String m_manage_msg;
	
	private String error_message;
	//获取现在时间
	private Date now;
	//页面信息
	private Page page;
	//获取请求信息
	private HttpServletRequest request;
	//获取要修改的监考信息
	private List<M_Manage> m_manages;
	//存储json传来的教师id
	private String tno;
	//传输姓名
	private String tname;
	//传输电话号
	private String tel;
	//修改成功信息
	private String updateM_manage_msg;
	//存储修改后的e_manage
	private M_Manage m;
	
	/**
	 * 自动派发监考
	 * @return
	 */
	public String autoM_arrange(){

		m_infos = service.select_all_m_info();
		if(m_infos.isEmpty()){
			m_manage_msg = "Oh~~~Sorry!您还未上传阶段考试信息哦~！赶紧上传吧！*^_^*";
			return SUCCESS;
		}
		m_infos = service.select_m_info();
		if(m_infos.isEmpty()){
			m_manage_msg = "所有阶段考试均已分配过监考，无需重复分配！";
			return SUCCESS;
		}
		//存储监考信息
		for(M_Info m_info : m_infos){
			
//			System.out.println(m_info.toString());
			//如果教师ID为空，用空字符串代替
			if(m_info.getTeacher()==null || m_info.getTeacher().indexOf("[") == -1){
				m_info.setTeacher("aaa[0000000000]");
			}
			
			//取考场个数，监考老师的数目为考场数目的二倍
			countNumber count = new countNumber();
			String ss = m_info.getAddress();
			int n = count.countNum(ss, ",");
//			System.out.println("---e_info.getAddress()中,的个数：---->>>"+n);
			num = n + 1;
			//遍历非科任，并且能监考的教师，按监考次数升序排列
			
			int nu1 = m_info.getTeacher().indexOf("[");
			String tea = m_info.getTeacher().substring(nu1+1, nu1+11);
//			System.out.println("-----tea------>>"+tea);
//			m_info.setTeacher(tea);
			teachers = service_t.select_arrange_teacher(tea);
			
			//检测teachers是否有元素
//			for(Teacher t: teachers){
//				System.out.println(t.toString());
//			}
			//取考试所在周
			if(m_info.getWeek() != null){
				week = m_info.getWeek();
			}
//			System.out.println("*****第几周：》》"+week);
			int nu ;
			//取考试日期，时间，周几
			if(m_info.getTimeStart() != null){
				DayOfWeek obj = new DayOfWeek();
				nu = m_info.getTimeStart().indexOf(" ");
				datetime = m_info.getTimeStart().substring(0,nu);
				try {
					day_of_week = obj.dayOfWeek(datetime);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				time = m_info.getTimeStart().substring(nu+1, m_info.getTimeStart().length());
//				System.out.println("考试时间--->>>"+time);
				time = obj.timeOfDay(time);
			}
//			System.out.println("周几————>>>"+day_of_week);
//			System.out.println("----datetime---->>:"+datetime);
//			System.out.println("考试时间--->>>"+time);
			
//			for(Teacher teacher : teachers){
//				System.out.println(m_info.getCname()+":"+teacher.getTname()+"---"+teacher.getTno());
//			}
//			System.out.println();
			
			//剔除考试时间有课的教师
			iterator = teachers.iterator();
			while(iterator.hasNext()){
				Teacher teacher = iterator.next();
				flag = false;
				courses = service_c.select_course(teacher.getTno());
				for (Course course : courses) {
					//存储老师有课的周数
					List<Integer> ll = new ArrayList<Integer>();
					if(course.getWeek() != null){
						int n1=-2;
						getWeeks gws = new getWeeks();
						if (course.getWeek().indexOf(",") == -1) {
							String str = course.getWeek();
							gws.getWeek(str);
							for(Integer a : gws.getLl()){
								ll.add(a);
							}
						}else{
							n1 = course.getWeek().indexOf(",");
							String[] str = course.getWeek().split("\\,");
							for(int i = 0 ; i < str.length ; i ++){
								gws.getWeek(str[i]);
								for(Integer a : gws.getLl()){
									ll.add(a);
								}
							}
						}
					}
//					System.out.println("是否含双周--->>"+course.getWeek().contains("双"));
//					System.out.println("是否含考试周数---》》》"+!ll.contains(Integer.parseInt(week)));
					
//					for(Integer o : ll){
//						System.out.println("周数--->>"+o);
//					}
					
					if( ll.contains(Integer.parseInt(week)) ){
						if("0".equals(course.getRemark())||
								"1".equals(course.getRemark())&&Integer.parseInt(week)%2==1||
									"2".equals(course.getRemark()) && Integer.parseInt(week)%2==0){	
							if(day_of_week.equals(course.getDay_of_week())){
								if(time.equals(course.getTime())){
									iterator.remove();
									flag = true;
								}
							}
						}
					}
					if(flag == true){
						break;
					}
					
				}
			}
//			for(Teacher teacher : teachers){
//				System.out.println(m_info.getCname()+":"+teacher.getTname());
//			}
//			System.out.println();
			
			//剔除考试时间有监考任务的教师
			iterator = teachers.iterator();
			while(iterator.hasNext()){
				Teacher teacher = iterator.next();
				flag = false;
				m_manages = service_m.select_m_manage(teacher.getTno());
				for(M_Manage e_manage : m_manages){
					nu = e_manage.getTimeStart().indexOf(" ");
					if(datetime.equals(e_manage.getTimeStart().substring(0,nu))){
//						System.out.println(e_manage.getTimeStart().substring(0,nu));
						iterator.remove();
						flag = true;
					}
					if(flag == true){
						break;
					}
				}
			}
//			for(Teacher teacher : teachers){
//				System.out.println(m_info.getCname()+":"+teacher.getTname()+"---"+teacher.getTno());
//			}
//			System.out.println();
			
			//剔除其他科与本科考试时间相同的其他科科任老师
			iterator = teachers.iterator();
			while(iterator.hasNext()){
				Teacher teacher = iterator.next();
				flag = false;
				others = service.select_other_m_info(teacher.getTno());
				for(M_Info other : others){
					nu = other.getTimeStart().indexOf(" ");
					if(datetime.equals(other.getTimeStart().substring(0,nu))){
						iterator.remove();
						flag = true;
					}				
				}
			}
			
//			for(Teacher teacher : teachers){
//				System.out.println(m_info.getCname()+":"+teacher.getTname()+"---"+teacher.getTno());
//			}
//			System.out.println();
			
			
			//本专业老师有ID号码 其他专业教师没有号码
//			System.out.println("-----tea------>>"+tea);
//			System.out.println("-----m_info.getTeacher()------>>"+m_info.getTeacher());
			if((!"".equals(tea))&&service_t.select_remark(tea)!=null){
				if("0".equals(service_t.select_remark(tea))){
					Teacher teacher = service_t.select_e_teacher(tea);
					teachers.add(0,teacher);
					//没有监考任务的科任老师放第一位
					m_manages = service_m.select_m_manage(tea);
					for(M_Manage m_manage : m_manages){
//						nu = m_manage.getTimeStart().indexOf(" ");
						if(m_info.getTimeStart().equals(m_manage.getTimeStart())){
							teachers.remove(0);
							break;
						}else{
							continue;
						}
					}
					//科任放在第一位
//					System.out.println("-----teacher-----:"+teacher.toString());
				}
			}
//			for(Teacher teacher : teachers){
//				System.out.println(m_info.getCname()+":"+teacher.getTname()+"---"+teacher.getTno());
//			}
			
//			System.out.println();
			int k = 0;
			String [] address = new String[num];
			for (int i = 0; i < num; i++) {
				for(int j = k ; j < ss.length() ; j ++){
					if(ss.substring(j, j+1).equals(")")){
						address[i] = ss.substring(k,j+1);
						k = j + 2;
						break;
					}
				}
//				System.out.println("-----address["+i+"]------>>>>:"+address[i]);
//				m_info.setAddress(address[i]);
			}
//			System.out.println("-------:"+m_info.getAddress());
			
			for(int i = 0 ; i < num ; i++){
				service_m.insert_m_manage(new M_Manage(m_info.getTeacher(),m_info.getCname(),m_info.getTimeStart(),m_info.getTimeEnd(),
						address[i], 
						(2*i<teachers.size())?teachers.get(2*i).getTno():"",
							(2*i<teachers.size())?teachers.get(2*i).getTname():"",
								(2*i<teachers.size())?teachers.get(2*i).getTelephone():"",
									(2*i+1<teachers.size())?teachers.get(2*i+1).getTno():"",
										(2*i+1<teachers.size())?teachers.get(2*i+1).getTname():"",
											(2*i+1<teachers.size())?teachers.get(2*i+1).getTelephone():""));
				//分配过监考老师后，count自增1
				if(2*i<teachers.size()){
					service_t.update_count(teachers.get(2*i).getTno());
				}
				if(2*i+1<teachers.size()){
					service_t.update_count(teachers.get(2*i+1).getTno());
				}
			}
			service.update_m_info_remark(
					new SelectM_info(m_info.getTeacher(),m_info.getCname(),
							m_info.getTimeStart(),
							m_info.getAddress())
					);
//			System.out.println(e_arranges.size());
		}

		m_manage_msg = "阶段考试自动分配成功，感谢您的使用！";
		return SUCCESS;
	}
	
	public String arrange() throws ParseException{
		m_manages = service_m.select_all_manage();
		Iterator<M_Manage> iterator = m_manages.iterator();
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		now = new Date();
//		for(M_Manage e_manage : m_manages){
//			System.out.println("before:---"+e_manage.toString());
//		}
		//剔除已过时考试信息
		while(iterator.hasNext()){
			M_Manage m_manage = iterator.next();
			datetime = m_manage.getTimeStart().split("\\s")[0].trim();
//			System.out.println(datetime);
			Date date = sdf.parse(datetime);
			now.setDate(now.getDate());
//			System.out.println(now.getTime()+"||"+date.getTime());
			if(now.getTime() > date.getTime()){
//				iterator.remove();
			}	
		}
		Collections.sort(m_manages,new Comparator<M_Manage>() {
			public int compare(M_Manage e1, M_Manage e2) {
				long t = 0;
				try {
					t = sdf.parse(e1.getTimeStart().split("\\s")[0].trim()).getTime()-
								sdf.parse(e2.getTimeStart().split("\\s")[0].trim()).getTime();

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(t>0){
					return 1;
				}else{
					return -1;
				}
			}
		}); 
//		System.out.println("2");
//		for(M_Manage e_manage : m_manages){
//			System.out.println(e_manage.toString());
//		}
		page = new Page();
		request = ServletActionContext.getRequest();
		int a = Integer.parseInt(request.getParameter("current"));
		page.setCurrent(a);
		page.setRows(m_manages.size());
		int from = page.getPageSize()*(page.getCurrent()-1);
		int to = 	page.getPageSize()*page.getCurrent();
		m_manages = m_manages.subList((from<m_manages.size())?from:0
				,(to<m_manages.size())?to:m_manages.size());
		return SUCCESS;
	}
	
	/**
	 * 查询监考次数后的某个老师的监考信息
	 * @return
	 */
	public String show(){
		request = ServletActionContext.getRequest();
		String tno = (String) request.getAttribute("tno");
//		System.out.println("tno----->>>"+tno);
//		String datetime = request.getParameter("datetime");
		m_manages = service_m.select_m_manage(tno);
//		for(E_Manage e : e_manages){
//			System.out.println("---------------------->>>>>>>>>>>"+e);
//		}
		return SUCCESS;
	}
	
	/**
	 * 显示当前用户的阶段监考信息
	 * @return
	 */
	public String showSelf(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		Teacher teacher = (Teacher)session.get("teacher");
		String tno = teacher.getTno();
//		System.out.println("tno----->>>"+tno);
		m_manages = service_m.select_m_manage(tno);
		return SUCCESS;
	}
	
	/**
	 * 管理员查询所有的监考信息
	 * @return
	 */
	public String showAll(){
		m_manages = service_m.select_all_manage();
		return SUCCESS;
	}
	
	/**
	 * 读取将被修改的监考信息，并将可以监考此考试的教师显示到前台
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String change()throws UnsupportedEncodingException{
		request = ServletActionContext.getRequest();
		String teacher = new String(request.getParameter("teacher"));
		String cname = new String(request.getParameter("cname"));
		String timeStart = request.getParameter("timeStart");
		String address = new String(request.getParameter("address"));
		
//		System.out.println(teacher+"---"+cname+"---"+timeStart+"---"+address);
		
		m_manages = service_m.select_all_manage();
		for(M_Manage m : m_manages){
			if(m.getTeacher().equals(teacher) &&
					m.getCname().equals(cname) &&
					m.getTimeStart().equals(timeStart) &&
					m.getAddress().contains(address)){
				m_manage = m;
			}
		}
		
		SelectM_info s = new SelectM_info(teacher,cname,timeStart,address);
		M_Info m_info = service.select_m_info_by(s);
//		System.out.println(m_info.toString());
		
		if(m_info==null){
			 error_message = "您的考试信息表中很有可能没有此考试信息，请确认考试信息是否存在！~";
			return ERROR;
		}
		
		if(m_info.getTeacher()==null){
			m_info.setTeacher(" ");
		}
		
		int nu1 = m_info.getTeacher().indexOf("[");
		String tea = m_info.getTeacher().substring(nu1+1, nu1+11);
		teachers = service_t.select_arrange_teacher(tea);
		
		//检测teachers是否有元素
//		for(Teacher t: teachers){
//			System.out.println(t.toString());
//		}
		//取考试所在周
		if(m_info.getWeek() != null){
			week = m_info.getWeek();
		}
//		System.out.println("*****第几周：》》"+week);
		int nu;
		//取考试日期，时间，周几
		if(m_info.getTimeStart() != null){
			DayOfWeek obj = new DayOfWeek();
			 nu = m_info.getTimeStart().indexOf(" ");
			datetime = m_info.getTimeStart().substring(0,nu);
			try {
				day_of_week = obj.dayOfWeek(datetime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			time = m_info.getTimeStart().substring(nu+1, m_info.getTimeStart().length());
			time = obj.timeOfDay(time);
		}
//		System.out.println("周几————>>>"+day_of_week);
//		System.out.println("----datetime---->>:"+datetime);
//		System.out.println("考试时间--->>>"+time);
		
		//剔除考试时间有课的教师
		iterator = teachers.iterator();
		while(iterator.hasNext()){
			Teacher teacher1 = iterator.next();
			flag = false;
			courses = service_c.select_course(teacher1.getTno());
			for (Course course : courses) {
				//存储老师有课的周数
				List<Integer> ll = new ArrayList<Integer>();
				if(course.getWeek() != null){
					getWeeks gws = new getWeeks();
//					int n1;
					if (course.getWeek().indexOf(",") == -1) {
						String str = course.getWeek().substring(0,course.getWeek().length());
						gws.getWeek(str);
						for(Integer a : gws.getLl()){
							ll.add(a);
						}
					}else{
						String [] str = course.getWeek().split("\\,");
						for(int i = 0 ; i < str.length ; i ++){
							gws.getWeek(str[i]);
							for(Integer a : gws.getLl()){
								ll.add(a);
							}
						}
					}
					
				}
//				System.out.println("是否含双周--->>"+course.getWeek().contains("双"));
//				System.out.println("是否含考试周数---》》》"+!ll.contains(Integer.parseInt(week)));
				
//				for(Integer o : ll){
//					System.out.println("周数--->>"+o);
//				}
				
				if( ll.contains(Integer.parseInt(week)) ){
					if("0".equals(course.getRemark())||
							"1".equals(course.getRemark())&&Integer.parseInt(week)%2==1||
								"2".equals(course.getRemark()) && Integer.parseInt(week)%2==0){	
						if(day_of_week.equals(course.getDay_of_week())){
							if(time.equals(course.getTime())){
								iterator.remove();
								flag = true;
							}
						}
					}
				}
				if(flag == true){
					break;
				}
				
			}
		}
//		for(Teacher teacher : teachers){
//			System.out.println(m_info.getCname()+":"+teacher.getTname());
//		}
//		System.out.println();
		
		//剔除考试时间有监考任务的教师
		iterator = teachers.iterator();
		while(iterator.hasNext()){
			Teacher teacher1 = iterator.next();
			flag = false;
			m_manages = service_m.select_m_manage(teacher1.getTno());
			for(M_Manage e_manage : m_manages){
				nu = e_manage.getTimeStart().indexOf(" ");
				if(datetime.equals(e_manage.getTimeStart().substring(0,nu))){
					iterator.remove();
					flag = true;
				}
				if(flag == true){
					break;
				}
			}
		}
//		for(Teacher teacher : teachers){
//			System.out.println(m_info.getCname()+":"+teacher.getTname());
//		}
//		System.out.println();
		//剔除其他科与本科考试时间相同的其他科科任老师
		iterator = teachers.iterator();
		while(iterator.hasNext()){
			Teacher teacher1 = iterator.next();
			flag = false;
			others = service.select_other_m_info(teacher1.getTno());
			for(M_Info other : others){
				nu = other.getTimeStart().indexOf(" ");
				if(datetime.equals(other.getTimeStart().substring(0,nu))){
					iterator.remove();
					flag = true;
				}				
			}
		}
		
		if((!"".equals(tea))&&service_t.select_remark(tea)!=null){
			if("0".equals(service_t.select_remark(tea))){
				Teacher teacher1 = service_t.select_e_teacher(tea);
				teachers.add(0,teacher1);
				//没有监考任务的科任老师放第一位
				m_manages = service_m.select_m_manage(tea);
				for(M_Manage m_manage : m_manages){
					if(m_info.getTimeStart().equals(m_manage.getTimeStart())){
						teachers.remove(0);
						break;
					}else{
						continue;
					}
				}
			}
		}
		
		iterator = teachers.iterator();
		while(iterator.hasNext()){
			Teacher t = iterator.next();
			if(t.getTno().equals(m_manage.getTno_one())||
					t.getTno().equals(m_manage.getTno_two())){
				iterator.remove();
			}
//			System.out.println(t.toString());
		}
		
		return SUCCESS;
	}
	
	public String select_tname_tel(){
		request = ServletActionContext.getRequest();
		tno = request.getParameter("tno");
		System.out.println(tno);
		//将被选中老师的监考次数加一 
//		service_t.update_count(tno);
		Teacher teacher = service_t.select_e_teacher(tno);
		tname = teacher.getTname();
		tel = teacher.getTelephone();
		return SUCCESS;
	}
	
	/**
	 * 修改阶段考试监考信息
	 * @return
	 */
	public String updateM_manage(){
//		System.out.println("m_manage   : ----"+m_manage.toString());
		service_m.update_M_Manage(m);
		//将选中要被修改的监考老师的监考次数减一
		service_t.update_count_reduce(m_manage.getTno_one());
		service_t.update_count_reduce(m_manage.getTno_two());
//		System.out.println("m:----"+m.toString());
		//将选中的监考老师的次数加一
		service_t.update_count(m.getTno_one());
		service_t.update_count(m.getTno_two());
		updateM_manage_msg = "修改完成";
		return SUCCESS;
	}
	
	public String getM_manage_msg() {
		return m_manage_msg;
	}
	public void setM_manage_msg(String m_manage_msg) {
		this.m_manage_msg = m_manage_msg;
	}

	public List<M_Manage> getM_manages() {
		return m_manages;
	}

	public void setM_manages(List<M_Manage> m_manages) {
		this.m_manages = m_manages;
	}
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public M_Manage getM_manage() {
		return m_manage;
	}

	public void setM_manage(M_Manage m_manage) {
		this.m_manage = m_manage;
	}
	
	public String getTno() {
		return tno;
	}

	public void setTno(String tno) {
		this.tno = tno;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getUpdateM_manage_msg() {
		return updateM_manage_msg;
	}

	public void setUpdateM_manage_msg(String updateM_manage_msg) {
		this.updateM_manage_msg = updateM_manage_msg;
	}
	

	public M_Manage getM() {
		return m;
	}

	public void setM(M_Manage m) {
		this.m = m;
	}

	public String getError_message() {
		return error_message;
	}

	public void setError_message(String errorMessage) {
		error_message = errorMessage;
	}

}
