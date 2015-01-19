package model.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import model.BoardGames;
import model.StoreInformation;
import model.Interface.BoardGamesDAO_Interface;
import model.Interface.StoreInformationDAO_Interface;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SaveImageToDB {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"model-config1-DriverManagerDataSource.xml");
		BoardGamesDAO_Interface dao = (BoardGamesDAO_Interface) context
				.getBean("BoardGamesDAO");
		// 把桌遊全部到出來
		List<BoardGames> list = dao.getAll();
		List<String> errorFileName = new ArrayList<String>();
		for (BoardGames vo : list) {
			try {
				File file = new File("WebContent/res/BoardGames/"
						+ vo.getImgFileName());
				InputStream is = new FileInputStream(file);
				ByteArrayOutputStream buffer = new ByteArrayOutputStream();
				int nRead;
				byte[] data = new byte[1024];
				while ((nRead = is.read(data, 0, data.length)) != -1) {
					buffer.write(data, 0, nRead);
					buffer.flush();
				}
				data = buffer.toByteArray();
				is.close();
				vo.setBoardGameImage(data);
			} catch (IOException e) {
				errorFileName.add(vo.getImgFileName());
			}
			dao.update(vo);
		}
		for (String s : errorFileName) {
			System.out.println("找不到圖片:"+s);
		}
		System.out.println("新增桌遊圖片完畢");
	}
}
