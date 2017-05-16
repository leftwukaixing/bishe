package manage.service;

import java.util.List;

import manage.dao.courseDao;
import manage.entity.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class courseService {
	@Autowired
	private courseDao dao;
	public void insert_course(List<Course> list){
		for (Course course : list) {
			dao.insert_course(course);
		}
	}
	public List<Course> select_course(String tno){
		return dao.select_course(tno);
	}
	public void delete_all_course() {
		// TODO Auto-generated method stub
		dao.delete_all_course();
	}
}
