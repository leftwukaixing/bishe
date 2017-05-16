package manage.service;

import java.util.List;
import java.util.Map;

import manage.dao.teacherDao;
import manage.entity.Teacher;
import manage.vo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;

@Service
@Transactional
public class teacherService {
	@Autowired
	private teacherDao dao;
	
	/**
	 * 添加教师
	 * @param teacher
	 */
	public void add_Teacher(Teacher teacher){
		dao.addTeacher(teacher);
	}
	
	public void del_Teacher(String tno){
		dao.del_Teacher(tno);
	}
	/**
	 * 修改密码
	 * @param user
	 */
	public void update_pwd(User user){
		if(user!=null){
			dao.update_pwd(user);
			//session中的密码也要改过来
			Map<String, Object> session = ActionContext.getContext().getSession();
			Teacher teacher = (Teacher)session.get("teacher");
			teacher.setPwd(user.getPwd());
			session.remove("teacher");
			session.put("teacher", teacher);
		}
		
	}
	
	/**
	 * 修改信息
	 * @param teacher
	 */
	public void update_info(Teacher teacher){
		if(teacher!=null){
			dao.update_info(teacher);
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.remove("teacher");
			session.put("teacher", teacher);
		}
	}
	public void update_upload(String tno){
		dao.update_upload(tno);
	}
	public String select_upload(String tno){
		return dao.select_upload(tno);
	}
	public List<Teacher> select_arrange_teacher(String tno){
		return dao.select_arrange_teacher(tno);
	}
	public String select_remark(String tno){
		return dao.select_remark(tno);
	}
	public Teacher select_e_teacher(String tno){
		return dao.select_e_teacher(tno);
	}
	public void update_count(String tno){
		dao.update_count(tno);
	}
	public void update_count_reduce(String tno){
		dao.update_count_reduce(tno);
	}
	public List<Teacher> select_all_teacher(){
		return dao.select_all_teacher();
	}
	public void update_count_zero(){
		dao.update_count_zero();
	}
	public void update_upload_zero(){
		dao.update_upload_zero();
	}
	public void update_teacher_info(Teacher teacher){
		dao.update_teacher_info(teacher);
	}
	public void delete_all_course_by_tno(String tno){
		dao.delete_all_course_by_tno(tno);
	}
}
