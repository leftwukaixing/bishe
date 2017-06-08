package manage.action;

import java.util.List;
import java.util.Map;

import manage.entity.Student;
import manage.entity.WatchLog;
import manage.service.watchLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class watchLogAction extends ActionSupport{
	@Autowired
	private watchLogService service;
	
	private List<WatchLog> list;
	
	public String listWatchLog() {
		Map<String,Object> amap = ActionContext.getContext().getSession();
		Student student = (Student)amap.get("user");
		try {
			list = service.select_WatchLogs_By_Sno(student.getSno());
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}

	public List<WatchLog> getList() {
		return list;
	}

	public void setList(List<WatchLog> list) {
		this.list = list;
	}
	
}
