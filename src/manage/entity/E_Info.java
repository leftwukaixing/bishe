package manage.entity;

public class E_Info {
	
	//试卷编号
	String paperno;
	//课程编号
	String cno;
	//课程名称
	String cname;
	//开课院系
	String college;
	//授课教师
	String teacher;
	//选课人数
	String chooseno;
	//已排人数
	String already;
	//考试地点
	String address;
	//考场总人数
	String numberAll;
	//考场容量
	String contines;
	//上课周次
	String weekc;
	//考试日期
	String datetime;
	//考试节次
	String week;
	//考试时间
	String time;
	int remark;
	public String getPaperno() {
		return paperno;
	}
	public void setPaperno(String paperno) {
		this.paperno = paperno;
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getChooseno() {
		return chooseno;
	}
	public void setChooseno(String chooseno) {
		this.chooseno = chooseno;
	}
	public String getAlready() {
		return already;
	}
	public void setAlready(String already) {
		this.already = already;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNumberAll() {
		return numberAll;
	}
	public void setNumberAll(String numberAll) {
		this.numberAll = numberAll;
	}
	public String getContines() {
		return contines;
	}
	public void setContines(String contines) {
		this.contines = contines;
	}
	public String getWeekc() {
		return weekc;
	}
	public void setWeekc(String weekc) {
		this.weekc = weekc;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getRemark() {
		return remark;
	}
	public void setRemark(int remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "E_Info [address=" + address + ", already=" + already
				+ ", chooseno=" + chooseno + ", cname=" + cname + ", cno="
				+ cno + ", college=" + college + ", contines=" + contines
				+ ", datetime=" + datetime + ", numberAll=" + numberAll
				+ ", paperno=" + paperno + ", remark=" + remark + ", teacher="
				+ teacher + ", time=" + time + ", week=" + week + ", weekc="
				+ weekc + "]";
	}
	public E_Info(String paperno, String cno, String cname, String college,
			String teacher, String chooseno, String already, String address,
			String numberAll, String contines, String weekc, String datetime,
			String week, String time, int remark) {
		super();
		this.paperno = paperno;
		this.cno = cno;
		this.cname = cname;
		this.college = college;
		this.teacher = teacher;
		this.chooseno = chooseno;
		this.already = already;
		this.address = address;
		this.numberAll = numberAll;
		this.contines = contines;
		this.weekc = weekc;
		this.datetime = datetime;
		this.week = week;
		this.time = time;
		this.remark = remark;
	}
	public E_Info() {
		super();
	}
}
