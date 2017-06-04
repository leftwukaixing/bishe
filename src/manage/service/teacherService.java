package manage.service;

import manage.dao.teacherDao;
import manage.entity.Teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class teacherService {
	@Autowired
	private teacherDao dao;
	
	public Teacher select_Teacher(String tno){
		return dao.select_Teacher(tno);
	}
	
	public void add_Teacher(Teacher tea){
		dao.add_Teacher(tea);
	}
	
	public void update_Teacher(Teacher tea){
		dao.update_Teacher(tea);
	}
}
