package manage.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manage.entity.Teacher;

public class AdminFilter implements Filter{
	
	// 存储默认允许访问的页面
	List<String> list = new ArrayList<String>();

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// 得到session
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();

		String path = req.getRequestURI();
		String context = req.getContextPath();
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		if(teacher!=null|| list.contains(path) || path.endsWith("js")
				|| path.endsWith("css") || path.endsWith("jpg")
				|| path.endsWith("png") || path.endsWith("gif")){
			// 放行
			chain.doFilter(request, response);
			//System.out.println("放行");
		}else{
			res.sendRedirect(context + "/index.action");
			//System.out.println("不放行");
		}
	}

	
	public void init(FilterConfig arg0) throws ServletException {
		// 初始化默认访问页面
		list.add("/jkmanage/index.action");
		list.add("/jkmanage/loginAction!selectTeacher");
	}

}