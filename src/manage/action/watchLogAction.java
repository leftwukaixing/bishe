package manage.action;

import manage.service.watchLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class watchLogAction extends ActionSupport{
	@Autowired
	private watchLogService service;
	
}
