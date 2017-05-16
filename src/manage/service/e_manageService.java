package manage.service;

import java.util.List;

import manage.dao.e_manageDao;
import manage.entity.E_Manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class e_manageService {
	@Autowired
	private e_manageDao dao;
	public List<E_Manage> select_e_manage(String tno){
		return dao.select_e_manage(tno);
	}
	public void insert_e_manage(E_Manage e_manage){
		dao.insert_e_manage(e_manage);
	}
	public List<E_Manage> select_all_manage(){
		return dao.select_all_e_manage();
	}
	public void update_E_Manage(E_Manage e_manage){
		dao.update_E_Manage(e_manage);
	}
	public void delete_all_e_manage(){
		dao.delete_all_e_manage();
	}
}
