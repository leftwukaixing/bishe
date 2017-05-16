package manage.dao.daoImpl;

import java.util.List;

import manage.dao.courseDao;
import manage.entity.Course;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class courseDaoImpl implements courseDao{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public void insert_course(Course course) {
		sqlSessionTemplate.insert("insert_course", course);
	}

	public List<Course> select_course(String tno) {
		return sqlSessionTemplate.selectList("select_course", tno);
	}
	
	public void delete_all_course(){
		sqlSessionTemplate.delete("delete_all_course");
	}
}
