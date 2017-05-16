package manage.entity;

import java.io.Serializable;

public class Teacher implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 教师id 
	 */
	private String tno;
	/**
	 * 教师姓名
	 */
	private String tname;
	/**
	 * 登陆密码
	 */
	private String pwd;
	/**
	 * 手机号
	 */
	private String telephone;
	/**
	 * 权限
	 */
	private String proy;
	/**
	 * 监考次数 默认是零
	 */
	private int count;
	/**
	 * 所属学院
	 */
	private String college;
	/**
	 * 备注 0不能监考 1可以监考
	 */
	private String remark;
	/**
	 * 专业
	 */
	private String major;
	/**
	 * 工作
	 */
	private String job;
	/**
	 * 上传课表信息 0代表未上传，1代表已上传
	 */
	private String upload;
	
	public String getUpload() {
		return upload;
	}
	public void setUpload(String upload) {
		this.upload = upload;
	}
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getProy() {
		return proy;
	}
	public void setProy(String proy) {
		this.proy = proy;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Teacher() {
		super();
	}
	@Override
	public String toString() {
		return "Teacher [tno=" + tno + ", tname=" + tname + ", pwd=" + pwd
				+ ", telephone=" + telephone + ", proy=" + proy + ", count="
				+ count + ", college=" + college + ", remark=" + remark
				+ ", major=" + major + ", job=" + job + ", upload=" + upload
				+ "]";
	}

}
