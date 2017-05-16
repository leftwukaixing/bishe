package manage.entity;

public class SelectM_info {
	
	private String teacher;
	private String cname;
	private String timeStart;
	private String address;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public SelectM_info() {
		super();
	}
	public SelectM_info(String teacher, String cname, String timeStart,
			String address) {
		super();
		this.teacher = teacher;
		this.cname = cname;
		this.timeStart = timeStart;
		this.address = address;
	}
	@Override
	public String toString() {
		return "SelectM_info [address=" + address + ", cname=" + cname
				+ ", teacher=" + teacher + ", timeStart=" + timeStart + "]";
	}
}
