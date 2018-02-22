package com.freecell.models;

import java.util.Random;
import java.util.Stack;
import com.freecell.views.FreeSpace;
import com.freecell.views.GameColumn;

public class FreeCellGame 
{
	private DynamicCardRefined[] set;
	private Stack<DynamicCardRefined> remaining;
	
	private Stack<DynamicCardRefined> cardsBeingMoved;
	private GameColumn cardsOriginalColumn;
	private FreeSpace cardOriginalFreeSpace;
	
	public DynamicCardRefined[] getSet() 
	{
		return set;
	}

	public void setSet(DynamicCardRefined[] set) 
	{
		this.set = set;
	}
	
	public FreeCellGame()
	{
		cardsBeingMoved = new Stack<DynamicCardRefined>();
		set = new DynamicCardRefined [52];
		remaining = new Stack<DynamicCardRefined>();
	}
	
	public void fillArray()
	{
		int suitMax = 4;
		int faceMax = 13;
		int index = 0;
		for (int suit = 1; suit <= suitMax; suit++ )
		{
			for(int face = 1; face <= faceMax; face++)
			{
				if(suit == 1)
					set[index] = new Heart(suit,face,16);
				if(suit == 2)
					set[index] = new Diamond(suit,face,16);
				if(suit == 3)
					set[index] = new Club(suit,face,16);
				if(suit == 4)
					set[index] = new Spade(suit,face,16);
				
				index++;
			}
		}
	}
	
	public void shuffle()
	{   
		Random gen = new Random();
		int y=0;
		DynamicCardRefined temp;
		for (int x = 0; x < set.length; x++ )
		{
			y=gen.nextInt(52);
			temp = set[x];
			set[x]=set[y];
			set[y]=temp;
		}
		
		for(int x = 0; x < set.length; x++)
		{
			remaining.push(set[x]);
		}
	}
	
	public Stack<DynamicCardRefined> getRemaining()
	{
		return remaining;
	}

	public Stack<DynamicCardRefined> getCardsBeingMoved() 
	{
		return cardsBeingMoved;
	}

	public void setCardsBeingMoved(Stack<DynamicCardRefined> cardsBeingMoved) 
	{
		this.cardsBeingMoved = cardsBeingMoved;
	}

	public GameColumn getCardsOriginalColumn() 
	{
		return cardsOriginalColumn;
	}

	public void setCardsOriginalColumn(GameColumn cardsOriginalColumn) 
	{
		this.cardsOriginalColumn = cardsOriginalColumn;
	}

	public FreeSpace getCardOriginalFreeSpace() 
	{
		return cardOriginalFreeSpace;
	}

	public void setCardOriginalFreeSpace(FreeSpace cardOriginalFreeSpace) 
	{
		this.cardOriginalFreeSpace = cardOriginalFreeSpace;
	}
}