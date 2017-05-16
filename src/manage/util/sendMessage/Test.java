package manage.util.sendMessage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;




import manage.entity.E_Manage;
import manage.entity.M_Manage;
import manage.entity.Teacher;

public class Test {
	public static List<M_Manage> listm;
	public static List<E_Manage> list;
	public static String datetime;
	public static Date date;
	public static E_Manage e_manage;
	public static M_Manage m_manage;
	public static void main(String[] args){
		SendMessage app = new SendMessage();
		Timer timer = new Timer();
		timer.schedule(new MyTimerTask(app) {
			@SuppressWarnings("deprecation")
			public void run() {
				Calendar c = Calendar.getInstance();
				int hours = c.get(Calendar.HOUR_OF_DAY);
				//System.out.println(hours);
				//每天早上8点触发，触发后关闭短信服务
				//发送两次，若第一次有更改方便第二次通知
//				System.out.println("1");
				if(hours==1 || hours==18){
//				System.out.println("2");
				//每天按时给管理员教师发送短信确认短信猫好使！-------------------------
					if(hours==8 ){
//						System.out.println("3");
						try
						{
//							System.out.println("5");
							app.sendSMS_0();

						}
						catch (Exception e)
						{
							e.printStackTrace();
						}
					}					
				//-----------------------------------------------------
					list = Test.DBConnection();
					listm = Test.DBConnectionM();
					if(list!=null || listm!=null){
						
						Iterator<E_Manage> iterator = list.iterator();
						Iterator<M_Manage> ite = listm.iterator();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						Date now = new Date();
						//剔除 除明天之外的期末考试
						while(iterator.hasNext()){
							try {
								E_Manage e_manage = iterator.next();
								System.out.println(e_manage.toString());
								datetime = e_manage.getDatetime().split("\\s")[0].trim();
								date = sdf.parse(datetime);
//								System.out.println(now.getDate()+"+"+date.getDate());
								if(now.getMonth() != date.getMonth() || now.getDate()!=(date.getDate()-1)){
									iterator.remove();
								}	
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}
						//剔除 除明天之外的阶段考试
						while(ite.hasNext()){
							try {
								M_Manage m_manage = ite.next();
								System.out.println(m_manage.toString());
								datetime = m_manage.getTimeStart().split("\\s")[0].trim();
								date = sdf.parse(datetime);
//								System.out.println(now.getDate()+"+-----"+date.getDate());
								if(!(now.getMonth() == date.getMonth()) || !(now.getDate()==(date.getDate()-1))){
									ite.remove();
								}	
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						
						}
					}
					try
					{
						if(list != null){
//							System.out.println(list.toString());
//							System.out.println("3");
							app.sendSMS(list);
//							System.out.println("4");
						}
						if(listm != null){
//							System.out.println("---"+list.toString());
//							System.out.println("3");
							app.sendMSMS(listm);
//							System.out.println("4");
						}
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}

				}

			}
		}, 1000,1*60*60*1000);
			
	};

	public static void sendMessage(List<Teacher> teachers,String msgContent){
		SendMessage app = new SendMessage();
		try
		{
			if(teachers != null){
				app.sendSMS_1(teachers,msgContent);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
	//从数据库读取期末监考信息
	public static List<E_Manage> DBConnection(){
		list = new ArrayList<E_Manage>();
		/**
		 * 此处从数据库中取值，赋给list，
		 * 每隔一天检查一遍第二天有没有老师要监考，
		 * 有则给监考老师发短信！没有
		 */	
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select * from e_manage";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","geren","geren");
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				e_manage = new E_Manage();
				e_manage.setCno(rs.getString("cno"));
				e_manage.setCname(rs.getString("cname"));
				e_manage.setAddress(rs.getString("address"));
				e_manage.setDatetime(rs.getString("datetime"));
				e_manage.setTime(rs.getString("time"));
				e_manage.setTno_one(rs.getString("tno_one"));
				e_manage.setTname_one(rs.getString("tname_one"));
				e_manage.setTel_one(rs.getString("tel_one"));
				e_manage.setTno_two(rs.getString("tno_two"));
				e_manage.setTname_two(rs.getString("tname_two"));
				e_manage.setTel_two(rs.getString("tel_two"));
				list.add(e_manage);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally{
			try {
				if(rs!=null){
					rs.close();
				}
				if(ps!=null){
					ps.close();
				}
				if(con!=null){
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		//System.out.println(list.size());
		return list;
	}
	//从数据库读取阶段考试信息
	public static List<M_Manage> DBConnectionM(){

		listm = new ArrayList<M_Manage>();
		/**
		 * 此处从数据库中取值，赋给list，
		 * 每隔一天检查一遍第二天有没有老师要监考，
		 * 有则给监考老师发短信！没有
		 */	
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select * from m_manage";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","geren","geren");
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				m_manage = new M_Manage();
				m_manage.setCname(rs.getString("cname"));
				m_manage.setTeacher(rs.getString("teacher"));
				m_manage.setTimeStart(rs.getString("timeStart"));
				m_manage.setTimeEnd(rs.getString("timeEnd"));
				m_manage.setAddress(rs.getString("address"));
				m_manage.setTno_one(rs.getString("tno_one"));
				m_manage.setTname_one(rs.getString("tname_one"));
				m_manage.setTel_one(rs.getString("tel_one"));
				m_manage.setTno_two(rs.getString("tno_two"));
				m_manage.setTname_two(rs.getString("tname_two"));
				m_manage.setTel_two(rs.getString("tel_two"));
//				System.out.println(m_manage.toString());
				listm.add(m_manage);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally{
			try {
				if(rs!=null){
					rs.close();
				}
				if(ps!=null){
					ps.close();
				}
				if(con!=null){
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		//System.out.println(list.size());
		return listm;
	
	}

}
