package manage.dao;

import java.util.List;

import manage.entity.Course;

public interface courseDao {
	public void insert_course(Course course);
	public List<Course> select_course(String tno);
	public void delete_all_course();
}
