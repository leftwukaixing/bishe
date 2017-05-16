package manage.dao;

import java.util.List;
import manage.entity.E_Info;
import manage.entity.SelectE_info;

public interface e_infoDao {
	public void insert_e_info(E_Info e_info);
	public List<E_Info> select_e_info();
	public List<E_Info> select_other_e_info(String tno);
	public void update_e_info_remark(SelectE_info selecte_info);
	public  List<E_Info> select_all_e_info();
	public E_Info select_e_info_by(SelectE_info s);
	public void delete_all_e_info();
}
