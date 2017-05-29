package manage.dao.daoImpl;

import manage.dao.teacherDao;
import manage.entity.Teacher;
import manage.entity.UserD;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class teacherDaoImpl implements teacherDao{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public Teacher select_Teacher(String tno) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("select_Teacher", tno);
	}
	
}
