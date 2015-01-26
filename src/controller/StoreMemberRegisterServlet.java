package controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.StoreMember;
import model.service.GlobalService;
import model.service.StoreMemberService;

@WebServlet("/StoreMemberRegisterServlet")
@MultipartConfig(
		location="",
		maxFileSize=2*1024*1024,
		maxRequestSize=2*1024*1024,
		fileSizeThreshold=10*1024*1024
)
public class StoreMemberRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
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
		session.setAttribute("MsgOK", msgOK); // 顯示正常訊息



		String storeusername = "";
		String storepassword = null;
		String storepassword2 = null;
		String storephone = null;
		String storeemail = null;
		String storeaddress = null;
		String filename = null;
		long sizeInBytes = 0;
		InputStream is = null;
		Collection<Part> parts = request.getParts(); // 此方法可以取得所有表單
		if (parts != null) {
			System.out.println("進入了迴圈333333333333");
			for (Part p : parts) {
				System.out.println("進入了迴圈");
				String fldName = p.getName();
				String value = request.getParameter(fldName);
				if (p.getContentType() == null) {// 表示抓到的不是圖片
					if (fldName.equalsIgnoreCase("storememberrname")) {
						storeusername = value;
					} else if (fldName.equals("storememberpassword")) {
						storepassword = value;
					} else if (fldName.equals("storememberpassword2")){
						storepassword2 = value;
					} else if (fldName.equalsIgnoreCase("storememberphone")) {
						storephone = value;
					} else if (fldName.equalsIgnoreCase("storememberemail")) {
						storeemail = value;
					} else if (fldName.equalsIgnoreCase("storememberaddress")) {
						storeaddress = value;
					} 
				}else {
					filename = GlobalService.getFileName(p); // 此為圖片檔的檔名
					if (filename != null && filename.trim().length() > 0) {
						sizeInBytes = p.getSize();
						is = p.getInputStream();
					} else {
						errorMsgMap.put("errPicture", "必須挑選圖片檔");
					}//end of errorMsgMap.put("errPicture", "必須挑選圖片檔");
				}//end of 處理圖片
			}//end of for迴圈
			// 2. 進行必要的資料轉換
			// 3. 檢查使用者輸入資料
			if (storeusername == null || storeusername.trim().length() == 0) {
				errorMsgMap.put("errorstoreUserNameEmpty", "帳號欄必須輸入");
			}
			if (storepassword == null || storepassword.trim().length() == 0){
				errorMsgMap.put("errorstorePasswordEmpty", "密碼欄必須輸入");
			}
			if (storepassword2 == null || storepassword2.trim().length() == 0){
				errorMsgMap.put("errorstorePasswordEmpty2", "確認密碼欄必須輸入");
			}
//			if (storepassword.trim().length() > 0 && storepassword2.trim().length() > 0) {
//				if (!storepassword.trim().equals(storepassword2.trim())) {
//					errorMsgMap.put("errorstorePassword2Empty", "密碼欄必須與確認欄一致");
//					errorMsgMap.put("errorstorePasswordEmpty", "*");
//				} else {
//					storepassword = storepassword2.trim();
//				}
//			}
			if(storephone == null || storephone.trim().length() == 0){
				errorMsgMap.put("errorstorePhoneEmpty", "手機欄必須輸入");
			}
			if(storeemail == null || storeemail.trim().length() == 0){
				errorMsgMap.put("errorstoreEmailEmpty", "信箱欄必須輸入");
			}
			if(storeaddress == null || storeaddress.trim().length() == 0){
				errorMsgMap.put("errorstoreAddressEmpty", "地址欄必須輸入");
			}
		}else {
			errorMsgMap.put("errTitle", "此表單不是上傳檔案的表單");
		}//end of if (parts != null)
		
		if (!errorMsgMap.isEmpty()) {
			// 導向原來輸入資料的畫面，這次會顯示錯誤訊息
			RequestDispatcher rd = request
					.getRequestDispatcher("register.jsp");
			rd.forward(request, response);
			return;
		}//end of if (!errorMsgMap.isEmpty())
		
		
		StoreMember storemember = new StoreMember();
		storemember.setStoreUsername(storeusername);
		storemember.setStorePswd(storepassword.getBytes());
		storemember.setStorePhone(storephone);
		storemember.setStoreEmail(storeemail);
		storemember.setStoreWebsite(storeaddress);
		storemember.setImgFileName(filename);
		try {
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			int nRead;
			byte[] data = new byte[1024];
			while ((nRead = is.read(data, 0, data.length)) != -1) {
				buffer.write(data, 0, nRead);
				buffer.flush();
			}
			data = buffer.toByteArray();
			is.close();
			storemember.setStoreImage(data);
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("輸入異常:發生於 RegisterServletMB");
		}
		
		StoreMemberService storememberservice = new StoreMemberService();
		List<StoreMember> successinsertstoremember = storememberservice.register(storemember);
		if(successinsertstoremember != null){
			System.out.printf("true");
			session.setAttribute("username", storemember.getStoreUsername());
			response.sendRedirect("registersuccess.jsp");
		}
		else{ errorMsgMap.put("errorUserNameDup","新增此筆資料有誤(RegisterServletMB)");
		}
		
		if (!errorMsgMap.isEmpty()) {
			// 導向原來輸入資料的畫面，這次會顯示錯誤訊息
			RequestDispatcher rd = request
					.getRequestDispatcher("register.jsp");
			rd.forward(request, response);
			return;
		}
		
		
		
		
	}//end of doPost
}//end of class
