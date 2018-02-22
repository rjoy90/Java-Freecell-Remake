package com.freecell.views;
// Ryan Joy		CS410
// 10-9-14		HW05
// FreeSpacesAndResultsPanel.java

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class FreeSpacesAndResultsPanel extends JPanel
{
	private FreeSpace [] freeSpaces;
	private ResultStack [] suitStacks;
	private MainView parent;
	
	public FreeSpacesAndResultsPanel()
	{
		System.out.println("freespaces and results panel is currently " + (isFocusable() ? " ": " not ") + "focusable" );
		setMaximumSize (new Dimension(1366, 150));
		setSize (new Dimension(1366, 150));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBackground (Color.red);
		freeSpaces = new FreeSpace[4];
		suitStacks =  new ResultStack[4];
		for(int x = 0; x < 4; x++)
		{
			freeSpaces[x] = new FreeSpace();
			suitStacks[x] = new ResultStack();
			this.add(freeSpaces[x]);
		}
		
		JPanel filler = new JPanel();
		filler.setMaximumSize(new Dimension(300,120));
		filler.setBackground(Color.blue);
		this.add(filler);
		
		for(int x = 0; x < 4; x++)
		{
			this.add(suitStacks[x]);
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


	public FreeSpace[] getFreeSpaces()
	{
		return freeSpaces;
	}
}