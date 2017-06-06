package manage.service;

import java.util.List;

import manage.dao.knowledgeDao;
import manage.entity.Knowledge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class knowledgeService {
	@Autowired
	private knowledgeDao dao;
	
	public void add_Knowledge(Knowledge klg){
		dao.add_knowledge(klg);
	}
	
	public List<Knowledge> select_Knowledges(){
		return dao.select_Knowledges();
	}
}
