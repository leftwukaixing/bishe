package manage.entity;

public class M_Info {
	
	//录入状态
	String stateLr;
	//申报教工姓名[工号]
	String teacher;
	//课程名称[课程号]
	String cname;
	//考试模式
	String examType;
	//阶段序号
	String M_number;
	//考试周次
	String week;
	//考试起始时间
	String timeStart;
	//考试结束时间
	String timeEnd;
	//班级
	String grade;
	//考试地点
	String address;
	//总考试座位数
	String numberSeat;
	//是否随堂考
	String examST;
	//课程类别
	String courseType;
	//课程性质
	String courseXZ;
	//理论学时
	String timeLL;
	//总学时
	String timeAll;
	//选课人数
	String numberChoose;
	//开课单位
	String argument;
	int remark;
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getExamType() {
		return examType;
	}
	public void setExamType(String examType) {
		this.examType = examType;
	}
	public String getM_number() {
		return M_number;
	}
	public void setM_number(String mNumber) {
		M_number = mNumber;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}
	public String getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNumberSeat() {
		return numberSeat;
	}
	public void setNumberSeat(String numberSeat) {
		this.numberSeat = numberSeat;
	}
	public String getExamST() {
		return examST;
	}
	public void setExamST(String examST) {
		this.examST = examST;
	}
	public String getCourseType() {
		return courseType;
	}
	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}
	public String getCourseXZ() {
		return courseXZ;
	}
	public void setCourseXZ(String courseXZ) {
		this.courseXZ = courseXZ;
	}
	public String getTimeLL() {
		return timeLL;
	}
	public void setTimeLL(String timeLL) {
		this.timeLL = timeLL;
	}
	public String getTimeAll() {
		return timeAll;
	}
	public void setTimeAll(String timeAll) {
		this.timeAll = timeAll;
	}
	public String getNumberChoose() {
		return numberChoose;
	}
	public void setNumberChoose(String numberChoose) {
		this.numberChoose = numberChoose;
	}
	public String getArgument() {
		return argument;
	}
	public void setArgument(String argument) {
		this.argument = argument;
	}
	public int getRemark() {
		return remark;
	}
	public void setRemark(int remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "M_Info [M_number=" + M_number + ", address=" + address
				+ ", argument=" + argument + ", cname=" + cname
				+ ", courseType=" + courseType + ", courseXZ=" + courseXZ
				+ ", examST=" + examST + ", examType=" + examType + ", grade="
				+ grade + ", numberChoose=" + numberChoose + ", numberSeat="
				+ numberSeat + ", remark=" + remark + ", teacher=" + teacher
				+ ", timeAll=" + timeAll + ", timeEnd=" + timeEnd + ", timeLL="
				+ timeLL + ", timeStart=" + timeStart + ", week=" + week + "]";
	}
	public M_Info(String teacher, String cname, String examType,
			String mNumber, String week, String timeStart, String timeEnd,
			String grade, String address, String numberSeat, String examST,
			String courseType, String courseXZ, String timeLL, String timeAll,
			String numberChoose, String argument, int remark) {
		super();
		this.teacher = teacher;
		this.cname = cname;
		this.examType = examType;
		M_number = mNumber;
		this.week = week;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.grade = grade;
		this.address = address;
		this.numberSeat = numberSeat;
		this.examST = examST;
		this.courseType = courseType;
		this.courseXZ = courseXZ;
		this.timeLL = timeLL;
		this.timeAll = timeAll;
		this.numberChoose = numberChoose;
		this.argument = argument;
		this.remark = remark;
	}
	public M_Info() {
		super();
	}
	
}
