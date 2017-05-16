package manage.entity;

public class M_Manage {
	
	/**
	 * 考试id
	 */
	private String teacher;
	/**
	 * 考试名称
	 */
	private String cname;
	/**
	 * 考试日期
	 */
	private String timeStart;
	/**
	 * 考试时间
	 */
	private String timeEnd;
	/**
	 * 考试地点
	 */
	private String address;
	/**
	 * 监考老师1的ID
	 */
	private String tno_one;
	/**
	 * 监考老师1的姓名
	 */
	private String tname_one;
	/**
	 *  监考老师1的电话
	 */
	private String tel_one;
	/**
	 *监考老师2的ID
	 */
	private String tno_two;
	/**
	 * 监考老师2的姓名
	 */
	private String tname_two;
	/**
	 * 监考老师2的电话
	 */
	private String tel_two;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTno_one() {
		return tno_one;
	}
	public void setTno_one(String tnoOne) {
		tno_one = tnoOne;
	}
	public String getTname_one() {
		return tname_one;
	}
	public void setTname_one(String tnameOne) {
		tname_one = tnameOne;
	}
	public String getTel_one() {
		return tel_one;
	}
	public void setTel_one(String telOne) {
		tel_one = telOne;
	}
	public String getTno_two() {
		return tno_two;
	}
	public void setTno_two(String tnoTwo) {
		tno_two = tnoTwo;
	}
	public String getTname_two() {
		return tname_two;
	}
	public void setTname_two(String tnameTwo) {
		tname_two = tnameTwo;
	}
	public String getTel_two() {
		return tel_two;
	}
	public void setTel_two(String telTwo) {
		tel_two = telTwo;
	}
	public M_Manage() {
		super();
	}
	public M_Manage(String teacher, String cname, String timeStart, String timeEnd,
			String address, String tnoOne, String tnameOne, String telOne,
			String tnoTwo, String tnameTwo, String telTwo) {
		super();
		this.teacher = teacher;
		this.cname = cname;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.address = address;
		tno_one = tnoOne;
		tname_one = tnameOne;
		tel_one = telOne;
		tno_two = tnoTwo;
		tname_two = tnameTwo;
		tel_two = telTwo;
	}
	@Override
	public String toString() {
		return "M_Manage [address=" + address + ", cname=" + cname
				+ ", teacher=" + teacher + ", tel_one=" + tel_one
				+ ", tel_two=" + tel_two + ", timeEnd=" + timeEnd
				+ ", timeStart=" + timeStart + ", tname_one=" + tname_one
				+ ", tname_two=" + tname_two + ", tno_one=" + tno_one
				+ ", tno_two=" + tno_two + "]";
	}
	
}
