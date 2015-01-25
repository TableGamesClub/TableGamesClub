package controller;

import java.io.IOException;
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

import model.Member;
import model.service.MemberService;

@WebServlet("/LoginMemberServlet.do")
public class MemberLoginServlet extends HttpServlet {
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
		String id = request.getParameter("loginId");
		// 讀取使用者所輸入，由瀏覽器送來的 pswd 欄位內的資料，注意大小寫
		String password = request.getParameter("loginpassword");
		String requestURI = (String) session.getAttribute("requestURI");

		Member mem = new Member();
		mem.setUsername(id);
		mem.setPswd(password.getBytes());
		// mem.setNickname(nickname);
		// mem.setEmail(email);
		// mem.setBirthday(birthday);
		// mem.setGender(gender);
		// mem.getJoinDate()

		// 如果 userId 欄位為空白，放一個錯誤訊息到 errorMsgMap 之內
		if (id == null || id.trim().length() == 0) {
			errorMsgMap.put("AccountEmptyError", "帳號欄必須輸入");
		}
		// 如果 password 欄位為空白，放一個錯誤訊息到 errorMsgMap 之內
		if (password == null || password.trim().length() == 0) {
			errorMsgMap.put("PasswordEmptyError", "密碼欄必須輸入");
		}

		if (!errorMsgMap.isEmpty()) {
			// System.out.println("error 111");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			return;
		}

		// 把member存進session裡, 交給上方的bar和會員個人資料存取
		MemberService login = new MemberService();
		if (login.login(mem) == true) {
			System.out.printf("true");
			List<Member> member = login.getOneMember(mem);
			for (Member bean : member) {
				// session.setAttribute("username", bean.getUsername());
				// session.setAttribute("nickname", bean.getNickname());
				session.setAttribute("Member", bean);
			}
			
			String contextPath = getServletContext().getContextPath();
			String target = (String) session.getAttribute("target");
			if(target != null){
				session.removeAttribute("target");
				response.sendRedirect(contextPath + target);
				return;
			}

			response.sendRedirect("home.jsp");
			return;
		} else {
			errorMsgMap.put("MAccountError", "帳號錯誤");
			errorMsgMap.put("MPasswordrror", "密碼錯誤");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			System.out.printf("false");
			return;
		}

	}
}
