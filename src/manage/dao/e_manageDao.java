package manage.dao;

import java.util.List;
import manage.entity.E_Manage;

public interface e_manageDao {
	public List<E_Manage> select_e_manage(String tno);
	public void insert_e_manage(E_Manage e_manage);
	public List<E_Manage> select_all_e_manage();
	public void update_E_Manage(E_Manage e_manage);
	public void delete_all_e_manage();
}
