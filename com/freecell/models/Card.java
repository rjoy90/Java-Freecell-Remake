package com.freecell.models;

import javax.swing.JPanel;
import java.awt.*;

public class Card extends JPanel {
private int suit, face;
private String faceAsString;

	public Card(int suit, int face)
	{
		this.suit = suit;
		this.face = face;
		
		switch(this.face)
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
		
		
		setMaximumSize (new Dimension(201, 301));//our favorite rooms :)
		setBackground (Color.white);
	}
	
	public int getFace() {
		return face;
	}

	public void setFace(int face) {
		this.face = face;
	}

	public void paintComponent (Graphics g){
		
		super.paintComponent(g);
		
		if (suit == 1 || suit == 2) //if suit is 1 for hearts, two for diamonds
			g.setColor(Color.red);
		else //suit is 3 for clubs, or 4 for spades
			g.setColor (Color.black);
		
		//draws the face in the two corners
		Font temp = new Font("Times New Roman", Font.PLAIN, 10);
		g.setFont(temp);
		g.drawString(faceAsString, 9,15);
		
		Font temp2 = new Font("Times New Roman", Font.PLAIN, -10);
		g.setFont(temp2);
		g.drawString(faceAsString, 191, 285);
		
		if(suit == 1 || suit == 3) //if suit is hearts or clubs
		{
			//draw the respective circles (red or black) in the four corners
			//the cards are being added to a panel of size 1000 X 700
			
			if(suit == 1)
		{
			//--------------------------------------------------------------------	
			//----------------------upper left heart------------------------------
		    //--------------------------------------------------------------------
			
			g.fillArc(2, 20, 10, 10, 180, -180);
			g.fillArc(12, 20, 10, 10, 180, -180);

			//this is a triangle that sits below the 2 arcs, completing the heart
			g.fillPolygon(new int [] { 2, 22, 12}, new int[] { 25, 25, 40 } , 3);
			
			//----------------------lower right heart-----------------------------
			//these are 2 arcs side by side
			g.fillArc(178, 270, 10, 10, 0, -180);
			g.fillArc(188, 270, 10, 10, 0, -180);
			//this is a triangle that sits above the 2 arcs, completing the heart
			g.fillPolygon(new int [] { 178, 198, 188}, new int[] { 275, 275, 260 } , 3);
			
			if(face == 1 || face == 3 || face == 5 || face == 9)
			{
				g.fillArc(80, 130, 20, 20, 0, 180);
				g.fillArc(100, 130, 20, 20, 0, 180);
				g.fillPolygon(new int [] {80, 120, 100}, new int[] { 140, 140, 170 } , 3);
			}
			
			if(face == 2 || face == 3)
			{
				//Mid-Upper heart
				g.fillArc(80, 20, 20, 20, 0, 180);
				g.fillArc(100, 20, 20, 20, 0, 180);
				g.fillPolygon(new int [] {80, 120, 100}, new int[] { 30, 30, 60 } , 3);

				//Mid-lower heart
				g.fillArc(80, 260, 20, 20, 0, -180);
				g.fillArc(100, 260, 20, 20, 0, -180);
				g.fillPolygon(new int [] {80, 120, 100}, new int[] { 270, 270, 240 } , 3);
			}
			
			if(face >= 4)
			{
				//Left-Upper heart
				g.fillArc(27, 20, 20, 20, 0, 180);
				g.fillArc(47, 20, 20, 20, 0, 180);
				g.fillPolygon(new int [] {27, 67, 47}, new int[] { 30, 30, 60 } , 3);

				//Right-lower heart
				g.fillArc(133, 260, 20, 20, 0, -180);
				g.fillArc(153, 260, 20, 20, 0, -180);
				g.fillPolygon(new int [] {133, 173, 153}, new int[] { 270, 270, 240 } , 3);

				if(face <= 10)
				{
				//Left-lower heart
				g.fillArc(27, 260, 20, 20, 0, -180);
				g.fillArc(47, 260, 20, 20, 0, -180);
				g.fillPolygon(new int [] {27, 67, 47}, new int[] { 270, 270, 240 } , 3);
				
				//Right-Upper heart
				g.fillArc(133, 20, 20, 20, 0, 180);
				g.fillArc(153, 20, 20, 20, 0, 180);
				g.fillPolygon(new int [] {133, 173, 153}, new int[] { 30, 30, 60 } , 3);
				}					
			}
			
			if(face == 6 || face == 7 || face == 8)
			{
				//Mid-left heart
				g.fillArc(27, 150, 20, 20, 0, -180);
				g.fillArc(47, 150, 20, 20, 0, -180);
				g.fillPolygon(new int [] {27, 67, 47}, new int[] { 160, 160, 130 } , 3);
				
				//mid-right heart
				g.fillArc(133, 130, 20, 20, 0, 180);
				g.fillArc(153, 130, 20, 20, 0, 180);
				g.fillPolygon(new int [] {135, 175, 155}, new int[] { 140, 140, 170 } , 3);
			}
			
			if(face == 7 || face == 8)
			{
				//Makes it look a mini square with the fifth centered in the upper half
				g.fillArc(80, 80, 20, 20, 0, 180);
				g.fillArc(100, 80, 20, 20, 0, 180);
				g.fillPolygon(new int [] {80, 120, 100}, new int[] { 90, 90, 120 } , 3);
			}
			
			if (face == 8)
			{
				//Mid-lower heart
				g.fillArc(80, 210, 20, 20, 0, -180);
				g.fillArc(100, 210, 20, 20, 0, -180);
				g.fillPolygon(new int [] {80, 120, 100}, new int[] { 220, 220, 190 } , 3);
			}
			
			if(face == 9 || face == 10)
			{
				//Makes it look a mini square with the fifth centered in the upper half
				g.fillArc(27, 90, 20, 20, 0, 180);
				g.fillArc(47, 90, 20, 20, 0, 180);
				g.fillPolygon(new int [] {27, 67, 47}, new int[] { 100, 100, 130 } , 3);
				
				//Mid-lower heart
				g.fillArc(27, 190, 20, 20, 0, -180);
				g.fillArc(47, 190, 20, 20, 0, -180);
				g.fillPolygon(new int [] {27, 67, 47}, new int[] { 200, 200, 170 } , 3);
				
				//Right-Upper heart
				g.fillArc(133, 90, 20, 20, 0, 180);
				g.fillArc(153, 90, 20, 20, 0, 180);
				g.fillPolygon(new int [] {133, 173, 153}, new int[] { 100, 100, 130 } , 3);
				
				//Mid-lower heart
				g.fillArc(133, 190, 20, 20, 0, -180);
				g.fillArc(153, 190, 20, 20, 0, -180);
				g.fillPolygon(new int [] {133, 173, 153}, new int[] { 200, 200, 170 } , 3);
			}
			
			if(face == 10)
				{
					//top "5" center
					g.fillArc(80, 55, 20, 20, 0, 180);
					g.fillArc(100, 55, 20, 20, 0, 180);
					g.fillPolygon(new int [] {80, 120, 100}, new int[] { 65, 65, 95 } , 3);
					
					//bottom "5" center
					g.fillArc(80, 225, 20, 20, 0, -180);
					g.fillArc(100, 225, 20, 20, 0, -180);
					g.fillPolygon(new int [] {80, 120, 100}, new int[] { 235, 235, 205 } , 3);
				}
			}
			
			else //working on clubs
			{
				//---------------------------upper left club-----------------------
				//---------------------------3 circles and 2 triangles-------------
				g.fillOval(9, 20, 10, 10); //top circle
				g.fillOval(2, 25, 10, 10); //left circle
				g.fillOval(16, 25, 10, 10); //right circle
				g.fillPolygon(new int[] {14, 10, 18}, new int[] {28,40,40}, 3); //this triangle points up for the base
				
				//lower right club
				g.fillOval(181, 270, 10, 10);  //this is for the bottom circle
				g.fillOval(174, 265, 10, 10); //this is for the circle to the left and just above the bottom circle
				g.fillOval(188, 265, 10, 10); //this is for the circle to the right and just above the bottom circle
				g.fillPolygon(new int[] {186,182,190}, new int[] {272,260,260}, 3); //this triangle points down for the base
				
				if(face == 1 || face == 3 || face == 5 || face == 9)
				{
					g.fillOval(90, 130, 20, 20); //top circle
					g.fillOval(77, 140, 20, 20); //left circle
					g.fillOval(103, 140, 20, 20); //right circle
					g.fillPolygon(new int [] {92, 108, 100}, new int[] { 170, 170, 146 } , 3);
				}
				
				if(face == 2 || face == 3)
				{
					//top center club
					g.fillOval(90, 20, 20, 20); //top circle
					g.fillOval(77, 30, 20, 20); //left circle
					g.fillOval(103, 30, 20, 20); //right circle
					g.fillPolygon(new int [] {92, 108, 100}, new int[] { 60, 60, 36 } , 3);
			
					//bottom center club
					g.fillOval(90, 260, 20, 20); //bottom circle
					g.fillOval(77, 250, 20, 20); //left circle
					g.fillOval(103, 250, 20, 20); //right circle
					g.fillPolygon(new int [] {92, 108, 100}, new int[] { 240, 240, 264 } , 3);
				}
				
				if(face >= 4)
				{
					//left upper club
					g.fillOval(44, 20, 20, 20); //top circle
					g.fillOval(31, 30, 20, 20); //left circle
					g.fillOval(57, 30, 20, 20); //right circle
					g.fillPolygon(new int [] {46, 62, 54}, new int[] { 60, 60, 36 } , 3);
			
					//right lower club
					g.fillOval(140, 260, 20, 20); //bottom circle
					g.fillOval(127, 250, 20, 20); //left circle
					g.fillOval(153, 250, 20, 20); //right circle
					g.fillPolygon(new int [] {142, 158, 150}, new int[] { 240, 240, 264 } , 3);
					
					if(face <= 10)
					{
						//right upper club
						g.fillOval(140, 20, 20, 20); //top circle
						g.fillOval(127, 30, 20, 20); //left circle
						g.fillOval(153, 30, 20, 20); //right circle
						g.fillPolygon(new int [] {142, 158, 150}, new int[] { 60, 60, 36 } , 3);
				
						//left lower club
						g.fillOval(44, 260, 20, 20); //bottom circle
						g.fillOval(31, 250, 20, 20); //left circle
						g.fillOval(57, 250, 20, 20); //right circle
						g.fillPolygon(new int [] {46, 62, 54}, new int[] { 240, 240, 264 } , 3);
					}
				}
				
				if(face == 6 || face == 7 || face == 8)
				{
					//left center club
					g.fillOval(44, 150, 20, 20); //bottom circle
					g.fillOval(31, 140, 20, 20); //left circle
					g.fillOval(57, 140, 20, 20); //right circle
					g.fillPolygon(new int [] {46, 62, 54}, new int[] { 130, 130, 154 } , 3);
					
					//right center club
					g.fillOval(140, 130, 20, 20); //top circle
					g.fillOval(127, 140, 20, 20); //left circle
					g.fillOval(153, 140, 20, 20); //right circle
					g.fillPolygon(new int [] {142, 158, 150}, new int[] { 170, 170, 146 } , 3);
				}// end 6,7,8
				
				if(face == 7 || face == 8)
				{
					//"7" center club
					g.fillOval(90, 80, 20, 20); //top circle
					g.fillOval(77, 90, 20, 20); //left circle
					g.fillOval(103, 90, 20, 20); //right circle
					g.fillPolygon(new int [] {92, 108, 100}, new int[] { 120, 120, 96 } , 3);
				}
				
				if(face == 8)
				{
					//"8" center club
					g.fillOval(90, 210, 20, 20); //bottom circle
					g.fillOval(77, 200, 20, 20); //left circle
					g.fillOval(103, 200, 20, 20); //right circle
					g.fillPolygon(new int [] {92, 108, 100}, new int[] { 190, 190, 214 } , 3);
				}

				if(face == 9 || face == 10)
				{
					//midUpper left club
					g.fillOval(44, 90, 20, 20); //top circle
					g.fillOval(31, 100, 20, 20); //left circle
					g.fillOval(57, 100, 20, 20); //right circle
					g.fillPolygon(new int [] {46, 62, 54}, new int[] { 130, 130, 106 } , 3);

					//mid upper right club					
					g.fillOval(140, 90, 20, 20); //top circle
					g.fillOval(127, 100, 20, 20); //left circle
					g.fillOval(153, 100, 20, 20); //right circle
					g.fillPolygon(new int [] {142, 158, 150}, new int[] { 130, 130, 106 } , 3);

					//mid lower left club
					g.fillOval(44, 190, 20, 20); //top circle
					g.fillOval(31, 180, 20, 20); //left circle
					g.fillOval(57, 180, 20, 20); //right circle
					g.fillPolygon(new int [] {46, 62, 54}, new int[] { 170, 170, 194 } , 3);

					//mid lower right club
					g.fillOval(140, 190, 20, 20);//bottom circle
					g.fillOval(127, 180, 20, 20); //left circle
					g.fillOval(153, 180, 20, 20); //right circle
					g.fillPolygon(new int [] {142, 158, 150}, new int[] { 170, 170, 194 } , 3);
				}

				if(face == 10)
				{
					//top center club
					g.fillOval(90, 50, 20, 20); //top circle
					g.fillOval(77, 60, 20, 20); //left circle
					g.fillOval(103, 60, 20, 20); //right circle
					g.fillPolygon(new int [] {92, 108, 100}, new int[] { 90, 90, 66 } , 3);

					//bottom center club
					g.fillOval(90, 230, 20, 20); //bottom circle
					g.fillOval(77, 220, 20, 20); //left circle
					g.fillOval(103, 220, 20, 20); //right circle
					g.fillPolygon(new int [] {92, 108, 100}, new int[] { 210, 210, 234 } , 3);
				}
			}//end clubs else			
		}//end hearts or clubs if
		
		else //diamonds or spades
		{
			if(suit == 2) //working on diamonds here
			{
				//NOTE:  POINTS ARE IN ORDER FROM: left top, right, bottom
				//upper left diamond
				g.fillPolygon(new int[] {2,12,22,12},  new int[] {30, 20, 30, 40} , 4 );
				//lower right diamond
				g.fillPolygon(new int[] {178,188,198,188},  new int[] {270, 260, 270, 280} , 4 );
				if(face == 1 || face == 3 || face == 5 || face == 9)
				{
					//center diamond
					g.fillPolygon(new int[] {80, 100, 120, 100}, new int[] {150,130,150,170}, 4);
				}

				if(face == 2 || face == 3)
				{
					g.fillPolygon(new int[] {80, 100, 120, 100}, new int[] {40, 20, 40, 60}, 4);
					g.fillPolygon(new int[] {80, 100, 120, 100}, new int[] {260, 240, 260, 280}, 4);
					
				}

				if(face >= 4)
				{
					g.fillPolygon(new int[] {27, 47, 67, 47}, new int[] {40, 20, 40, 60}, 4);
					g.fillPolygon(new int[] {133, 153, 173, 153}, new int[] {260, 240, 260, 280}, 4);

					if(face <= 10)
					{
						g.fillPolygon(new int[] {133, 153, 173, 153}, new int[] {40, 20, 40, 60}, 4);
						g.fillPolygon(new int[] {27, 47, 67, 47}, new int[] {260, 240, 260, 280}, 4);
					}
				}
				
				if(face == 6 || face == 7 || face == 8)
				{
					g.fillPolygon(new int[] {27, 47, 67, 47}, new int[] {150,130,150,170}, 4);
					g.fillPolygon(new int[] {133, 153, 173, 153}, new int[] {150,130,150,170}, 4);
				}
				
				if(face == 7 || face == 8)
				{
					g.fillPolygon(new int[] {80, 100, 120, 100}, new int[] {100, 80, 100, 120}, 4);
					
				}
				
				if(face == 8)
				{
					g.fillPolygon(new int[] {80, 100, 120, 100}, new int[] {210, 190, 210, 230}, 4);
				}
				
				if(face == 9 || face == 10)
				{
					g.fillPolygon(new int[] {27, 47, 67, 47}, new int[] {110,90,110,130}, 4);
					g.fillPolygon(new int[] {133, 153, 173, 153}, new int[] {110,90,110,130}, 4);
					

					g.fillPolygon(new int[] {27, 47, 67, 47}, new int[] {190,170,190,210}, 4);
					g.fillPolygon(new int[] {133, 153, 173, 153}, new int[] {190,170,190,210}, 4);
				}
				
				if(face == 10)
				{
					g.fillPolygon(new int[] {80, 100, 120, 100}, new int[] {70, 50, 70, 90}, 4);
					g.fillPolygon(new int[] {80, 100, 120, 100}, new int[] {230, 210, 230, 250}, 4);
				}
			}
			
			else //working on spades here
			{
				//--------------------------------------------------------------------	
				//----------------------upper left spade------------------------------
			    //--------------------------------------------------------------------
				g.fillArc(2, 25, 10, 10, 0, -180);
				g.fillArc(12, 25, 10, 10, 0, -180);
				
				g.fillPolygon(new int [] {2, 22, 12}, new int[] { 30, 30, 20 } , 3); //this helps form the heart part of the spade
				g.fillPolygon(new int[] {12, 8, 16}, new int[] {28,40,40}, 3); //this triangle points up for the base
				
				//----------------------lower right spade-----------------------------
				g.fillArc(178, 265, 10, 10, 180, -180);
				g.fillArc(188, 265, 10, 10, 180, -180);
				g.fillPolygon(new int [] { 178, 198, 188}, new int[] {270, 270, 280 } , 3); //this helps form the heart part of the spade
				g.fillPolygon(new int[] {188,184,192}, new int[] {272,260,260}, 3); //this triangle points down for the base
				
				if(face == 1 || face == 3 || face == 5 || face == 9)
				{
					g.fillArc(80, 140, 20, 20, -180, 180);
					g.fillArc(100, 140, 20, 20, -180, 180);
	
					//"heart" triangle of spade
					g.fillPolygon(new int [] {80, 120, 100}, new int[] { 150, 150, 130 } , 3);
					//base of spade
					g.fillPolygon(new int [] {92, 108, 100}, new int[] { 170, 170, 146 } , 3);
				}
				
				if(face == 2 || face == 3)
				{
					//top center spade
					g.fillArc(80, 30, 20,20,-180,180);
					g.fillArc(100, 30, 20, 20, -180, 180);
					g.fillPolygon(new int [] {80, 120, 100}, new int[] { 40, 40, 20 } , 3);
					g.fillPolygon(new int [] {92, 108, 100}, new int[] { 60, 60, 36 } , 3);
					
					//bottom center spade
					g.fillArc(80, 250, 20,20,180,-180);
					g.fillArc(100, 250, 20, 20, 180, -180);
					g.fillPolygon(new int [] {80, 120, 100}, new int[] { 260, 260, 280 } , 3);
					g.fillPolygon(new int [] {92, 108, 100}, new int[] { 240, 240, 264 } , 3);
				}
				
				if(face >= 4)
				{
					//top left spade
					g.fillArc(27, 30, 20,20,-180,180);
					g.fillArc(47, 30, 20, 20, -180, 180);
					g.fillPolygon(new int [] {27, 67, 47}, new int[] { 40, 40, 20 } , 3);
					g.fillPolygon(new int [] {39, 55, 47}, new int[] { 60, 60, 36 } , 3);
					
					//bottom right spade
					g.fillArc(133, 250, 20, 20, 180, -180);
					g.fillArc(153, 250, 20, 20, 180, -180);
					g.fillPolygon(new int [] {133, 173, 153}, new int[] { 260, 260, 280 } , 3);
					g.fillPolygon(new int [] {145, 161, 153}, new int[] { 240, 240, 264 } , 3);
					
					if(face <= 10)
					{
						//top right spade
						g.fillArc(133, 30, 20,20,-180,180);
						g.fillArc(153, 30, 20, 20, -180, 180);
						g.fillPolygon(new int [] {133, 173, 153}, new int[] { 40, 40, 20 } , 3);
						g.fillPolygon(new int [] {145, 161, 153}, new int[] { 60, 60, 36 } , 3);
						
						//bottom left spade
						g.fillArc(27, 250, 20, 20, 180, -180);
						g.fillArc(47, 250, 20, 20, 180, -180);
						g.fillPolygon(new int [] {27, 67, 47}, new int[] { 260, 260, 280 } , 3);
						g.fillPolygon(new int [] {39, 55, 47}, new int[] { 240, 240, 264 } , 3);
					}
				}
				
				if(face == 6 || face == 7 || face == 8)
				{
					//center right spade
					g.fillArc(133, 140, 20, 20, -180, 180);
					g.fillArc(153, 140, 20, 20, -180, 180);
					g.fillPolygon(new int [] {133, 173, 153}, new int[] { 150, 150, 130 } , 3);
					g.fillPolygon(new int [] {145, 161, 153}, new int[] { 170, 170, 146 } , 3);
					
					//center left spade
					g.fillArc(27, 140, 20, 20, 180, -180);
					g.fillArc(47, 140, 20, 20, 180, -180);
					g.fillPolygon(new int [] {27, 67, 47}, new int[] { 150, 150, 170 } , 3);
					g.fillPolygon(new int [] {39, 55, 47}, new int[] { 130, 130, 154 } , 3);
				}
				
				if(face == 7 || face == 8)
				{
					//"7" spade
					g.fillArc(80, 90, 20,20,-180,180);
					g.fillArc(100, 90, 20, 20, -180, 180);
					g.fillPolygon(new int [] {80, 120, 100}, new int[] { 100, 100, 80 } , 3);
					g.fillPolygon(new int [] {92, 108, 100}, new int[] { 120, 120, 96 } , 3);
				}
				
				if(face == 8)
				{
					//"8" spade
					g.fillArc(80, 200, 20,20,180,-180);
					g.fillArc(100, 200, 20, 20, 180, -180);
					g.fillPolygon(new int [] {80, 120, 100}, new int[] { 210, 210, 230 } , 3);
					g.fillPolygon(new int [] {92, 108, 100}, new int[] { 190, 190, 214 } , 3);
				}
				
				if(face == 9 || face == 10)
				{
					//midUpper right spade
					g.fillArc(133, 100, 20, 20, -180, 180);
					g.fillArc(153, 100, 20, 20, -180, 180);
					g.fillPolygon(new int [] {133, 173, 153}, new int[] { 110, 110, 90 } , 3);
					g.fillPolygon(new int [] {145, 161, 153}, new int[] { 130, 130, 106 } , 3);
					
					//midUpper left spade
					g.fillArc(27, 100, 20, 20, -180, 180);
					g.fillArc(47, 100, 20, 20, -180, 180);
					g.fillPolygon(new int [] {27, 67, 47}, new int[] { 110, 110, 90 } , 3);
					g.fillPolygon(new int [] {39, 55, 47}, new int[] { 130, 130, 106 } , 3);
					
					//midLower left spade
					g.fillArc(27, 180, 20, 20, 180, -180);
					g.fillArc(47, 180, 20, 20, 180, -180);
					g.fillPolygon(new int [] {27, 67, 47}, new int[] { 190, 190, 210 } , 3);
					g.fillPolygon(new int [] {39, 55, 47}, new int[] { 170, 170, 194 } , 3);
					
					//midLower right spade
					g.fillArc(133, 180, 20, 20, 180, -180);
					g.fillArc(153, 180, 20, 20, 180, -180);
					g.fillPolygon(new int [] {133, 173, 153}, new int[] { 190, 190, 210 } , 3);
					g.fillPolygon(new int [] {145, 161, 153}, new int[] { 170, 170, 194 } , 3);
				}
				
				if(face == 10)
				{
					//top center spade
					g.fillArc(80, 60, 20,20,-180,180);
					g.fillArc(100, 60, 20, 20, -180, 180);
					g.fillPolygon(new int [] {80, 120, 100}, new int[] { 70, 70, 50 } , 3);
					g.fillPolygon(new int [] {92, 108, 100}, new int[] { 90, 90, 66 } , 3);
					
					//bottom center spade
					g.fillArc(80, 220, 20,20,180,-180);
					g.fillArc(100, 220, 20, 20, 180, -180);
					g.fillPolygon(new int [] {80, 120, 100}, new int[] { 230, 230, 250 } , 3);
					g.fillPolygon(new int [] {92, 108, 100}, new int[] { 210, 210, 234 } , 3);
				}
			}
		}
		
		if(face >= 11 && face <= 13)
		{
			g.setFont(new Font ("Times New Roman", Font.BOLD, 150));
			g.drawString(faceAsString, 50, 200);
		}
		
		g.setColor(Color.black);
		g.drawRect(0, 0, 200, 300);
		
	}
}