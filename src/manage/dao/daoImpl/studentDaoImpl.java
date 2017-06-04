package manage.dao.daoImpl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import manage.dao.studentDao;
import manage.entity.Student;

@Repository
public class studentDaoImpl implements studentDao{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public Student select_Student(String sno) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("select_Student", sno);
		}

	public void add_Student(Student stu) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert("add_Student", stu);
	}

	public void update_Student(Student stu) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update("update_Student", stu);
	}
}
	
