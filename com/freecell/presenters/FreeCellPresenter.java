package com.freecell.presenters;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Stack;

import javax.swing.SwingUtilities;

import com.freecell.Helper;
import com.freecell.models.Card;
import com.freecell.models.FreeCellGame;
import com.freecell.views.DeckBackPanel;
import com.freecell.views.FreeSpace;
import com.freecell.views.FreeSpacesAndResultsPanel;
import com.freecell.views.GameColumn;
import com.freecell.views.MainView;
import com.freecell.views.ResultStack;
import com.freecell.views.TablePanel;

public class FreeCellPresenter 
{
	/*
	 * NOTE: any method starting with "handle" are called from mainview
	 */
	FreeCellGame model;
	MainView view;
	Helper helper;
	
	public FreeCellPresenter(FreeCellGame model, MainView view)
	{
		this.model = model;
		this.view = view;
	}

	public FreeCellGame getModel() 
	{
		return model;
	}

	public void setModel(FreeCellGame model) 
	{
		this.model = model;
	}

	public MainView getView() 
	{
		return view;
	}

	public void setView(MainView view) 
	{
		this.view = view;
	}

	public Helper getHelper() 
	{
		return helper;
	}

	public void setHelper(Helper helper) 
	{
		this.helper = helper;
	}

	public void loadCardsToView()
	{
		int inputNum = 52;
		TablePanel table = view.getTable();
		GameColumn[] columns = table.getGameColumns();
		for (int x = 0; x < inputNum; x++)
		{
			columns[x % 8].push(model.getRemaining().peek());
			model.getRemaining().pop();
		}    
	}

	public void handleMousePressed (MouseEvent event)
	{
		model.setCardOriginalFreeSpace(null);
		model.setCardsOriginalColumn(null);
		Point sourcePoint = event.getPoint();
		
		Component comp = view.getComponentAt(sourcePoint);
		
		if(comp instanceof TablePanel)
		{
			Point tablePoint = SwingUtilities.convertPoint(view, sourcePoint, comp);
			tablePanelMousePressed(tablePoint);
		}
			
		else
		{
			Point fsPoint = SwingUtilities.convertPoint(view, sourcePoint, comp);
			fsAndResultsMousePressed(fsPoint);
		}
	}
	
	public void tablePanelMousePressed(Point tablePoint)
	{
		model.setCardOriginalFreeSpace(null);
		model.setCardsOriginalColumn(null);
		gameColumnMousePressed(tablePoint);
	}
	
	public void gameColumnMousePressed(Point aPoint)
	{
		TablePanel table = view.getTable();
		if(table.getComponentAt(aPoint) instanceof GameColumn)
		{
			model.setCardsOriginalColumn(((GameColumn)table.getComponentAt(aPoint)));
			Card temp = getCardInColumn(aPoint);
			GameColumn original = model.getCardsOriginalColumn();
			int cardIndex = original.indexOf(temp);
			
			System.out.println("\nPoint x: " + aPoint.x + " y: " + aPoint.y);
			System.out.println("index: " + cardIndex);
			Stack<Card> cards = original.getColumnCards();
			int size = cards.size();
			
			//default the click to grab the lowest card
			if(cardIndex >= size) 
				cardIndex = cards.size()-1; 
			
			//this implies trying to get more than one card
			if(cardIndex != cards.size()-1)
			{
				if(helper.validateSequence(cards.subList(cardIndex,size)))
				{
					System.out.println("Valid sequence.");
					helper.movingCards(model.getCardsBeingMoved(), original, cardIndex, size);
				}
				
				else
				{
					System.out.println("Invalid sequence.");
				}
			}
			
			else
			{
				helper.movingCards(model.getCardsBeingMoved(), original, cardIndex, size);
			}
		}
	}
	
	public void fsAndResultsMousePressed(Point fsPoint)
	{
		FreeSpacesAndResultsPanel fsAndResults = (FreeSpacesAndResultsPanel)view.getFreespacesAndResults();
		if(fsAndResults.getComponentAt(fsPoint) instanceof FreeSpace)
		{
			FreeSpace fs = (FreeSpace) fsAndResults.getComponentAt(fsPoint);
			
			if(fs.getCardPlacedInFreeSpace() != null)
			{
				model.setCardOriginalFreeSpace(fs);
				Stack<Card> cardsBeingMoved = model.getCardsBeingMoved();
				cardsBeingMoved.push(fs.getCardPlacedInFreeSpace());
				fs.remove(fs.getCardPlacedInFreeSpace());
				fs.setCardPlacedInFreeSpace(null);
				fs.add(new DeckBackPanel());
				fs.validate();
				fs.repaint();
			}
		}
	}
	
	public void handleMouseReleased(MouseEvent e) 
	{
		if(!clearScreenOfMovingCards())
			return;
	
		Point sourcePoint = e.getPoint();
		
		Component comp = view.getComponentAt(sourcePoint);
		if(comp instanceof TablePanel)
			tablePanelMouseReleased(sourcePoint);
		
		else
			fsAndResultsMouseReleased(sourcePoint);
	}
	
	public void fsAndResultsMouseReleased(Point sourcePoint)
	{
		Point fsPoint = SwingUtilities.convertPoint(view, sourcePoint, view.getFreespacesAndResults());
		FreeSpacesAndResultsPanel fsAndResults = view.getFreespacesAndResults();
		if(fsAndResults.getComponentAt(fsPoint) instanceof FreeSpace)
			freeSpaceMouseReleased((FreeSpace)fsAndResults.getComponentAt(fsPoint));
			
		else if(fsAndResults.getComponentAt(fsPoint) instanceof ResultStack)
			resultStackMouseReleased((ResultStack)fsAndResults.getComponentAt(fsPoint));
		
		else
			helper.returnCards();
	}
	
	public Card getCardInColumn(Point aPoint)
	{
		TablePanel table = view.getTable();
		GameColumn cardsOriginalColumn = model.getCardsOriginalColumn();
		Point columnPoint = SwingUtilities.convertPoint(table, aPoint, cardsOriginalColumn);
		if(cardsOriginalColumn.getComponentAt(columnPoint) instanceof Card)
			return (Card) cardsOriginalColumn.getComponentAt(columnPoint);
		else 
			return cardsOriginalColumn.peek();
	}
	
	public void handleMouseDragged (MouseEvent e)
	{	
		Stack<Card> cardsBeingMoved = model.getCardsBeingMoved();
		if(cardsBeingMoved.size() == 0)
			return;
		
		Point point = e.getPoint();
		int size = cardsBeingMoved.size();
		helper.drawMovingCards(cardsBeingMoved, point, size);
	}
	 
	public boolean clearScreenOfMovingCards() 
	{
		Stack<Card> cardsBeingMoved = model.getCardsBeingMoved();
		if(cardsBeingMoved.size() == 0)
			return false;
		 
		for(int x = 0; x < cardsBeingMoved.size(); x++)
		{
			view.remove(cardsBeingMoved.get(x));
		}
		 
		view.validate();
		view.repaint();
		return true;
	}
	
	public void freeSpaceMouseReleased(FreeSpace fs)
	{
		Stack<Card> cardsBeingMoved = model.getCardsBeingMoved();
		if(cardsBeingMoved.size() > 1)
		{
			helper.returnToOriginalColumn();
		}
			 
		else if(fs.getCardPlacedInFreeSpace() == null)
		{
			cardsBeingMoved.peek().setBounds(0, 0, 80,120);
			fs.removeAll();
			fs.add(cardsBeingMoved.peek());
			fs.setCardPlacedInFreeSpace(cardsBeingMoved.peek());
				 
			fs.validate();
			fs.repaint();
			cardsBeingMoved.pop();
		}
			
		else
		{
			GameColumn cardsOriginalColumn = model.getCardsOriginalColumn();
			if(cardsOriginalColumn != null)
			{
				cardsOriginalColumn.push(cardsBeingMoved.peek());
				cardsBeingMoved.pop();
			}
				 
			else
			{
				helper.returnToFreeSpace(fs, cardsBeingMoved);
			}
		}
	}
	
	public void resultStackMouseReleased(ResultStack stack)
	{
		System.out.println("Adding to result stack:\n");
		Stack<Card> cardsBeingMoved = model.getCardsBeingMoved();
		if(cardsBeingMoved.size() > 1) 
		{
			helper.returnToOriginalColumn();
		}
			 
		else if(!stack.push(cardsBeingMoved.peek()))
		{
			System.out.println("Wrong suit or face value for this stack");
			helper.returnCards();
		}
			 
		else
		{
			cardsBeingMoved.pop();
		}
	}
	
	public void tablePanelMouseReleased(Point aPoint)
	{
		Point tablePoint = SwingUtilities.convertPoint(view, aPoint, view.getTable());
		gameColumnMouseReleased(tablePoint);
	}
	
	public void gameColumnMouseReleased(Point tablePoint)
	{
		TablePanel table = view.getTable();
		if(table.getComponentAt(tablePoint) instanceof GameColumn)
		{
			System.out.println("Releasing in game column\n");
			GameColumn newColumn = (GameColumn) table.getComponentAt(tablePoint);
			GameColumn cardsOriginalColumn = model.getCardsOriginalColumn();
			Stack<Card> cardsBeingMoved= model.getCardsBeingMoved();
			if(newColumn != cardsOriginalColumn)
			{
				if(helper.checkNumMoves(cardsBeingMoved.subList(0, cardsBeingMoved.size()), cardsOriginalColumn, newColumn))
				{
					System.out.println("This move can be made");
					helper.newColumn(cardsBeingMoved, newColumn);
				}
					
				else
				{
					System.out.println("This move can't be made");
					helper.returnCards(); 
				}
			}
				
			else
			{
				helper.returnCards();
			}
		}
			
		else
		{
			helper.returnCards();
		}
	}
	
	public void refreshView()
	{
		view.repaint();
	}
	
	public void remove(Component comp)
	{
		view.remove(comp);
	}
	
	public void add(Component comp, int index)
	{
		view.add(comp, index);
	}
}