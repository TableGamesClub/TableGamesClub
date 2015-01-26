package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mail.QuitRoomSuccessMail_adder;
import mail.QuitRoomSuccessMail_creater;
import model.GroupRoom;
import model.Joiner_Info;
import model.Member;
import model.Interface.GroupRoomDAO_Interface;
import model.Interface.Joiner_InfoDAO_Interface;
import model.service.GroupService;

import org.apache.catalina.connector.Request;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@WebServlet(urlPatterns = { "/RemoveRoomServlet" })
public class RemoveRoomServlet extends HttpServlet {

	@Override
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");// 文字資料轉內碼
		String roomId = request.getParameter("roomId01");//房間號碼
		String reason = request.getParameter("removeReason");//離團理由
		Map<String, String> errorMsg = new HashMap<String, String>();//存放錯誤訊息
		System.out.println(roomId);
		System.out.println(reason);
		int roomIdWeb = 0;
		try {
			roomIdWeb = Integer.parseInt(roomId);
			System.out.println("型態轉換成功");
		} catch (NumberFormatException e) {
			System.err.println("房間號碼轉換錯誤！");
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		GroupService service = new GroupService();
		Joiner_Info jbean = new Joiner_Info();
		Member mem = (Member) session.getAttribute("Member");
		String roomNameWeb = mem.getUsername();//網頁會員帳號
		System.out.println(roomNameWeb);
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"model-config1-DriverManagerDataSource.xml");
		Joiner_InfoDAO_Interface jidao =
				(Joiner_InfoDAO_Interface) context.getBean("Joiner_InfoDAO");
		GroupRoomDAO_Interface gdao =
				(GroupRoomDAO_Interface) context.getBean("GroupRoomDAO");
		if(roomId != null){
			//查詢該房間資訊
			List<Joiner_Info> list = jidao.findByGroupSerialNumber(roomIdWeb);
			
			//開始刪團
			gdao.delete(roomIdWeb);
			System.out.println(roomIdWeb+"號房間，刪團成功！");
			
//			//開團者電子郵件
//			GroupRoom room = gdao.findByPrimeKey(roomIdWeb);
//			String createRoomEmail = room.getMember().getEmail();
//			//退團者電子郵件
//			String quitRoomEmail = mem.getEmail();
//			//開始寄發郵件
//			System.out.println("開始寄發電子郵件");
//			QuitRoomSuccessMail_adder mail1 = 
//					new QuitRoomSuccessMail_adder("spadem45420@gmail.com","系統通知信件","親愛的["+mem.getNickname()+"]您好，您已經退出["+room.getGroupRoomName()+"]桌遊團。");
//			QuitRoomSuccessMail_creater mail2 = 
//					new QuitRoomSuccessMail_creater("spadem45420@gmail.com","系統通知信件","親愛的["+room.getMember().getNickname()+"]您好，您的團員["+mem.getNickname()+"]已經退出<br>退團理由：<br>",reason);
//			mail1.start();
//			mail2.start();
			
			System.out.println("導向刪團成功畫面！");
			response.sendRedirect("remove-group-success.jsp");
			return;
		}
	}
}