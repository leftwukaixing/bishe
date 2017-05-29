package manage.dao;

import manage.entity.UserD;

public interface loginDao {
	public UserD select_user(String userid);	
}
