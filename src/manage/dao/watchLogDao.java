package manage.dao;

import java.util.List;

import manage.entity.WatchLog;

public interface watchLogDao {
	
	public List<WatchLog> select_WatchLogs_By_Kno(String kno);
	
	public List<WatchLog> select_WatchLogs_By_Sno(String sno);
	
	public void update_WatchLog(WatchLog wlg);
	
	public void add_WatchLog(WatchLog wlg);
	
	public WatchLog select_WatchLog(WatchLog wlg);
}
