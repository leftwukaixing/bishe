package manage.util.sendMessage;

import java.util.TimerTask;

public abstract class MyTimerTask extends TimerTask{
	
	public SendMessage app;
	
	public MyTimerTask(SendMessage app) {
		this.app = app;
	}
}
