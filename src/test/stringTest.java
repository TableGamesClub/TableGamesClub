package test;

import java.util.ArrayList;
import java.util.List;

public class stringTest {
	public List<Integer> dismantle(String roomNumber){//拆房間範圍人數
		String dismantle = "~";
		List<Integer> list = new ArrayList<Integer>();
		for(String s : roomNumber.split(dismantle)){
			list.add(Integer.parseInt(s.trim()));
		}
		return list;
	}
	public static void main(String[] args) {
		String test = "15 ~ 30";
		stringTest test1 = new stringTest();
//		for(Integer s : test1.dismantle(test)){
//			System.out.println(s);
//		}
		System.out.println(test1.dismantle(test).get(0));
		
	}

}
