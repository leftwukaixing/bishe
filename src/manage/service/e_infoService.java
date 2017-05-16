package manage.service;

import java.util.List;


import manage.dao.e_infoDao;
import manage.entity.E_Info;
import manage.entity.SelectE_info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class e_infoService {
	@Autowired
	private e_infoDao dao;
	public void insert_e_info(List<E_Info> list){
		for (E_Info e_info : list) {
			dao.insert_e_info(e_info);
		}
	}
	public List<E_Info> select_e_info(){
		return dao.select_e_info();
	}
	public List<E_Info> select_other_e_info(String tno){
		return dao.select_other_e_info(tno);
	}
	public void update_e_info_remark(SelectE_info selecte_info){
		dao.update_e_info_remark(selecte_info);
	}
	public  List<E_Info> select_all_e_info(){
		return dao.select_all_e_info();
	}
	public E_Info select_e_info_by(SelectE_info s){
		return dao.select_e_info_by(s);
	}
	public void delete_all_e_info(){
		dao.delete_all_e_info();
	}
	
}
