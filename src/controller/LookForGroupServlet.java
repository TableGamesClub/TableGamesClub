package controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GroupRoom;
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
//		HttpSession session = request.getSession();
		Map<String, String> errorMsgMap = new HashMap<String, String>();
		request.setAttribute("ErrorMsgKey", errorMsgMap);
		String gametype = request.getParameter("gametype");
		String gametime = request.getParameter("gametime");
		String gamenamesearch = request.getParameter("gamenamesearch");
			if (gametype.equals("策略遊戲") ) {
				GroupService groupservice = new GroupService();
				List<GroupRoom> currectgrouproom = new ArrayList<GroupRoom>(); // 存放用關鍵字搜到的Grouproom
				List<GroupRoom> grouproomall = groupservice.getAll(); // get出所有的有開的團
				for (GroupRoom list : grouproomall) {
					List<Integer> style = groupservice.getgametype(list.getGroupSerialNumber()); // 把每個團的流水號丟入, 回傳類型編號
					for (int typenumber : style) {
						if (typenumber == 1) {  //typenumber是"策略遊戲"的交給currectgrouproom
							currectgrouproom.add(list);
							break;
						}// end of for (int typenumber : style)
					}// end of for(int typenumber: style)
				}// end of for(GroupRoom list:grouproomall)
				for (int i = 0; i < currectgrouproom.size(); i++) {
					System.out.println(currectgrouproom.get(i).getGroupSerialNumber());
				}//for (int i = 0; i < currectgrouproom.size(); i++)

			}// end of if (gametype == "策略遊戲")
			if (gametype.equals("益智遊戲") ) {
				GroupService groupservice = new GroupService();
				List<GroupRoom> currectgrouproom = new ArrayList<GroupRoom>(); // 存放用關鍵字搜到的Grouproom
				List<GroupRoom> grouproomall = groupservice.getAll(); // get出所有的有開的團
				for (GroupRoom list : grouproomall) {
					List<Integer> style = groupservice.getgametype(list.getGroupSerialNumber()); // 把每個團的流水號丟入, 回傳類型編號
					for (int typenumber : style) {
						if (typenumber == 2) {  //typenumber是"益智遊戲"的交給currectgrouproom
							currectgrouproom.add(list);
							break;
						}// end of for (int typenumber : style)
					}// end of for(int typenumber: style)
				}// end of for(GroupRoom list:grouproomall)
				for (int i = 0; i < currectgrouproom.size(); i++) {
					System.out.println(currectgrouproom.get(i).getGroupSerialNumber());
				}//for (int i = 0; i < currectgrouproom.size(); i++)

			}// end of if (gametype == "益智遊戲")
			if (gametype.equals("推理遊戲") ) {
				GroupService groupservice = new GroupService();
				List<GroupRoom> currectgrouproom = new ArrayList<GroupRoom>(); // 存放用關鍵字搜到的Grouproom
				List<GroupRoom> grouproomall = groupservice.getAll(); // get出所有的有開的團
				for (GroupRoom list : grouproomall) {
					List<Integer> style = groupservice.getgametype(list.getGroupSerialNumber()); // 把每個團的流水號丟入, 回傳類型編號
					for (int typenumber : style) {
						if (typenumber == 3) {  //typenumber是"推理遊戲"的交給currectgrouproom
							currectgrouproom.add(list);
							break;
						}// end of for (int typenumber : style)
					}// end of for(int typenumber: style)
				}// end of for(GroupRoom list:grouproomall)
				for (int i = 0; i < currectgrouproom.size(); i++) {
					System.out.println(currectgrouproom.get(i).getGroupSerialNumber());
				}//for (int i = 0; i < currectgrouproom.size(); i++)

			}// end of if (gametype == "推理遊戲")
			if (gametype.equals("角色扮演遊戲") ) {
				GroupService groupservice = new GroupService();
				List<GroupRoom> currectgrouproom = new ArrayList<GroupRoom>(); // 存放用關鍵字搜到的Grouproom
				List<GroupRoom> grouproomall = groupservice.getAll(); // get出所有的有開的團
				for (GroupRoom list : grouproomall) {
					List<Integer> style = groupservice.getgametype(list.getGroupSerialNumber()); // 把每個團的流水號丟入, 回傳類型編號
					for (int typenumber : style) {
						if (typenumber == 4) {  //typenumber是"角色扮演遊戲"的交給currectgrouproom
							currectgrouproom.add(list);
							break;
						}// end of for (int typenumber : style)
					}// end of for(int typenumber: style)
				}// end of for(GroupRoom list:grouproomall)
				for (int i = 0; i < currectgrouproom.size(); i++) {
					System.out.println(currectgrouproom.get(i).getGroupSerialNumber());
				}//for (int i = 0; i < currectgrouproom.size(); i++)

			}// end of if (gametype == "角色扮演遊戲")
			if (gametype.equals("小品遊戲") ) {
				GroupService groupservice = new GroupService();
				List<GroupRoom> currectgrouproom = new ArrayList<GroupRoom>(); // 存放用關鍵字搜到的Grouproom
				List<GroupRoom> grouproomall = groupservice.getAll(); // get出所有的有開的團
				for (GroupRoom list : grouproomall) {
					List<Integer> style = groupservice.getgametype(list.getGroupSerialNumber()); // 把每個團的流水號丟入, 回傳類型編號
					for (int typenumber : style) {
						if (typenumber == 5) {  //typenumber是"小品遊戲"的交給currectgrouproom
							currectgrouproom.add(list);
							break;
						}// end of for (int typenumber : style)
					}// end of for(int typenumber: style)
				}// end of for(GroupRoom list:grouproomall)
				for (int i = 0; i < currectgrouproom.size(); i++) {
					System.out.println(currectgrouproom.get(i).getGroupSerialNumber());
				}//for (int i = 0; i < currectgrouproom.size(); i++)

			}// end of if (gametype == "小品遊戲")
			
			
	}
}
