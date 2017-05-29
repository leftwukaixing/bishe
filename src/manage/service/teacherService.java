package manage.service;

import java.util.Map;

import manage.dao.teacherDao;
import manage.entity.Teacher;
import manage.entity.UserD;

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
	public Teacher select_Teacher(String tno){
		return dao.select_Teacher(tno);
	}
	/**
	 * 修改密码
	 * @param user
	 */
	public void update_pwd(UserD user){
		if(user!=null){
			dao.update_pwd(user);
			//session中的密码也要改过来
			Map<String, Object> session = ActionContext.getContext().getSession();
			Teacher teacher = (Teacher)session.get("teacher");
			user.setPassword(user.getPassword());
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
}
