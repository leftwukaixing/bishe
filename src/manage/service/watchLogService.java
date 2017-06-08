package manage.service;

import java.util.List;

import manage.dao.watchLogDao;
import manage.entity.WatchLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class watchLogService {
	@Autowired
	private watchLogDao dao;
	
	public List<WatchLog> select_WatchLogs_By_Kno(String kno){
		return dao.select_WatchLogs_By_Kno(kno);
	}
	
	public List<WatchLog> select_WatchLogs_By_Sno(String sno){
		return dao.select_WatchLogs_By_Sno(sno);
	}
}
