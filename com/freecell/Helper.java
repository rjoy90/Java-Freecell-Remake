package com.freecell;

import java.awt.Point;
import java.util.List;
import java.util.Stack;

import com.freecell.models.DynamicCardRefined;
import com.freecell.models.FreeCellGame;
import com.freecell.presenters.FreeCellPresenter;
import com.freecell.views.FreeSpace;
import com.freecell.views.FreeSpacesAndResultsPanel;
import com.freecell.views.GameColumn;
import com.freecell.views.MainView;
import com.freecell.views.TablePanel;

public class Helper 
{
	private FreeCellPresenter presenter;
	public Helper(FreeCellPresenter presenter)
	{
		this.presenter = presenter;
	}
	
	public boolean validateSequence(List<DynamicCardRefined> subList)
	{
		for(int x = 0; x < subList.size()-1; x++)
		{
			if(subList.get(x+1).getColor() == subList.get(x).getColor() 
			|| subList.get(x).getFace() - subList.get(x+1).getFace() != 1)
			{
				return false;
			}
		}
		
		return true;
	}
	
	public boolean checkNumMoves(List<DynamicCardRefined> list, GameColumn start, GameColumn destination)
	{
		int size = list.size();
		System.out.println("You are attempting to move " + size + " cards.");
		
		Stack<DynamicCardRefined> destStack = destination.getColumnCards();
		if(!destStack.isEmpty() && (destStack.peek().getColor().equals(list.get(0).getColor()) ||
		destStack.peek().getFace() - list.get(0).getFace() != 1))
		{
			return false;
		}
		
		int max = 1;
		MainView view = presenter.getView();
		FreeSpacesAndResultsPanel fsPanel = view.getFreespacesAndResults();
		FreeSpace[] freespaces = fsPanel.getFreeSpaces();
		for(int x = 0; x < 4; x++)
		{
			if(freespaces[x].getCardPlacedInFreeSpace() == null)
				max++;
		}
		
		TablePanel table = view.getTable();
		GameColumn[] columns = table.getGameColumns();
		for(int x = 0; x < 8; x++)
		{
			if(columns[x] == start || columns[x] == destination)
				continue;
			else if(columns[x].hasNoCards())
				max++;
		}
		System.out.println("Max cards that can be moved to this column: " + max);
		
		return size <= max;
	}
	
	public void returnToOriginalColumn()
	{
		FreeCellGame game = presenter.getModel();
		Stack<DynamicCardRefined> cardsBeingMoved = game.getCardsBeingMoved();
		GameColumn cardsOriginalColumn = game.getCardsOriginalColumn();
		int size = cardsBeingMoved.size();
		for(int x = 0; x < size; x++)
		{
			cardsOriginalColumn.push(cardsBeingMoved.get(x));
		}
		
		clearSequenceStack(cardsBeingMoved);
	}
	
	public void clearSequenceStack(Stack<DynamicCardRefined> cardsBeingMoved)
	{
		int size = cardsBeingMoved.size();
		System.out.println("Sequence stack size: " + size);
		System.out.println("Clearing sequence stack: ");
		for(int x = 0; x < size; x++)
		{
			DynamicCardRefined temp = cardsBeingMoved.pop();
			System.out.println("Removed: " + temp + " from sequence stack");
		}
		
		System.out.println("Sequence stack size after: " + cardsBeingMoved.size());
	}
	
	public void movingCards(Stack<DynamicCardRefined> cardsBeingMoved, GameColumn cardsOriginalColumn, int cardIndex, int size)
	{
		System.out.println("Num cards to move: " + (size - cardIndex));
		for(int x = cardIndex; x < size; x++)
		{
			cardsBeingMoved.push(cardsOriginalColumn.get(x));
		}
		
		for(int x = cardIndex; x < size; x++)
		{
			cardsOriginalColumn.pop();
		}
	}
	
	public void newColumn(Stack<DynamicCardRefined> cardsBeingMoved, GameColumn column)
	{
		for(int x = 0; x < cardsBeingMoved.size(); x++)
		{
			column.push(cardsBeingMoved.get(x));
		}
		
		clearSequenceStack(cardsBeingMoved);
		
		presenter.refreshView();
	}
	
	public void drawMovingCards(Stack<DynamicCardRefined> cardsBeingMoved, Point primaryPoint, int size)
	{
		for(int x = 0; x < size; x++)
		{
			presenter.remove(cardsBeingMoved.get(x));
		}
		
		for(int x = 0; x < size; x++)
		{
			cardsBeingMoved.get(x).setBounds(primaryPoint.x, primaryPoint.y + (40*x), 80, 120);
			presenter.add(cardsBeingMoved.get(x), x);
			cardsBeingMoved.get(x).validate();
		}
		
		presenter.refreshView();
	}
	
	public void returnToFreeSpace(FreeSpace cardOriginalFreeSpace, Stack<DynamicCardRefined> cardsBeingMoved)
	{
		cardOriginalFreeSpace.remove(0);
		cardOriginalFreeSpace.setCardPlacedInFreeSpace(cardsBeingMoved.peek());
		cardOriginalFreeSpace.add(cardsBeingMoved.peek());
		cardOriginalFreeSpace.validate();
		presenter.refreshView();
		cardsBeingMoved.pop();
	}
	
	public void returnCards()
	{
		FreeCellGame game = presenter.getModel();
		GameColumn cardsOriginalColumn = game.getCardsOriginalColumn();
		if(cardsOriginalColumn != null)
			returnToOriginalColumn();
		else
		{
			FreeSpace fs = game.getCardOriginalFreeSpace();
			Stack<DynamicCardRefined> cardsBeingMoved = game.getCardsBeingMoved();
			returnToFreeSpace(fs, cardsBeingMoved);
		}
	}
}