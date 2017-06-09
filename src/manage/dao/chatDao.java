package manage.dao;

import java.util.List;

import manage.entity.Chat;

public interface chatDao {
	public void add_Chat(Chat chat);
	
	public List<Chat> select_Chats();
}
