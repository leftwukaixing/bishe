package manage.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import manage.dao.loginDao;
import manage.entity.Teacher;
import manage.vo.User;
@Service
@Transactional
public class loginService {
	@Autowired
	private loginDao dao;
	public Teacher select_teacher(User u){
		return dao.select_teacher(u.getTno());
	}
}
