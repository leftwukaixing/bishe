package manage.dao;

import java.util.List;

import manage.entity.Teacher;
import manage.vo.User;

public interface teacherDao {
	/**
	 * 添加教师
	 * @param teacher
	 */
	public void addTeacher(Teacher teacher);
	//修改密码
	public void update_pwd(User user);
	//修改信息
	public void update_info(Teacher teacher);
	//修改上传信息
	public void update_upload(String tno);
	//查看上传信息
	public String select_upload(String tno);
	//查询教师信息
	public List<Teacher> select_arrange_teacher(String tno);
	//查询科任能否监考
	public String select_remark(String tno);
	//查询科任
	public Teacher select_e_teacher(String tno);
	//增加监考次数
	public void update_count(String tno);
	/**
	 * 将指定老师的监考次数减一
	 * @param tno
	 */
	public void update_count_reduce(String tno);
	//查询所有老师
	public List<Teacher> select_all_teacher();
	//将所有教师监考次数置为0
	public void update_count_zero();
	//将所有教师的上传次数置为0
	public void update_upload_zero();
	//修改教师信息（权限，监考次数，备注，上传）
	public void update_teacher_info(Teacher teacher);
	//删除教师的所有课表
	public void delete_all_course_by_tno(String tno);
	//删除指定教师的信息
	public void del_Teacher(String tno);
}
