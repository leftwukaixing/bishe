package manage.entity;

import java.io.Serializable;

public class Knowledge implements Serializable{
	private static final long serialVersionUID = 1L;
	private String kno;
	private String chapter;
	private String content;
	private String describe;
	public String getKno() {
		return kno;
	}
	public void setKno(String kno) {
		this.kno = kno;
	}
	public String getChapter() {
		return chapter;
	}
	public void setChapter(String chapter) {
		this.chapter = chapter;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public Knowledge(String kno, String chapter, String content, String describe) {
		super();
		this.kno = kno;
		this.chapter = chapter;
		this.content = content;
		this.describe = describe;
	}
	public Knowledge() {
		super();
	}
	@Override
	public String toString() {
		return "knowledge [chapter=" + chapter + ", content=" + content
				+ ", describe=" + describe + ", kno=" + kno + "]";
	}
}
