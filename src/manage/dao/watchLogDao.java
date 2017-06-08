package manage.dao;

import java.util.List;

import manage.entity.WatchLog;

public interface watchLogDao {
	
	public List<WatchLog> select_WatchLogs_By_Kno(String kno);
	
	public List<WatchLog> select_WatchLogs_By_Sno(String sno);
}
