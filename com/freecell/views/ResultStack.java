package com.freecell.views;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Stack;
import javax.swing.JPanel;
import com.freecell.models.Card;

public class ResultStack extends JPanel
{
	private Stack<Card> results;
	private String suit;
	
	public ResultStack()
	{
		setMaximumSize(new Dimension(100,150));
		results = new Stack<Card>();
		this.add(new DeckBackPanel());
		
	}
	
	public boolean push(Card thisCard)
	{
		System.out.println(thisCard + " --> " + thisCard.getFace());
		if(results.size() == 0)
		{
			if(thisCard.getFace() == 1)
			{
				suit = thisCard.getSuitAsString();
				addCard(thisCard);
				return true;
			}
			
			else 
				return false;
		}
		
		else if(thisCard.getSuitAsString().equals(suit) && thisCard.getFace() - results.size() == 1)
		{
			addCard(thisCard);
			return true;
		}
			
		else
		{
			return false;
		}
	}
	
	public void addCard(Card thisCard)
	{
		results.push(thisCard);
		this.removeAll();
		this.add(results.peek());
		this.validate();
		this.repaint();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	}
}
