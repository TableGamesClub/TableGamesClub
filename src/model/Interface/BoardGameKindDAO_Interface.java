package model.Interface;

import java.util.List;
import java.util.Set;

import model.BoardGameKind;
import model.BoardGames;
import model.GroupChoiceGames;
import model.GroupRoom;

public interface BoardGameKindDAO_Interface {
	public abstract String selectGameKindName(Integer boardgameserialnumber);
	
	public abstract List<Integer> sequenceandselecttypedesc(int boardGameSerialNumber);
	
	public abstract List<Integer> sequenceandselecttype(int boardGameSerialNumber);
	
	public abstract BoardGameKind findByPrimeKey(Integer boardGameSerialNumber);
	
	public Integer findByGamesName(String boardGameStyle);

	public abstract List<BoardGameKind> getAll();

	public abstract void insert(BoardGameKind bean);

	public abstract void update(BoardGameKind bean);

	public abstract void delete(Integer boardGameSerialNumber);

	public abstract Set<GroupChoiceGames> getGroupChoiceGamesByBoardGameSerialNumber(
			Integer boardGameSerialNumber);

	public abstract Set<BoardGames> getBoardGamesByBoardGameSerialNumber(
			Integer boardGameSerialNumber);
}
