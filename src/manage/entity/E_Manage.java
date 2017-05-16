package manage.entity;

public class E_Manage {
	/**
	 * 考试id
	 */
	private String cno;
	/**
	 * 考试名称
	 */
	private String cname;
	/**
	 * 考试日期
	 */
	private String datetime;
	/**
	 * 考试时间
	 */
	private String time;
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
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
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
	public E_Manage() {
		super();
	}
	public E_Manage(String cno, String cname, String datetime, String time,
			String address, String tnoOne, String tnameOne, String telOne,
			String tnoTwo, String tnameTwo, String telTwo) {
		super();
		this.cno = cno;
		this.cname = cname;
		this.datetime = datetime;
		this.time = time;
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
		return "E_Manage [address=" + address + ", cname=" + cname + ", cno="
				+ cno + ", datetime=" + datetime + ", tel_one=" + tel_one
				+ ", tel_two=" + tel_two + ", time=" + time + ", tname_one="
				+ tname_one + ", tname_two=" + tname_two + ", tno_one="
				+ tno_one + ", tno_two=" + tno_two + "]";
	}
}
