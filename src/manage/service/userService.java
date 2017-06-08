package manage.service;

import manage.dao.userDao;
import manage.entity.UserD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class userService {
	@Autowired
	private userDao dao;
	
	public void add_UserD (UserD userd) {
		dao.add_UserD(userd);
	}
	
	public void update_PW(UserD userd) {
		dao.update_PW(userd);
	}
}
