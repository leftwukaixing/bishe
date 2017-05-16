package manage.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * 过滤编码.用于把编码统一为:utf-8 
 * * */
public class EncodingFilter implements Filter
{
	public EncodingFilter() {
	
	} 
	public void destroy() { 
	
	} 
	/**
	 *  过滤方法 
	 *  */
	public void doFilter(ServletRequest request, 
			ServletResponse response,   FilterChain chain) 
					throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);
		}
	public void init(FilterConfig arg0) 
			throws ServletException {
		
	}
	
}
