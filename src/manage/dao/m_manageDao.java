package manage.dao;

import java.util.List;
import manage.entity.M_Manage;

public interface m_manageDao {
	public List<M_Manage> select_m_manage(String tno);
	public void insert_m_manage(M_Manage m_manage);
	public List<M_Manage> select_all_m_manage();
	public void update_M_Manage(M_Manage m_manage);
	public void delete_all_m_manage();
}
