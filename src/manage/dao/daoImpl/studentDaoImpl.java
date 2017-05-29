package manage.dao.daoImpl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import manage.dao.studentDao;
import manage.entity.Student;

public class studentDaoImpl implements studentDao{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public Student select_Student(String sno) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("select_Teacher", sno);
		}
}
	
