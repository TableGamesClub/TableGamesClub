package controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BoardGames;
import model.GroupChoiceGames;
import model.GroupRoom;
import model.Member;
import model.Interface.BoardGamesDAO_Interface;
import model.service.GroupService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@WebServlet(name = "ChangeToCheckGroupInformation", urlPatterns = { "/controller/CTCGI" })
public class LookforGroupChangeToCheckGroupInformationServlet extends
		HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {


		String id = request.getParameter("id");   //收到的團主鍵
		System.out.println(id);
		Map<String, GroupRoom> info = new HashMap<String, GroupRoom>();   //存放資料區grouproom
		Map<String, Member> info2 = new HashMap<>();  //存放資料Member
		Map<String, String> info3 = new HashMap<>();  //存放資料GroupChoiceGames
		Map<String, String> info4 = new HashMap<>();
		Map<String, String> info5 = new HashMap<>();
		// 圖片識別ID
		Map<String, Integer> requestimage = new HashMap<String, Integer>();
		request.setAttribute("requestimage", requestimage);
//		HttpSession session = request.getSession();
		request.setAttribute("info", info);
		request.setAttribute("roomMaster", info2);
		request.setAttribute("info3", info3);
		request.setAttribute("info4", info4);
		request.setAttribute("info5", info5);
		int a = 0;
		int b = 0;
		try {
			int roomId = Integer.parseInt(id);

			
			GroupService groupservice = new GroupService();
			GroupRoom takeInfoGR = groupservice.getOneGroupRoom(roomId);
			List<Integer> takeInfoGCG = groupservice.getgametype(roomId);
			List<String> typetemp = new ArrayList<>();  //存放Type
			List<GroupChoiceGames> choicename = groupservice.getBoardGameNames(roomId);
			
			for(int list : takeInfoGCG){
				String type = groupservice.selectGameKindName(list);
				typetemp.add(type);
			}
			
			for(String i :typetemp){
				System.out.println(i);
				
				info3.put("type"+String.valueOf(a), i);
				a++;
			}
			
			for(GroupChoiceGames j: choicename){
				String gamename = j.getBoardGameName();
				info4.put("choicegames" +String.valueOf(b), String.valueOf(gamename));
				b++;
			}
			//房間名稱 ↓
//			String grouproomname = takeInfoGR.getGroupRoomName();
//			//店家名↓
//			String storename = takeInfoGR.getStoreName();
//			//開團者暱稱
			Member mem = takeInfoGR.getMember();
			System.out.println(mem.getEmail());
			info.put("GroupRoom",takeInfoGR);
			info2.put("DarkFlameMaster", mem);
			info5.put("numbernin", String.valueOf(groupservice.countGroupRoomsMyJoined(mem)));
			
			
			
			requestimage.put("simpleimage" , roomId);


			if (!info.isEmpty()) {
				
				RequestDispatcher rd = request
						.getRequestDispatcher("/checkgroupinformation.jsp");
				rd.forward(request, response);
				return;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//		this.doGet(request, response);
	}
}
