package manage.service;

import manage.dao.studentDao;
import manage.entity.Student;

import org.springframework.beans.factory.annotation.Autowired;

public class studentService {
	@Autowired
	private studentDao dao;
	
	public Student select_Student(String sno){
		return dao.select_Student(sno);
	}
}
