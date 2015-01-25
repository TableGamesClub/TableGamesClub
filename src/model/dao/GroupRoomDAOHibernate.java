package model.dao;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;

import model.GroupChoiceGames;
import model.GroupRoom;
import model.GroupRoom_Info;
import model.GroupRoom_Message;
import model.Joiner_Info;
import model.Member;
import model.StoreInformation;
import model.StoreMember;
import model.Interface.GroupRoomDAO_Interface;
import model.Interface.MemberDAO_Interface;
import model.Interface.StoreInformationDAO_Interface;
import model.Interface.StoreMemberDAO_Interface;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import sun.print.resources.serviceui;

public class GroupRoomDAOHibernate implements GroupRoomDAO_Interface {
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	private static final String GET_BY_STARTTIMEDESC = "from GroupRoom order by groupStartTime desc";
	@Override
	public List<GroupRoom> sequencestarttimedesc(GroupRoom bean){
		List<GroupRoom> list = hibernateTemplate.find(GET_BY_STARTTIMEDESC);
		return list;
	};
	
	
	private static final String GET_BY_STARTTIME = "from GroupRoom order by groupStartTime";
	
	public List<GroupRoom> sequencestarttime(GroupRoom bean){
		List<GroupRoom> list = hibernateTemplate.find(GET_BY_STARTTIME);
		return list;
	}
	
	@Override
	public GroupRoom findByPrimeKey(Integer groupSerialNumber) {
		GroupRoom groupRoom = (GroupRoom) hibernateTemplate.get(
				GroupRoom.class, groupSerialNumber);
		return groupRoom;
	}

	@Override
	public List<GroupRoom> findByGroupRoomName(String groupRoomName) {
		GroupRoom groupRoom = new GroupRoom();
		groupRoom.setGroupRoomName(groupRoomName);
		List<GroupRoom> list = hibernateTemplate.findByExample(groupRoom);
		return list;
	}

	private static final String GET_BY_UNKNOWN = "from GroupRoom where storeName like ? or groupRoomName like ? order by groupSerialNumber";

	@Override
	public List<GroupRoom> findByUnknown(String unknown) {
		String[] unknownQuery = { "%" + unknown + "%", "%" + unknown + "%" };
		List<GroupRoom> list = hibernateTemplate.find(GET_BY_UNKNOWN,
				unknownQuery);
		return list;
	}

	private static final String GET_BY_MEMBERID = "from GroupRoom where memberId = ? order by groupSerialNumber";
	
	@Override
	public List<GroupRoom> findByMemberId(Integer memberId) {
		List<GroupRoom> list = hibernateTemplate
				.find(GET_BY_MEMBERID, memberId);
		return list;
	}

	private static final String GET_ALL_STMT = "from GroupRoom order by groupSerialNumber";

	@Override
	public List<GroupRoom> getAll() {
		List<GroupRoom> list = hibernateTemplate.find(GET_ALL_STMT);
		return list;
	}

	@Override
	public void insert(GroupRoom bean) {
		hibernateTemplate.saveOrUpdate(bean);
	}

	@Override
	public void update(GroupRoom bean) {
		hibernateTemplate.saveOrUpdate(bean);
	}

	@Override
	public void delete(Integer groupSerialNumber) {
		GroupRoom groupRoom = (GroupRoom) hibernateTemplate.get(
				GroupRoom.class, groupSerialNumber);
		hibernateTemplate.delete(groupRoom);
	}

	public static void main(String[] args) {
		// GroupRoomDAO_Interface dao = new GroupRoomDAOHibernate();
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"model-config1-DriverManagerDataSource.xml");
		GroupRoomDAO_Interface dao = (GroupRoomDAO_Interface) context
				.getBean("GroupRoomDAO");
		
//		GroupRoom bean = new GroupRoom();
//		List<GroupRoom> beans = dao.sequencestarttimedesc(bean);
//		for (GroupRoom vo : beans) {
//		System.out.println(vo.getGroupStartTime());
//		}
//		
//		System.out.printf("\n");
//		List<GroupRoom> beans2 = dao.sequencestarttime(bean);
//		for (GroupRoom vo : beans2) {
//		System.out.println(vo.getGroupStartTime());
//		}
		
		
		
//		// 新增
//		GroupRoom bean1 = new GroupRoom();
//		StoreMemberDAO_Interface smdao = (StoreMemberDAO_Interface) context
//				.getBean("StoreMemberDAO");
//		StoreMember smbean1 = smdao.findByPrimeKey(1);
//		bean1.setStoreMember(smbean1);
//		MemberDAO_Interface mdao = (MemberDAO_Interface) context
//				.getBean("MemberDAO");
//		Member mbean1 = mdao.findByPrimeKey(1);
//		bean1.setMember(mbean1);
//		StoreInformationDAO_Interface sidao = (StoreInformationDAO_Interface) context
//				.getBean("StoreInformationDAO");
//		StoreInformation sibean = sidao.findByPrimeKey(1);
//		bean1.setStoreName(sibean.getStoreName());
//		bean1.setGroupStartTime(java.sql.Date.valueOf("2014-12-24"));
//		bean1.setGroupEndTime(java.sql.Date.valueOf("2014-12-31"));
//		bean1.setGroupRoomName("一起打桌遊八!");
//		bean1.setGroupSuggestNumber("6-15");
//		bean1.setGroupString("rwejnewrgghieuhgieurghuewhguoeguioergouierjhoigherughuerhguerhgurehguerhugheruigherughuehgueah iioe hgihgio hgoi");
//		bean1.setGroupLowerLimit(6);
//		bean1.setGroupUpperLimit(15);
//		bean1.setGroupGameTime(java.sql.Time.valueOf("03:00:00"));
//		bean1.setReserveGroupStartTime(java.sql.Timestamp
//				.valueOf("2015-1-1 13:00:00"));
//		bean1.setReserveGroupEndTime(java.sql.Timestamp
//				.valueOf("2015-1-1 16:00:00"));
//		bean1.setRoomState(0);
//		String filename1 = "boardgames.jpg";
//		bean1.setImgFileName(filename1);
//		File f = new File("WebContent/res/" + bean1.getImgFileName());
//		try {
//			InputStream is = new FileInputStream(f);
//			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
//			int nRead;
//			byte[] data = new byte[1024];
//			while ((nRead = is.read(data, 0, data.length)) != -1) {
//				buffer.write(data, 0, nRead);
//				buffer.flush();
//			}
//			data = buffer.toByteArray();
//			is.close();
//			bean1.setPrivateGroupImage(data);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		dao.insert(bean1);
//		// 修改
//		// 刪除
//		// 查詢單筆
//		System.out.println(dao.findByPrimeKey(1).getMember().getUsername());
//		// 查詢多筆
//		List<GroupRoom> beans = dao.getAll();
//		for (GroupRoom vo : beans) {
//			System.out.println(vo.getGroupStartTime());
//			System.out.println(vo.getGroupEndTime());
//			System.out.println(new java.sql.Time(vo.getGroupGameTime()
//					.getTime()));
//			System.out.println(vo.getGroupGameTime());
//			System.out.println(vo.getReserveGroupStartTime());
//			System.out.println(vo.getReserveGroupEndTime());
//		}
		
		//-------------------向軒測試---------------------
		// 新增
//		GroupRoom bean1 = new GroupRoom();
//		StoreMemberDAO_Interface smdao = (StoreMemberDAO_Interface) context
//				.getBean("StoreMemberDAO");
//		StoreMember smbean1 = smdao.findByPrimeKey(1);
//		bean1.setStoreMember(smbean1);
//		MemberDAO_Interface mdao = (MemberDAO_Interface) context
//				.getBean("MemberDAO");
//		Member mbean1 = mdao.findByPrimeKey(1);
//		bean1.setMember(mbean1);
//		StoreInformationDAO_Interface sidao = (StoreInformationDAO_Interface) context
//				.getBean("StoreInformationDAO");
//		StoreInformation sibean = sidao.findByPrimeKey(1);
//		bean1.setStoreName(sibean.getStoreName());
//		bean1.setGroupStartTime(java.sql.Date.valueOf("2014-12-24"));
//		bean1.setGroupEndTime(java.sql.Date.valueOf("2014-12-31"));
//		bean1.setGroupRoomName("一起打桌遊八!");
//		bean1.setGroupSuggestNumber("6-15");
//		bean1.setGroupString("rwejnewrgghieuhgieurghuewhguoeguioergouierjhoigherughuerhguerhgurehguerhugheruigherughuehgueah iioe hgihgio hgoi");
//		bean1.setGroupLowerLimit(6);
//		bean1.setGroupUpperLimit(15);
//		bean1.setGroupGameTime(java.sql.Time.valueOf("03:00:00"));
//		bean1.setReserveGroupStartTime(java.sql.Timestamp
//				.valueOf("2015-1-1 13:00:00"));
//		bean1.setReserveGroupEndTime(java.sql.Timestamp
//				.valueOf("2015-1-1 16:00:00"));
//		bean1.setRoomState(0);
//		String filename1 = "boardgames.jpg";
//		bean1.setImgFileName(filename1);
//		File f = new File("WebContent/res/" + bean1.getImgFileName());
//		try {
//			InputStream is = new FileInputStream(f);
//			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
//			int nRead;
//			byte[] data = new byte[1024];
//			while ((nRead = is.read(data, 0, data.length)) != -1) {
//				buffer.write(data, 0, nRead);
//				buffer.flush();
//			}
//			data = buffer.toByteArray();
//			is.close();
//			bean1.setPrivateGroupImage(data);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		dao.insert(bean1);
		// 修改
		// 刪除
		dao.delete(1013);
		// 查詢單筆
//		Member mem = dao.findByPrimeKey(1).getMember();
//		System.out.println(mem.getUsername());
		// 查詢多筆
//		List<GroupRoom> beans = dao.getAll();
//		for (GroupRoom vo : beans) {
//			System.out.println(vo.getGroupStartTime());
//			System.out.println(vo.getGroupEndTime());
//			System.out.println(new java.sql.Time(vo.getGroupGameTime()
//					.getTime()));
//			System.out.println(vo.getGroupGameTime());
//			System.out.println(vo.getReserveGroupStartTime());
//			System.out.println(vo.getReserveGroupEndTime());
//		}
		
		
		//-------------------建霖測試---------------------	
		
//		findbyname
//		List<GroupRoom> list = dao.findByGroupRoomName("一起打桌遊八!");
//		for(GroupRoom bean : list){
//			System.out.println(bean.getGroupSerialNumber());
//		}
	}//end of main


	@Override
	public Set<GroupRoom_Info> getGroupRoom_InfoByGroupSerialNumber(
			Integer groupSerialNumber) {
		Set<GroupRoom_Info> set = findByPrimeKey(groupSerialNumber)
				.getGroupRoomInfos();
		return set;
	}

	@Override
	public Set<Joiner_Info> getJoiner_InfoByGroupSerialNumber(
			Integer groupSerialNumber) {
		Set<Joiner_Info> set = findByPrimeKey(groupSerialNumber)
				.getJoinerInfos();
		return set;
	}

	@Override
	public Set<GroupRoom_Message> getGroupRoom_MessageByGroupSerialNumber(
			Integer groupSerialNumber) {
		Set<GroupRoom_Message> set = findByPrimeKey(groupSerialNumber)
				.getGroupRoomMessages();
		return set;
	}

	@Override
	public Set<GroupChoiceGames> getGroupChoiceGamesByGroupSerialNumber(
			Integer groupSerialNumber) {
		Set<GroupChoiceGames> set = findByPrimeKey(groupSerialNumber)
				.getGroupChoiceGameses();
		return set;
	}
}
