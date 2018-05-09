package com.freecell.models;
import javax.swing.JPanel;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Card extends JPanel
{
	//9,10 when size = 12, yScale = 1/2, when y = 20, yScale = 3/4
	
	//NOTATION:----------------------------------------
	//UL = upperLeft, LR = lower right, crn = corner, cb = corner base, b = base
	//tri = triangle, dist= distance, circ = circle, rad = radius 
	protected int suit, face;
	protected int xSize, ySize; //size of icons
	protected int width; //width of card to be calculated
	protected int height;//height of card to be calculated
	protected int size, cSize;//size and corner size of icons
	protected int ULnumbX;//x location for drawing number
	protected int ULnumbY;//y location for drawing number
	protected String color;
	protected String faceAsString;
	protected String faceName;
	protected String suitAsString;
	
	public Card(int suit, int face, int size)
	{
		this.size = size;
		xSize = size;
		cSize = size/2;
		ySize = size;
		width = size *5;
		height = ((int) (width*3.0/2.0));
		
		
		ULnumbX = (int) (2 + cSize/4.0);//9
		ULnumbY = 15;//hard coded due to default font size of 10
		this.suit = suit;
		this.face = face;
		
		switch(face)
		{
			case 1:
				faceAsString = "A";
				break;
				
			case 2:
				faceAsString = "2";
				break;
				
			case 3:
				faceAsString = "3";
				break;
				
			case 4:
				faceAsString = "4";
				break;
		
			case 5:
				faceAsString = "5";
				break;
				
			case 6:
				faceAsString = "6";
				break;
		
			case 7:
				faceAsString = "7";
				break;
		
			case 8:
				faceAsString = "8";
				break;
				
			case 9:
				faceAsString = "9";
				break;
		
			case 10:
				faceAsString = "10";
				break;
		
			case 11:
				faceAsString = "J";
				break;
		
			case 12:
				faceAsString = "Q";
				break;
		
			case 13:
				faceAsString = "K";
				break;
		
			default:
				break;
		}
		
		switch(suit)
		{
			case 1:
				color = "Red";
				suitAsString = "Hearts";
				break;
			
			case 2:
				color = "Red";
				suitAsString = "Diamonds";
				break;
				
			case 3:
				color = "Black";
				suitAsString = "Clubs";
				break;
				
			case 4:
				color = "Black";
				suitAsString = "Spades";
				break;
		}
		
		if(face == 1)
			faceName = "Ace";
		if(face >= 2 && face <= 10)
			faceName = Integer.toString(face);
		if(face == 11)
			faceName = "Jack";
		if(face == 12)
			faceName = "Queen";
		if(face == 13)
			faceName = "King";
	
		setMaximumSize(new Dimension(width, height));
		setPreferredSize(new Dimension(width,height));
	
		
	}
	
	public String getColor()
	{
		return color;
	}
	
	public String getFaceName()
	{
		return faceName;
	}
	
	public String getSuitAsString()
	{
		return suitAsString;
	}
	
	public int getSuit()
	{
		return suit;
	}
	
	public int getFace()
	{
		return face;
	}
	
	public String toString()
	{
		return faceName + " of " + suitAsString;
	}
}