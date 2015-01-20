package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

import model.StoreMember;
import model.Interface.StoreMemberDAO_Interface;
import model.dao.StoreMemberDAOHibernate;
import model.service.StoreMemberService;

@WebServlet("/StoreMemberLoginServlet.do")
public class StoreMemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 設定輸入資料的編碼
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		// 準備存放錯誤訊息的Map物件
		Map<String, String> errorMsgMap = new HashMap<String, String>();
		Map<String, String> msgOK = new HashMap<String, String>();
		// 將errorMsgMap放入request物件內，識別字串為 "ErrorMsgKey"
		request.setAttribute("ErrorMsgKey", errorMsgMap);
		session.setAttribute("MsgOK", msgOK); // 顯示常訊息

		// 讀取使用者所輸入，由瀏覽器送來的 mId 欄位內的資料，注意大小寫
		String storename = request.getParameter("storename");
		// 讀取使用者所輸入，由瀏覽器送來的 pswd 欄位內的資料，注意大小寫
		String storepassword = request.getParameter("storepassword");

		StoreMember storemem = new StoreMember();
		 storemem.setStoreUsername(storename);
		storemem.setStorePswd(storepassword.getBytes());

		// 前端登入是否跟database裡面的資料相符合(只比密碼)
		StoreMemberService sms = new StoreMemberService();
		if (sms.login(storemem)) {
			System.out.printf("true");
			// 抓現在日期時間
			java.util.Date utilDate = java.util.Calendar.getInstance().getTime();
			SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String JoinDate = sdFormat.format(utilDate);
			session.setAttribute("JoinDate", JoinDate);
			List<StoreMember> list = sms.findByUsername(storemem);
			if (list != null) {
				for (StoreMember vo : list) {
					session.setAttribute("storemem", vo);
					response.sendRedirect("StoreMemberInformation.jsp");
				}
			} else{
				System.out.println("喔喔糟糕!");
			}
		} else {
			System.out.printf("false");
			errorMsgMap.put("AccountError", "帳號錯誤");
			errorMsgMap.put("Passwordrror", "密碼錯誤");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}
}
