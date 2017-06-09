package manage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import manage.dao.loginDao;
import manage.entity.UserD;
import manage.vo.User;
@Service
@Transactional
public class loginService {
	@Autowired
	private loginDao dao;
	public UserD select_user(User u){
		return dao.select_user(u.getUserid());
	}
}
