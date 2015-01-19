package controller;

import java.io.IOException;
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

import model.BoardGameKind;
import model.GroupChoiceGames;
import model.GroupRoom;
import model.Joiner_Info;
import model.Member;
import model.Interface.BoardGameKindDAO_Interface;
import model.Interface.GroupChoiceGamesDAO_Interface;
import model.Interface.Joiner_InfoDAO_Interface;
import model.service.GroupService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@WebServlet("/MemberInfoServlet")
public class MemberInfoServlet extends HttpServlet {
	private Joiner_InfoDAO_Interface jidao;
	private GroupChoiceGamesDAO_Interface gcgdao;
	private BoardGameKindDAO_Interface bgkdao;

	private static final long serialVersionUID = 1L;

	public MemberInfoServlet() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"model-config1-DriverManagerDataSource.xml");
		// ApplicationContext context = new ClassPathXmlApplicationContext(
		// "model-config2-JndiObjectFactoryBean.xml");
		jidao = (Joiner_InfoDAO_Interface) context.getBean("Joiner_InfoDAO");
		gcgdao = (GroupChoiceGamesDAO_Interface) context
				.getBean("GroupChoiceGamesDAO");
		bgkdao = (BoardGameKindDAO_Interface) context
				.getBean("BoardGameKindDAO");
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

		Set<GroupChoiceGames> choices = null;
		List<Integer> type = null;

		Object obj = session.getAttribute("Member");
		Member mem = (Member) obj;

		if (mem != null) {

			GroupService service = new GroupService();
			List<GroupRoom> memgroupall = service.getGroupRoomsMyJoined(mem);// 查到我所加的團

			int groupSerialNumber = -1;
			int i = 0;
			int p = 0;
			Map<String, Integer> map = new HashMap<>();
			Map<String, String> typeList = new HashMap<>();
			Map<String, Set<GroupChoiceGames>> choiceGames = new HashMap<>();
			for (GroupRoom vo : memgroupall) {
				groupSerialNumber = vo.getGroupSerialNumber();// 取得每一個的團編號
				choices = vo.getGroupChoiceGameses();
				List<Joiner_Info> ji = jidao
						.findByGroupSerialNumber(groupSerialNumber);
				int count = 0;
				count = ji.size();
				// 用switch來判斷
				switch (p) {
				case 0:
					choiceGames.put("choices0", choices);
					map.put("count0", count);
					break;
				case 1:
					choiceGames.put("choices1", choices);
					map.put("count1", count);
					break;
				case 2:
					choiceGames.put("choices2", choices);
					map.put("count2", count);
					break;
				case 3:
					choiceGames.put("choices3", choices);
					map.put("count3", count);
					break;
				case 4:
					choiceGames.put("choices4", choices);
					map.put("count4", count);
					break;
				case 5:
					choiceGames.put("choices5", choices);
					map.put("count5", count);
					break;
				case 6:
					choiceGames.put("choices6", choices);
					map.put("count6", count);
					break;
				case 7:
					choiceGames.put("choices7", choices);
					map.put("count7", count);
					break;
				case 8:
					choiceGames.put("choices8", choices);
					map.put("count8", count);
					break;
				case 9:
					choiceGames.put("choices9", choices);
					map.put("count9", count);
					break;
				case 10:
					choiceGames.put("choices10", choices);
					map.put("count10", count);
					break;
				}
				p++;
				switch (i) {
				case 0:
					groupSerialNumber = vo.getGroupSerialNumber();// 取得每一個的團編號
					type = gcgdao.findByGroupSerialNumber(groupSerialNumber);// 團裡所選桌遊類型編號
					int o0 = 0;
					for (Integer t : type) {
						BoardGameKind kind = bgkdao.findByPrimeKey(t);
						switch (o0) { // 找到的類型放進typeList
						case 0:
							String kind00 = kind.getBoardGameStyle();
							typeList.put("kind00", kind00);
							break;
						case 1:
							String kind01 = kind.getBoardGameStyle();
							typeList.put("kind01", kind01);
							break;
						case 2:
							String kind02 = kind.getBoardGameStyle();
							typeList.put("kind02", kind02);
							break;
						case 3:
							String kind03 = kind.getBoardGameStyle();
							typeList.put("kind03", kind03);
							break;
						case 4:
							String kind04 = kind.getBoardGameStyle();
							typeList.put("kind04", kind04);
							break;
						case 5:
							String kind05 = kind.getBoardGameStyle();
							typeList.put("kind05", kind05);
							break;
						case 6:
							String kind06 = kind.getBoardGameStyle();
							typeList.put("kind06", kind06);
							break;
						case 7:
							String kind07 = kind.getBoardGameStyle();
							typeList.put("kind07", kind07);
							break;
						case 8:
							String kind08 = kind.getBoardGameStyle();
							typeList.put("kind08", kind08);
							break;
						case 9:
							String kind09 = kind.getBoardGameStyle();
							typeList.put("kind09", kind09);
							break;
						case 10:
							String kind10 = kind.getBoardGameStyle();
							typeList.put("kind10", kind10);
							break;
						}
						o0++;
					}
					;
					break;
				case 1:
					groupSerialNumber = vo.getGroupSerialNumber();// 取得每一個的團編號
					type = gcgdao.findByGroupSerialNumber(groupSerialNumber);// 團裡所選桌遊類型編號
					int o1 = 0;
					for (Integer t : type) {
						BoardGameKind kind = bgkdao.findByPrimeKey(t);
						switch (o1) { // 找到的類型放進typeList
						case 0:
							String kind000 = kind.getBoardGameStyle();
							typeList.put("kind000", kind000);
							break;
						case 1:
							String kind001 = kind.getBoardGameStyle();
							typeList.put("kind001", kind001);
							break;
						case 2:
							String kind002 = kind.getBoardGameStyle();
							typeList.put("kind002", kind002);
							break;
						case 3:
							String kind003 = kind.getBoardGameStyle();
							typeList.put("kind003", kind003);
							break;
						case 4:
							String kind004 = kind.getBoardGameStyle();
							typeList.put("kind004", kind004);
							break;
						case 5:
							String kind005 = kind.getBoardGameStyle();
							typeList.put("kind005", kind005);
							break;
						case 6:
							String kind006 = kind.getBoardGameStyle();
							typeList.put("kind006", kind006);
							break;
						case 7:
							String kind007 = kind.getBoardGameStyle();
							typeList.put("kind007", kind007);
							break;
						case 8:
							String kind008 = kind.getBoardGameStyle();
							typeList.put("kind008", kind008);
							break;
						case 9:
							String kind009 = kind.getBoardGameStyle();
							typeList.put("kind009", kind009);
							break;
						case 10:
							String kind010 = kind.getBoardGameStyle();
							typeList.put("kind010", kind010);
							break;
						}
						o1++;
					}
					;
					break;
				case 2:
					groupSerialNumber = vo.getGroupSerialNumber();// 取得每一個的團編號
					type = gcgdao.findByGroupSerialNumber(groupSerialNumber);// 團裡所選桌遊類型編號
					int o2 = 0;
					for (Integer t : type) {
						BoardGameKind kind = bgkdao.findByPrimeKey(t);
						switch (o2) { // 找到的類型放進typeList
						case 0:
							String kind0000 = kind.getBoardGameStyle();
							typeList.put("kind0000", kind0000);
							break;
						case 1:
							String kind0001 = kind.getBoardGameStyle();
							typeList.put("kind0001", kind0001);
							break;
						case 2:
							String kind0002 = kind.getBoardGameStyle();
							typeList.put("kind0002", kind0002);
							break;
						case 3:
							String kind0003 = kind.getBoardGameStyle();
							typeList.put("kind0003", kind0003);
							break;
						case 4:
							String kind0004 = kind.getBoardGameStyle();
							typeList.put("kind0004", kind0004);
							break;
						case 5:
							String kind0005 = kind.getBoardGameStyle();
							typeList.put("kind0005", kind0005);
							break;
						case 6:
							String kind0006 = kind.getBoardGameStyle();
							typeList.put("kind0006", kind0006);
							break;
						case 7:
							String kind0007 = kind.getBoardGameStyle();
							typeList.put("kind0007", kind0007);
							break;
						case 8:
							String kind0008 = kind.getBoardGameStyle();
							typeList.put("kind0008", kind0008);
							break;
						case 9:
							String kind0009 = kind.getBoardGameStyle();
							typeList.put("kind0009", kind0009);
							break;
						case 10:
							String kind0010 = kind.getBoardGameStyle();
							typeList.put("kind0010", kind0010);
							break;
						}
						o2++;
					}
				case 3:
					groupSerialNumber = vo.getGroupSerialNumber();// 取得每一個的團編號
					type = gcgdao.findByGroupSerialNumber(groupSerialNumber);// 團裡所選桌遊類型編號
					int o3 = 0;
					for (Integer t : type) {
						BoardGameKind kind = bgkdao.findByPrimeKey(t);
						switch (o3) { // 找到的類型放進typeList
						case 0:
							String kind00000 = kind.getBoardGameStyle();
							typeList.put("kind00000", kind00000);
							break;
						case 1:
							String kind00001 = kind.getBoardGameStyle();
							typeList.put("kind00001", kind00001);
							break;
						case 2:
							String kind00002 = kind.getBoardGameStyle();
							typeList.put("kind00002", kind00002);
							break;
						case 3:
							String kind00003 = kind.getBoardGameStyle();
							typeList.put("kind00003", kind00003);
							break;
						case 4:
							String kind00004 = kind.getBoardGameStyle();
							typeList.put("kind00004", kind00004);
							break;
						case 5:
							String kind00005 = kind.getBoardGameStyle();
							typeList.put("kind00005", kind00005);
							break;
						case 6:
							String kind00006 = kind.getBoardGameStyle();
							typeList.put("kind00006", kind00006);
							break;
						case 7:
							String kind00007 = kind.getBoardGameStyle();
							typeList.put("kind00007", kind00007);
							break;
						case 8:
							String kind00008 = kind.getBoardGameStyle();
							typeList.put("kind00008", kind00008);
							break;
						case 9:
							String kind00009 = kind.getBoardGameStyle();
							typeList.put("kind00009", kind00009);
							break;
						case 10:
							String kind00010 = kind.getBoardGameStyle();
							typeList.put("kind00010", kind00010);
							break;
						}
						o3++;
					}
					break;
				case 4:
					groupSerialNumber = vo.getGroupSerialNumber();// 取得每一個的團編號
					type = gcgdao.findByGroupSerialNumber(groupSerialNumber);// 團裡所選桌遊類型編號
					int o4 = 0;
					for (Integer t : type) {
						BoardGameKind kind = bgkdao.findByPrimeKey(t);
						switch (o4) { // 找到的類型放進typeList
						case 0:
							String kind000000 = kind.getBoardGameStyle();
							typeList.put("kind000000", kind000000);
							break;
						case 1:
							String kind000001 = kind.getBoardGameStyle();
							typeList.put("kind000001", kind000001);
							break;
						case 2:
							String kind000002 = kind.getBoardGameStyle();
							typeList.put("kind000002", kind000002);
							break;
						case 3:
							String kind000003 = kind.getBoardGameStyle();
							typeList.put("kind000003", kind000003);
							break;
						case 4:
							String kind000004 = kind.getBoardGameStyle();
							typeList.put("kind000004", kind000004);
							break;
						case 5:
							String kind000005 = kind.getBoardGameStyle();
							typeList.put("kind000005", kind000005);
							break;
						case 6:
							String kind000006 = kind.getBoardGameStyle();
							typeList.put("kind000006", kind000006);
							break;
						case 7:
							String kind000007 = kind.getBoardGameStyle();
							typeList.put("kind000007", kind000007);
							break;
						case 8:
							String kind000008 = kind.getBoardGameStyle();
							typeList.put("kind000008", kind000008);
							break;
						case 9:
							String kind000009 = kind.getBoardGameStyle();
							typeList.put("kind000009", kind000009);
							break;
						case 10:
							String kind000010 = kind.getBoardGameStyle();
							typeList.put("kind000010", kind000010);
							break;
						}
						o4++;
					}
					break;
				case 5:
					groupSerialNumber = vo.getGroupSerialNumber();// 取得每一個的團編號
					type = gcgdao.findByGroupSerialNumber(groupSerialNumber);// 團裡所選桌遊類型編號
					int o5 = 0;
					for (Integer t : type) {
						BoardGameKind kind = bgkdao.findByPrimeKey(t);
						switch (o5) { // 找到的類型放進typeList
						case 0:
							String kind0000000 = kind.getBoardGameStyle();
							typeList.put("kind0000000", kind0000000);
							break;
						case 1:
							String kind0000001 = kind.getBoardGameStyle();
							typeList.put("kind0000001", kind0000001);
							break;
						case 2:
							String kind0000002 = kind.getBoardGameStyle();
							typeList.put("kind0000002", kind0000002);
							break;
						case 3:
							String kind0000003 = kind.getBoardGameStyle();
							typeList.put("kind0000003", kind0000003);
							break;
						case 4:
							String kind0000004 = kind.getBoardGameStyle();
							typeList.put("kind0000004", kind0000004);
							break;
						case 5:
							String kind0000005 = kind.getBoardGameStyle();
							typeList.put("kind0000005", kind0000005);
							break;
						case 6:
							String kind0000006 = kind.getBoardGameStyle();
							typeList.put("kind0000006", kind0000006);
							break;
						case 7:
							String kind0000007 = kind.getBoardGameStyle();
							typeList.put("kind0000007", kind0000007);
							break;
						case 8:
							String kind0000008 = kind.getBoardGameStyle();
							typeList.put("kind0000008", kind0000008);
							break;
						case 9:
							String kind0000009 = kind.getBoardGameStyle();
							typeList.put("kind0000009", kind0000009);
							break;
						case 10:
							String kind0000010 = kind.getBoardGameStyle();
							typeList.put("kind0000010", kind0000010);
							break;
						}
						o5++;
					}
					break;
				case 6:
					groupSerialNumber = vo.getGroupSerialNumber();// 取得每一個的團編號
					type = gcgdao.findByGroupSerialNumber(groupSerialNumber);// 團裡所選桌遊類型編號
					int o6 = 0;
					for (Integer t : type) {
						BoardGameKind kind = bgkdao.findByPrimeKey(t);
						switch (o6) { // 找到的類型放進typeList
						case 0:
							String kind00000000 = kind.getBoardGameStyle();
							typeList.put("kind00000000", kind00000000);
							break;
						case 1:
							String kind00000001 = kind.getBoardGameStyle();
							typeList.put("kind00000001", kind00000001);
							break;
						case 2:
							String kind00000002 = kind.getBoardGameStyle();
							typeList.put("kind00000002", kind00000002);
							break;
						case 3:
							String kind00000003 = kind.getBoardGameStyle();
							typeList.put("kind00000003", kind00000003);
							break;
						case 4:
							String kind00000004 = kind.getBoardGameStyle();
							typeList.put("kind00000004", kind00000004);
							break;
						case 5:
							String kind00000005 = kind.getBoardGameStyle();
							typeList.put("kind00000005", kind00000005);
							break;
						case 6:
							String kind00000006 = kind.getBoardGameStyle();
							typeList.put("kind00000006", kind00000006);
							break;
						case 7:
							String kind00000007 = kind.getBoardGameStyle();
							typeList.put("kind00000007", kind00000007);
							break;
						case 8:
							String kind00000008 = kind.getBoardGameStyle();
							typeList.put("kind00000008", kind00000008);
							break;
						case 9:
							String kind00000009 = kind.getBoardGameStyle();
							typeList.put("kind00000009", kind00000009);
							break;
						case 10:
							String kind00000010 = kind.getBoardGameStyle();
							typeList.put("kind00000010", kind00000010);
							break;
						}
						o6++;
					}
					break;
				case 7:
					groupSerialNumber = vo.getGroupSerialNumber();// 取得每一個的團編號
					type = gcgdao.findByGroupSerialNumber(groupSerialNumber);// 團裡所選桌遊類型編號
					int o7 = 0;
					for (Integer t : type) {
						BoardGameKind kind = bgkdao.findByPrimeKey(t);
						switch (o7) { // 找到的類型放進typeList
						case 0:
							String kind000000000 = kind.getBoardGameStyle();
							typeList.put("kind000000000", kind000000000);
							break;
						case 1:
							String kind000000001 = kind.getBoardGameStyle();
							typeList.put("kind000000001", kind000000001);
							break;
						case 2:
							String kind000000002 = kind.getBoardGameStyle();
							typeList.put("kind000000002", kind000000002);
							break;
						case 3:
							String kind000000003 = kind.getBoardGameStyle();
							typeList.put("kind000000003", kind000000003);
							break;
						case 4:
							String kind000000004 = kind.getBoardGameStyle();
							typeList.put("kind000000004", kind000000004);
							break;
						case 5:
							String kind000000005 = kind.getBoardGameStyle();
							typeList.put("kind000000005", kind000000005);
							break;
						case 6:
							String kind000000006 = kind.getBoardGameStyle();
							typeList.put("kind000000006", kind000000006);
							break;
						case 7:
							String kind000000007 = kind.getBoardGameStyle();
							typeList.put("kind000000007", kind000000007);
							break;
						case 8:
							String kind000000008 = kind.getBoardGameStyle();
							typeList.put("kind000000008", kind000000008);
							break;
						case 9:
							String kind000000009 = kind.getBoardGameStyle();
							typeList.put("kind000000009", kind000000009);
							break;
						case 10:
							String kind000000010 = kind.getBoardGameStyle();
							typeList.put("kind000000010", kind000000010);
							break;
						}
						o7++;
					}
					break;
				case 8:
					groupSerialNumber = vo.getGroupSerialNumber();// 取得每一個的團編號
					type = gcgdao.findByGroupSerialNumber(groupSerialNumber);// 團裡所選桌遊類型編號
					int o8 = 0;
					for (Integer t : type) {
						BoardGameKind kind = bgkdao.findByPrimeKey(t);
						switch (o8) { // 找到的類型放進typeList
						case 0:
							String kind0000000000 = kind.getBoardGameStyle();
							typeList.put("kind0000000000", kind0000000000);
							break;
						case 1:
							String kind0000000001 = kind.getBoardGameStyle();
							typeList.put("kind0000000001", kind0000000001);
							break;
						case 2:
							String kind0000000002 = kind.getBoardGameStyle();
							typeList.put("kind0000000002", kind0000000002);
							break;
						case 3:
							String kind0000000003 = kind.getBoardGameStyle();
							typeList.put("kind0000000003", kind0000000003);
							break;
						case 4:
							String kind0000000004 = kind.getBoardGameStyle();
							typeList.put("kind0000000004", kind0000000004);
							break;
						case 5:
							String kind0000000005 = kind.getBoardGameStyle();
							typeList.put("kind0000000005", kind0000000005);
							break;
						case 6:
							String kind0000000006 = kind.getBoardGameStyle();
							typeList.put("kind0000000006", kind0000000006);
							break;
						case 7:
							String kind0000000007 = kind.getBoardGameStyle();
							typeList.put("kind0000000007", kind0000000007);
							break;
						case 8:
							String kind0000000008 = kind.getBoardGameStyle();
							typeList.put("kind0000000008", kind0000000008);
							break;
						case 9:
							String kind0000000009 = kind.getBoardGameStyle();
							typeList.put("kind0000000009", kind0000000009);
							break;
						case 10:
							String kind0000000010 = kind.getBoardGameStyle();
							typeList.put("kind0000000010", kind0000000010);
							break;
						}
						o8++;
					}
					break;
				case 9:
					groupSerialNumber = vo.getGroupSerialNumber();// 取得每一個的團編號
					type = gcgdao.findByGroupSerialNumber(groupSerialNumber);// 團裡所選桌遊類型編號
					int o9 = 0;
					for (Integer t : type) {
						BoardGameKind kind = bgkdao.findByPrimeKey(t);
						switch (o9) { // 找到的類型放進typeList
						case 0:
							String kind00000000000 = kind.getBoardGameStyle();
							typeList.put("kind00000000000", kind00000000000);
							break;
						case 1:
							String kind00000000001 = kind.getBoardGameStyle();
							typeList.put("kind00000000001", kind00000000001);
							break;
						case 2:
							String kind00000000002 = kind.getBoardGameStyle();
							typeList.put("kind00000000002", kind00000000002);
							break;
						case 3:
							String kind00000000003 = kind.getBoardGameStyle();
							typeList.put("kind0000000003", kind00000000003);
							break;
						case 4:
							String kind00000000004 = kind.getBoardGameStyle();
							typeList.put("kind00000000004", kind00000000004);
							break;
						case 5:
							String kind00000000005 = kind.getBoardGameStyle();
							typeList.put("kind00000000005", kind00000000005);
							break;
						case 6:
							String kind00000000006 = kind.getBoardGameStyle();
							typeList.put("kind00000000006", kind00000000006);
							break;
						case 7:
							String kind00000000007 = kind.getBoardGameStyle();
							typeList.put("kind00000000007", kind00000000007);
							break;
						case 8:
							String kind00000000008 = kind.getBoardGameStyle();
							typeList.put("kind00000000008", kind00000000008);
							break;
						case 9:
							String kind00000000009 = kind.getBoardGameStyle();
							typeList.put("kind00000000009", kind00000000009);
							break;
						case 10:
							String kind00000000010 = kind.getBoardGameStyle();
							typeList.put("kind00000000010", kind00000000010);
							break;
						}
						o9++;
					}
					break;
				case 10:
					groupSerialNumber = vo.getGroupSerialNumber();// 取得每一個的團編號
					type = gcgdao.findByGroupSerialNumber(groupSerialNumber);// 團裡所選桌遊類型編號
					int o10 = 0;
					for (Integer t : type) {
						BoardGameKind kind = bgkdao.findByPrimeKey(t);
						switch (o10) { // 找到的類型放進typeList
						case 0:
							String kind000000000000 = kind.getBoardGameStyle();
							typeList.put("kind000000000000", kind000000000000);
							break;
						case 1:
							String kind000000000001 = kind.getBoardGameStyle();
							typeList.put("kind000000000001", kind000000000001);
							break;
						case 2:
							String kind000000000002 = kind.getBoardGameStyle();
							typeList.put("kind000000000002", kind000000000002);
							break;
						case 3:
							String kind000000000003 = kind.getBoardGameStyle();
							typeList.put("kind000000000003", kind000000000003);
							break;
						case 4:
							String kind000000000004 = kind.getBoardGameStyle();
							typeList.put("kind000000000004", kind000000000004);
							break;
						case 5:
							String kind000000000005 = kind.getBoardGameStyle();
							typeList.put("kind000000000005", kind000000000005);
							break;
						case 6:
							String kind000000000006 = kind.getBoardGameStyle();
							typeList.put("kind000000000006", kind000000000006);
							break;
						case 7:
							String kind000000000007 = kind.getBoardGameStyle();
							typeList.put("kind000000000007", kind000000000007);
							break;
						case 8:
							String kind000000000008 = kind.getBoardGameStyle();
							typeList.put("kind000000000008", kind000000000008);
							break;
						case 9:
							String kind000000000009 = kind.getBoardGameStyle();
							typeList.put("kind000000000009", kind000000000009);
							break;
						case 10:
							String kind000000000010 = kind.getBoardGameStyle();
							typeList.put("kind000000000010", kind000000000010);
							break;
						}
						o10++;
					}
					break;
				}
				i++;
			}
			session.setAttribute("memgroupall", memgroupall);// 已加入的團資訊
			session.setAttribute("typeList", typeList);// 該團所選的桌遊類型
			session.setAttribute("map_count", map);// 該團已加入的人數
			session.setAttribute("choiceGames", choiceGames);

			response.sendRedirect("memberinformation.jsp");
		} else {
			response.sendRedirect("login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
