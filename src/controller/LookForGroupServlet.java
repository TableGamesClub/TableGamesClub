package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.BoardGameKind;
import model.GroupRoom;
import model.Interface.BoardGameKindDAO_Interface;
import model.service.GroupService;

@WebServlet("/LookForGroupServlet.do")
public class LookForGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LookForGroupServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// HttpSession session = request.getSession();
		Map<String, String> errorMsgMap = new HashMap<String, String>();
		request.setAttribute("ErrorMsgKey", errorMsgMap);
		String gametype = request.getParameter("gametype");
		String gametime = request.getParameter("gametime");
		String gamenumber = request.getParameter("gamenumber");
		String gamenamesearch = request.getParameter("gamenamesearch");
		// List<GroupRoom> currectgrouproom = new ArrayList<GroupRoom>(); //
		// 存放用類型遊戲搜尋結果
		// List<GroupRoom> currectgrouproomnumber = new ArrayList<GroupRoom>();
		// List<GroupRoom> currectgrouptimer = new ArrayList<GroupRoom>();
		GroupService groupservice = new GroupService();
		List<GroupRoom> desclist = new ArrayList<GroupRoom>();

		if (gametime.equals("最近→最遠")) {
			if (gametype.equals("策略遊戲")) {
				int type = 1;

				List<Integer> selectgroupdesc = groupservice
						.sequenceandselecttypedesc(type);
				for (Integer list : selectgroupdesc) {
					
					System.out.print("團序號:" + list + " ");     //get順序
					List<Integer> selectgrouptype = groupservice.getgametype(list);
					for(int j :selectgrouptype){
						BoardGameKind boardgamekind = new BoardGameKind();
						
						ApplicationContext context = new ClassPathXmlApplicationContext(
								"model-config1-DriverManagerDataSource.xml");
						BoardGameKindDAO_Interface dao = (BoardGameKindDAO_Interface) context
								.getBean("BoardGameKindDAO");
						BoardGameKind b1 = dao.findByPrimeKey(j);
						System.out.println(b1.getBoardGameStyle());   //get團全部的類型
						
					}

					desclist.add(groupservice.getOneGroupRoom(list));

				}
				for (GroupRoom i : desclist) {
//					System.out.print("團序號:" +i.getGroupSerialNumber() + " ");//get順序
					System.out.println(groupservice.getOneGroupRoom(i.getGroupSerialNumber()).getGroupRoomName());//get團名
					System.out.println(groupservice.getOneGroupRoom(i.getGroupSerialNumber()).getGroupStartTime());//get團時間
					System.out.println(groupservice.countGroupRoomsByGroupSerialNumber(i));//get人數;
				}


			}

		}// end of if(gametime.equals("最近→最遠"))
		else {

		}// end of else(gametime.equals("最近→最遠"))
			//
		// if (gametype.equals("策略遊戲")) {
		// GroupService groupservice = new GroupService();
		//
		// List<GroupRoom> grouproomall = groupservice.getAll(); // get出所有的有開的團
		// for (GroupRoom list : grouproomall) {
		// List<Integer> style = groupservice.getgametype(list
		// .getGroupSerialNumber()); // 把每個團的流水號丟入, 回傳類型編號
		// for (int typenumber : style) {
		// if (typenumber == 1) { // typenumber是"策略遊戲"的交給currectgrouproom
		// currectgrouproom.add(list);
		// break;
		// }// end of for (int typenumber : style)
		// }// end of for(int typenumber: style)
		// }// end of for(GroupRoom list:grouproomall)
		// for (int i = 0; i < currectgrouproom.size(); i++) {
		// System.out.println(currectgrouproom.get(i)
		// .getGroupSerialNumber());
		// }// for (int i = 0; i < currectgrouproom.size(); i++)
		//
		// }// end of if (gametype == "策略遊戲")
		// if (gametype.equals("益智遊戲")) {
		// GroupService groupservice = new GroupService();
		//
		// List<GroupRoom> grouproomall = groupservice.getAll(); // get出所有的有開的團
		// for (GroupRoom list : grouproomall) {
		// List<Integer> style = groupservice.getgametype(list
		// .getGroupSerialNumber()); // 把每個團的流水號丟入, 回傳類型編號
		// for (int typenumber : style) {
		// if (typenumber == 2) { // typenumber是"益智遊戲"的交給currectgrouproom
		// currectgrouproom.add(list);
		// break;
		// }// end of for (int typenumber : style)
		// }// end of for(int typenumber: style)
		// }// end of for(GroupRoom list:grouproomall)
		// for (int i = 0; i < currectgrouproom.size(); i++) {
		// System.out.println(currectgrouproom.get(i)
		// .getGroupSerialNumber());
		// }// for (int i = 0; i < currectgrouproom.size(); i++)
		//
		// }// end of if (gametype == "益智遊戲")
		// if (gametype.equals("推理遊戲")) {
		// GroupService groupservice = new GroupService();
		//
		// List<GroupRoom> grouproomall = groupservice.getAll(); // get出所有的有開的團
		// for (GroupRoom list : grouproomall) {
		// List<Integer> style = groupservice.getgametype(list
		// .getGroupSerialNumber()); // 把每個團的流水號丟入, 回傳類型編號
		// for (int typenumber : style) {
		// if (typenumber == 3) { // typenumber是"推理遊戲"的交給currectgrouproom
		// currectgrouproom.add(list);
		// break;
		// }// end of for (int typenumber : style)
		// }// end of for(int typenumber: style)
		// }// end of for(GroupRoom list:grouproomall)
		// for (int i = 0; i < currectgrouproom.size(); i++) {
		// System.out.println(currectgrouproom.get(i)
		// .getGroupSerialNumber());
		// }// for (int i = 0; i < currectgrouproom.size(); i++)
		//
		// }// end of if (gametype == "推理遊戲")
		// if (gametype.equals("角色扮演遊戲")) {
		// GroupService groupservice = new GroupService();
		//
		// List<GroupRoom> grouproomall = groupservice.getAll(); // get出所有的有開的團
		// for (GroupRoom list : grouproomall) {
		// List<Integer> style = groupservice.getgametype(list
		// .getGroupSerialNumber()); // 把每個團的流水號丟入, 回傳類型編號
		// for (int typenumber : style) {
		// if (typenumber == 4) { // typenumber是"角色扮演遊戲"的交給currectgrouproom
		// currectgrouproom.add(list);
		// break;
		// }// end of for (int typenumber : style)
		// }// end of for(int typenumber: style)
		// }// end of for(GroupRoom list:grouproomall)
		// for (int i = 0; i < currectgrouproom.size(); i++) {
		// System.out.println(currectgrouproom.get(i)
		// .getGroupSerialNumber());
		// }// for (int i = 0; i < currectgrouproom.size(); i++)
		//
		// }// end of if (gametype == "角色扮演遊戲")
		// if (gametype.equals("小品遊戲")) {
		// GroupService groupservice = new GroupService();
		//
		// List<GroupRoom> grouproomall = groupservice.getAll(); // get出所有的有開的團
		// for (GroupRoom list : grouproomall) {
		// List<Integer> style = groupservice.getgametype(list
		// .getGroupSerialNumber()); // 把每個團的流水號丟入, 回傳類型編號
		// for (int typenumber : style) {
		// if (typenumber == 5) { // typenumber是"小品遊戲"的交給currectgrouproom
		// currectgrouproom.add(list);
		// break;
		// }// end of for (int typenumber : style)
		// }// end of for(int typenumber: style)
		// }// end of for(GroupRoom list:grouproomall)
		// for (int i = 0; i < currectgrouproom.size(); i++) {
		// System.out.println(currectgrouproom.get(i)
		// .getGroupSerialNumber());
		// }// for (int i = 0; i < currectgrouproom.size(); i++)
		//
		// }// end of if (gametype == "小品遊戲")
		//
		// if (gamenumber.equals("10人以下")) {
		// GroupService groupservice = new GroupService();
		//
		//
		// List<GroupRoom> grouproomall = groupservice.getAll(); // get出所有的有開的團
		// for (GroupRoom list : grouproomall) {
		//
		// int num = groupservice.countGroupRoomsByGroupSerialNumber(list);
		// if (num < 10) {
		// currectgrouproomnumber.add(list);
		// }
		// }
		//
		// for (int i = 0; i < currectgrouproomnumber.size(); i++) {
		// System.out.println(currectgrouproomnumber.get(i)
		// .getGroupSerialNumber());
		//
		// }
		// }
		// if (gamenumber.equals("10至20人")) {
		// GroupService groupservice = new GroupService();
		//
		//
		// List<GroupRoom> grouproomall = groupservice.getAll(); // get出所有的有開的團
		// for (GroupRoom list : grouproomall) {
		//
		// int num = groupservice.countGroupRoomsByGroupSerialNumber(list);
		// if (num >= 10 && num < 20) {
		// currectgrouproomnumber.add(list);
		// }
		// }
		//
		// for (int i = 0; i < currectgrouproomnumber.size(); i++) {
		// System.out.println(currectgrouproomnumber.get(i)
		// .getGroupSerialNumber());
		//
		// }
		// }
		//
		// if (gamenumber.equals("10至20人")) {
		// GroupService groupservice = new GroupService();
		//
		//
		// List<GroupRoom> grouproomall = groupservice.getAll(); // get出所有的有開的團
		// for (GroupRoom list : grouproomall) {
		//
		// int num = groupservice.countGroupRoomsByGroupSerialNumber(list);
		// if (num > 20) {
		// currectgrouproomnumber.add(list);
		// }
		// }
		//
		// for (int i = 0; i < currectgrouproomnumber.size(); i++) {
		// System.out.println(currectgrouproomnumber.get(i)
		// .getGroupSerialNumber());
		//
		// }
		// }
		//
		//
		//
		//
		//
		// if (gametime.equals("最近→最遠")) {
		// GroupService groupservice = new GroupService();
		//
		//
		// List<GroupRoom> grouproomall = groupservice.getAll();
		//
		// for (GroupRoom list : grouproomall) {
		// currectgrouptimer = groupservice.sequencestarttimedesc(list);
		// }
		//
		// for (int i = 0; i < currectgrouptimer.size(); i++) {
		// System.out.println(currectgrouptimer.get(i)
		// .getGroupSerialNumber());
		// }
		// }
		//
		// if (gametime.equals("最遠→最近")) {
		// GroupService groupservice = new GroupService();
		//
		//
		// List<GroupRoom> grouproomall = groupservice.getAll();
		//
		// for (GroupRoom list : grouproomall) {
		// currectgrouptimer = groupservice.sequencestarttime(list);
		// }
		//
		// for (int i = 0; i < currectgrouptimer.size(); i++) {
		// System.out.println(currectgrouptimer.get(i)
		// .getGroupSerialNumber());
		// }
		// }

		// GroupService groupservice = new GroupService();
		// List<GroupRoom> tempselectgroup = new ArrayList<GroupRoom>();
		// List<GroupRoom> selectgroup = groupservice.getAll();
		// for (GroupRoom list : selectgroup) {
		// tempselectgroup = groupservice.sequencestarttime(list);
		// List<GroupRoom> selectgametype = new ArrayList<GroupRoom>();
		//
		// Date selectgametime = list.getGroupStartTime();
		// int selectgamenumber =
		// groupservice.countGroupRoomsByGroupSerialNumber(list);
		// }
		//
		// for (int i = 0; i < tempselectgroup.size(); i++) {
		// System.out.println(tempselectgroup.get(i).getGroupSerialNumber());
		// }
		//
		//

		// if (gametype.equals(" ") && gametime.equals(" ")
		// && gamenamesearch.equals(" ")) {
		//
		// GroupService groupservice_v3 = new GroupService();
		// List<GroupRoom> allgroup = groupservice_v3.getAll();
		// for (GroupRoom alllist : allgroup) {
		// alllist.getGroupSerialNumber();
		// }
		// }

	}
}
