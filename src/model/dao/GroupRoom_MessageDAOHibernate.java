package model.dao;

import java.util.List;

import model.GroupRoom;
import model.GroupRoom_Message;
import model.Member;
import model.StoreInformation;
import model.Interface.GroupRoomDAO_Interface;
import model.Interface.GroupRoom_MessageDAO_Interface;
import model.Interface.MemberDAO_Interface;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class GroupRoom_MessageDAOHibernate implements
		GroupRoom_MessageDAO_Interface {
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public GroupRoom_Message findByPrimeKey(Integer groupRoomMessageSerialNumber) {
		GroupRoom_Message groupRoomMessage = (GroupRoom_Message) hibernateTemplate
				.get(GroupRoom_Message.class, groupRoomMessageSerialNumber);
		return groupRoomMessage;
	}

	private static final String GET_ALL_STMT = "from GroupRoomMessage order by groupSerialNumber";

	@Override
	public List<GroupRoom_Message> getAll() {
		List<GroupRoom_Message> list = hibernateTemplate.find(GET_ALL_STMT);
		return list;
	}

	@Override
	public void insert(GroupRoom_Message bean) {
		hibernateTemplate.saveOrUpdate(bean);
	}

	@Override
	public void update(GroupRoom_Message bean) {
		hibernateTemplate.saveOrUpdate(bean);
	}

	@Override
	public void delete(Integer groupRoomMessageSerialNumber) {
		GroupRoom_Message groupRoomMessage = (GroupRoom_Message) hibernateTemplate
				.get(GroupRoom_Message.class, groupRoomMessageSerialNumber);
		hibernateTemplate.delete(groupRoomMessage);
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"model-config1-DriverManagerDataSource.xml");
		GroupRoom_MessageDAO_Interface dao = (GroupRoom_MessageDAO_Interface) context
				.getBean("GroupRoom_MessageDAO");
		// 新增
		GroupRoom_Message bean = new GroupRoom_Message();
		
		GroupRoomDAO_Interface grdao = (GroupRoomDAO_Interface) context
				.getBean("GroupRoomDAO");
		GroupRoom sibean = grdao.findByPrimeKey(1);
		bean.setGroupRoom(sibean);
		bean.setMessageUsername("opchannel");
		bean.setMessageContents("請問團可以開的成嗎?");
		bean.setMessageTime(java.sql.Date.valueOf("2014-12-30"));
		dao.insert(bean);

		// 修改
		// 刪除
		// 查詢單筆
		// 查詢多筆
	}
}
