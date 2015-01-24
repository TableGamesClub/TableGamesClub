package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.service.GroupService;

@WebServlet("/StoreMemberCancelGroupServlet")
public class StoreMemberCancelGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// System.out.println("哈哈");
		// 設定輸入資料的編碼
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		// 準備存放錯誤訊息的Map物件
		Map<String, String> errorMsgMap = new HashMap<String, String>();
		Map<String, String> msgOK = new HashMap<String, String>();
		// 將errorMsgMap放入request物件內，識別字串為 "ErrorMsgKey"
		request.setAttribute("ErrorMsgKey", errorMsgMap);
		session.setAttribute("MsgOK", msgOK); // 顯示常訊息
		
		String roomId = request.getParameter("cancelbt00");
//		System.out.println(roomId);
		
		if(roomId!=null){
			int roomId_Int = Integer.valueOf(roomId);
			GroupService service = new GroupService();
			
			try {
				service.deleteGroupRoom(roomId_Int);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("刪除出現錯誤，發生在/TableGamesClub/src/controller/StoreMemberCancelGroupServlet.java");
			}
			response.sendRedirect("/TableGamesClub/cancel-store-group-success.jsp");
			return;
		} else{
			response.sendRedirect("StoreMember-GroupInformation.jsp");
			return;
		}
	}
}
