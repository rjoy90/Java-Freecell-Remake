package com.freecell.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import com.freecell.presenters.FreeCellPresenter;

public class MainView extends JLayeredPane
{ 
	/*
	 * View holds panels, and has knowledge of its presenter
	 */
	private TablePanel table;
	private FreeSpacesAndResultsPanel freespacesAndResults;
	private FreeCellPresenter presenter;
	
	public MainView() 
	{   
		//layout panels vertically, green bg
		setMaximumSize(new Dimension(1366,768));
		setLayout (new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.green);
		
		//so jlayer doesn't show white bg
		System.out.println("Main view is currently " + (super.isOpaque() ? " " : " not ") + "opaque");
		setOpaque(true);
		
		//init panels
		table = new TablePanel();
		freespacesAndResults = new FreeSpacesAndResultsPanel();
		
		//let panels know mainview is their parent
		table.setParent(this);
		freespacesAndResults.setParent(this);
		
		ViewListener vl = new ViewListener();
		this.addMouseListener(vl);
		this.addMouseMotionListener(vl);
	}
	
	//adding panels to jframe
	public void addPanels(JFrame mainFrame)
	{
		this.add(freespacesAndResults);
		this.add(table);
		mainFrame.add(this);
		mainFrame.pack();
	}

	private class ViewListener implements MouseListener, MouseMotionListener
	{
		@Override
		public void mousePressed(MouseEvent e) 
		{
			presenter.handleMousePressed(e);
		}

		@Override
		public void mouseReleased(MouseEvent e) 
		{
			presenter.handleMouseReleased(e);
		}
		
		@Override
		public void mouseDragged(MouseEvent e) 
		{
			presenter.handleMouseDragged(e);
		}

		@Override
		public void mouseMoved(MouseEvent e) 
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent e) 
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) 
		{
			if(!isFocusOwner())
				requestFocusInWindow();	
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	/*
	 * getters and setters
	 */
	public TablePanel getTable() 
	{
		return table;
	}

	public FreeCellPresenter getPresenter() 
	{
		return presenter;
	}

	public void setPresenter(FreeCellPresenter presenter) 
	{
		this.presenter = presenter;
	}

	public void setTable(TablePanel table) 
	{
		this.table = table;
	}

	public FreeSpacesAndResultsPanel getFreespacesAndResults() 
	{
		return freespacesAndResults;
	}

	public void setFreespacesAndResults(FreeSpacesAndResultsPanel freespacesAndResults) 
	{
		this.freespacesAndResults = freespacesAndResults;
	}
}