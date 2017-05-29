package manage.dao;

import manage.entity.Teacher;
import manage.entity.UserD;

public interface teacherDao {
	/**
	 * 添加教师
	 * @param teacher
	 */
	public Teacher select_Teacher(String tno);
}
