package manage.dao.daoImpl;

import java.util.List;

import manage.dao.e_infoDao;
import manage.entity.E_Info;
import manage.entity.SelectE_info;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class e_infoDaoImpl implements e_infoDao{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate; 
	public void insert_e_info(E_Info e_info) {
		sqlSessionTemplate.insert("insert_e_info", e_info);
	}
	public List<E_Info> select_e_info() {
		return  sqlSessionTemplate.selectList("select_e_info");
	}
	public List<E_Info> select_other_e_info(String tno) {
		
		return sqlSessionTemplate.selectList("select_other_e_info", tno);
	}
	public void update_e_info_remark(SelectE_info selecte_info) {
		sqlSessionTemplate.update("update_e_info_remark", selecte_info);
	}
	public List<E_Info> select_all_e_info() {
		
		return sqlSessionTemplate.selectList("select_all_e_info");
	}
	public E_Info select_e_info_by(SelectE_info s) {
		return sqlSessionTemplate.selectOne("select_e_info_by", s);
	}
	public void delete_all_e_info() {
		sqlSessionTemplate.delete("delete_all_e_info");
	}
}
