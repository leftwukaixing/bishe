package manage.dao;

import manage.entity.Student;

public interface studentDao {
	public Student select_Student(String sno);
	
	public void add_Student(Student stu);
	
	public void update_Student(Student stu);
}
