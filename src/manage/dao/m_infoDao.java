package manage.dao;

import java.util.List;
import manage.entity.M_Info;
import manage.entity.SelectM_info;

public interface m_infoDao {

	public void insert_m_info(M_Info mInfo);
	public List<M_Info> select_m_info();
	public List<M_Info> select_other_m_info(String tno);
	public void update_m_info_remark(SelectM_info selectm_info);
	public List<M_Info> select_all_m_info();
	public M_Info select_m_info_by(SelectM_info s);
	public void delete_all_m_info();
	
}
