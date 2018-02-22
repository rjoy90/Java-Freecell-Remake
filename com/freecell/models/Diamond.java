package com.freecell.models;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Diamond extends DynamicCardRefined
{
	//--------------------------------------------------------
	//--------------Diamonds here-----------------------------
	//--------------------------------------------------------
	private int diamond_ULcrn_bX;
	private int diamond_LRcrn_bX;
	private int diamondLeftX;
	private int diamondCenterX;
	private int diamondRightX;
	private int diamond_top;
	private int diamond_centerY;
	private int diamond_bottomY;	//for alignment reasons, the top corner of the bottom corner and regular bottom suits are not the same
	private int diamond_bottom_crnY;
	private int diamond_sevenEightY;
	private int diamond_eightY;
	private int diamond_nineTen_upperY;
	private int diamond_nineTen_lowerY;
	private int diamond_ten_upperY;
	private int diamond_ten_lowerY;
		
	public Diamond(int suit, int face, int size)
	{
		super(suit,face, size);
		diamond_ULcrn_bX = 2;	diamond_LRcrn_bX = (int) (width - cSize - diamond_ULcrn_bX - cSize/4.0);//178, left corner of diamond
		diamondLeftX = (int) (diamond_ULcrn_bX + cSize + cSize/4.0);//27, left corner of diamond
		diamondCenterX = (int) (width/2.0 - cSize); //80, left corner of diamond
		diamondRightX = (int) (diamond_LRcrn_bX - cSize/4.0 - size);// 133, left corner of diamond
		diamond_top = 20;	//top corner of diamond
		diamond_centerY = (int) (height/2.0 - cSize);//130, top corner of diamond
		diamond_bottom_crnY = (int) (height - size - 10);//260, top corner of diamond
		diamond_bottomY = (int) (diamond_bottom_crnY - size/2 );//240, top of diamond
		diamond_sevenEightY = (int) (diamond_top + 4.0*ySize/4.0);//80, top corner of diamond
		diamond_eightY = (int) (diamond_bottomY - 4.0*ySize/4.0);//210, top corner of diamond
		diamond_nineTen_upperY = (int) (diamond_top + ySize + 1.0*ySize/4.0);//90, top corner of diamond
		diamond_nineTen_lowerY = (int) (diamond_bottomY - ySize - 1.0*ySize/4.0);//230,top of diamond
		diamond_ten_upperY = (int) (diamond_top +3.0*ySize/4.0);//50, top of diamond
		diamond_ten_lowerY = (int) (diamond_bottomY - 3.0*ySize/4.0);//250, bottom of diamond
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(Color.red);
		g.setFont(new Font("Times New Roman", Font.BOLD, 10));
		g.drawString(faceAsString, ULnumbX, ULnumbY);
		
		g.setFont(new Font("Times New Roman", Font.BOLD, -10));
		g.drawString(faceAsString, width-ULnumbX, height-ULnumbY);
		
		drawDiamond(g, diamond_ULcrn_bX, diamond_top, cSize);
		drawDiamond(g, diamond_LRcrn_bX, diamond_bottom_crnY, cSize);
		
		if(face == 1 || face == 3 || face == 5 || face == 9)
		{
			drawDiamond(g,diamondCenterX, diamond_centerY, size); //center not flipped
		}
		
		if(face == 2 || face == 3)
		{
			drawDiamond(g, diamondCenterX, diamond_top, size);
			drawDiamond(g ,diamondCenterX, diamond_bottomY,size);
		}
		
		if(face >= 4)
		{
			drawDiamond(g, diamondLeftX, diamond_top, size);
			drawDiamond(g, diamondRightX, diamond_bottomY, size);
			
			if(face <= 10)
			{
				drawDiamond(g, diamondRightX, diamond_top, size);
				drawDiamond(g, diamondLeftX, diamond_bottomY, size);
			}
		}
		
		if(face >= 6 && face <= 8)
		{
			drawDiamond(g, diamondRightX , diamond_centerY , size);
			drawDiamond(g, diamondLeftX, diamond_centerY, size);
		}
		
		if(face == 7 || face == 8)
		{
			drawDiamond(g, diamondCenterX, diamond_sevenEightY, size);
		}
		
		if(face == 8)
		{
			drawDiamond(g, diamondCenterX, diamond_eightY, size);
		}

		if(face == 9 || face == 10)
		{
			drawDiamond(g, diamondLeftX, diamond_nineTen_upperY, size);
			drawDiamond(g, diamondRightX, diamond_nineTen_upperY, size);
			drawDiamond(g, diamondLeftX, diamond_nineTen_lowerY, size);
			drawDiamond(g, diamondRightX, diamond_nineTen_lowerY, size);
		}
		
		if(face == 10)
		{
			drawDiamond(g, diamondCenterX, diamond_ten_upperY, size);
			drawDiamond(g, diamondCenterX, diamond_ten_lowerY, size);
		}
		
		if(face == 11 || face == 12 || face == 13)
		{
			g.setFont(new Font("Times New Roman", Font.BOLD, size*3));
			g.drawString(faceAsString, (int) (width/2.0 - size), (int) (height/2.0 + size));
		}
		
		g.setColor(Color.black);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(5));
		
		g.drawRect(0, 0, width-1, height-1);
	}
	
	public void drawDiamond(Graphics g, int leftBaseX, int topBaseY, int size)
	{
		g.fillPolygon(new int[] {leftBaseX, leftBaseX+size/2, leftBaseX+size, leftBaseX+size/2}, 
		new int[] {topBaseY + size/2, topBaseY, topBaseY + size/2, topBaseY + size }, 4);//left, top, right, bottom
	}
	
}