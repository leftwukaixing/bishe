package manage.entity;

import java.io.Serializable;

public class Teacher implements Serializable{
	private static final long serialVersionUID = 1L;

	private String tno;
	private String tname;
	private String trank;
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTrank() {
		return trank;
	}
	public void setTrank(String trank) {
		this.trank = trank;
	}
	public Teacher(String tno, String tname, String trank) {
		super();
		this.tno = tno;
		this.tname = tname;
		this.trank = trank;
	}
	public Teacher() {
		super();
	}
	@Override
	public String toString() {
		return "Teacher [tname=" + tname + ", tno=" + tno + ", trank=" + trank
				+ "]";
	}
	
}
