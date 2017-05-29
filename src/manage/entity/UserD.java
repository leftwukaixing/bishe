package manage.entity;

import java.io.Serializable;

public class UserD implements Serializable{
	private static final long serialVersionUID = 1L;
	private String uid;
	private String password;
	private String proy;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setProy(String proy) {
		this.proy = proy;
	}
	public String getProy() {
		return proy;
	}
	public UserD(String uid, String password, String proy) {
		super();
		this.uid = uid;
		this.password = password;
		this.proy = proy;
	}
	public UserD() {
		super();
	}
	@Override
	public String toString() {
		return "User [password=" + password + ", proy=" + proy + ", uid=" + uid
				+ "]";
	}
	
}
