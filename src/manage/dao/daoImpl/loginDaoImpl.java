package manage.dao.daoImpl;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import manage.dao.loginDao;
import manage.entity.Teacher;

@Repository
public class loginDaoImpl implements loginDao{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate; 
	public Teacher select_teacher(String tno) {
		return sqlSessionTemplate.selectOne("select_teacher", tno);
	}

}
