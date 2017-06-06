package manage.dao.daoImpl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import manage.dao.knowledgeDao;
import manage.entity.Knowledge;

@Repository
public class knowledgeDaoImpl implements knowledgeDao{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void add_knowledge(Knowledge klg) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert("add_knowledge", klg);
	}

	public List<Knowledge> select_Knowledges() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("select_knowledges");
	}

}
