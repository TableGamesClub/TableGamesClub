package controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GroupRoom;
import model.service.GroupService;


@WebServlet("/SelectLookForGroupServlet")
public class SelectLookForGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SelectLookForGroupServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		GroupService groupservice = new GroupService();
//		List<GroupRoom> desclist = new ArrayList<GroupRoom>();
		
		// 圖片識別ID
		Map<String, Integer> requestimage = new HashMap<String, Integer>();
		request.setAttribute("requestimage", requestimage);

		// 存取團名
		Map<String, String> requestgroupname = new HashMap<String, String>();
		request.setAttribute("requestgroupname", requestgroupname);
		
		// 存放人數
		Map<String, String> requestnumberofpeople = new HashMap<String, String>();
		request.setAttribute("numberofpeople", requestnumberofpeople);

		// 存放類型
		Map<String, String> requesttype = new HashMap<String, String>();
		request.setAttribute("requestype", requesttype);

		// 存放時間
		Map<String, String> requesttime = new HashMap<String, String>();
		request.setAttribute("requesttype", requesttime);
		int y = 0;
		int z = 0;
		int a = 0;
		int b = 0;
		int c = 0;
		
		
		List<GroupRoom> selectgroupdesc = groupservice.getAll();
		for(GroupRoom all : selectgroupdesc){
			int list  = all.getGroupSerialNumber();
			
			requestimage.put("simpleimage" +String.valueOf(y), list);
//			int Groupdesc = groupservice.countGroupRoomsByGroupSerialNumber(list);
			
			
			GroupRoom selectgroup = groupservice.getOneGroupRoom(list);
			System.out.println(selectgroup.getGroupSerialNumber());
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
			
			y++;
			z++;
			a++;
			b++;
			c++;
		}
		RequestDispatcher rd = request.getRequestDispatcher("LookForGroup.jsp");
		rd.forward(request, response);
		
		
		
		
		

	}

}