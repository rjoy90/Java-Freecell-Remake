package com.freecell;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.freecell.models.FreeCellGame;
import com.freecell.presenters.FreeCellPresenter;
import com.freecell.views.MainView;

public class Main 
{
	/*
	 * review code, add comments before running
	 * change two listeners in fsAndResults and tablePanel to only one in the main view
	 * sadly, the two separate don't want to work :(
	 */
	public static void main(String[] args) 
	{
		//init frame and size
		JFrame frame = new JFrame ("Ryan Joy CS410 HW09/HW10/Final Freecell Game");
		frame.setPreferredSize(new Dimension(1300,750));
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);   
		
		//init view and panels
		MainView view = new MainView();
		view.addPanels(frame);
		
		//init model and presenter
		FreeCellGame model = new FreeCellGame();
		FreeCellPresenter presenter = new FreeCellPresenter(model, view);
		view.setPresenter(presenter);
		
		//init helper
		Helper helper = new Helper(presenter);
		presenter.setHelper(helper);
		
		//populates deck and shuffles
		model.fillArray();
		model.shuffle();
		
		//add and display cards to view
		presenter.loadCardsToView();
	}
}