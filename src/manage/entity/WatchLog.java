package manage.entity;

import java.io.Serializable;

public class WatchLog implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String sno;
	private String kno;
	private String progress;
	private String status;
	private String watch_time;
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getKno() {
		return kno;
	}
	public void setKno(String kno) {
		this.kno = kno;
	}
	public String getProgress() {
		return progress;
	}
	public void setProgress(String progress) {
		this.progress = progress;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getWatch_time() {
		return watch_time;
	}
	public void setWatch_time(String watchTime) {
		watch_time = watchTime;
	}
	public WatchLog(String sno, String kno, String progress, String status,
			String watchTime) {
		super();
		this.sno = sno;
		this.kno = kno;
		this.progress = progress;
		this.status = status;
		watch_time = watchTime;
	}
	public WatchLog() {
		super();
	}
	@Override
	public String toString() {
		return "WatchLog [kno=" + kno + ", progress=" + progress + ", sno="
				+ sno + ", status=" + status + ", watch_time=" + watch_time
				+ "]";
	}
}
