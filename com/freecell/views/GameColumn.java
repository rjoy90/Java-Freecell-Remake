package com.freecell.views;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Stack;
import javax.swing.JLayeredPane;
import com.freecell.models.Card;

public class GameColumn extends JLayeredPane 
{
	public static int count;
	
	private int number;
	private Stack<Card> columnCards;//each gameColumn holds a stack of cards
	private final int width, height;
	public GameColumn()
	{
		number = ++count;
		width = 120;// this is really 80, but +40 for the gaps
		height = 120;
		columnCards = new Stack<Card>();
		super.setOpaque(true);//this will allow the jlayeredpane to be transparent, revealing gamecolumn's true background
		setBackground(Color.orange);
		this.setMaximumSize(new Dimension(80, 720));
	}
	
	public void push(Card thisCard)
	{
		System.out.println("Adding: " + thisCard + " to column: " + number); 
		thisCard.setBounds(0, (int) (height/3.0 * columnCards.size()), 80,120);
		this.add(thisCard, new Integer(columnCards.size()));
		columnCards.push(thisCard);
		this.validate();
		this.repaint();
	}
	
	public Card pop()
	{
		Card cardRemoved = columnCards.pop();
		System.out.println("Removing: " + cardRemoved + " from column: " + number);
		this.remove(cardRemoved);
		this.validate();
		this.repaint();
		return cardRemoved;
	}
	
	public Card peek()
	{
		return columnCards.peek();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D temp = (Graphics2D) g;
		temp.setStroke(new BasicStroke(5));
		temp.drawRect(0,0,80,720);
	}
	
	public Stack<Card> getColumnCards()
	{
		return columnCards;
	}
	
	public boolean hasNoCards()
	{
		return columnCards.isEmpty();
	}
	
	public int getNumber()
	{
		return number;
	}
	
	public int indexOf(Card aCard)
	{
		return columnCards.indexOf(aCard);
	}
	
	public Card get(int index)
	{
		return columnCards.get(index);
	}
}