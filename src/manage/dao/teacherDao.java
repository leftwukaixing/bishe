package manage.dao;

import manage.entity.Teacher;

public interface teacherDao {
	/**
	 * 选择教师
	 * @param teacher
	 */
	public Teacher select_Teacher(String tno);
	
	/**
	 * 添加教师
	 * @param tea
	 */
	public void add_Teacher(Teacher tea);
	
	/**
	 * 修改教师个人信息
	 * @param tea
	 */
	public void update_Teacher(Teacher tea);
}
