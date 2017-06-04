package manage.dao.daoImpl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import manage.dao.userDao;
import manage.entity.UserD;

@Repository
public class userDaoImpl implements userDao{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void add_UserD(UserD userd) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert("add_User", userd);
	}

}
