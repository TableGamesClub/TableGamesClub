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
import model.StoreInformation;
import model.Interface.GroupRoomDAO_Interface;
import model.Interface.StoreInformationDAO_Interface;
import model.Interface.StoreMemberDAO_Interface;
import model.service.GroupService;

@WebServlet("/GetCount")
public class TimeCalculate extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GroupService service = new GroupService();
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"model-config1-DriverManagerDataSource.xml");
		StoreInformationDAO_Interface dao = (StoreInformationDAO_Interface) context
				.getBean("StoreInformationDAO");
		String GroupStartTime = request.getParameter("S");
		String GroupEndTime = request.getParameter("E");
		String StoreNumber = request.getParameter("N");
		PrintWriter out = response.getWriter();
		Date StartTime = service.convertDate(GroupStartTime+":00");
		Date EndTime = service.convertDate(GroupEndTime+":00");
		GroupRoom bean = new GroupRoom();//創建GroupRoom bean
		StoreInformation store = dao.findByPrimeKey(Integer.parseInt(StoreNumber));
		if(store != null){
			String StoreName = store.getStoreName();//取得店名
			int StoreUpper = dao.findByPrimeKey(Integer.parseInt(StoreNumber)).getGroupUpperLimit();
			bean.setStoreName(StoreName);
			System.out.println(StoreName);
			bean.setReserveGroupStartTime(StartTime);
			System.out.println(StartTime);
			bean.setReserveGroupEndTime(EndTime);
			System.out.println(EndTime);
			int count = service.countJoinedMemberNumber(bean);
			out.print(StoreUpper-count);
		}
	}
	
}
