package manage.dao.daoImpl;

import manage.dao.teacherDao;
import manage.entity.Teacher;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class teacherDaoImpl implements teacherDao{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public Teacher select_Teacher(String tno) {
		return sqlSessionTemplate.selectOne("select_Teacher", tno);
	}

	public void add_Teacher(Teacher tea) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert("add_Teacher", tea);
	}

	public void update_Teacher(Teacher tea) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update("update_Teacher", tea);
	}
	
}
