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
import manage.entity.E_Info;
import manage.entity.E_Manage;
import manage.entity.SelectE_info;
import manage.entity.Teacher;
import manage.service.courseService;
import manage.service.e_infoService;
import manage.service.e_manageService;
import manage.service.teacherService;
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
public class e_manageAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	@Autowired
	private e_infoService service;
	@Autowired
	private teacherService service_t;
	@Autowired
	private courseService service_c;
	@Autowired
	private e_manageService service_m;
	//存储考试信息
	private List<E_Info> e_infos;
	//存储其他科目考试信息
	private List<E_Info> others;
	//存放教师信息
	private List<Teacher> teachers;
	//存放课程信息
	private List<Course> courses;
	//存放查询的监考信息
	private List<E_Manage> e_manages;
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
	private String e_manage_msg;
	//获取现在时间
	private Date now;
	//页面信息
	private Page page;
	//获取请求信息
	private HttpServletRequest request;
	//获取要修改的监考信息，设置为static为了在修改时实现次数的修改
	private static E_Manage e_manage;
	//存储json传来的教师id
	private String tno;
	//传输姓名
	private String tname;
	//传输电话号
	private String tel;
	//修改成功信息
	private String updateE_manage_msg;
	
	private String error_message;
	//存储修改后的e_manage
	private E_Manage e;
	

	public String auto_arrange(){
		e_infos = service.select_all_e_info();
		if(e_infos.isEmpty()){
			e_manage_msg = "您还未上传期末考试信息，请先上传！";
			return SUCCESS;
		}
		e_infos = service.select_e_info();
		if(e_infos.isEmpty()){
			e_manage_msg = "所有期末考试均已分配过监考，无需重复分配！";
			return SUCCESS;
		}
		//存储监考信息
		for(E_Info e_info : e_infos){
			
			//如果教师ID为空，用空字符串代替
			if(e_info.getTeacher()==null){
				e_info.setTeacher(" ");
			}
			
			//取考场个数，监考老师的数目为考场数目的二倍
			num = e_info.getAddress().split("-").length;
			//遍历非科任，并且能监考的教师，按监考次数升序排列
//			System.out.println("e_info.getTeacher()---->>>"+e_info.getTeacher());
			String ss = e_info.getTeacher();
			countNumber count = new countNumber();
			int n = count.countNum(ss, ",");
//			System.out.println("---e_info.getTeacher()中,的个数：---->>>"+n);
			String  tea = new String();
			
			for(int i = 0 ;i <= n ;i++){
				for(int j = 0 ; j < ss.length() - 1 ; j++){
					if(ss.substring(j, j+1).equals("[")){
						tea = ss.substring(j+1, j+11);
					}
				}
				teachers = service_t.select_arrange_teacher(tea);
//				System.out.println("tea---->>>>>>>"+tea);
				e_info.setTeacher(tea);
			}
			
//			teachers = service_t.select_arrange_teacher(e_info.getTeacher());
//			System.out.println(teachers.isEmpty());
			//检测teachers是否有元素
			for(Teacher t: teachers){
				System.out.println(t.toString());
			}
			//取考试所在周
//			week = e_info.getWeek();
			
			if(e_info.getWeek() != null){
				int n1 = e_info.getWeek().indexOf("第");
				int n2 = e_info.getWeek().indexOf("周");
				week = e_info.getWeek().substring(n1+1, n2);
				int nu = e_info.getWeek().indexOf("星");
				day_of_week = e_info.getWeek().substring(nu, nu+3);
				if(day_of_week.equals("星期七")){
					day_of_week = "星期日";
				}
				time = e_info.getWeek().substring(e_info.getWeek().length()-4, e_info.getWeek().length());
			}
			
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
						int n1 = -2;
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
//				System.out.println(e_info.getCname()+":"+teacher.getTname());
//			}
//			System.out.println();
			
			datetime = e_info.getDatetime();
			//剔除考试时间有监考任务的教师
			iterator = teachers.iterator();
			while(iterator.hasNext()){
				Teacher teacher = iterator.next();
				flag = false;
				e_manages = service_m.select_e_manage(teacher.getTno());
				System.out.println(e_manages);
				for(E_Manage e_manage : e_manages){
					if(datetime.equals(e_manage.getDatetime())){
						iterator.remove();
						flag = true;
					}
					if(flag == true){
						break;
					}
				}
			}
//			for(Teacher teacher : teachers){
//				System.out.println(e_info.getCname()+":"+teacher.getTname());
//			}
//			System.out.println();
			//剔除其他科与本科考试时间相同的其他科科任老师
			iterator = teachers.iterator();
			while(iterator.hasNext()){
				Teacher teacher = iterator.next();
				flag = false;
				others = service.select_other_e_info(teacher.getTno());
				for(E_Info other : others){
					if(datetime.equals(other.getDatetime())){
						iterator.remove();
						flag = true;
					}				
				}
			}
			//判断科任能否监考			
//			for(Teacher teacher : teachers){
//				System.out.println(e_info.getCname()+":"+teacher.getTname());
//			}
//			System.out.println();
			
			
			//本专业老师有ID号码 其他专业教师没有号码
//			System.out.println("~~~~~~~~~~~~~~`:"+e_info.getTeacher());
			if((!"".equals(e_info.getTeacher()))&&service_t.select_remark(e_info.getTeacher())!=null){
				if("0".equals(service_t.select_remark(e_info.getTeacher()))){
//					Teacher teacher = service_t.select_e_teacher(e_info.getTeacher());
//					teachers.add(0,teacher);
					//没有监考任务的科任老师放第一位
					Teacher [] teach = new Teacher[n+1];
					int k = 0;
					for (int j = 0; j <= n; j++) {
						for (int i = k; i < ss.length() ; i++) {
							if (ss.substring(i, i + 1).equals("[")) {
								String teachs = ss.substring(i+1, i + 11);
								System.out.println("======teachs:====="+teachs);
								teach[j] = service_t.select_e_teacher(teachs);
								k = i + 12;
								break;
							}
						}
						teachers.add(j,teach[j]);
						e_manages = service_m.select_e_manage(teach[j].getTno());
						for(E_Manage e_manage : e_manages){
							if(datetime.equals(e_manage.getDatetime())){
								teachers.remove(j);
								break;
							}else{
								continue;
							}
						}
					}
				}
			}
			for(Teacher teacher : teachers){
				System.out.println(e_info.getCname()+":"+teacher.getTname());
			}
			System.out.println();
			for(int i=0;i<num;i++){
				service_m.insert_e_manage(new E_Manage(e_info.getCno(),e_info.getCname(),e_info.getDatetime(),e_info.getTime(),
						e_info.getAddress().split("-")[i], 
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
			service.update_e_info_remark(
					new SelectE_info(e_info.getCno(),
							e_info.getDatetime(),
							e_info.getAddress())
					);
//			System.out.println(e_arranges.size());
		}

		e_manage_msg = "期末考试自动分配成功，谢谢使用！";
		return SUCCESS;
	}
	
	/**
	 * 管理员查询所有的监考信息
	 * @return
	 */
	public String arrange() throws ParseException{
		e_manages = service_m.select_all_manage();
		Iterator<E_Manage> iterator = e_manages.iterator();
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		now = new Date();
		
		//剔除已过时考试信息

//		while(iterator.hasNext()){
//			E_Manage e_manage = iterator.next();
//			datetime = e_manage.getDatetime().split("\\s")[0].trim();
//			Date date = sdf.parse(datetime);
//			now.setDate(now.getDate());
//			if(now.getTime()>date.getTime()){
//				iterator.remove();
//			}	
//		}
//		System.out.println("1");
		//按时间先后排列
		Collections.sort(e_manages,new Comparator<E_Manage>() {
			public int compare(E_Manage e1, E_Manage e2) {
				long t = 0;
				try {
					t = sdf.parse(e1.getDatetime().split("\\s")[0].trim()).getTime()-
								sdf.parse(e2.getDatetime().split("\\s")[0].trim()).getTime();

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
		System.out.println("2");
		for(E_Manage e_manage : e_manages){
			System.out.println(e_manage.toString());
		}
		page = new Page();
		request = ServletActionContext.getRequest();
		int a = Integer.parseInt(request.getParameter("current"));
		page.setCurrent(a);
		page.setRows(e_manages.size());
		int from = page.getPageSize()*(page.getCurrent()-1);
		int to = 	page.getPageSize()*page.getCurrent();
		e_manages = e_manages.subList((from<e_manages.size())?from:0
				,(to<e_manages.size())?to:e_manages.size());
		return SUCCESS;
	}
	
	/**
	 * 查询监考次数
	 * @return
	 */
	public String seeTimes(){
		teachers = service_t.select_all_teacher();
		Collections.sort(teachers,new Comparator<Teacher>() {
			public int compare(Teacher t1, Teacher t2) {
				return t1.getCount()-t2.getCount();
			}
		}); 
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
	/**
	 * 查询监考次数后的某个老师的监考信息
	 * @return
	 */
	public String show(){
		request = ServletActionContext.getRequest();
		String tno = (String) request.getAttribute("tno");
//		System.out.println("tno----->>>"+tno);
//		String datetime = request.getParameter("datetime");
		e_manages = service_m.select_e_manage(tno);
		return SUCCESS;
	}
	
	/**
	 * 显示当前用户的监考信息
	 * @return
	 */
	public String showSelf(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		Teacher teacher = (Teacher)session.get("teacher");
		String tno = teacher.getTno();
//		System.out.println("tno----->>>"+tno);
		e_manages = service_m.select_e_manage(tno);
		return SUCCESS;
	}
	
	/**
	 * 修改监考信息
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String change() throws UnsupportedEncodingException{
		request = ServletActionContext.getRequest();
		String cno = request.getParameter("cno");
		String datetime = request.getParameter("datetime");
		String address = new String(request.getParameter("address"));
//		System.out.println(cno+","+datetime+","+address);
		e_manages = service_m.select_all_manage();
		for(E_Manage e : e_manages){
			if(e.getCno().equals(cno)&&
					e.getDatetime().equals(datetime)&&
						e.getAddress().equals(address)){
				e_manage = e;
			}
		}
		
		SelectE_info s = new SelectE_info(cno,datetime,address);
		E_Info e_info = service.select_e_info_by(s);
//		System.out.println("-------e_info()---->>>:"+e_info.toString());
		//如果教师ID为空，用空字符串代替
		if(e_info==null){
			 error_message = "您的考试信息表中很有可能没有此考试信息，请确认考试信息是否存在！~";
			return ERROR;
		}
		
		if(e_info.getTeacher()==null){
			e_info.setTeacher(" ");
		}
		
		String ss = e_info.getTeacher();
		countNumber count = new countNumber();
		int n = count.countNum(ss, ",");
//		System.out.println("---e_info.getTeacher()中,的个数：---->>>"+n);
		String  tea = new String();
		for(int i = 0 ;i <= n ;i++){
			for(int j = 0 ; j < ss.length() - 1 ; j++){
				if(ss.substring(j, j+1).equals("[")){
					tea = ss.substring(j+1, j+11);
				}
			}
			teachers = service_t.select_arrange_teacher(tea);
//			System.out.println("tea---->>>>>>>"+tea);
			e_info.setTeacher(tea);
		}
		
//		teachers = service_t.select_arrange_teacher(e_info.getTeacher());
		
		if(e_info.getWeek() != null){
			int n1 = e_info.getWeek().indexOf("第");
			int n2 = e_info.getWeek().indexOf("周");
			week = e_info.getWeek().substring(n1+1, n2);
			int nu = e_info.getWeek().indexOf("星");
			day_of_week = e_info.getWeek().substring(nu, nu+3);
			time = e_info.getWeek().substring(e_info.getWeek().length()-4, e_info.getWeek().length());
		}
		
		//剔除考试时间有课的教师
		iterator = teachers.iterator();
		while(iterator.hasNext()){
			Teacher teacher = iterator.next();
			flag = false;
			courses = service_c.select_course(teacher.getTno());
			for (Course course : courses) {
//				int begin = Integer.parseInt(course.getWeek().split("-")[0]);
//				System.out.println("begin---->>>"+begin);
//				int end = Integer.parseInt(course.getWeek().split("-")[1]);
//				System.out.println("end---->>>"+end);
				
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
					
//					System.out.println("other------->>"+other);
				}
//				System.out.println("是否含双周--->>"+course.getWeek().contains("双"));
//				System.out.println("是否含考试周数---》》》"+!ll.contains(Integer.parseInt(week)));
				
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
//			System.out.println(e_info.getCname()+":"+teacher.getTname());
//		}
//		System.out.println();
		datetime = e_info.getDatetime();
		//剔除考试时间有监考任务的教师
		iterator = teachers.iterator();
		while(iterator.hasNext()){
			Teacher teacher = iterator.next();
			flag = false;
			e_manages = service_m.select_e_manage(teacher.getTno());
			for(E_Manage e_manage : e_manages){
				if(datetime.equals(e_manage.getDatetime())){
					iterator.remove();
					flag = true;
				}
				if(flag == true){
					break;
				}
			}
		}
//		for(Teacher teacher : teachers){
//			System.out.println(e_info.getCname()+":"+teacher.getTname());
//		}
//		System.out.println();
		//剔除其他科与本科考试时间相同的其他科科任老师
		iterator = teachers.iterator();
		while(iterator.hasNext()){
			Teacher teacher = iterator.next();
			flag = false;
			others = service.select_other_e_info(teacher.getTno());
			for(E_Info other : others){
				if(datetime.equals(other.getDatetime())){
					iterator.remove();
					flag = true;
				}				
			}
		}
		//判断科任能否监考			
//		for(Teacher teacher : teachers){
//			System.out.println(e_info.getCname()+":"+teacher.getTname());
//		}
//		System.out.println();
		
		//科任放在第一位
		if("0".equals(service_t.select_remark(e_info.getTeacher()))){
			Teacher teacher = service_t.select_e_teacher(e_info.getTeacher());
			//判断科任有无监考任务
			e_manages = service_m.select_e_manage(teacher.getTno());
			Iterator<E_Manage> it = e_manages.iterator();
			datetime = request.getParameter("datetime");
			while(it.hasNext()){
				E_Manage e_manage = it.next();
				if(!datetime.equals(e_manage.getDatetime())){
					it.remove();
				}
			}

			if(e_manages == null || (e_manages != null&&e_manages.isEmpty())){
				teachers.add(0, teacher);
			}	
		}
		iterator = teachers.iterator();
		while(iterator.hasNext()){
			Teacher t = iterator.next();
			if(t.getTno().equals(e_manage.getTno_one())||
					t.getTno().equals(e_manage.getTno_two())){
				iterator.remove();
			}
		}
		return SUCCESS;
	}
	
	public String select_tname_tel(){
		request = ServletActionContext.getRequest();
		tno = request.getParameter("tno");
//		System.out.println(tno);
		Teacher teacher = service_t.select_e_teacher(tno);
		tname = teacher.getTname();
		tel = teacher.getTelephone();
		return SUCCESS;
	}
	public String updateE_manage(){
		service_m.update_E_Manage(e);
//		System.out.println(e_manage.toString());
		//将修改前的监考老师的次数减一
		service_t.update_count_reduce(e_manage.getTno_one());
		service_t.update_count_reduce(e_manage.getTno_two());
		//将修改后的监考老师的监考次数加一
		service_t.update_count(e.getTno_one());
		service_t.update_count(e.getTno_two());
		updateE_manage_msg = "修改成功";
		return SUCCESS;
	}
	public String getE_manage_msg() {
		return e_manage_msg;
	}
	public void setE_manage_msg(String e_manage_msg) {
		this.e_manage_msg = e_manage_msg;
	}

	public List<E_Manage> getE_manages() {
		return e_manages;
	}

	public void setE_manages(List<E_Manage> e_manages) {
		this.e_manages = e_manages;
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

	public E_Manage getE_manage() {
		return e_manage;
	}

	public void setE_manage(E_Manage e_manage) {
		this.e_manage = e_manage;
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

	public String getUpdateE_manage_msg() {
		return updateE_manage_msg;
	}

	public void setUpdateE_manage_msg(String updateE_manage_msg) {
		this.updateE_manage_msg = updateE_manage_msg;
	}
	

	public E_Manage getE() {
		return e;
	}

	public void setE(E_Manage e) {
		this.e = e;
	}

	public String getError_message() {
		return error_message;
	}

	public void setError_message(String errorMessage) {
		error_message = errorMessage;
	}
	
}
