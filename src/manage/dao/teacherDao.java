package manage.dao;

import manage.entity.Teacher;
import manage.entity.UserD;

public interface teacherDao {
	/**
	 * 添加教师
	 * @param teacher
	 */
	public void addTeacher(Teacher teacher);
	//修改密码
	public void update_pwd(UserD userd);
	//修改信息
	public void update_info(Teacher teacher);
	//获取指定教师的信息
	public Teacher select_Teacher(String tno);
}
