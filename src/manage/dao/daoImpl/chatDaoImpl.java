package manage.dao.daoImpl;

import java.util.List;
import manage.dao.chatDao;
import manage.entity.Chat;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class chatDaoImpl implements chatDao{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public void add_Chat(Chat chat) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert("add_chat", chat);
	}

	public List<Chat> select_Chats() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("select_chats");
	}
	

}
