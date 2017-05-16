package manage.dao.daoImpl;

import java.util.List;
import manage.dao.m_infoDao;
import manage.entity.M_Info;
import manage.entity.SelectM_info;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class m_infoDaoImpl implements m_infoDao{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate; 

	public void insert_m_info(M_Info m_Info) {
		sqlSessionTemplate.insert("insert_m_info", m_Info);
	}
	public List<M_Info> select_m_info() {
		return  sqlSessionTemplate.selectList("select_m_info");
	}
	public List<M_Info> select_other_m_info(String tno) {
		
		return sqlSessionTemplate.selectList("select_other_m_info", tno);
	}
	public void update_m_info_remark(SelectM_info selectm_info) {
		sqlSessionTemplate.update("update_m_info_remark", selectm_info);
	}
	public List<M_Info> select_all_m_info() {
		return sqlSessionTemplate.selectList("select_all_m_info");
	}
	public M_Info select_m_info_by(SelectM_info s) {
		return sqlSessionTemplate.selectOne("select_m_info_by", s);
	}
	public void delete_all_m_info() {
		sqlSessionTemplate.delete("delete_all_m_info");
	}

}
