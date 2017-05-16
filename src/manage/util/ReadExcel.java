package manage.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import manage.entity.Course;
import manage.entity.E_Info;
import manage.entity.M_Info;

public class ReadExcel {
	
	/**
	 * 从Excel中读取（Course）教师课程表，并存入数据库中
	 * @param url
	 * @param tno
	 * @return
	 */
	public static List<Course> readCourse(String url, String tno) {
		List<Course> list = new ArrayList<Course>();
		Workbook book = null;
		Cell cell;
		int r = 0, c = 0;// 课表开始变量
		boolean start = false;
		// 存储学期和学年
		String[] context;
		// 存储学年
		String grade = null;
		// 存储学期
		String term = null;
		// 读取内容
		String[][] strings;
		String day_of_week = null;
		String time = null;
		String cname = null;
		String week = null;
		String remark = null;
		String address = null;
		String student = null;
		// 获得表格文件
		try {
			book = Workbook.getWorkbook(new File(url));
			// 取工作表对象 从0开始
			Sheet sheet = book.getSheet(0);
			int rows = sheet.getRows();// 行
			int cols = sheet.getColumns();// 列
			strings = new String[rows][cols];
			// System.out.println(rows+","+cols);
			// 找到课表开始行列
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					// 参数顺序是列，行
					cell = sheet.getCell(j, i);
					// 去除内容两边的空格
					strings[i][j] = cell.getContents().trim();
					if (start == false && !"".equals(strings[i][j])) {
						r = i;
						c = j;
						start = true;
					}
				}
			}
			for (int i = r; i < r + 9; i++) {
				for (int j = c; j < c + 8; j++) {
					// 读取学年和学期
					if (i == r + 1 && j == c && strings[i][j].contains("学年学期")) {
						context = strings[i][j].trim().split("\\s");
						context = context[0].split("：");
						context = context[1].split("-");
						grade = context[0] + "-" + context[1];
						term = context[2];

					}
					if (i > r + 3 && j > c+1 && !"".equals(strings[i][j])) {
						context = strings[i][j].split("\\s");
						// 取周几
						day_of_week = strings[r + 2][j];
						System.out.println("-----"+day_of_week);
						// 取节数
						time = strings[i][c];

						// 课程表里的格里有多科考试！
						int num = (context.length + 1) / 5;

						// 
						for (String con : context) {
							System.out.println(con);
						}

						for (int k = 0; k < num; k++) {
							// 取课程名,从0开始
							cname = context[0 + 5 * k].trim();
							
							student = context[1 + 5 * k].trim();
							
							// 取周数
							week = (context[2 + 5 * k].trim().split("周"))[0];
							// 取单双周信息
							if (context[1 + 5 * k].contains("单周")) {
								remark = "1";
							} else if (context[1 + 5 * k].contains("双周")) {
								remark = "2";
							} else {
								remark = "0";
							}
							address = context[3 + 5 * k].trim();
//							student = context[1 + 5 * k].trim();
							// 还差tno!!!从session中取值
							System.out.println(grade + "|" + term + "|" + cname
									+ "|" + day_of_week + "|" + time + "|"
									+ week + "|" + remark + "|" + "" + "|"
									+ address + "|" + student);
							list.add(new Course(grade, term, cname,
									day_of_week, time, week, remark, tno,
									address, student));
						}

					}
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("导入课程出错");
		}
		return list;
	}
	
	/**
	 * 从Excel中读取（E_Info）期末考试信息表，并写入数据库
	 * @param url
	 * @return
	 */
	public static List<E_Info> readE_Info(String url) {
		List<E_Info> list = new ArrayList<E_Info>();
		Workbook book = null;
		Cell cell;
		int r = 0, c = 0;// 开始变量
		boolean start = false;
		// 读取内容
		String[][] strings;		
		//试卷编号
		String paperno = null;
		//课程编号
		String cno = null;
		//课程名称
		String cname = null;
		//开课院系
		String college = null;
		//授课教师
		String teacher = null;
		//选课人数
		String chooseno = null;
		//已排人数
		String already = null;
		//考试地点
		String address = null;
		//考场总人数
		String numberAll = null;
		//考场容量
		String contines = null;
		//上课周次
		String weekc = null;
		//考试日期
		String datetime = null;
		//考试节次
		String week = null;
		//考试时间
		String time = null;
		//标记
		int remark = 0;
		
		try {
			book = Workbook.getWorkbook(new File(url));
			// 取工作表对象 从0开始
			Sheet sheet = book.getSheet(0);
			int rows = sheet.getRows();// 行
			int cols = sheet.getColumns();// 列
			strings = new String[rows][cols];
			// System.out.println(rows+","+cols);
			for (int i = 0; i < rows; i++) {
				for (int j = 1; j < cols; j++) {
					// 参数顺序是列，行
					cell = sheet.getCell(j, i);
					// 去除内容两边的空格
					strings[i][j] = cell.getContents().trim();
					if (start == false && !"".equals(strings[i][j])) {
						r = i;
						c = j;
						start = true;
					}
				}
			}
			for (int i = r; i < rows; i++) {
				for (int j = c; j < cols; j++) {
					if (i > r && j == c ) {
						paperno = strings[i][j];
					}
					if (i > r && j == c ) {
						cno = strings[i][j];
					}
					if (i > r && j == c + 1) {
						cname = strings[i][j];
					}
					if (i > r && j == c + 2) {
						college = strings[i][j];
					}
					if (i > r && j == c + 3) {
						teacher = strings[i][j];
					}
					if (i > r && j == c + 7) {
						chooseno = strings[i][j];
					}
					if (i > r && j == c + 8) {
						already = strings[i][j];
					}
					if (i > r && j == c + 9) {
						address = strings[i][j];
					}
					if (i > r && j == c + 10) {
						numberAll = strings[i][j];
					}
					if (i > r && j == c + 11) {
						contines = strings[i][j];
					}
					if (i > r && j == c + 12) {
						weekc = strings[i][j];
					}
					if (i > r && j == c + 13) {
						datetime = strings[i][j];
					}
					if (i > r && j == c + 14) {
						week = strings[i][j];
					}
					if (i > r && j == c + 15) {
						time = strings[i][j];
					}
				}
				if (i > r) {
//					System.out.println(paperno+"||"+cno+"||"+cname+"||"+college+"||"
//							+teacher+"||"+chooseno+"||"+already+"||"+address+"||"
//							+numberAll+"||"+contines+"||"+weekc+"||"+datetime+"||"
//							+week+"||"+time+"||"+remark);
					list.add(new E_Info(paperno,cno,cname,college,
							teacher,chooseno,already,address,
							numberAll,contines,weekc,datetime,
							week,time,remark));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 从Excel中读取（M_Info）阶段考试信息表，并写入数据库
	 * @param url
	 * @return
	 */
	public static List<M_Info> readM_Info(String url){

		List<M_Info> list = new ArrayList<M_Info>();
		Workbook book = null;
		Cell cell;
		int r = 0, c = 0;// 开始变量
		boolean start = false;
		// 读取内容
		String[][] strings;	
		//申报教工姓名[工号]
		String teacher = null;
		//课程名称[课程号]
		String cname = null;
		//考试模式
		String examType = null;
		//阶段序号
		String M_number = null;
		//考试周次
		String week = null;
		//考试起始时间
		String timeStart = null;
		//考试结束时间
		String timeEnd = null;
		//班级
		String grade = null;
		//考试地点
		String address = null;
		//总考试座位数
		String numberSeat = null;
		//是否随堂考
		String examST = null;
		//课程类别
		String courseType = null;
		//课程性质
		String courseXZ = null;
		//理论学时
		String timeLL = null;
		//总学时
		String timeAll = null;
		//选课人数
		String numberChoose = null;
		//监考单位
		String argument = null;
		//标记
		int remark = 0;
		
		try {
			book = Workbook.getWorkbook(new File(url));
			// 取工作表对象 从0开始
			Sheet sheet = book.getSheet(0);			
			int rows = sheet.getRows();// 行
			int cols = sheet.getColumns();// 列
			
			for(int i = 0 ; i < rows ; i ++){
//				System.out.println(sheet.getCell(1, i).getContents());
				if(sheet.getCell(1, i).getContents().isEmpty()){
					rows--;
				}
			}
			
//			System.out.println(rows+","+cols);
			
			strings = new String[rows][cols];
			for (int i = 0; i < rows; i++) {
				for (int j = 1; j < cols; j++) {
					// 参数顺序是列，行
					cell = sheet.getCell(j, i);
					// 去除内容两边的空格
					strings[i][j] = cell.getContents().trim();
					if (start == false && !"".equals(strings[i][j])) {
						r = i;
						c = j;
						start = true;
					}
				}
			}
//			System.out.println(r+"--"+c);
			for (int i = r ; i < rows; i++) {
				for (int j = c ; j < cols; j++) {
					if (i > r && j == c ) {
						teacher = strings[i][j];
					}
					if (i > r && j == c + 1 ) {
						cname = strings[i][j];
					}
					if (i > r && j == c + 2 ) {
						examType = strings[i][j];
					}
					if (i > r && j == c + 3 ) {
						M_number = strings[i][j];
					}
					if (i > r && j == c + 4) {
						week = strings[i][j];
					}
					if (i > r && j == c + 5 ) {
						timeStart = strings[i][j];
					}
					if (i > r && j == c + 6 ) {
						timeEnd = strings[i][j];
					}
					if (i > r && j == c + 7) {
						grade = strings[i][j];
					}
					if (i > r && j == c + 8 ) {
						address = strings[i][j];
					}
					if (i > r && j == c + 9 ) {
						numberSeat = strings[i][j];
					}
					if (i > r && j == c + 10 ) {
						examST = strings[i][j];
					}
					if (i > r && j == c + 11 ) {
						courseType = strings[i][j];
					}
					if (i > r && j == c + 12 ) {
						courseXZ = strings[i][j];
					}
					if (i > r && j == c + 13 ) {
						timeLL = strings[i][j];
					}
					if (i > r && j == c + 14 ) {
						timeAll = strings[i][j];
					}
					if (i > r && j == c + 15 ) {
						numberChoose = strings[i][j];
					}
					if (i > r && j == c + 16 ) {
						argument = strings[i][j];
					}
				}
				if (i > r && cname!="" && teacher!="") {
//					System.out.println(teacher+"|~~|"+cname+"|~~|"+examType+"|~~|"
//							+M_number+"|~~|"+week+"|~~|"+timeStart+"|~~|"+timeEnd+"|~~|"
//							+grade+"|~~|"+address+"|~~|"+numberSeat+"|~~|"+examST+"|~~|"
//							+courseType+"|~~|"+courseXZ+"|~~|"+timeLL+"|~~|"+timeAll+"|~~|"
//							+numberChoose+"|~~|"+argument+"|~~|"+remark);
					list.add(new M_Info(teacher,cname,examType,M_number,
							week,timeStart,timeEnd,grade,
							address,numberSeat,examST,courseType,
							courseXZ,timeLL,timeAll,numberChoose,argument,remark));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	
	}
	
}
