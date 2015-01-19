package model.dao;

import java.util.List;

import model.GroupRoom_Info;
import model.Interface.GroupRoom_InfoDAO_Interface;
import model.Interface.GroupRoom_MessageDAO_Interface;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class GroupRoom_InfoDAOHibernate implements GroupRoom_InfoDAO_Interface {
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public GroupRoom_Info findByPrimeKey(Integer groupPictureSerialNumber) {
		GroupRoom_Info groupRoomInfo = (GroupRoom_Info) hibernateTemplate.get(
				GroupRoom_Info.class, groupPictureSerialNumber);
		return groupRoomInfo;
	}

	private static final String GET_BY_GROUPSERIALNUMBER = "from GroupRoomInfo where groupSerialNumber = ? order by groupPictureSerialNumber";

	@Override
	public List<GroupRoom_Info> findByGroupSerialNumber(
			Integer groupSerialNumber) {
		List<GroupRoom_Info> list = hibernateTemplate.find(
				GET_BY_GROUPSERIALNUMBER, groupSerialNumber);
		return list;
	}

	private static final String GET_ALL_STMT = "from GroupRoomInfo order by groupPictureSerialNumber";

	@Override
	public List<GroupRoom_Info> getAll() {
		List<GroupRoom_Info> list = hibernateTemplate.find(GET_ALL_STMT);
		return list;
	}

	@Override
	public void insert(GroupRoom_Info bean) {
		hibernateTemplate.saveOrUpdate(bean);
	}

	@Override
	public void update(GroupRoom_Info bean) {
		hibernateTemplate.saveOrUpdate(bean);
	}

	@Override
	public void delete(Integer groupPictureSerialNumber) {
		GroupRoom_Info groupRoomInfo = (GroupRoom_Info) hibernateTemplate.get(
				GroupRoom_Info.class, groupPictureSerialNumber);
		hibernateTemplate.delete(groupRoomInfo);
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"model-config1-DriverManagerDataSource.xml");
		GroupRoom_InfoDAO_Interface dao = (GroupRoom_InfoDAO_Interface) context
				.getBean("GroupRoom_InfoDAO");
		// 新增
		// 修改
		// 刪除
		// 查詢單筆
		System.out.println(dao.findByPrimeKey(1).getGroupRoom());
		// 查詢多筆
	}
}
