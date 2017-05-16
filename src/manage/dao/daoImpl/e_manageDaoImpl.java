package manage.dao.daoImpl;

import java.util.List;

import manage.dao.e_manageDao;
import manage.entity.E_Manage;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class e_manageDaoImpl implements e_manageDao{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public List<E_Manage> select_e_manage(String tno) {
		return sqlSessionTemplate.selectList("select_e_manage", tno);
	}

	public void insert_e_manage(E_Manage e_manage) {
		sqlSessionTemplate.insert("insert_e_manage", e_manage);
	}

	public List<E_Manage> select_all_e_manage() {
		return sqlSessionTemplate.selectList("select_all_e_manage");
	}

	public void update_E_Manage(E_Manage e_manage) {
		sqlSessionTemplate.update("update_E_Manage", e_manage);
	}

	public void delete_all_e_manage() {
		sqlSessionTemplate.delete("delete_all_e_manage");
	} 
}
