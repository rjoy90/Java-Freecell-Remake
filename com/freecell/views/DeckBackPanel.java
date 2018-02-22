package com.freecell.views;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class DeckBackPanel extends JLayeredPane
{
	private boolean empty;
	public DeckBackPanel()
	{
		empty = false;
		setPreferredSize(new Dimension(100,150));
		setBackground(Color.cyan);
		//setMaximumSize(new Dimension(100,150));
		super.setOpaque(true);
	}
   
	public void setEmpty(boolean empty)
	{
		this.empty = empty;
	}
   
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawRect(0,0,80,120);
		if(!empty)
		{
			g.setColor(Color.green);
			g.fillRect(0, 0, 80, 120);
			g.setColor(Color.yellow);
			g.fillPolygon(new int[] {20,40, 60, 40 }, new int[] {60,40,60,80}, 4);
			Graphics2D temp = (Graphics2D) g;
			temp.setStroke(new BasicStroke(5));
			temp.setColor(Color.black);
			temp.drawRect(0, 0, 100, 150);
		}
		
		else
		{
			setBackground(Color.white);
			g.setColor(Color.red);
			g.fillOval(10, 40, 80, 80);
	}
	}
}