package manage.entity;

import java.io.Serializable;

public class UserD implements Serializable{
	private static final long serialVersionUID = 1L;
	private String userid;
	private String pwd;
	private String proxy;
	public UserD() {
		super();
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getProxy() {
		return proxy;
	}
	public void setProxy(String proxy) {
		this.proxy = proxy;
	}
	public UserD(String userid, String pwd, String proxy) {
		super();
		this.userid = userid;
		this.pwd = pwd;
		this.proxy = proxy;
	}
	@Override
	public String toString() {
		return "UserD [proxy=" + proxy + ", pwd=" + pwd + ", userid=" + userid
				+ "]";
	}
}
