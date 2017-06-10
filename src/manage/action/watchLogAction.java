package manage.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import manage.entity.Student;
import manage.entity.WatchLog;
import manage.service.watchLogService;
import manage.vo.Watch;

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
	
	private Watch wlg;
	
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
	
	public void updateWatchLog(){
		SimpleDateFormat myFmt=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		Date now = new Date();
		Map<String,Object> amap = ActionContext.getContext().getSession();
		Student student = (Student)amap.get("user");
		String href = wlg.getHref();
		String kname = href.substring(href.lastIndexOf("/")+1, href.length()-4);
		String kno = kname.split("-")[0];
		WatchLog wl = new WatchLog(student.getSno(),kno,wlg.getProgress(),wlg.getStatus(),myFmt.format(now).toString());
		try {
			WatchLog w = service.select_WatchLog(wl);
			if (w == null) {
				service.add_WatchLog(wl);
			} else {
				service.update_WatchLog(wl);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<WatchLog> getList() {
		return list;
	}

	public void setList(List<WatchLog> list) {
		this.list = list;
	}

	public Watch getWlg() {
		return wlg;
	}

	public void setWlg(Watch wlg) {
		this.wlg = wlg;
	}
	
}
