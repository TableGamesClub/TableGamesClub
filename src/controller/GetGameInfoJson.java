package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.json.simple.JSONArray;


//import org.json.JSONArray;




import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.BoardGames;
import model.StoreInformation;
import model.Interface.BoardGamesDAO_Interface;
import model.service.StoreMemberService;



@WebServlet("/GetGameInfoJson")
public class GetGameInfoJson extends HttpServlet {
	
	public GetGameInfoJson(){
		super();
	}

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		StoreMemberService service = new StoreMemberService();
		String id = request.getParameter("id");
		JSONArray json = new JSONArray();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(id != null){
			int gameId = Integer.parseInt(id);
			ApplicationContext context = new ClassPathXmlApplicationContext(
					"model-config1-DriverManagerDataSource.xml");
			BoardGamesDAO_Interface dao = 
					(BoardGamesDAO_Interface) context.getBean("BoardGamesDAO");
			BoardGames game = dao.findByPrimeKey(gameId);
				System.out.println(game.getBoardGameName());
				System.out.println(game.getBoardGameNumber());
				System.out.println(game.getBoardGameExplan());
				json.add("遊戲名稱："+game.getBoardGameName());
				json.add("遊戲人數："+game.getBoardGameNumber());
				json.add("遊戲說明："+game.getBoardGameExplan());
				out.print(json);
		}
	}
}
