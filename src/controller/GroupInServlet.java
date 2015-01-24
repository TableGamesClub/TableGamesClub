package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mail.createRoomSuccessMail;
import model.GroupRoom;
import model.Joiner_Info;
import model.Member;
import model.StoreInformation;
import model.Interface.Joiner_InfoDAO_Interface;
import model.service.GroupService;

@WebServlet(name = "GroupInServlet", urlPatterns = { "/controller/GIS" })
public class GroupInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GroupInServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		HttpSession session = request.getSession();
		try {
			int intid = Integer.parseInt(id);

			Map<String, String> insertOk = new HashMap<>(); // 存放加團成功
			Map<String, String> insertNotOk = new HashMap<>(); // 存放加團失敗

			request.setAttribute("insertOk", insertOk);
			request.setAttribute("insertNotOk", insertNotOk);

			GroupService groupservice = new GroupService();

			GroupRoom grouproom = groupservice.getOneGroupRoom(intid);

			// 該團目前人數↓
			int ima = groupservice
					.countGroupRoomsByGroupSerialNumber(grouproom);
			// 該團上限人數↓
			int sugiru = grouproom.getGroupUpperLimit();
			if (sugiru > ima) {

				// 該團目前人數↓
				int miseima = groupservice.countJoinedMemberNumber(grouproom);
				// 該團上限人數↓
				int misesugiru = groupservice
						.numOfPeo(grouproom.getStoreName());

				if (misesugiru > miseima) {

					ApplicationContext context = new ClassPathXmlApplicationContext(
							"model-config1-DriverManagerDataSource.xml");
					Joiner_InfoDAO_Interface dao = (Joiner_InfoDAO_Interface) context
							.getBean("Joiner_InfoDAO");

					// 抓現在時間
					SimpleDateFormat sdFormat = new SimpleDateFormat(
							"yyyy/MM/dd hh:mm:ss");
					Date date = new Date();
					String strDate = sdFormat.format(date);

					// 會員
					Member mbean = new Member();
					mbean = (Member) session.getAttribute("Member");
					if (mbean == null) {
						System.out.println("會員未登入");
						RequestDispatcher rd = request
								.getRequestDispatcher("/checkjoint-groupinformation.jsp");
						rd.forward(request, response);
						return;
					}

					// 包成joininfo加入團
					Joiner_Info joiner = new Joiner_Info();
					joiner.setUsername(mbean.getUsername());
					joiner.setJoinTime(new java.util.Date());
					joiner.setGroupRoom(grouproom);
					dao.insert(joiner);

					System.out.println(groupservice
							.iWantToJoinThisGroup(joiner));

					insertOk.put("CreateOK", "加入房間成功");
					System.out.println("加入房間成功");
//					// 寄發開團成功信件
					
					System.out.println("開始寄發系統信件");
					createRoomSuccessMail mail = new createRoomSuccessMail(
							"spadem45420@gmail.com", "系統送發信件，您的團["
									+ grouproom.getGroupRoomName() + "]開團成功！",
							"123");
					mail.start();
					
					RequestDispatcher rd = request
							.getRequestDispatcher("/joint-group-success.jsp");
					rd.forward(request, response);
					return;

				} else {
					insertNotOk.put("storeupper", "店家所容納的人數已超過上限");
					RequestDispatcher rd = request
							.getRequestDispatcher("/checkjoint-groupinformation.jsp");
					rd.forward(request, response);
				}

			} else {
				insertNotOk.put("groupupper", "您所加入的團已超過上限人數");
				RequestDispatcher rd = request
						.getRequestDispatcher("/checkjoint-groupinformation.jsp");
				rd.forward(request, response);
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		}



	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// no use
	}

}
