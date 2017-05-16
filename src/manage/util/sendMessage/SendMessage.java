// SendMessage.java - Sample application.
//
// This application shows you the basic procedure for sending messages.
// You will find how to send synchronous and asynchronous messages.
//
// For asynchronous dispatch, the example application sets a callback
// notification, to see what's happened with messages.

package manage.util.sendMessage;

import java.io.IOException;
import java.util.List;

import manage.entity.E_Manage;
import manage.entity.M_Manage;
import manage.entity.Teacher;

import org.smslib.AGateway;  
import org.smslib.GatewayException;  
import org.smslib.IOutboundMessageNotification;  
import org.smslib.OutboundMessage;  
import org.smslib.Service;  
import org.smslib.Message.MessageEncodings;  
import org.smslib.TimeoutException;
import org.smslib.modem.SerialModemGateway;  
  
public class SendMessage { 
	String phoneNumber = "18346083694";
    public static Service srv;  
    public static OutboundMessage msg;  
    public static OutboundNotification outboundNotification;
    public static SerialModemGateway gateway;
    /**
     * static 静态块 ，表明该代码段只执行一次，
     */
    static{
		 
    	outboundNotification = new OutboundNotification();  
//      srv = new Service();  
        srv = Service.getInstance();  
        gateway = new SerialModemGateway("modem.com1", "COM3", 9600, "Wavecom", ""); // 设置端口与波特率  
        gateway.setInbound(true);  
        gateway.setOutbound(true);  
        gateway.setSimPin("1234");  
//      gateway.setOutboundNotification(outboundNotification);  
        srv.setOutboundMessageNotification(outboundNotification);  
        try {
        	srv.addGateway(gateway);
            System.out.println("初始化成功，准备开启服务"); 
			srv.startService();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        System.out.println("服务启动成功"); 
        
    }
  //按时给监考教师发送期末监考信息
    public void sendSMS(List<E_Manage> list) throws GatewayException, TimeoutException, IOException, InterruptedException {  
        try {  

            for (E_Manage e:list) {
               msg = new OutboundMessage(e.getTel_one(), e.getTname_one()
            		   +"老师您好，您在明天有期末考试监考，时间为："+e.getDatetime()+" "+e.getTime()+
            		   "，地点为："+e.getAddress()+"，科目为："+e.getCname()+"。如有问题，请联系李林辉老师13836100803！谢谢");  
               msg.setEncoding(MessageEncodings.ENCUCS2); // 中文  
               srv.sendMessage(msg);
               System.out.println(msg);
               
               msg = new OutboundMessage(e.getTel_two(), e.getTname_two()
            		   +"老师您好，您在明天有期末考试监考，时间为："+e.getDatetime()+" "+e.getTime()+
            		   "，地点为："+e.getAddress()+"，科目为："+e.getCname()+"。如有问题，请联系李林辉老师13836100803！谢谢");  
               msg.setEncoding(MessageEncodings.ENCUCS2); // 中文  
               srv.sendMessage(msg);
               System.out.println(msg);
            }  
            //给管理员老师发短信确认，（老版本！)
//            msg = new OutboundMessage("18646173304","今日短信猫正常！");  
//            msg.setEncoding(MessageEncodings.ENCUCS2); // 中文  
//            srv.sendMessage(msg);
//            System.out.println(msg);
//--------------------------------------------
            //服务不停止，端口不释放！因为短息要按间隔时间发送！
//            srv.stopService();  
//            System.out.println("停止服务完毕！");
//            srv.removeGateway(gateway);
//            System.out.println("释放端口完毕！");
        } catch (Exception e) {  
            e.printStackTrace();  
        }
    }  
  //按时给监考教师发送阶段监考信息
    public void sendMSMS(List<M_Manage> list) throws GatewayException, TimeoutException, IOException, InterruptedException {  
        try {  

            for (M_Manage e:list) {
               msg = new OutboundMessage(e.getTel_one(), e.getTname_one()
            		   +"老师您好，您在明天有阶段考试监考，时间为："+e.getTimeStart()+"到"+e.getTimeEnd()+
            		   "，地点为："+e.getAddress()+"，科目为："+e.getCname()+"。如有问题，请联系李林辉老师13836100803！谢谢");  
               msg.setEncoding(MessageEncodings.ENCUCS2); // 中文  
               srv.sendMessage(msg);
               System.out.println(msg);
               
               msg = new OutboundMessage(e.getTel_two(), e.getTname_two()
            		   +"老师您好，您在明天有阶段考试监考，时间为："+e.getTimeStart()+"到"+e.getTimeEnd()+
            		   "，地点为："+e.getAddress()+"，科目为："+e.getCname()+"。如有问题，请联系李林辉老师13836100803！谢谢");  
               msg.setEncoding(MessageEncodings.ENCUCS2); // 中文  
               srv.sendMessage(msg);
               System.out.println(msg);
            }  
            //服务不停止，端口不释放！因为短息要按间隔时间发送！
//          srv.stopService();  
//          System.out.println("停止服务完毕！");
//          srv.removeGateway(gateway);
//          System.out.println("释放端口完毕！");
        } catch (Exception e) {  
            e.printStackTrace();  
        }
    }  
    //给管理员老师发短信确认！
    public void sendSMS_0( ) throws Exception {
    	try {
    		//System.out.println("4");
        	//每天！！！给管理员老师发送信息，确保短信猫运行正常（新版！）
            msg = new OutboundMessage(phoneNumber,"管理员老师您好！今日短信猫正常！祝您工作愉快！");  
            msg.setEncoding(MessageEncodings.ENCUCS2); // 中文  
            srv.sendMessage(msg);
            System.out.println(msg);
            
            msg = new OutboundMessage("18346083694","管理员老师您好！今日短信猫正常！祝您工作愉快！");  
            msg.setEncoding(MessageEncodings.ENCUCS2); // 中文  
            srv.sendMessage(msg);
            System.out.println(msg);
            
//            服务不停止，端口不释放！因为短信要按间隔时间发送！
//            srv.stopService();  
//            System.out.println("停止服务完毕！");  
//            srv.removeGateway(gateway);
//            System.out.println("释放端口完毕！");
            
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }
    //给选中老师发短信功能
    public void sendSMS_1(List<Teacher> list,String content) throws Exception {
    	try {
            for (Teacher t:list) {  
//            	System.out.println(t.toString());
               msg = new OutboundMessage(t.getTelephone(),content);  
               msg.setEncoding(MessageEncodings.ENCUCS2); // 中文  
               srv.sendMessage(msg);
               System.out.println(msg);
            }  
        	//给管理员老师发送信息，确保短信猫运行正常
            msg = new OutboundMessage(phoneNumber,"今日短信猫工作正常！");  
            msg.setEncoding(MessageEncodings.ENCUCS2); // 中文  
            srv.sendMessage(msg);
            System.out.println(msg);
            
//            服务不停止，端口不释放！因为短信要按间隔时间发送！
//            srv.stopService();  
//            System.out.println("停止服务完毕！");  
//            srv.removeGateway(gateway);
//            System.out.println("释放端口完毕！");
            
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }
}

class OutboundNotification implements IOutboundMessageNotification {  
    public void process(AGateway agateway, OutboundMessage outboundmessage) {  
        System.out.println("Outbound handler called from Gateway: " + agateway);  
        System.out.println(outboundmessage);  
          
    }  
}  