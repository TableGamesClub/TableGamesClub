package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.GroupRoom;
import model.Interface.GroupRoomDAO_Interface;
import model.service.GroupService;

@WebServlet("/GetCount")
public class TimeCalculate extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GroupService service = new GroupService();
		String GroupStartTime = request.getParameter("S");
		String GroupStartTime2 = request.getParameter("S2");
		String GroupEndTime = request.getParameter("E");
		String GroupEndTime2 = request.getParameter("E2");
		String StoreName = request.getParameter("N");
		PrintWriter out = response.getWriter();
		Date StartTime = service.convertDate(GroupStartTime+" "+GroupStartTime2);
		Date EndTime = service.convertDate(GroupEndTime+" "+GroupEndTime2);
		GroupRoom bean = new GroupRoom();
		bean.setStoreName(StoreName);
		System.out.println(StoreName);
		bean.setReserveGroupStartTime(StartTime);
		System.out.println(StartTime);
		bean.setReserveGroupEndTime(EndTime);
		System.out.println(EndTime);
		int count = service.countJoinedMemberNumber(bean);
		out.print(count);
//		service.countJoinedMemberNumber(bean);
	}
	
}
