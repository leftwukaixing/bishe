package manage.entity;

public class Course {
	/**
	 * 学年
	 */
	private String grade;
	/**
	 * 学期
	 */
	private String term;
	/**
	 * 课程名
	 */
	private String cname;
	/**
	 * 周几
	 */
	private String day_of_week;
	/**
	 * 节数
	 */
	private String time;
	/**
	 * 开始节数周
	 */
	private String week;
	/**
	 * 单双周信息
	 */
	private String remark;
	/**
	 * 任课教师id
	 */
	private String tno;
	/**
	 * 上课地点
	 */
	private String address;
	/**
	 * 上课班级
	 */
	private String student;
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getDay_of_week() {
		return day_of_week;
	}
	public void setDay_of_week(String day_of_week) {
		this.day_of_week = day_of_week;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStudent() {
		return student;
	}
	public void setStudent(String student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Course [grade=" + grade + ", term=" + term + ", cname=" + cname
				+ ", day_of_week=" + day_of_week + ", time=" + time + ", week="
				+ week + ", remark=" + remark + ", tno=" + tno + ", address="
				+ address + ", student=" + student + "]";
	}
	public Course(String grade, String term, String cname, String day_of_week,
			String time, String week, String remark, String tno,
			String address, String student) {
		super();
		this.grade = grade;
		this.term = term;
		this.cname = cname;
		this.day_of_week = day_of_week;
		this.time = time;
		this.week = week;
		this.remark = remark;
		this.tno = tno;
		this.address = address;
		this.student = student;
	}
	public Course() {
		super();
	}
}
