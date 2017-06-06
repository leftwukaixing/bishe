package manage.dao;

import java.util.List;

import manage.entity.WatchLog;

public interface watchLogDao {
	
	public List<WatchLog> select_WatchLogs_by_kno(String kno);
}
