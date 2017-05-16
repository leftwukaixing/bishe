package manage.vo;

public class User {
	private String tno;
	private String pwd;
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "User [pwd=" + pwd + ", tno=" + tno + "]";
	}
}
