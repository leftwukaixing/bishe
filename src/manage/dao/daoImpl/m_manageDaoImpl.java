package manage.dao.daoImpl;

import java.util.List;
import manage.dao.m_manageDao;
import manage.entity.M_Manage;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class m_manageDaoImpl implements m_manageDao{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<M_Manage> select_m_manage(String tno) {
		return sqlSessionTemplate.selectList("select_m_manage", tno);
	}

	public void insert_m_manage(M_Manage m_manage) {
		sqlSessionTemplate.insert("insert_m_manage", m_manage);
	}

	public List<M_Manage> select_all_m_manage() {
		return sqlSessionTemplate.selectList("select_all_m_manage");
	}

	public void update_M_Manage(M_Manage m_manage) {
		sqlSessionTemplate.update("update_M_Manage", m_manage);
	}

	public void delete_all_m_manage() {
		sqlSessionTemplate.delete("delete_all_m_manage");
	} 
	
}
