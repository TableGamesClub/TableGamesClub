package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GroupChoiceGames;
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
		HttpSession session = request.getSession();
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
//		List<GroupRoom> desclist = new ArrayList<GroupRoom>();
//		session.removeAttribute("");
		//專賣店名稱
		Map<String, String> storename = new HashMap<String, String>();
		session.setAttribute("storename", storename);
		
		//遊戲名稱
		Map<String, List<GroupChoiceGames>> gamename = new HashMap<String, List<GroupChoiceGames>>();
		session.setAttribute("gamename", gamename);
		
		// 圖片識別ID
		Map<String, Integer> requestimage = new HashMap<String, Integer>();
		session.setAttribute("requestimage", requestimage);

		// 存取團名
		Map<String, String> requestgroupname = new HashMap<String, String>();
		session.setAttribute("requestgroupname", requestgroupname);
		
		// 存放人數
		Map<String, String> requestnumberofpeople = new HashMap<String, String>();
		session.setAttribute("numberofpeople", requestnumberofpeople);

		// 存放類型
		Map<String, String> requesttype = new HashMap<String, String>();
		session.setAttribute("requestype", requesttype);

		// 存放時間
		Map<String, String> requesttime = new HashMap<String, String>();
		session.setAttribute("requesttype", requesttime);
		int w = 0;
		int x = 0;
		int y = 0;
		int z = 0;
		int a = 0;
		int b = 0;
		int c = 0;
		
		
		if(!gamenamesearch.equals("")){
			List<GroupRoom> fuzzysearch = groupservice.getGroupRooms(gamenamesearch);
			for(GroupRoom all : fuzzysearch)
			{
				int groupRoomId  = all.getGroupSerialNumber();
				
				requestimage.put("simpleimage" +String.valueOf(y), groupRoomId);
//				int Groupdesc = groupservice.countGroupRoomsByGroupSerialNumber(list);
				
				
				GroupRoom selectgroup = groupservice.getOneGroupRoom(groupRoomId);
				System.out.println(selectgroup.getGroupSerialNumber());
				
				//取專賣店名
				String mese = selectgroup.getStoreName();
				storename.put("simplemese" + String.valueOf(w), mese);
				
				//遊戲名
				List<GroupChoiceGames> gamenames = groupservice.getBoardGameNames(groupRoomId);
				gamename.put("simplegamename" + String.valueOf(x), gamenames);
				
				
				//取團名↓
				String groupname = selectgroup.getGroupRoomName();
				requestgroupname.put("simplegroupgroupname"+String.valueOf(z), groupname);
				
				

				// 取人數↓
				int count = groupservice.countGroupRoomsByGroupSerialNumber(selectgroup);
				
				requestnumberofpeople.put("peoplenumber" + String.valueOf(a), String.valueOf(count));
				
				// 取類型↓
				List<Integer> typed = groupservice
						.getgametype(selectgroup
								.getGroupSerialNumber());// 類型
				int i = 0;
				for (int typelist : typed) {
					String gamestype = groupservice
							.selectGameKindName(typelist);
					requesttype.put("type" + String.valueOf(i) + String.valueOf(b),	gamestype);
					i++;
				}
				// 取時間↓
				
				Date starttime = selectgroup.getReserveGroupStartTime();
				requesttime.put("time" + String.valueOf(c), String.valueOf(starttime));
				
				w++;
				x++;
				y++;
				z++;
				a++;
				b++;
				c++;
			}
			RequestDispatcher rd = request.getRequestDispatcher("LookForGroup.jsp");
			rd.forward(request, response);
		}
		else{
		
		if (gametime.equals("最近→最遠")) {
			if (gametype.equals("策略遊戲")) {
				if (gamenumber.equals("10人以下")) {
					int type = 1;
					List<Integer> selectgroupdesc = groupservice
							.sequenceandselecttypedesc(type);

					for (Integer groupRoomId : selectgroupdesc) {
						// System.out.print("團序號:" + list + " ");//get順序
						
						
						
						requestimage.put("simpleimage" +String.valueOf(y), groupRoomId);
						
						int Groupdesc = groupservice.countGroupRoomsByGroupSerialNumber(groupRoomId);
						if (Groupdesc < 10) {
							GroupRoom selectgroup = groupservice
									.getOneGroupRoom(groupRoomId);
							System.out.println(selectgroup
									.getGroupSerialNumber());
							
							
							//取專賣店名
							String mese = selectgroup.getStoreName();
							storename.put("simplemese" + String.valueOf(w), mese);
							
							//遊戲名
							List<GroupChoiceGames> gamenames = groupservice.getBoardGameNames(groupRoomId);
							gamename.put("simplegamename" + String.valueOf(x), gamenames);
							
							//取團名↓
							String groupname = selectgroup.getGroupRoomName();
							requestgroupname.put("simplegroupgroupname"+String.valueOf(z), groupname);
							

							// 取人數↓
							int count = groupservice.countGroupRoomsByGroupSerialNumber(selectgroup);
							
							requestnumberofpeople.put("peoplenumber" + String.valueOf(a), String.valueOf(count));
							
							// 取類型↓
							List<Integer> typed = groupservice
									.getgametype(selectgroup
											.getGroupSerialNumber());// 類型
							int i = 0;
							for (int typelist : typed) {
								String gamestype = groupservice
										.selectGameKindName(typelist);
								requesttype.put("type" + String.valueOf(i) + String.valueOf(b),	gamestype);
								i++;
							}
							// 取時間↓
							Date starttime = selectgroup.getReserveGroupStartTime();
							requesttime.put("time" + String.valueOf(c), String.valueOf(starttime));
	
						}//end of if (Groupdesc < 10)
						w++;
						x++;
						y++;
						z++;
						a++;
						b++;
						c++;
						
					}//end of for (Integer list : selectgroupdesc)
					RequestDispatcher rd = request.getRequestDispatcher("LookForGroup.jsp");
					rd.forward(request, response);
					
				}// end of if (gamenumber.equals("10人以下"))
				
				if (gamenumber.equals("10至20人")) {
					int type = 1;
					List<Integer> selectgroupdesc = groupservice
							.sequenceandselecttypedesc(type);

					for (Integer groupRoomId : selectgroupdesc) {
						// System.out.print("團序號:" + list + " ");//get順序
						
						
						
						requestimage.put("simpleimage" +String.valueOf(y), groupRoomId);
						
						int Groupdesc = groupservice.countGroupRoomsByGroupSerialNumber(groupRoomId);
						if (Groupdesc >=10 && Groupdesc <20) {
							GroupRoom selectgroup = groupservice
									.getOneGroupRoom(groupRoomId);
							System.out.println(selectgroup
									.getGroupSerialNumber());
							
							//取專賣店名
							String mese = selectgroup.getStoreName();
							storename.put("simplemese" + String.valueOf(w), mese);
							
							//遊戲名
							List<GroupChoiceGames> gamenames = groupservice.getBoardGameNames(groupRoomId);
							gamename.put("simplegamename" + String.valueOf(x), gamenames);
							
							//取團名↓
							String groupname = selectgroup.getGroupRoomName();
							requestgroupname.put("simplegroupgroupname"+String.valueOf(z), groupname);
							

							// 取人數↓
							int count = groupservice.countGroupRoomsByGroupSerialNumber(selectgroup);
							
							requestnumberofpeople.put("peoplenumber" + String.valueOf(a), String.valueOf(count));
							
							// 取類型↓
							List<Integer> typed = groupservice
									.getgametype(selectgroup
											.getGroupSerialNumber());// 類型
							int i = 0;
							for (int typelist : typed) {
								String gamestype = groupservice
										.selectGameKindName(typelist);
								requesttype.put("type" + String.valueOf(i) + String.valueOf(b),	gamestype);
								i++;
							}
							// 取時間↓
							Date starttime = selectgroup.getReserveGroupStartTime();
							requesttime.put("time" + String.valueOf(c), String.valueOf(starttime));
	
						}//end of if (Groupdesc >=10 && Groupdesc <20)
						w++;
						x++;
						y++;
						z++;
						a++;
						b++;
						c++;
						
					}//end of for (Integer list : selectgroupdesc)
					RequestDispatcher rd = request.getRequestDispatcher("LookForGroup.jsp");
					rd.forward(request, response);
					
				}// end of if (gamenumber.equals("10至20人"))
				
				if (gamenumber.equals("20人以上")) {
					int type = 1;
					List<Integer> selectgroupdesc = groupservice
							.sequenceandselecttypedesc(type);

					for (Integer groupRoomId : selectgroupdesc) {
						// System.out.print("團序號:" + list + " ");//get順序
						
						
						
						requestimage.put("simpleimage" +String.valueOf(y), groupRoomId);
						
						int Groupdesc = groupservice.countGroupRoomsByGroupSerialNumber(groupRoomId);
						if (Groupdesc >=20) {
							GroupRoom selectgroup = groupservice
									.getOneGroupRoom(groupRoomId);
							System.out.println(selectgroup
									.getGroupSerialNumber());
							
							//取專賣店名
							String mese = selectgroup.getStoreName();
							storename.put("simplemese" + String.valueOf(w), mese);
							
							//遊戲名
							List<GroupChoiceGames> gamenames = groupservice.getBoardGameNames(groupRoomId);
							gamename.put("simplegamename" + String.valueOf(x), gamenames);
							
							//取團名↓
							String groupname = selectgroup.getGroupRoomName();
							requestgroupname.put("simplegroupgroupname"+String.valueOf(z), groupname);
							

							// 取人數↓
							int count = groupservice.countGroupRoomsByGroupSerialNumber(selectgroup);
							
							requestnumberofpeople.put("peoplenumber" + String.valueOf(a), String.valueOf(count));
							
							// 取類型↓
							List<Integer> typed = groupservice
									.getgametype(selectgroup
											.getGroupSerialNumber());// 類型
							int i = 0;
							for (int typelist : typed) {
								String gamestype = groupservice
										.selectGameKindName(typelist);
								requesttype.put("type" + String.valueOf(i) + String.valueOf(b),	gamestype);
								i++;
							}
							// 取時間↓
							Date starttime = selectgroup.getReserveGroupStartTime();
							requesttime.put("time" + String.valueOf(c), String.valueOf(starttime));
	
						}//end of if (Groupdesc >=20)
						w++;
						x++;
						y++;
						z++;
						a++;
						b++;
						c++;
						
					}//end of for (Integer list : selectgroupdesc)
					RequestDispatcher rd = request.getRequestDispatcher("LookForGroup.jsp");
					rd.forward(request, response);
					
				}// end of if (gamenumber.equals("20人以上"))
				
			}// end of if (gametype.equals("策略遊戲")) 
			
			if (gametype.equals("益智遊戲")) {
				if (gamenumber.equals("10人以下")) {
					int type = 2;
					List<Integer> selectgroupdesc = groupservice
							.sequenceandselecttypedesc(type);

					for (Integer groupRoomId : selectgroupdesc) {
						// System.out.print("團序號:" + list + " ");//get順序
						
						
						
						requestimage.put("simpleimage" +String.valueOf(y), groupRoomId);
						
						int Groupdesc = groupservice.countGroupRoomsByGroupSerialNumber(groupRoomId);
						if (Groupdesc < 10) {
							GroupRoom selectgroup = groupservice
									.getOneGroupRoom(groupRoomId);
							System.out.println(selectgroup
									.getGroupSerialNumber());
							
							//取專賣店名
							String mese = selectgroup.getStoreName();
							storename.put("simplemese" + String.valueOf(w), mese);
							
							//遊戲名
							List<GroupChoiceGames> gamenames = groupservice.getBoardGameNames(groupRoomId);
							gamename.put("simplegamename" + String.valueOf(x), gamenames);
							
							//取團名↓
							String groupname = selectgroup.getGroupRoomName();
							requestgroupname.put("simplegroupgroupname"+String.valueOf(z), groupname);
							

							// 取人數↓
							int count = groupservice.countGroupRoomsByGroupSerialNumber(selectgroup);
							
							requestnumberofpeople.put("peoplenumber" + String.valueOf(a), String.valueOf(count));
							
							// 取類型↓
							List<Integer> typed = groupservice
									.getgametype(selectgroup
											.getGroupSerialNumber());// 類型
							int i = 0;
							for (int typelist : typed) {
								String gamestype = groupservice
										.selectGameKindName(typelist);
								requesttype.put("type" + String.valueOf(i) + String.valueOf(b),	gamestype);
								i++;
							}
							// 取時間↓
							Date starttime = selectgroup.getReserveGroupStartTime();
							requesttime.put("time" + String.valueOf(c), String.valueOf(starttime));
	
						}//end of if (Groupdesc < 10)
						w++;
						x++;
						y++;
						z++;
						a++;
						b++;
						c++;
						
					}//end of for (Integer list : selectgroupdesc)
					RequestDispatcher rd = request.getRequestDispatcher("LookForGroup.jsp");
					rd.forward(request, response);
					
				}// end of if (gamenumber.equals("10人以下"))
				
				if (gamenumber.equals("10至20人")) {
					int type = 1;
					List<Integer> selectgroupdesc = groupservice
							.sequenceandselecttypedesc(type);

					for (Integer groupRoomId : selectgroupdesc) {
						// System.out.print("團序號:" + list + " ");//get順序
						
						
						
						requestimage.put("simpleimage" +String.valueOf(y), groupRoomId);
						
						int Groupdesc = groupservice.countGroupRoomsByGroupSerialNumber(groupRoomId);
						if (Groupdesc >=10 && Groupdesc <20) {
							GroupRoom selectgroup = groupservice
									.getOneGroupRoom(groupRoomId);
							System.out.println(selectgroup
									.getGroupSerialNumber());
							
							//取專賣店名
							String mese = selectgroup.getStoreName();
							storename.put("simplemese" + String.valueOf(w), mese);
							
							//遊戲名
							List<GroupChoiceGames> gamenames = groupservice.getBoardGameNames(groupRoomId);
							gamename.put("simplegamename" + String.valueOf(x), gamenames);
							
							//取團名↓
							String groupname = selectgroup.getGroupRoomName();
							requestgroupname.put("simplegroupgroupname"+String.valueOf(z), groupname);
							

							// 取人數↓
							int count = groupservice.countGroupRoomsByGroupSerialNumber(selectgroup);
							
							requestnumberofpeople.put("peoplenumber" + String.valueOf(a), String.valueOf(count));
							
							// 取類型↓
							List<Integer> typed = groupservice
									.getgametype(selectgroup
											.getGroupSerialNumber());// 類型
							int i = 0;
							for (int typelist : typed) {
								String gamestype = groupservice
										.selectGameKindName(typelist);
								requesttype.put("type" + String.valueOf(i) + String.valueOf(b),	gamestype);
								i++;
							}
							// 取時間↓
							Date starttime = selectgroup.getReserveGroupStartTime();
							requesttime.put("time" + String.valueOf(c), String.valueOf(starttime));
	
						}//end of if (Groupdesc >=10 && Groupdesc <20)
						w++;
						x++;
						y++;
						z++;
						a++;
						b++;
						c++;
						
					}//end of for (Integer list : selectgroupdesc)
					RequestDispatcher rd = request.getRequestDispatcher("LookForGroup.jsp");
					rd.forward(request, response);
					
				}// end of if (gamenumber.equals("10至20人"))
				
				if (gamenumber.equals("20人以上")) {
					int type = 1;
					List<Integer> selectgroupdesc = groupservice
							.sequenceandselecttypedesc(type);

					for (Integer groupRoomId : selectgroupdesc) {
						// System.out.print("團序號:" + list + " ");//get順序
						
						
						
						requestimage.put("simpleimage" +String.valueOf(y), groupRoomId);
						
						int Groupdesc = groupservice.countGroupRoomsByGroupSerialNumber(groupRoomId);
						if (Groupdesc >=20) {
							GroupRoom selectgroup = groupservice
									.getOneGroupRoom(groupRoomId);
							System.out.println(selectgroup
									.getGroupSerialNumber());
							
							//取專賣店名
							String mese = selectgroup.getStoreName();
							storename.put("simplemese" + String.valueOf(w), mese);
							
							//遊戲名
							List<GroupChoiceGames> gamenames = groupservice.getBoardGameNames(groupRoomId);
							gamename.put("simplegamename" + String.valueOf(x), gamenames);
							
							//取團名↓
							String groupname = selectgroup.getGroupRoomName();
							requestgroupname.put("simplegroupgroupname"+String.valueOf(z), groupname);
							

							// 取人數↓
							int count = groupservice.countGroupRoomsByGroupSerialNumber(selectgroup);
							
							requestnumberofpeople.put("peoplenumber" + String.valueOf(a), String.valueOf(count));
							
							// 取類型↓
							List<Integer> typed = groupservice
									.getgametype(selectgroup
											.getGroupSerialNumber());// 類型
							int i = 0;
							for (int typelist : typed) {
								String gamestype = groupservice
										.selectGameKindName(typelist);
								requesttype.put("type" + String.valueOf(i) + String.valueOf(b),	gamestype);
								i++;
							}
							// 取時間↓
							Date starttime = selectgroup.getReserveGroupStartTime();
							requesttime.put("time" + String.valueOf(c), String.valueOf(starttime));
	
						}//end of if (Groupdesc >=20)
						w++;
						x++;
						y++;
						z++;
						a++;
						b++;
						c++;
						
					}//end of for (Integer list : selectgroupdesc)
					RequestDispatcher rd = request.getRequestDispatcher("LookForGroup.jsp");
					rd.forward(request, response);
					
				}// end of if (gamenumber.equals("20人以上"))
				
			}// end of if (gametype.equals("益智遊戲")) 
			
			if (gametype.equals("推理遊戲")) {
				if (gamenumber.equals("10人以下")) {
					int type = 3;
					List<Integer> selectgroupdesc = groupservice
							.sequenceandselecttypedesc(type);

					for (Integer groupRoomId : selectgroupdesc) {
						// System.out.print("團序號:" + list + " ");//get順序
						
						
						
						requestimage.put("simpleimage" +String.valueOf(y), groupRoomId);
						
						int Groupdesc = groupservice.countGroupRoomsByGroupSerialNumber(groupRoomId);
						if (Groupdesc < 10) {
							GroupRoom selectgroup = groupservice
									.getOneGroupRoom(groupRoomId);
							System.out.println(selectgroup
									.getGroupSerialNumber());
							
							//取專賣店名
							String mese = selectgroup.getStoreName();
							storename.put("simplemese" + String.valueOf(w), mese);
							
							//遊戲名
							List<GroupChoiceGames> gamenames = groupservice.getBoardGameNames(groupRoomId);
							gamename.put("simplegamename" + String.valueOf(x), gamenames);
							
							//取團名↓
							String groupname = selectgroup.getGroupRoomName();
							requestgroupname.put("simplegroupgroupname"+String.valueOf(z), groupname);
							

							// 取人數↓
							int count = groupservice.countGroupRoomsByGroupSerialNumber(selectgroup);
							
							requestnumberofpeople.put("peoplenumber" + String.valueOf(a), String.valueOf(count));
							
							// 取類型↓
							List<Integer> typed = groupservice
									.getgametype(selectgroup
											.getGroupSerialNumber());// 類型
							int i = 0;
							for (int typelist : typed) {
								String gamestype = groupservice
										.selectGameKindName(typelist);
								requesttype.put("type" + String.valueOf(i) + String.valueOf(b),	gamestype);
								i++;
							}
							// 取時間↓
							Date starttime = selectgroup.getReserveGroupStartTime();
							requesttime.put("time" + String.valueOf(c), String.valueOf(starttime));
	
						}//end of if (Groupdesc < 10)
						w++;
						x++;
						y++;
						z++;
						a++;
						b++;
						c++;
						
					}//end of for (Integer list : selectgroupdesc)
					RequestDispatcher rd = request.getRequestDispatcher("LookForGroup.jsp");
					rd.forward(request, response);
					
				}// end of if (gamenumber.equals("10人以下"))
				
				if (gamenumber.equals("10至20人")) {
					int type = 1;
					List<Integer> selectgroupdesc = groupservice
							.sequenceandselecttypedesc(type);

					for (Integer groupRoomId : selectgroupdesc) {
						// System.out.print("團序號:" + list + " ");//get順序
						
						
						
						requestimage.put("simpleimage" +String.valueOf(y), groupRoomId);
						
						int Groupdesc = groupservice.countGroupRoomsByGroupSerialNumber(groupRoomId);
						if (Groupdesc >=10 && Groupdesc <20) {
							GroupRoom selectgroup = groupservice
									.getOneGroupRoom(groupRoomId);
							System.out.println(selectgroup
									.getGroupSerialNumber());
							
							//取專賣店名
							String mese = selectgroup.getStoreName();
							storename.put("simplemese" + String.valueOf(w), mese);
							
							//遊戲名
							List<GroupChoiceGames> gamenames = groupservice.getBoardGameNames(groupRoomId);
							gamename.put("simplegamename" + String.valueOf(x), gamenames);
							
							//取團名↓
							String groupname = selectgroup.getGroupRoomName();
							requestgroupname.put("simplegroupgroupname"+String.valueOf(z), groupname);
							

							// 取人數↓
							int count = groupservice.countGroupRoomsByGroupSerialNumber(selectgroup);
							
							requestnumberofpeople.put("peoplenumber" + String.valueOf(a), String.valueOf(count));
							
							// 取類型↓
							List<Integer> typed = groupservice
									.getgametype(selectgroup
											.getGroupSerialNumber());// 類型
							int i = 0;
							for (int typelist : typed) {
								String gamestype = groupservice
										.selectGameKindName(typelist);
								requesttype.put("type" + String.valueOf(i) + String.valueOf(b),	gamestype);
								i++;
							}
							// 取時間↓
							Date starttime = selectgroup.getReserveGroupStartTime();
							requesttime.put("time" + String.valueOf(c), String.valueOf(starttime));
	
						}//end of if (Groupdesc >=10 && Groupdesc <20)
						w++;
						x++;
						y++;
						z++;
						a++;
						b++;
						c++;
						
					}//end of for (Integer list : selectgroupdesc)
					RequestDispatcher rd = request.getRequestDispatcher("LookForGroup.jsp");
					rd.forward(request, response);
					
				}// end of if (gamenumber.equals("10至20人"))
				
				if (gamenumber.equals("20人以上")) {
					int type = 1;
					List<Integer> selectgroupdesc = groupservice
							.sequenceandselecttypedesc(type);

					for (Integer groupRoomId : selectgroupdesc) {
						// System.out.print("團序號:" + list + " ");//get順序
						
						
						
						requestimage.put("simpleimage" +String.valueOf(y), groupRoomId);
						
						int Groupdesc = groupservice.countGroupRoomsByGroupSerialNumber(groupRoomId);
						if (Groupdesc >=20) {
							GroupRoom selectgroup = groupservice
									.getOneGroupRoom(groupRoomId);
							System.out.println(selectgroup
									.getGroupSerialNumber());
							
							//取專賣店名
							String mese = selectgroup.getStoreName();
							storename.put("simplemese" + String.valueOf(w), mese);
							
							//遊戲名
							List<GroupChoiceGames> gamenames = groupservice.getBoardGameNames(groupRoomId);
							gamename.put("simplegamename" + String.valueOf(x), gamenames);
							
							//取團名↓
							String groupname = selectgroup.getGroupRoomName();
							requestgroupname.put("simplegroupgroupname"+String.valueOf(z), groupname);
							

							// 取人數↓
							int count = groupservice.countGroupRoomsByGroupSerialNumber(selectgroup);
							
							requestnumberofpeople.put("peoplenumber" + String.valueOf(a), String.valueOf(count));
							
							// 取類型↓
							List<Integer> typed = groupservice
									.getgametype(selectgroup
											.getGroupSerialNumber());// 類型
							int i = 0;
							for (int typelist : typed) {
								String gamestype = groupservice
										.selectGameKindName(typelist);
								requesttype.put("type" + String.valueOf(i) + String.valueOf(b),	gamestype);
								i++;
							}
							// 取時間↓
							Date starttime = selectgroup.getReserveGroupStartTime();
							requesttime.put("time" + String.valueOf(c), String.valueOf(starttime));
	
						}//end of if (Groupdesc >=20)
						w++;
						x++;
						y++;
						z++;
						a++;
						b++;
						c++;
						
					}//end of for (Integer list : selectgroupdesc)
					RequestDispatcher rd = request.getRequestDispatcher("LookForGroup.jsp");
					rd.forward(request, response);
					
				}// end of if (gamenumber.equals("20人以上"))
				
			}// end of if (gametype.equals("推理遊戲")) 
			
			if (gametype.equals("角色扮演遊戲")) {
				if (gamenumber.equals("10人以下")) {
					int type = 4;
					List<Integer> selectgroupdesc = groupservice
							.sequenceandselecttypedesc(type);

					for (Integer groupRoomId : selectgroupdesc) {
						// System.out.print("團序號:" + list + " ");//get順序
						
						
						
						requestimage.put("simpleimage" +String.valueOf(y), groupRoomId);
						
						int Groupdesc = groupservice.countGroupRoomsByGroupSerialNumber(groupRoomId);
						if (Groupdesc < 10) {
							GroupRoom selectgroup = groupservice
									.getOneGroupRoom(groupRoomId);
							System.out.println(selectgroup
									.getGroupSerialNumber());
							
							//取專賣店名
							String mese = selectgroup.getStoreName();
							storename.put("simplemese" + String.valueOf(w), mese);
							
							//遊戲名
							List<GroupChoiceGames> gamenames = groupservice.getBoardGameNames(groupRoomId);
							gamename.put("simplegamename" + String.valueOf(x), gamenames);
							
							//取團名↓
							String groupname = selectgroup.getGroupRoomName();
							requestgroupname.put("simplegroupgroupname"+String.valueOf(z), groupname);
							

							// 取人數↓
							int count = groupservice.countGroupRoomsByGroupSerialNumber(selectgroup);
							
							requestnumberofpeople.put("peoplenumber" + String.valueOf(a), String.valueOf(count));
							
							// 取類型↓
							List<Integer> typed = groupservice
									.getgametype(selectgroup
											.getGroupSerialNumber());// 類型
							int i = 0;
							for (int typelist : typed) {
								String gamestype = groupservice
										.selectGameKindName(typelist);
								requesttype.put("type" + String.valueOf(i) + String.valueOf(b),	gamestype);
								i++;
							}
							// 取時間↓
							Date starttime = selectgroup.getReserveGroupStartTime();
							requesttime.put("time" + String.valueOf(c), String.valueOf(starttime));
	
						}//end of if (Groupdesc < 10)
						w++;
						x++;
						y++;
						z++;
						a++;
						b++;
						c++;
						
					}//end of for (Integer list : selectgroupdesc)
					RequestDispatcher rd = request.getRequestDispatcher("LookForGroup.jsp");
					rd.forward(request, response);
					
				}// end of if (gamenumber.equals("10人以下"))
				
				if (gamenumber.equals("10至20人")) {
					int type = 1;
					List<Integer> selectgroupdesc = groupservice
							.sequenceandselecttypedesc(type);

					for (Integer groupRoomId : selectgroupdesc) {
						// System.out.print("團序號:" + list + " ");//get順序
						
						
						
						requestimage.put("simpleimage" +String.valueOf(y), groupRoomId);
						
						int Groupdesc = groupservice.countGroupRoomsByGroupSerialNumber(groupRoomId);
						if (Groupdesc >=10 && Groupdesc <20) {
							GroupRoom selectgroup = groupservice
									.getOneGroupRoom(groupRoomId);
							System.out.println(selectgroup
									.getGroupSerialNumber());
							
							//取專賣店名
							String mese = selectgroup.getStoreName();
							storename.put("simplemese" + String.valueOf(w), mese);
							
							//遊戲名
							List<GroupChoiceGames> gamenames = groupservice.getBoardGameNames(groupRoomId);
							gamename.put("simplegamename" + String.valueOf(x), gamenames);
							
							//取團名↓
							String groupname = selectgroup.getGroupRoomName();
							requestgroupname.put("simplegroupgroupname"+String.valueOf(z), groupname);
							

							// 取人數↓
							int count = groupservice.countGroupRoomsByGroupSerialNumber(selectgroup);
							
							requestnumberofpeople.put("peoplenumber" + String.valueOf(a), String.valueOf(count));
							
							// 取類型↓
							List<Integer> typed = groupservice
									.getgametype(selectgroup
											.getGroupSerialNumber());// 類型
							int i = 0;
							for (int typelist : typed) {
								String gamestype = groupservice
										.selectGameKindName(typelist);
								requesttype.put("type" + String.valueOf(i) + String.valueOf(b),	gamestype);
								i++;
							}
							// 取時間↓
							Date starttime = selectgroup.getReserveGroupStartTime();
							requesttime.put("time" + String.valueOf(c), String.valueOf(starttime));
	
						}//end of if (Groupdesc >=10 && Groupdesc <20)
						w++;
						x++;
						y++;
						z++;
						a++;
						b++;
						c++;
						
					}//end of for (Integer list : selectgroupdesc)
					RequestDispatcher rd = request.getRequestDispatcher("LookForGroup.jsp");
					rd.forward(request, response);
					
				}// end of if (gamenumber.equals("10至20人"))
				
				if (gamenumber.equals("20人以上")) {
					int type = 1;
					List<Integer> selectgroupdesc = groupservice
							.sequenceandselecttypedesc(type);

					for (Integer groupRoomId : selectgroupdesc) {
						// System.out.print("團序號:" + list + " ");//get順序
						
						
						
						requestimage.put("simpleimage" +String.valueOf(y), groupRoomId);
						
						int Groupdesc = groupservice.countGroupRoomsByGroupSerialNumber(groupRoomId);
						if (Groupdesc >=20) {
							GroupRoom selectgroup = groupservice
									.getOneGroupRoom(groupRoomId);
							System.out.println(selectgroup
									.getGroupSerialNumber());
							
							//取專賣店名
							String mese = selectgroup.getStoreName();
							storename.put("simplemese" + String.valueOf(w), mese);
							
							//遊戲名
							List<GroupChoiceGames> gamenames = groupservice.getBoardGameNames(groupRoomId);
							gamename.put("simplegamename" + String.valueOf(x), gamenames);
							
							//取團名↓
							String groupname = selectgroup.getGroupRoomName();
							requestgroupname.put("simplegroupgroupname"+String.valueOf(z), groupname);
							

							// 取人數↓
							int count = groupservice.countGroupRoomsByGroupSerialNumber(selectgroup);
							
							requestnumberofpeople.put("peoplenumber" + String.valueOf(a), String.valueOf(count));
							
							// 取類型↓
							List<Integer> typed = groupservice
									.getgametype(selectgroup
											.getGroupSerialNumber());// 類型
							int i = 0;
							for (int typelist : typed) {
								String gamestype = groupservice
										.selectGameKindName(typelist);
								requesttype.put("type" + String.valueOf(i) + String.valueOf(b),	gamestype);
								i++;
							}
							// 取時間↓
							Date starttime = selectgroup.getReserveGroupStartTime();
							requesttime.put("time" + String.valueOf(c), String.valueOf(starttime));
	
						}//end of if (Groupdesc >=20)
						w++;
						x++;
						y++;
						z++;
						a++;
						b++;
						c++;
						
					}//end of for (Integer list : selectgroupdesc)
					RequestDispatcher rd = request.getRequestDispatcher("LookForGroup.jsp");
					rd.forward(request, response);
					
				}// end of if (gamenumber.equals("20人以上"))
				
			}// end of if (gametype.equals("角色扮演遊戲")) 
			
			if (gametype.equals("小品遊戲")) {
				if (gamenumber.equals("10人以下")) {
					int type = 5;
					List<Integer> selectgroupdesc = groupservice
							.sequenceandselecttypedesc(type);

					for (Integer groupRoomId : selectgroupdesc) {
						// System.out.print("團序號:" + list + " ");//get順序
						
						
						
						requestimage.put("simpleimage" +String.valueOf(y), groupRoomId);
						
						int Groupdesc = groupservice.countGroupRoomsByGroupSerialNumber(groupRoomId);
						if (Groupdesc < 10) {
							GroupRoom selectgroup = groupservice
									.getOneGroupRoom(groupRoomId);
							System.out.println(selectgroup
									.getGroupSerialNumber());
							
							//取專賣店名
							String mese = selectgroup.getStoreName();
							storename.put("simplemese" + String.valueOf(w), mese);
							
							//遊戲名
							List<GroupChoiceGames> gamenames = groupservice.getBoardGameNames(groupRoomId);
							gamename.put("simplegamename" + String.valueOf(x), gamenames);
							
							//取團名↓
							String groupname = selectgroup.getGroupRoomName();
							requestgroupname.put("simplegroupgroupname"+String.valueOf(z), groupname);
							

							// 取人數↓
							int count = groupservice.countGroupRoomsByGroupSerialNumber(selectgroup);
							
							requestnumberofpeople.put("peoplenumber" + String.valueOf(a), String.valueOf(count));
							
							// 取類型↓
							List<Integer> typed = groupservice
									.getgametype(selectgroup
											.getGroupSerialNumber());// 類型
							int i = 0;
							for (int typelist : typed) {
								String gamestype = groupservice
										.selectGameKindName(typelist);
								requesttype.put("type" + String.valueOf(i) + String.valueOf(b),	gamestype);
								i++;
							}
							// 取時間↓
							Date starttime = selectgroup.getReserveGroupStartTime();
							requesttime.put("time" + String.valueOf(c), String.valueOf(starttime));
	
						}//end of if (Groupdesc < 10)
						w++;
						x++;
						y++;
						z++;
						a++;
						b++;
						c++;
						
					}//end of for (Integer list : selectgroupdesc)
					RequestDispatcher rd = request.getRequestDispatcher("LookForGroup.jsp");
					rd.forward(request, response);
					
				}// end of if (gamenumber.equals("10人以下"))
				
				if (gamenumber.equals("10至20人")) {
					int type = 1;
					List<Integer> selectgroupdesc = groupservice
							.sequenceandselecttypedesc(type);

					for (Integer groupRoomId : selectgroupdesc) {
						// System.out.print("團序號:" + list + " ");//get順序
						
						
						
						requestimage.put("simpleimage" +String.valueOf(y), groupRoomId);
						
						int Groupdesc = groupservice.countGroupRoomsByGroupSerialNumber(groupRoomId);
						if (Groupdesc >=10 && Groupdesc <20) {
							GroupRoom selectgroup = groupservice
									.getOneGroupRoom(groupRoomId);
							System.out.println(selectgroup
									.getGroupSerialNumber());
							//取專賣店名
							String mese = selectgroup.getStoreName();
							storename.put("simplemese" + String.valueOf(w), mese);
							
							//遊戲名
							List<GroupChoiceGames> gamenames = groupservice.getBoardGameNames(groupRoomId);
							gamename.put("simplegamename" + String.valueOf(x), gamenames);
							
							//取團名↓
							String groupname = selectgroup.getGroupRoomName();
							requestgroupname.put("simplegroupgroupname"+String.valueOf(z), groupname);
							

							// 取人數↓
							int count = groupservice.countGroupRoomsByGroupSerialNumber(selectgroup);
							
							requestnumberofpeople.put("peoplenumber" + String.valueOf(a), String.valueOf(count));
							
							// 取類型↓
							List<Integer> typed = groupservice
									.getgametype(selectgroup
											.getGroupSerialNumber());// 類型
							int i = 0;
							for (int typelist : typed) {
								String gamestype = groupservice
										.selectGameKindName(typelist);
								requesttype.put("type" + String.valueOf(i) + String.valueOf(b),	gamestype);
								i++;
							}
							// 取時間↓
							Date starttime = selectgroup.getReserveGroupStartTime();
							requesttime.put("time" + String.valueOf(c), String.valueOf(starttime));
	
						}//end of if (Groupdesc >=10 && Groupdesc <20)
						w++;
						x++;
						y++;
						z++;
						a++;
						b++;
						c++;
						
					}//end of for (Integer list : selectgroupdesc)
					RequestDispatcher rd = request.getRequestDispatcher("LookForGroup.jsp");
					rd.forward(request, response);
					
				}// end of if (gamenumber.equals("10至20人"))
				
				if (gamenumber.equals("20人以上")) {
					int type = 1;
					List<Integer> selectgroupdesc = groupservice
							.sequenceandselecttypedesc(type);

					for (Integer groupRoomId : selectgroupdesc) {
						// System.out.print("團序號:" + list + " ");//get順序
						
						
						
						requestimage.put("simpleimage" +String.valueOf(y), groupRoomId);
						
						int Groupdesc = groupservice.countGroupRoomsByGroupSerialNumber(groupRoomId);
						if (Groupdesc >=20) {
							GroupRoom selectgroup = groupservice
									.getOneGroupRoom(groupRoomId);
							System.out.println(selectgroup
									.getGroupSerialNumber());
							
							//取專賣店名
							String mese = selectgroup.getStoreName();
							storename.put("simplemese" + String.valueOf(w), mese);
							
							//遊戲名
							List<GroupChoiceGames> gamenames = groupservice.getBoardGameNames(groupRoomId);
							gamename.put("simplegamename" + String.valueOf(x), gamenames);
							
							//取團名↓
							String groupname = selectgroup.getGroupRoomName();
							requestgroupname.put("simplegroupgroupname"+String.valueOf(z), groupname);
							

							// 取人數↓
							int count = groupservice.countGroupRoomsByGroupSerialNumber(selectgroup);
							
							requestnumberofpeople.put("peoplenumber" + String.valueOf(a), String.valueOf(count));
							
							// 取類型↓
							List<Integer> typed = groupservice
									.getgametype(selectgroup
											.getGroupSerialNumber());// 類型
							int i = 0;
							for (int typelist : typed) {
								String gamestype = groupservice
										.selectGameKindName(typelist);
								requesttype.put("type" + String.valueOf(i) + String.valueOf(b),	gamestype);
								i++;
							}
							// 取時間↓
							Date starttime = selectgroup.getReserveGroupStartTime();
							requesttime.put("time" + String.valueOf(c), String.valueOf(starttime));
	
						}//end of if (Groupdesc >=20)
						w++;
						x++;
						y++;
						z++;
						a++;
						b++;
						c++;
						
					}//end of for (Integer list : selectgroupdesc)
					RequestDispatcher rd = request.getRequestDispatcher("LookForGroup.jsp");
					rd.forward(request, response);
					
				}// end of if (gamenumber.equals("20人以上"))
				
			}// end of if (gametype.equals("小品遊戲")) 
		}//end of if (gametime.equals("最近→最遠"))

		if (gametime.equals("最遠→最近")) {
			if (gametype.equals("策略遊戲")) {
				if (gamenumber.equals("10人以下")) {
					int type = 1;
					List<Integer> selectgroupdesc = groupservice
							.sequenceandselecttype(type);

					for (Integer groupRoomId : selectgroupdesc) {
						// System.out.print("團序號:" + list + " ");//get順序
						
						
						
						requestimage.put("simpleimage" +String.valueOf(y), groupRoomId);
						
						int Groupdesc = groupservice.countGroupRoomsByGroupSerialNumber(groupRoomId);
						if (Groupdesc < 10) {
							GroupRoom selectgroup = groupservice
									.getOneGroupRoom(groupRoomId);
							System.out.println(selectgroup
									.getGroupSerialNumber());
							
							//取專賣店名
							String mese = selectgroup.getStoreName();
							storename.put("simplemese" + String.valueOf(w), mese);
							
							//遊戲名
							List<GroupChoiceGames> gamenames = groupservice.getBoardGameNames(groupRoomId);
							gamename.put("simplegamename" + String.valueOf(x), gamenames);
							
							//取團名↓
							String groupname = selectgroup.getGroupRoomName();
							requestgroupname.put("simplegroupgroupname"+String.valueOf(z), groupname);
							

							// 取人數↓
							int count = groupservice.countGroupRoomsByGroupSerialNumber(selectgroup);
							
							requestnumberofpeople.put("peoplenumber" + String.valueOf(a), String.valueOf(count));
							
							// 取類型↓
							List<Integer> typed = groupservice
									.getgametype(selectgroup
											.getGroupSerialNumber());// 類型
							int i = 0;
							for (int typelist : typed) {
								String gamestype = groupservice
										.selectGameKindName(typelist);
								requesttype.put("type" + String.valueOf(i) + String.valueOf(b),	gamestype);
								i++;
							}
							// 取時間↓
							Date starttime = selectgroup.getReserveGroupStartTime();
							requesttime.put("time" + String.valueOf(c), String.valueOf(starttime));
	
						}//end of if (Groupdesc < 10)
						w++;
						x++;
						y++;
						z++;
						a++;
						b++;
						c++;
						
					}//end of for (Integer list : selectgroupdesc)
					RequestDispatcher rd = request.getRequestDispatcher("LookForGroup.jsp");
					rd.forward(request, response);
					
				}// end of if (gamenumber.equals("10人以下"))
				
				if (gamenumber.equals("10至20人")) {
					int type = 1;
					List<Integer> selectgroupdesc = groupservice
							.sequenceandselecttypedesc(type);

					for (Integer groupRoomId : selectgroupdesc) {
						// System.out.print("團序號:" + list + " ");//get順序
						
						
						
						requestimage.put("simpleimage" +String.valueOf(y), groupRoomId);
						
						int Groupdesc = groupservice.countGroupRoomsByGroupSerialNumber(groupRoomId);
						if (Groupdesc >=10 && Groupdesc <20) {
							GroupRoom selectgroup = groupservice
									.getOneGroupRoom(groupRoomId);
							System.out.println(selectgroup
									.getGroupSerialNumber());
							
							//取專賣店名
							String mese = selectgroup.getStoreName();
							storename.put("simplemese" + String.valueOf(w), mese);
							
							//遊戲名
							List<GroupChoiceGames> gamenames = groupservice.getBoardGameNames(groupRoomId);
							gamename.put("simplegamename" + String.valueOf(x), gamenames);
							
							//取團名↓
							String groupname = selectgroup.getGroupRoomName();
							requestgroupname.put("simplegroupgroupname"+String.valueOf(z), groupname);
							

							// 取人數↓
							int count = groupservice.countGroupRoomsByGroupSerialNumber(selectgroup);
							
							requestnumberofpeople.put("peoplenumber" + String.valueOf(a), String.valueOf(count));
							
							// 取類型↓
							List<Integer> typed = groupservice
									.getgametype(selectgroup
											.getGroupSerialNumber());// 類型
							int i = 0;
							for (int typelist : typed) {
								String gamestype = groupservice
										.selectGameKindName(typelist);
								requesttype.put("type" + String.valueOf(i) + String.valueOf(b),	gamestype);
								i++;
							}
							// 取時間↓
							Date starttime = selectgroup.getReserveGroupStartTime();
							requesttime.put("time" + String.valueOf(c), String.valueOf(starttime));
	
						}//end of if (Groupdesc >=10 && Groupdesc <20)
						w++;
						x++;
						y++;
						z++;
						a++;
						b++;
						c++;
						
					}//end of for (Integer list : selectgroupdesc)
					RequestDispatcher rd = request.getRequestDispatcher("LookForGroup.jsp");
					rd.forward(request, response);
					
				}// end of if (gamenumber.equals("10至20人"))
				
				if (gamenumber.equals("20人以上")) {
					int type = 1;
					List<Integer> selectgroupdesc = groupservice
							.sequenceandselecttypedesc(type);

					for (Integer groupRoomId : selectgroupdesc) {
						// System.out.print("團序號:" + list + " ");//get順序
						
						
						
						requestimage.put("simpleimage" +String.valueOf(y), groupRoomId);
						
						int Groupdesc = groupservice.countGroupRoomsByGroupSerialNumber(groupRoomId);
						if (Groupdesc >=20) {
							GroupRoom selectgroup = groupservice
									.getOneGroupRoom(groupRoomId);
							System.out.println(selectgroup
									.getGroupSerialNumber());
							
							//取專賣店名
							String mese = selectgroup.getStoreName();
							storename.put("simplemese" + String.valueOf(w), mese);
							
							//遊戲名
							List<GroupChoiceGames> gamenames = groupservice.getBoardGameNames(groupRoomId);
							gamename.put("simplegamename" + String.valueOf(x), gamenames);
							
							//取團名↓
							String groupname = selectgroup.getGroupRoomName();
							requestgroupname.put("simplegroupgroupname"+String.valueOf(z), groupname);
							

							// 取人數↓
							int count = groupservice.countGroupRoomsByGroupSerialNumber(selectgroup);
							
							requestnumberofpeople.put("peoplenumber" + String.valueOf(a), String.valueOf(count));
							
							// 取類型↓
							List<Integer> typed = groupservice
									.getgametype(selectgroup
											.getGroupSerialNumber());// 類型
							int i = 0;
							for (int typelist : typed) {
								String gamestype = groupservice
										.selectGameKindName(typelist);
								requesttype.put("type" + String.valueOf(i) + String.valueOf(b),	gamestype);
								i++;
							}
							// 取時間↓
							Date starttime = selectgroup.getReserveGroupStartTime();
							requesttime.put("time" + String.valueOf(c), String.valueOf(starttime));
	
						}//end of if (Groupdesc >=20)
						w++;
						x++;
						y++;
						z++;
						a++;
						b++;
						c++;
						
					}//end of for (Integer list : selectgroupdesc)
					RequestDispatcher rd = request.getRequestDispatcher("LookForGroup.jsp");
					rd.forward(request, response);
					
				}// end of if (gamenumber.equals("20人以上"))
				
			}// end of if (gametype.equals("策略遊戲")) 
			
			if (gametype.equals("益智遊戲")) {
				if (gamenumber.equals("10人以下")) {
					int type = 2;
					List<Integer> selectgroupdesc = groupservice
							.sequenceandselecttypedesc(type);

					for (Integer groupRoomId : selectgroupdesc) {
						// System.out.print("團序號:" + list + " ");//get順序
						
						
						
						requestimage.put("simpleimage" +String.valueOf(y), groupRoomId);
						
						int Groupdesc = groupservice.countGroupRoomsByGroupSerialNumber(groupRoomId);
						if (Groupdesc < 10) {
							GroupRoom selectgroup = groupservice
									.getOneGroupRoom(groupRoomId);
							System.out.println(selectgroup
									.getGroupSerialNumber());
							
							//取專賣店名
							String mese = selectgroup.getStoreName();
							storename.put("simplemese" + String.valueOf(w), mese);
							
							//遊戲名
							List<GroupChoiceGames> gamenames = groupservice.getBoardGameNames(groupRoomId);
							gamename.put("simplegamename" + String.valueOf(x), gamenames);
							
							//取團名↓
							String groupname = selectgroup.getGroupRoomName();
							requestgroupname.put("simplegroupgroupname"+String.valueOf(z), groupname);
							

							// 取人數↓
							int count = groupservice.countGroupRoomsByGroupSerialNumber(selectgroup);
							
							requestnumberofpeople.put("peoplenumber" + String.valueOf(a), String.valueOf(count));
							
							// 取類型↓
							List<Integer> typed = groupservice
									.getgametype(selectgroup
											.getGroupSerialNumber());// 類型
							int i = 0;
							for (int typelist : typed) {
								String gamestype = groupservice
										.selectGameKindName(typelist);
								requesttype.put("type" + String.valueOf(i) + String.valueOf(b),	gamestype);
								i++;
							}
							// 取時間↓
							Date starttime = selectgroup.getReserveGroupStartTime();
							requesttime.put("time" + String.valueOf(c), String.valueOf(starttime));
	
						}//end of if (Groupdesc < 10)
						w++;
						x++;
						y++;
						z++;
						a++;
						b++;
						c++;
						
					}//end of for (Integer list : selectgroupdesc)
					RequestDispatcher rd = request.getRequestDispatcher("LookForGroup.jsp");
					rd.forward(request, response);
					
				}// end of if (gamenumber.equals("10人以下"))
				
				if (gamenumber.equals("10至20人")) {
					int type = 1;
					List<Integer> selectgroupdesc = groupservice
							.sequenceandselecttypedesc(type);

					for (Integer groupRoomId : selectgroupdesc) {
						// System.out.print("團序號:" + list + " ");//get順序
						
						
						
						requestimage.put("simpleimage" +String.valueOf(y), groupRoomId);
						
						int Groupdesc = groupservice.countGroupRoomsByGroupSerialNumber(groupRoomId);
						if (Groupdesc >=10 && Groupdesc <20) {
							GroupRoom selectgroup = groupservice
									.getOneGroupRoom(groupRoomId);
							System.out.println(selectgroup
									.getGroupSerialNumber());
							
							//取專賣店名
							String mese = selectgroup.getStoreName();
							storename.put("simplemese" + String.valueOf(w), mese);
							
							//遊戲名
							List<GroupChoiceGames> gamenames = groupservice.getBoardGameNames(groupRoomId);
							gamename.put("simplegamename" + String.valueOf(x), gamenames);
							
							//取團名↓
							String groupname = selectgroup.getGroupRoomName();
							requestgroupname.put("simplegroupgroupname"+String.valueOf(z), groupname);
							

							// 取人數↓
							int count = groupservice.countGroupRoomsByGroupSerialNumber(selectgroup);
							
							requestnumberofpeople.put("peoplenumber" + String.valueOf(a), String.valueOf(count));
							
							// 取類型↓
							List<Integer> typed = groupservice
									.getgametype(selectgroup
											.getGroupSerialNumber());// 類型
							int i = 0;
							for (int typelist : typed) {
								String gamestype = groupservice
										.selectGameKindName(typelist);
								requesttype.put("type" + String.valueOf(i) + String.valueOf(b),	gamestype);
								i++;
							}
							// 取時間↓
							Date starttime = selectgroup.getReserveGroupStartTime();
							requesttime.put("time" + String.valueOf(c), String.valueOf(starttime));
	
						}//end of if (Groupdesc >=10 && Groupdesc <20)
						w++;
						x++;
						y++;
						z++;
						a++;
						b++;
						c++;
						
					}//end of for (Integer list : selectgroupdesc)
					RequestDispatcher rd = request.getRequestDispatcher("LookForGroup.jsp");
					rd.forward(request, response);
					
				}// end of if (gamenumber.equals("10至20人"))
				
				if (gamenumber.equals("20人以上")) {
					int type = 1;
					List<Integer> selectgroupdesc = groupservice
							.sequenceandselecttypedesc(type);

					for (Integer groupRoomId : selectgroupdesc) {
						// System.out.print("團序號:" + list + " ");//get順序
						
						
						
						requestimage.put("simpleimage" +String.valueOf(y), groupRoomId);
						
						int Groupdesc = groupservice.countGroupRoomsByGroupSerialNumber(groupRoomId);
						if (Groupdesc >=20) {
							GroupRoom selectgroup = groupservice
									.getOneGroupRoom(groupRoomId);
							System.out.println(selectgroup
									.getGroupSerialNumber());
							
							//取專賣店名
							String mese = selectgroup.getStoreName();
							storename.put("simplemese" + String.valueOf(w), mese);
							
							//遊戲名
							List<GroupChoiceGames> gamenames = groupservice.getBoardGameNames(groupRoomId);
							gamename.put("simplegamename" + String.valueOf(x), gamenames);
							
							//取團名↓
							String groupname = selectgroup.getGroupRoomName();
							requestgroupname.put("simplegroupgroupname"+String.valueOf(z), groupname);
							

							// 取人數↓
							int count = groupservice.countGroupRoomsByGroupSerialNumber(selectgroup);
							
							requestnumberofpeople.put("peoplenumber" + String.valueOf(a), String.valueOf(count));
							
							// 取類型↓
							List<Integer> typed = groupservice
									.getgametype(selectgroup
											.getGroupSerialNumber());// 類型
							int i = 0;
							for (int typelist : typed) {
								String gamestype = groupservice
										.selectGameKindName(typelist);
								requesttype.put("type" + String.valueOf(i) + String.valueOf(b),	gamestype);
								i++;
							}
							// 取時間↓
							Date starttime = selectgroup.getReserveGroupStartTime();
							requesttime.put("time" + String.valueOf(c), String.valueOf(starttime));
	
						}//end of if (Groupdesc >=20)
						w++;
						x++;
						y++;
						z++;
						a++;
						b++;
						c++;
						
					}//end of for (Integer list : selectgroupdesc)
					RequestDispatcher rd = request.getRequestDispatcher("LookForGroup.jsp");
					rd.forward(request, response);
					
				}// end of if (gamenumber.equals("20人以上"))
				
			}// end of if (gametype.equals("益智遊戲")) 
			
			if (gametype.equals("推理遊戲")) {
				if (gamenumber.equals("10人以下")) {
					int type = 3;
					List<Integer> selectgroupdesc = groupservice
							.sequenceandselecttypedesc(type);

					for (Integer groupRoomId : selectgroupdesc) {
						// System.out.print("團序號:" + list + " ");//get順序
						
						
						
						requestimage.put("simpleimage" +String.valueOf(y), groupRoomId);
						
						int Groupdesc = groupservice.countGroupRoomsByGroupSerialNumber(groupRoomId);
						if (Groupdesc < 10) {
							GroupRoom selectgroup = groupservice
									.getOneGroupRoom(groupRoomId);
							System.out.println(selectgroup
									.getGroupSerialNumber());
							
							//取專賣店名
							String mese = selectgroup.getStoreName();
							storename.put("simplemese" + String.valueOf(w), mese);
							
							//遊戲名
							List<GroupChoiceGames> gamenames = groupservice.getBoardGameNames(groupRoomId);
							gamename.put("simplegamename" + String.valueOf(x), gamenames);
							
							//取團名↓
							String groupname = selectgroup.getGroupRoomName();
							requestgroupname.put("simplegroupgroupname"+String.valueOf(z), groupname);
							

							// 取人數↓
							int count = groupservice.countGroupRoomsByGroupSerialNumber(selectgroup);
							
							requestnumberofpeople.put("peoplenumber" + String.valueOf(a), String.valueOf(count));
							
							// 取類型↓
							List<Integer> typed = groupservice
									.getgametype(selectgroup
											.getGroupSerialNumber());// 類型
							int i = 0;
							for (int typelist : typed) {
								String gamestype = groupservice
										.selectGameKindName(typelist);
								requesttype.put("type" + String.valueOf(i) + String.valueOf(b),	gamestype);
								i++;
							}
							// 取時間↓
							Date starttime = selectgroup.getReserveGroupStartTime();
							requesttime.put("time" + String.valueOf(c), String.valueOf(starttime));
	
						}//end of if (Groupdesc < 10)
						w++;
						x++;
						y++;
						z++;
						a++;
						b++;
						c++;
						
					}//end of for (Integer list : selectgroupdesc)
					RequestDispatcher rd = request.getRequestDispatcher("LookForGroup.jsp");
					rd.forward(request, response);
					
				}// end of if (gamenumber.equals("10人以下"))
				
				if (gamenumber.equals("10至20人")) {
					int type = 1;
					List<Integer> selectgroupdesc = groupservice
							.sequenceandselecttypedesc(type);

					for (Integer groupRoomId : selectgroupdesc) {
						// System.out.print("團序號:" + list + " ");//get順序
						
						
						
						requestimage.put("simpleimage" +String.valueOf(y), groupRoomId);
						
						int Groupdesc = groupservice.countGroupRoomsByGroupSerialNumber(groupRoomId);
						if (Groupdesc >=10 && Groupdesc <20) {
							GroupRoom selectgroup = groupservice
									.getOneGroupRoom(groupRoomId);
							System.out.println(selectgroup
									.getGroupSerialNumber());
							
							//取專賣店名
							String mese = selectgroup.getStoreName();
							storename.put("simplemese" + String.valueOf(w), mese);
							
							//遊戲名
							List<GroupChoiceGames> gamenames = groupservice.getBoardGameNames(groupRoomId);
							gamename.put("simplegamename" + String.valueOf(x), gamenames);
							
							//取團名↓
							String groupname = selectgroup.getGroupRoomName();
							requestgroupname.put("simplegroupgroupname"+String.valueOf(z), groupname);
							

							// 取人數↓
							int count = groupservice.countGroupRoomsByGroupSerialNumber(selectgroup);
							
							requestnumberofpeople.put("peoplenumber" + String.valueOf(a), String.valueOf(count));
							
							// 取類型↓
							List<Integer> typed = groupservice
									.getgametype(selectgroup
											.getGroupSerialNumber());// 類型
							int i = 0;
							for (int typelist : typed) {
								String gamestype = groupservice
										.selectGameKindName(typelist);
								requesttype.put("type" + String.valueOf(i) + String.valueOf(b),	gamestype);
								i++;
							}
							// 取時間↓
							Date starttime = selectgroup.getReserveGroupStartTime();
							requesttime.put("time" + String.valueOf(c), String.valueOf(starttime));
	
						}//end of if (Groupdesc >=10 && Groupdesc <20)
						w++;
						x++;
						y++;
						z++;
						a++;
						b++;
						c++;
						
					}//end of for (Integer list : selectgroupdesc)
					RequestDispatcher rd = request.getRequestDispatcher("LookForGroup.jsp");
					rd.forward(request, response);
					
				}// end of if (gamenumber.equals("10至20人"))
				
				if (gamenumber.equals("20人以上")) {
					int type = 1;
					List<Integer> selectgroupdesc = groupservice
							.sequenceandselecttypedesc(type);

					for (Integer groupRoomId : selectgroupdesc) {
						// System.out.print("團序號:" + list + " ");//get順序
						
						
						
						requestimage.put("simpleimage" +String.valueOf(y), groupRoomId);
						
						int Groupdesc = groupservice.countGroupRoomsByGroupSerialNumber(groupRoomId);
						if (Groupdesc >=20) {
							GroupRoom selectgroup = groupservice
									.getOneGroupRoom(groupRoomId);
							System.out.println(selectgroup
									.getGroupSerialNumber());
							
							//取專賣店名
							String mese = selectgroup.getStoreName();
							storename.put("simplemese" + String.valueOf(w), mese);
							
							//遊戲名
							List<GroupChoiceGames> gamenames = groupservice.getBoardGameNames(groupRoomId);
							gamename.put("simplegamename" + String.valueOf(x), gamenames);
							
							//取團名↓
							String groupname = selectgroup.getGroupRoomName();
							requestgroupname.put("simplegroupgroupname"+String.valueOf(z), groupname);
							

							// 取人數↓
							int count = groupservice.countGroupRoomsByGroupSerialNumber(selectgroup);
							
							requestnumberofpeople.put("peoplenumber" + String.valueOf(a), String.valueOf(count));
							
							// 取類型↓
							List<Integer> typed = groupservice
									.getgametype(selectgroup
											.getGroupSerialNumber());// 類型
							int i = 0;
							for (int typelist : typed) {
								String gamestype = groupservice
										.selectGameKindName(typelist);
								requesttype.put("type" + String.valueOf(i) + String.valueOf(b),	gamestype);
								i++;
							}
							// 取時間↓
							Date starttime = selectgroup.getReserveGroupStartTime();
							requesttime.put("time" + String.valueOf(c), String.valueOf(starttime));
	
						}//end of if (Groupdesc >=20)
						w++;
						x++;
						y++;
						z++;
						a++;
						b++;
						c++;
						
					}//end of for (Integer list : selectgroupdesc)
					RequestDispatcher rd = request.getRequestDispatcher("LookForGroup.jsp");
					rd.forward(request, response);
					
				}// end of if (gamenumber.equals("20人以上"))
				
			}// end of if (gametype.equals("推理遊戲")) 
			
			if (gametype.equals("角色扮演遊戲")) {
				if (gamenumber.equals("10人以下")) {
					int type = 4;
					List<Integer> selectgroupdesc = groupservice
							.sequenceandselecttypedesc(type);

					for (Integer groupRoomId : selectgroupdesc) {
						// System.out.print("團序號:" + list + " ");//get順序
						
						
						
						requestimage.put("simpleimage" +String.valueOf(y), groupRoomId);
						
						int Groupdesc = groupservice.countGroupRoomsByGroupSerialNumber(groupRoomId);
						if (Groupdesc < 10) {
							GroupRoom selectgroup = groupservice
									.getOneGroupRoom(groupRoomId);
							System.out.println(selectgroup
									.getGroupSerialNumber());
							
							//取專賣店名
							String mese = selectgroup.getStoreName();
							storename.put("simplemese" + String.valueOf(w), mese);
							
							//遊戲名
							List<GroupChoiceGames> gamenames = groupservice.getBoardGameNames(groupRoomId);
							gamename.put("simplegamename" + String.valueOf(x), gamenames);
							
							//取團名↓
							String groupname = selectgroup.getGroupRoomName();
							requestgroupname.put("simplegroupgroupname"+String.valueOf(z), groupname);
							

							// 取人數↓
							int count = groupservice.countGroupRoomsByGroupSerialNumber(selectgroup);
							
							requestnumberofpeople.put("peoplenumber" + String.valueOf(a), String.valueOf(count));
							
							// 取類型↓
							List<Integer> typed = groupservice
									.getgametype(selectgroup
											.getGroupSerialNumber());// 類型
							int i = 0;
							for (int typelist : typed) {
								String gamestype = groupservice
										.selectGameKindName(typelist);
								requesttype.put("type" + String.valueOf(i) + String.valueOf(b),	gamestype);
								i++;
							}
							// 取時間↓
							Date starttime = selectgroup.getReserveGroupStartTime();
							requesttime.put("time" + String.valueOf(c), String.valueOf(starttime));
	
						}//end of if (Groupdesc < 10)
						w++;
						x++;
						y++;
						z++;
						a++;
						b++;
						c++;
						
					}//end of for (Integer list : selectgroupdesc)
					RequestDispatcher rd = request.getRequestDispatcher("LookForGroup.jsp");
					rd.forward(request, response);
					
				}// end of if (gamenumber.equals("10人以下"))
				
				if (gamenumber.equals("10至20人")) {
					int type = 1;
					List<Integer> selectgroupdesc = groupservice
							.sequenceandselecttypedesc(type);

					for (Integer groupRoomId : selectgroupdesc) {
						// System.out.print("團序號:" + list + " ");//get順序
						
						
						
						requestimage.put("simpleimage" +String.valueOf(y), groupRoomId);
						
						int Groupdesc = groupservice.countGroupRoomsByGroupSerialNumber(groupRoomId);
						if (Groupdesc >=10 && Groupdesc <20) {
							GroupRoom selectgroup = groupservice
									.getOneGroupRoom(groupRoomId);
							System.out.println(selectgroup
									.getGroupSerialNumber());
							
							//取專賣店名
							String mese = selectgroup.getStoreName();
							storename.put("simplemese" + String.valueOf(w), mese);
							
							//遊戲名
							List<GroupChoiceGames> gamenames = groupservice.getBoardGameNames(groupRoomId);
							gamename.put("simplegamename" + String.valueOf(x), gamenames);
							
							//取團名↓
							String groupname = selectgroup.getGroupRoomName();
							requestgroupname.put("simplegroupgroupname"+String.valueOf(z), groupname);
							

							// 取人數↓
							int count = groupservice.countGroupRoomsByGroupSerialNumber(selectgroup);
							
							requestnumberofpeople.put("peoplenumber" + String.valueOf(a), String.valueOf(count));
							
							// 取類型↓
							List<Integer> typed = groupservice
									.getgametype(selectgroup
											.getGroupSerialNumber());// 類型
							int i = 0;
							for (int typelist : typed) {
								String gamestype = groupservice
										.selectGameKindName(typelist);
								requesttype.put("type" + String.valueOf(i) + String.valueOf(b),	gamestype);
								i++;
							}
							// 取時間↓
							Date starttime = selectgroup.getReserveGroupStartTime();
							requesttime.put("time" + String.valueOf(c), String.valueOf(starttime));
	
						}//end of if (Groupdesc >=10 && Groupdesc <20)
						w++;
						x++;
						y++;
						z++;
						a++;
						b++;
						c++;
						
					}//end of for (Integer list : selectgroupdesc)
					RequestDispatcher rd = request.getRequestDispatcher("LookForGroup.jsp");
					rd.forward(request, response);
					
				}// end of if (gamenumber.equals("10至20人"))
				
				if (gamenumber.equals("20人以上")) {
					int type = 1;
					List<Integer> selectgroupdesc = groupservice
							.sequenceandselecttypedesc(type);

					for (Integer groupRoomId : selectgroupdesc) {
						// System.out.print("團序號:" + list + " ");//get順序
						
						
						
						requestimage.put("simpleimage" +String.valueOf(y), groupRoomId);
						
						int Groupdesc = groupservice.countGroupRoomsByGroupSerialNumber(groupRoomId);
						if (Groupdesc >=20) {
							GroupRoom selectgroup = groupservice
									.getOneGroupRoom(groupRoomId);
							System.out.println(selectgroup
									.getGroupSerialNumber());
							
							//取專賣店名
							String mese = selectgroup.getStoreName();
							storename.put("simplemese" + String.valueOf(w), mese);
							
							//遊戲名
							List<GroupChoiceGames> gamenames = groupservice.getBoardGameNames(groupRoomId);
							gamename.put("simplegamename" + String.valueOf(x), gamenames);
							
							//取團名↓
							String groupname = selectgroup.getGroupRoomName();
							requestgroupname.put("simplegroupgroupname"+String.valueOf(z), groupname);
							

							// 取人數↓
							int count = groupservice.countGroupRoomsByGroupSerialNumber(selectgroup);
							
							requestnumberofpeople.put("peoplenumber" + String.valueOf(a), String.valueOf(count));
							
							// 取類型↓
							List<Integer> typed = groupservice
									.getgametype(selectgroup
											.getGroupSerialNumber());// 類型
							int i = 0;
							for (int typelist : typed) {
								String gamestype = groupservice
										.selectGameKindName(typelist);
								requesttype.put("type" + String.valueOf(i) + String.valueOf(b),	gamestype);
								i++;
							}
							// 取時間↓
							Date starttime = selectgroup.getReserveGroupStartTime();
							requesttime.put("time" + String.valueOf(c), String.valueOf(starttime));
	
						}//end of if (Groupdesc >=20)
						w++;
						x++;
						y++;
						z++;
						a++;
						b++;
						c++;
						
					}//end of for (Integer list : selectgroupdesc)
					RequestDispatcher rd = request.getRequestDispatcher("LookForGroup.jsp");
					rd.forward(request, response);
					
				}// end of if (gamenumber.equals("20人以上"))
				
			}// end of if (gametype.equals("角色扮演遊戲")) 
			
			if (gametype.equals("小品遊戲")) {
				if (gamenumber.equals("10人以下")) {
					int type = 5;
					List<Integer> selectgroupdesc = groupservice
							.sequenceandselecttypedesc(type);

					for (Integer groupRoomId : selectgroupdesc) {
						// System.out.print("團序號:" + list + " ");//get順序
						
						
						
						requestimage.put("simpleimage" +String.valueOf(y), groupRoomId);
						
						int Groupdesc = groupservice.countGroupRoomsByGroupSerialNumber(groupRoomId);
						if (Groupdesc < 10) {
							GroupRoom selectgroup = groupservice
									.getOneGroupRoom(groupRoomId);
							System.out.println(selectgroup
									.getGroupSerialNumber());
							
							//取專賣店名
							String mese = selectgroup.getStoreName();
							storename.put("simplemese" + String.valueOf(w), mese);
							
							//遊戲名
							List<GroupChoiceGames> gamenames = groupservice.getBoardGameNames(groupRoomId);
							gamename.put("simplegamename" + String.valueOf(x), gamenames);
							
							//取團名↓
							String groupname = selectgroup.getGroupRoomName();
							requestgroupname.put("simplegroupgroupname"+String.valueOf(z), groupname);
							

							// 取人數↓
							int count = groupservice.countGroupRoomsByGroupSerialNumber(selectgroup);
							
							requestnumberofpeople.put("peoplenumber" + String.valueOf(a), String.valueOf(count));
							
							// 取類型↓
							List<Integer> typed = groupservice
									.getgametype(selectgroup
											.getGroupSerialNumber());// 類型
							int i = 0;
							for (int typelist : typed) {
								String gamestype = groupservice
										.selectGameKindName(typelist);
								requesttype.put("type" + String.valueOf(i) + String.valueOf(b),	gamestype);
								i++;
							}
							// 取時間↓
							Date starttime = selectgroup.getReserveGroupStartTime();
							requesttime.put("time" + String.valueOf(c), String.valueOf(starttime));
	
						}//end of if (Groupdesc < 10)
						w++;
						x++;
						y++;
						z++;
						a++;
						b++;
						c++;
						
					}//end of for (Integer list : selectgroupdesc)
					RequestDispatcher rd = request.getRequestDispatcher("LookForGroup.jsp");
					rd.forward(request, response);
					
				}// end of if (gamenumber.equals("10人以下"))
				
				if (gamenumber.equals("10至20人")) {
					int type = 1;
					List<Integer> selectgroupdesc = groupservice
							.sequenceandselecttypedesc(type);

					for (Integer groupRoomId : selectgroupdesc) {
						// System.out.print("團序號:" + list + " ");//get順序
						
						
						
						requestimage.put("simpleimage" +String.valueOf(y), groupRoomId);
						
						int Groupdesc = groupservice.countGroupRoomsByGroupSerialNumber(groupRoomId);
						if (Groupdesc >=10 && Groupdesc <20) {
							GroupRoom selectgroup = groupservice
									.getOneGroupRoom(groupRoomId);
							System.out.println(selectgroup
									.getGroupSerialNumber());
							
							//取專賣店名
							String mese = selectgroup.getStoreName();
							storename.put("simplemese" + String.valueOf(w), mese);
							
							//遊戲名
							List<GroupChoiceGames> gamenames = groupservice.getBoardGameNames(groupRoomId);
							gamename.put("simplegamename" + String.valueOf(x), gamenames);
							
							//取團名↓
							String groupname = selectgroup.getGroupRoomName();
							requestgroupname.put("simplegroupgroupname"+String.valueOf(z), groupname);
							

							// 取人數↓
							int count = groupservice.countGroupRoomsByGroupSerialNumber(selectgroup);
							
							requestnumberofpeople.put("peoplenumber" + String.valueOf(a), String.valueOf(count));
							
							// 取類型↓
							List<Integer> typed = groupservice
									.getgametype(selectgroup
											.getGroupSerialNumber());// 類型
							int i = 0;
							for (int typelist : typed) {
								String gamestype = groupservice
										.selectGameKindName(typelist);
								requesttype.put("type" + String.valueOf(i) + String.valueOf(b),	gamestype);
								i++;
							}
							// 取時間↓
							Date starttime = selectgroup.getReserveGroupStartTime();
							requesttime.put("time" + String.valueOf(c), String.valueOf(starttime));
	
						}//end of if (Groupdesc >=10 && Groupdesc <20)
						w++;
						x++;
						y++;
						z++;
						a++;
						b++;
						c++;
						
					}//end of for (Integer list : selectgroupdesc)
					RequestDispatcher rd = request.getRequestDispatcher("LookForGroup.jsp");
					rd.forward(request, response);
					
				}// end of if (gamenumber.equals("10至20人"))
				
				if (gamenumber.equals("20人以上")) {
					int type = 1;
					List<Integer> selectgroupdesc = groupservice
							.sequenceandselecttypedesc(type);

					for (Integer groupRoomId : selectgroupdesc) {
						// System.out.print("團序號:" + list + " ");//get順序
						
						
						
						requestimage.put("simpleimage" +String.valueOf(y), groupRoomId);
						
						int Groupdesc = groupservice.countGroupRoomsByGroupSerialNumber(groupRoomId);
						if (Groupdesc >=20) {
							GroupRoom selectgroup = groupservice
									.getOneGroupRoom(groupRoomId);
							System.out.println(selectgroup
									.getGroupSerialNumber());
							
							//取專賣店名
							String mese = selectgroup.getStoreName();
							storename.put("simplemese" + String.valueOf(w), mese);
							
							//遊戲名
							List<GroupChoiceGames> gamenames = groupservice.getBoardGameNames(groupRoomId);
							gamename.put("simplegamename" + String.valueOf(x), gamenames);
							
							//取團名↓
							String groupname = selectgroup.getGroupRoomName();
							requestgroupname.put("simplegroupgroupname"+String.valueOf(z), groupname);
							

							// 取人數↓
							int count = groupservice.countGroupRoomsByGroupSerialNumber(selectgroup);
							
							requestnumberofpeople.put("peoplenumber" + String.valueOf(a), String.valueOf(count));
							
							// 取類型↓
							List<Integer> typed = groupservice
									.getgametype(selectgroup
											.getGroupSerialNumber());// 類型
							int i = 0;
							for (int typelist : typed) {
								String gamestype = groupservice
										.selectGameKindName(typelist);
								requesttype.put("type" + String.valueOf(i) + String.valueOf(b),	gamestype);
								i++;
							}
							// 取時間↓
							Date starttime = selectgroup.getReserveGroupStartTime();
							requesttime.put("time" + String.valueOf(c), String.valueOf(starttime));
	
						}//end of if (Groupdesc >=20)
						w++;
						x++;
						y++;
						z++;
						a++;
						b++;
						c++;
						
					}//end of for (Integer list : selectgroupdesc)
					RequestDispatcher rd = request.getRequestDispatcher("LookForGroup.jsp");
					rd.forward(request, response);
					
				}// end of if (gamenumber.equals("20人以上"))
				
			}// end of if (gametype.equals("小品遊戲")) 
		}//end of if (gametime.equals("最遠→最近"))
		
		
		
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
		
		}//end of if else (!gamenamesearch.equals(null))
	}
}
