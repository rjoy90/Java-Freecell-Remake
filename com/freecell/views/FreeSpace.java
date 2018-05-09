package com.freecell.views;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

import com.freecell.models.Card;

public class FreeSpace extends JPanel
{
	private Card cardPlacedInFreeSpace;
	public FreeSpace()
	{
		cardPlacedInFreeSpace = null;
		this.setPreferredSize(new Dimension(100,150));
		this.setMaximumSize(new Dimension(100,150));
		this.add(new DeckBackPanel());
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	}

	public Card getCardPlacedInFreeSpace() 
	{
		return cardPlacedInFreeSpace;
	}

	public void setCardPlacedInFreeSpace(Card cardPlacedInFreeSpace) 
	{
		this.cardPlacedInFreeSpace = cardPlacedInFreeSpace;
	}
}