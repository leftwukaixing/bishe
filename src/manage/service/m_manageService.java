package manage.service;

import java.util.List;
import manage.dao.m_manageDao;
import manage.entity.M_Manage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class m_manageService {	
	@Autowired
	private m_manageDao dao;
	public List<M_Manage> select_m_manage(String tno){
		return dao.select_m_manage(tno);
	}
	public void insert_m_manage(M_Manage m_manage){
		dao.insert_m_manage(m_manage);
	}
	public List<M_Manage> select_all_manage(){
		return dao.select_all_m_manage();
	}
	public void update_M_Manage(M_Manage m_manage){
		dao.update_M_Manage(m_manage);
	}
	public void delete_all_m_manage(){
		dao.delete_all_m_manage();
	}
}
