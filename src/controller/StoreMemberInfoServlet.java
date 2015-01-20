package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.StoreInformation;
import model.StoreMember;
import model.Interface.BoardGameKindDAO_Interface;
import model.Interface.BoardGamesDAO_Interface;
import model.Interface.GroupChoiceGamesDAO_Interface;
import model.Interface.Joiner_InfoDAO_Interface;
import model.Interface.RentalTimeDAO_Interface;
import model.Interface.StoreInformationDAO_Interface;
import model.Interface.StoreMemberDAO_Interface;
import model.Interface.StoreScoreDAO_Interface;
import model.service.StoreMemberService;

@WebServlet("/StoreMemberInfoServlet")
public class StoreMemberInfoServlet extends HttpServlet {

	private StoreMemberDAO_Interface dao1 = null;
	private StoreInformationDAO_Interface dao2 = null;
	private RentalTimeDAO_Interface dao3 = null;
	private StoreScoreDAO_Interface dao4 = null;
	private BoardGamesDAO_Interface dao5 = null;

	private static final long serialVersionUID = 1L;

	public StoreMemberInfoServlet() {
		// ApplicationContext context = new ClassPathXmlApplicationContext(
		// "model-config2-JndiObjectFactoryBean.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"model-config1-DriverManagerDataSource.xml");
		dao1 = (StoreMemberDAO_Interface) context.getBean("StoreMemberDAO");
		dao2 = (StoreInformationDAO_Interface) context
				.getBean("StoreInformationDAO");
		dao3 = (RentalTimeDAO_Interface) context.getBean("RentalTimeDAO");
		dao4 = (StoreScoreDAO_Interface) context.getBean("StoreScoreDAO");
		dao5 = (BoardGamesDAO_Interface) context.getBean("BoardGamesDAO");
	}

	protected void doGet(HttpServletRequest request,
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

		StoreMember storeMember = new StoreMember();
		// 取得session 店家會員資料
		storeMember = (StoreMember) session.getAttribute("storemem");

		if (storeMember != null) {
			// 利用店家找一下專賣店ID
			Set<StoreInformation> list = storeMember.getStoreInformations();
			List<StoreInformation> storeInfoList = new ArrayList<StoreInformation>();
			for (StoreInformation vo : list) {
				System.out.println("1");
				StoreInformation sInformation = dao2.findByPrimeKey(vo
						.getStoreId());
				storeInfoList.add(sInformation);// 裝滿店家專賣店資料
				System.out.println(sInformation.getStoreId());
				System.out.println(sInformation.getStoreName());
			}
			session.setAttribute("StoreInfoList", storeInfoList);// 放此店家所屬的多筆專賣店

			response.sendRedirect("StoreInformation.jsp");
		}else{
			response.sendRedirect("login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
