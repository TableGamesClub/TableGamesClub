package model.dao;

import java.util.List;
import java.util.Set;

import model.BoardGameKind;
import model.BoardGames;
import model.GroupChoiceGames;
import model.GroupRoom;
import model.Interface.BoardGameKindDAO_Interface;
import model.Interface.GroupRoomDAO_Interface;
import model.Interface.StoreInformationDAO_Interface;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class BoardGameKindDAOHibernate implements BoardGameKindDAO_Interface {
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	private static final String GET_GAMEKIND_NAME ="from BoardGameKind where boardgameserialnumber = ?";
	@Override
	public String selectGameKindName(Integer boardgameserialnumber){
		List<BoardGameKind> list = hibernateTemplate.find(GET_GAMEKIND_NAME,boardgameserialnumber);
		if(list != null){
			return list.get(0).getBoardGameStyle();
		}
		return null;
	}
	
	private static final String GET_GROUP_BY_TYPE_DESC ="select groupSerialNumber from GroupRoom where groupSerialNumber in (select groupRoom.groupSerialNumber from GroupChoiceGames where boardGameKind.boardGameSerialNumber = ? group by groupRoom.groupSerialNumber) order by reserveGroupStartTime desc";
	@Override
	public List<Integer> sequenceandselecttypedesc(int boardGameSerialNumber){
		List<Integer> list = hibernateTemplate.find(GET_GROUP_BY_TYPE_DESC, boardGameSerialNumber);
		return list;
	}
	
	private static final String GET_GROUP_BY_TYPE ="select groupSerialNumber from GroupRoom where groupSerialNumber in (select groupRoom.groupSerialNumber from GroupChoiceGames where boardGameKind.boardGameSerialNumber = ? group by groupRoom.groupSerialNumber) order by reserveGroupStartTime";
	@Override
	public List<Integer> sequenceandselecttype(int boardGameSerialNumber){
		List<Integer> list = hibernateTemplate.find(GET_GROUP_BY_TYPE, boardGameSerialNumber);
		return list;
	}

	@Override
	public BoardGameKind findByPrimeKey(Integer boardGameSerialNumber) {
		BoardGameKind boardGameKind = (BoardGameKind) hibernateTemplate.get(
				BoardGameKind.class, boardGameSerialNumber);
		return boardGameKind;
	}
	
	private static final String GET_BY_NAME = "from BoardGameKind where boardGameStyle = ?";
	public Integer findByGamesName(String boardGameStyle) {
		List<BoardGameKind> list = hibernateTemplate.find(GET_BY_NAME,boardGameStyle);
		if(list != null){
			return list.get(0).getBoardGameSerialNumber();
		}
		return null;
	}

	private static final String GET_ALL_STMT = "from BoardGameKind order by boardGameSerialNumber";
	@Override
	public List<BoardGameKind> getAll() {
		List<BoardGameKind> list = hibernateTemplate.find(GET_ALL_STMT);
		return list;
	}

	@Override
	public void insert(BoardGameKind bean) {
		hibernateTemplate.saveOrUpdate(bean);
	}

	@Override
	public void update(BoardGameKind bean) {
		hibernateTemplate.saveOrUpdate(bean);
	}

	@Override
	public void delete(Integer boardGameSerialNumber) {
		BoardGameKind boardGameKind = (BoardGameKind) hibernateTemplate.get(
				BoardGameKind.class, boardGameSerialNumber);
		hibernateTemplate.delete(boardGameKind);
	}

	public static void main(String[] args) {
		// BoardGameKindDAO_Interface dao = new BoardGameKindDAOHibernate();
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"model-config1-DriverManagerDataSource.xml");
		BoardGameKindDAO_Interface dao = (BoardGameKindDAO_Interface) context
				.getBean("BoardGameKindDAO");

		List<Integer> list = dao.sequenceandselecttypedesc(1);
		for (Integer i : list) {
		System.out.println(i);
		}
		
		System.out.printf("\n");
		List<Integer> list2 = dao.sequenceandselecttype(1);
		for (Integer i : list2) {
		System.out.println(i);
		}
		
//		String b1 = dao.selectGameKindName(1);
//		System.out.println(b1);
		
		
		
//		// 新增
//		BoardGameKind bean1 = new BoardGameKind();
//		bean1.setBoardGameSerialNumber(1);
//		bean1.setBoardGameStyle("策略遊戲");
//		dao.insert(bean1);
//
//		BoardGameKind bean2 = new BoardGameKind();
//		bean2.setBoardGameSerialNumber(2);
//		bean2.setBoardGameStyle("益智遊戲");
//		dao.insert(bean2);
//
//		BoardGameKind bean3 = new BoardGameKind();
//		bean3.setBoardGameSerialNumber(3);
//		bean3.setBoardGameStyle("推理遊戲");
//		dao.insert(bean3);
//
//		BoardGameKind bean4 = new BoardGameKind();
//		bean4.setBoardGameSerialNumber(4);
//		bean4.setBoardGameStyle("角色扮演遊戲");
//		dao.insert(bean4);
//
//		BoardGameKind bean5 = new BoardGameKind();
//		bean5.setBoardGameSerialNumber(5);
//		bean5.setBoardGameStyle("小品遊戲");
//		dao.insert(bean5);
//		// 修改
//		// BoardGameKind bean6 = new BoardGameKind();
//		// bean6.setBoardGameNumber(1);
//		// bean6.setBoardGameStyle("恐怖遊戲");
//		// dao.update(bean6);
//		// 刪除
//		// dao.delete(1);
//		// 查詢單筆
//		BoardGameKind b1 = dao.findByPrimeKey(1);
//		System.out.println(b1.getBoardGameStyle());
//		// 查詢多筆
//		List<BoardGameKind> beans = dao.getAll();
//		for (BoardGameKind vo : beans) {
//			System.out.println(vo.getBoardGameSerialNumber());
//			System.out.println(vo.getBoardGameStyle());
//		}

		// 新增
//		BoardGameKind bean1 = new BoardGameKind();
//		bean1.setBoardGameSerialNumber(1);
//		bean1.setBoardGameStyle("策略遊戲");
//		dao.insert(bean1);
//
//		BoardGameKind bean2 = new BoardGameKind();
//		bean2.setBoardGameSerialNumber(2);
//		bean2.setBoardGameStyle("益智遊戲");
//		dao.insert(bean2);
//
//		BoardGameKind bean3 = new BoardGameKind();
//		bean3.setBoardGameSerialNumber(3);
//		bean3.setBoardGameStyle("推理遊戲");
//		dao.insert(bean3);
//
//		BoardGameKind bean4 = new BoardGameKind();
//		bean4.setBoardGameSerialNumber(4);
//		bean4.setBoardGameStyle("角色扮演遊戲");
//		dao.insert(bean4);
//
//		BoardGameKind bean5 = new BoardGameKind();
//		bean5.setBoardGameSerialNumber(5);
//		bean5.setBoardGameStyle("小品遊戲");
//		dao.insert(bean5);
		// 修改
		// BoardGameKind bean6 = new BoardGameKind();
		// bean6.setBoardGameNumber(1);
		// bean6.setBoardGameStyle("恐怖遊戲");
		// dao.update(bean6);
		// 刪除
		// dao.delete(1);
		// 查詢單筆
//		BoardGameKind b1 = dao.findByPrimeKey(1);
//		System.out.println(b1.getBoardGameStyle());
		// 查詢多筆
//		List<BoardGameKind> beans = dao.getAll();
//		for (BoardGameKind vo : beans) {
//			System.out.println(vo.getBoardGameSerialNumber());
//			System.out.println(vo.getBoardGameStyle());
//		}
		//查流水號By Name
//		System.out.println(dao.findByGamesName("策略遊戲"));

	}

	@Override
	public Set<GroupChoiceGames> getGroupChoiceGamesByBoardGameSerialNumber(
			Integer boardGameSerialNumber) {
		Set<GroupChoiceGames> set = findByPrimeKey(boardGameSerialNumber)
				.getGroupChoiceGameses();
		return set;
	}

	@Override
	public Set<BoardGames> getBoardGamesByBoardGameSerialNumber(
			Integer boardGameSerialNumber) {
		Set<BoardGames> set = findByPrimeKey(boardGameSerialNumber)
				.getBoardGameses();
		return set;
	}
}
