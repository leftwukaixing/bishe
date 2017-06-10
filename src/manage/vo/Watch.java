package manage.vo;

public class Watch {
	private String progress;
	private String status;
	private String href;
	public String getProgress() {
		return progress;
	}
	public void setProgress(String progress) {
		this.progress = progress;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String vlength) {
		this.status = vlength;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public Watch(String progress, String status, String href) {
		super();
		this.progress = progress;
		this.status = status;
		this.href = href;
	}
	public Watch() {
		super();
	}
	@Override
	public String toString() {
		return "Watch [href=" + href + ", progress=" + progress + ", status="
				+ status + "]";
	}
}
