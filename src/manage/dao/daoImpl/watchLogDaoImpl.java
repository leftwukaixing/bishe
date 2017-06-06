package manage.dao.daoImpl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import manage.dao.watchLogDao;
import manage.entity.WatchLog;

@Repository
public class watchLogDaoImpl implements watchLogDao{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<WatchLog> select_WatchLogs_by_kno(String kno) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("select_watchLogs_by_kno",kno);
	}

}
