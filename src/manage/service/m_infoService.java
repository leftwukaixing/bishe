package manage.service;

import java.util.List;
import manage.dao.m_infoDao;
import manage.entity.M_Info;
import manage.entity.SelectM_info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class m_infoService {
	@Autowired
	private m_infoDao dao;
	
	public void insert_m_info(List<M_Info> list) {
		for (M_Info m_info : list) {
			dao.insert_m_info(m_info);
		}
	}
	public List<M_Info> select_m_info(){
		return dao.select_m_info();
	}
	public List<M_Info> select_other_m_info(String tno){
		return dao.select_other_m_info(tno);
	}
	public void update_m_info_remark(SelectM_info selectm_info){
		dao.update_m_info_remark(selectm_info);
	}
	public List<M_Info> select_all_m_info() {
		return dao.select_all_m_info();
	}
	public M_Info select_m_info_by(SelectM_info s){
		return dao.select_m_info_by(s);
	}
	public void delete_all_m_info(){
		dao.delete_all_m_info();
	}
}
