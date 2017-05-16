package manage.dao.daoImpl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import manage.dao.teacherDao;
import manage.entity.Teacher;
import manage.vo.User;

@Repository
public class teacherDaoImpl implements teacherDao{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public void update_pwd(User user) {
		sqlSessionTemplate.update("update_pwd", user);
	}

	public void update_info(Teacher teacher) {
		sqlSessionTemplate.update("update_info", teacher);
	}

	public void update_upload(String tno) {
		sqlSessionTemplate.update("update_upload",tno);
	}

	public String select_upload(String tno) {
		return sqlSessionTemplate.selectOne("select_upload",tno);
	}

	public List<Teacher> select_arrange_teacher(String tno) {
		
		return sqlSessionTemplate.selectList("select_arrange_teacher", tno);
	}

	public String select_remark(String tno) {
		return sqlSessionTemplate.selectOne("select_remark", tno);
	}

	public Teacher select_e_teacher(String tno) {
		return sqlSessionTemplate.selectOne("select_e_teacher", tno);
	}

	public void update_count(String tno) {
		sqlSessionTemplate.update("update_count", tno);
	}

	public List<Teacher> select_all_teacher() {
		return sqlSessionTemplate.selectList("select_all_teacher");
	}

	public void update_count_zero() {
		sqlSessionTemplate.update("update_count_zero");
	}

	public void update_upload_zero() {
		sqlSessionTemplate.update("update_upload_zero");
	}

	public void update_teacher_info(Teacher teacher) {
		sqlSessionTemplate.update("update_teacher_info",teacher);
	}

	public void delete_all_course_by_tno(String tno) {
		sqlSessionTemplate.delete("delete_all_course_by_tno",tno);
	}

	public void update_count_reduce(String tno) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update("update_count_reduce", tno);
	}

	public void addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert("add_teacher", teacher);
	}

	public void del_Teacher(String tno) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.delete("del_Teacher", tno);
	}
	
}
