package manage.service;

import manage.dao.studentDao;
import manage.entity.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class studentService {
	@Autowired
	private studentDao dao;
	
	public Student select_Student(String sno){
		return dao.select_Student(sno);
	}
	
	public void add_Student(Student stu){
		dao.add_Student(stu);
	}
	
	public void update_Student(Student stu){
		dao.update_Student(stu);
	}
	
	public int select_count(){
		return dao.select_count();
	}
}
