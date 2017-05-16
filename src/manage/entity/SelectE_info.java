package manage.entity;

public class SelectE_info {
	private String cno;
	private String datetime;
	private String address;
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public SelectE_info() {
		super();
	}
	public SelectE_info(String cno, String datetime, String address) {
		super();
		this.cno = cno;
		this.datetime = datetime;
		this.address = address;
	}
	@Override
	public String toString() {
		return "SelectE_info [address=" + address + ", cno=" + cno
				+ ", datetime=" + datetime + "]";
	}
}
