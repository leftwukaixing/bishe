package manage.dao.daoImpl;


import org.mybatis.spring.SqlSessionTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import manage.dao.loginDao;
import manage.entity.UserD;

@Repository
public class loginDaoImpl implements loginDao{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate; 
	public UserD select_user(String uid) {
		return sqlSessionTemplate.selectOne("select_user", uid);
	}
}
