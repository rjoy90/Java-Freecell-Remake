package com.freecell.views;
// Ryan Joy		CS410
// 10-9-14		HW05
// TablePanel.java
// sets up the table for playing cards

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class TablePanel extends JPanel
{
	private GameColumn [] gameColumns;
	private MainView parent;
	public TablePanel()
	{
		System.out.println("table panel is currently " + (isFocusable() ? " ": " not ") + "focusable" );
		
		gameColumns = new GameColumn[8];
		setMaximumSize(new Dimension(1366,600));
		setSize(new Dimension(1366,600));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		setBackground(Color.magenta);
		for(int x = 0; x < 8; x++)
		{
			gameColumns[x] = new GameColumn();
			this.add(gameColumns[x]);
			JPanel filler = new JPanel();
			filler.setMaximumSize(new Dimension(40,720));
			filler.setBackground(Color.cyan);
			
			this.add(filler);
			this.validate();
			this.repaint();
		}
	}
	
	public MainView getParent() 
	{
		return parent;
	}

	public void setParent(MainView parent) 
	{
		this.parent = parent;
	}

	public GameColumn [] getGameColumns()
	{
		return gameColumns;
	}

	public void setGameColumns(GameColumn[] gameColumns) 
	{
		this.gameColumns = gameColumns;
	}

	public void parentTest()
	{
		System.out.println("Hello from table panel");
		System.out.println("My parent panel is: " + this.getParent());
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	}
}