package manage.entity;

import java.io.Serializable;

public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String sno;
	private String sname;
	private String sclass;
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSclass() {
		return sclass;
	}
	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
	public Student(String sno, String sname, String sclass) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sclass = sclass;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [sclass=" + sclass + ", sname=" + sname + ", sno="
				+ sno + "]";
	}
	
}
