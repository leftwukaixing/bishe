package manage.vo;

public class Page {
	//接收请求参数input
	//要显示第几页记录，默认显示第1页
	private Integer current = 1;
//	每页显示几条记录，默认显示5条
	private Integer pageSize = 15;
	//总记录数，默认为1
	private Integer rows = 0;
	//在JSP中使用${totalPage}时，会自动调用getTotalPage()
	public Integer getTotalPage(){
		int totalPage = 0;
		if (rows%pageSize==0) {
			totalPage = rows/pageSize;
		} else {
			totalPage = rows/pageSize+1;
		}
		if(totalPage==0)
			totalPage=1;
		return totalPage;
	}
	//在XML中#{begin}会自动调用getBegin方法
	public Integer getBegin() {
		return (current-1)*pageSize;
		//mysql的分页不含开头 从零开始  原oracle的返回值为(current-1)*pageSize+1;
	}
//	在XML中#{end}会自动调用getEnd方法
	public Integer getEnd() {
		return current*pageSize+1;
	}
	public Integer getCurrent() {
		return current;
	}
	public void setCurrent(Integer current) {
		this.current = current;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	
}
