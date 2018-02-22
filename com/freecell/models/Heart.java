package com.freecell.models;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Heart extends DynamicCardRefined
{
	//--------------------------------------
	//-------hearts dynamic locations-------
	//--------------------------------------	
	private int heart_bottom; //y of bottom hearts 
	private int heart_top;//y of top hearts
	private int heart_center_bY;//y of center hearts (A,3,5,9)
	private int heart_centerL_bY;//6,7,8
	private int heart_centerR_bY;//6,7,8
	private int heart_sevEghtC_bY;//7,8
	private int heart_eightC_bY;//8 only
	private int heart_nineTenU_bY;//9 10
	private int heart_nineTenL_bY;// 9 10
	private int heart_TenU_bY;//10
	private int heart_TenL_bY;//10
	private int heart_ULcbX;
	private int heart_LRcbX;
	private int heart_leftX;
	private int heart_rightX;
	private int heart_centerX;
	public Heart(int suit, int face, int size)
	{
		super(suit,face, size);
		//hearts:	the following are baseYs for each number, uppers being upperMost, lower being lowerMost 
		heart_top = 20;		//"20" top corners, 2, 3
		heart_bottom = height - heart_top;//"280"  bottom corners, 2,3
		heart_center_bY = (int) (height/2.0 - ySize/2.0);//"130" A,3,5,9
		heart_centerL_bY = (int) (height/2.0 + ySize/2.0);//"170", for 6,7,8
		heart_centerR_bY = heart_center_bY;//"130"	   6,7,8 (normal on right)
		
		heart_sevEghtC_bY = (int) (heart_top + 4.0*ySize/4.0);//7,8	(center, normal)
		
		heart_eightC_bY = (int) (heart_bottom - 4.0*ySize/4.0);//8 (center, flipped)
		//for 7,8 --> 20 scale factor = 0, 40 scale factor = 
		
		heart_nineTenU_bY = (int) (heart_top + ySize + 1.0*ySize/4.0);	//"90" 	9,10 (midUpper,normal)
		//for 9,10 -->  12 scale factor = 0, 20 scale factor = 1/2, 40 scales factor = 3/4

		//"210", 9,10 (center,flip)
		heart_nineTenL_bY = (int) (heart_bottom  - ySize - 1.0*ySize/4.0);	
		
		heart_TenU_bY = (int) (heart_top + 3.0*ySize/4.0);
		heart_TenL_bY = (int) (heart_bottom - 3.0*ySize/4.0); 
		//heart_TenU_bY = (int) (heart_nineTenU_bY-ySize +cSize/2.0);	//"60" 10 only (upper "5")	
		//heart_TenL_bY = (int) (heart_bottom - ySize/2.0); //"240" ten only (lower "5");

		//heart Xs:
		heart_ULcbX = 2;	heart_LRcbX = width-cSize-heart_ULcbX; //178, leftMost arc
				 			
		heart_leftX = (int) (heart_ULcbX+cSize + cSize/4.0);	// "27" leftArc, leftColumn 	
		heart_rightX = (int) (heart_LRcbX - size - cSize/4.0);//"173", leftArc, right column  
		heart_centerX = (int) (width/2.0 - cSize); //"80", leftArc, center column
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(Color.red);
		g.setFont(new Font("Times New Roman", Font.BOLD, 10));
		g.drawString(faceAsString, ULnumbX, ULnumbY);
		
		g.setFont(new Font("Times New Roman", Font.BOLD, -10));
		g.drawString(faceAsString, width-ULnumbX, height-ULnumbY);
		
		drawHeart(g, heart_ULcbX, heart_top, cSize, (3*cSize/4), false);//corner size normal
		drawHeart(g, heart_LRcbX, heart_bottom, cSize, (3*cSize/4), true);//corner size flipped
		
		if(face == 1 || face == 3 || face == 5 || face == 9)
		{
			drawHeart(g,heart_centerX, heart_center_bY, size, (3*size/4), false); //center not flipped
		}
		
		if(face == 2 || face == 3)
		{
			drawHeart(g, heart_centerX, heart_top, size, (3*size/4), false);
			drawHeart(g ,heart_centerX, heart_bottom,size,(3*size/4), true);
		}
		
		if(face >= 4)
		{
			drawHeart(g, heart_leftX, heart_top, size, (3*size/4), false);
			drawHeart(g, heart_rightX, heart_bottom, size, (3*size/4),true);
			
			if(face <= 10)
			{
				drawHeart(g, heart_rightX, heart_top, size, (3*size/4), false);
				drawHeart(g, heart_leftX, heart_bottom, size, (3*size/4), true);
			}
		}
		
		if(face >= 6 && face <= 8)
		{
			drawHeart(g, heart_rightX , heart_centerR_bY , size, (3*size/4), false);
			drawHeart(g, heart_leftX, heart_centerL_bY, size, (3*size/4), true);
		}
		
		if(face == 7 || face == 8)
		{
			drawHeart(g, heart_centerX, heart_sevEghtC_bY, size, (3*size/4), false);
		}
		
		if(face == 8)
		{
			drawHeart(g, heart_centerX, heart_eightC_bY, size, (3*size/4), true);
		}

		if(face == 9 || face == 10)
		{
			drawHeart(g, heart_leftX, heart_nineTenU_bY, size, (3*size/4), false);
			drawHeart(g, heart_rightX, heart_nineTenU_bY, size, (3*size/4), false);
			drawHeart(g, heart_leftX, heart_nineTenL_bY, size, (3*size/4), true);
			drawHeart(g, heart_rightX, heart_nineTenL_bY, size, (3*size/4), true);
		}
		
		if(face == 10)
		{
			drawHeart(g, heart_centerX, heart_TenU_bY, size, (3*size/4), false);
			drawHeart(g, heart_centerX, heart_TenL_bY, size, (3*size/4), true);
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
	
	public void drawHeart(Graphics g, int baseX, int baseY, int size, int triHeight, boolean flipped)
	{
		if(!flipped)
		{
			g.fillArc(baseX, baseY, size/2, size/2, 180, -180);//left arc
			g.fillArc(baseX+(size/2), baseY, size/2, size/2, 180, -180);//right triangle
			g.fillPolygon(new int[] {baseX, baseX+size, baseX + (size/2)}, 
			new int[] {baseY+(size/4),baseY+(size/4),baseY+(size/4) + triHeight }, 3);//base triangle
		}
		
		else
		{
			//bottom of the arc, need to figure in half the size of baseY when flipped
			g.fillArc(baseX, baseY-(size/2), size/2, size/2, -180, 180);//left arc
			g.fillArc(baseX+(size/2), baseY-(size/2), size/2, size/2, -180, 180);//right arc
			g.fillPolygon(new int[] {baseX, baseX+size, baseX + (size/2)}, 
			new int[] {baseY-(size/4),baseY-(size/4),baseY-(size/4) - triHeight }, 3);//base triangle
		}
	}
}