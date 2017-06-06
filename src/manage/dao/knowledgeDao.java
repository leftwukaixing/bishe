package manage.dao;

import java.util.List;

import manage.entity.Knowledge;

public interface knowledgeDao {
	public void add_knowledge(Knowledge klg);
	
	public List<Knowledge> select_Knowledges();
}
