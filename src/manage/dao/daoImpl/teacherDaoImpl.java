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

	public void update_pwd(UserD user) {
		sqlSessionTemplate.update("update_pwd", user);
	}

	public void update_info(Teacher teacher) {
		sqlSessionTemplate.update("update_info", teacher);
	}

	public void addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert("add_teacher", teacher);
	}

	public Teacher select_Teacher(String tno) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("select_Teacher", tno);
	}
	
}
