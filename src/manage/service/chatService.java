package manage.service;

import java.util.List;

import manage.dao.chatDao;
import manage.entity.Chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class chatService {
	
	@Autowired
	private chatDao dao;
	
	public void add_Chat(Chat chat){
		dao.add_Chat(chat);
	}
	
	public List<Chat> select_Chats(){
		return dao.select_Chats();
	}
}
