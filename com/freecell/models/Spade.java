package com.freecell.models;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Spade extends DynamicCardRefined
{
	//--------------------------------------------------------
	//--------------Spades here-------------------------------
	//--------------------------------------------------------
	
	private int spade_crnDistX; //base triangle distance x
	private int spade_ULcrnL_bX; //left arc
	private int spade_ULcrnR_bX;//right arc
	private int spade_LRcrnL_bX;//left arc
	private int spade_LRcrnR_bX;//right arc
	private int spade_ULcrn_tri_bX; //center x of base triangle
	private int spade_LRcrn_tri_bX;//center x of base triangle
	private int spade_distX;//base triangle distance x
	private int spade_leftX;
	private int spade_left_tri_bX;
	private int spade_centerX;
	private int spade_centerTri_bX;
	private int spade_rightX;
	private int spade_rightTri_bX;
	private int spade_top;
	private int spade_crnDistY;//heart triangle height
	private int spade_distY;//heart triangle height
	private int spade_ULcrn_tri_bY;
	private int spade_top_tri_bY;
	private int spade_bottom;
	private int spade_LRcrn_tri_bY;
	private int spade_bottom_tri_bY;
	private int spade_centerY;
	private int spade_center_tri_bY;
	private int spade_centerL_bY;
	private int spade_sixSevEght_tri_bY;
	private int spade_sevEght_bY;
	private int spade_sevEght_tri_bY;
	private int spade_eight_bY;
	private int spade_eight_tri_bY;
	private int spade_nineTenU_bY;
	private int spade_nineTenU_tri_bY;
	private int spade_nineTenL_bY;
	private int spade_nineTenL_tri_bY;
	private int spade_tenU_bY;
	private int spade_tenU_tri_bY;
	private int spade_tenL_bY;
	private int spade_tenL_tri_bY;
		
	public Spade(int suit, int face, int size)
	{
		super(suit,face, size);
		spade_crnDistX = (int) (2.0/5.0*cSize);//8, distance for base triangle
		spade_distX = (int) (2.0/5.0 * size);//16, length of triangle base
		spade_ULcrnL_bX = 2;
		spade_LRcrnL_bX = (int) (width - cSize - spade_ULcrnL_bX);//178, start of left arc
		spade_ULcrnR_bX = spade_ULcrnL_bX + cSize/2; //12, start of right arc
		spade_LRcrnR_bX = spade_LRcrnL_bX+ cSize/2;//188, right arc
		spade_ULcrn_tri_bX = spade_ULcrnR_bX;//12, x of tip of triangles (heart part and base part)
		spade_LRcrn_tri_bX = spade_LRcrnR_bX;//188, x of tip of triangles (heart part and base part)
		
		spade_leftX = (int) (spade_ULcrnL_bX + cSize + cSize/4.0);//27, start of left arc
		spade_left_tri_bX = spade_leftX + cSize;//47, tip for triangle base x upper left
		spade_centerX = width/2 - cSize;//80, x start for center
		spade_centerTri_bX = spade_centerX + cSize;// tip for triangle baseX center
		spade_rightX = (int) (spade_LRcrnR_bX - cSize/2.0 - cSize/4.0 - size);//133
		spade_rightTri_bX = spade_rightX + cSize;//153, right base triangle center x
		
		spade_top = 20;//tip of heart part of triangle
		spade_crnDistY = (int) (3.0/5.0 *cSize);//12, height of base triangle
		spade_distY = (int) (3.0/5.0 * size);//24, height of base triangle
		spade_ULcrn_tri_bY = (int) (spade_top + 2.0/5.0 * cSize);//28, tip of base triangle for spade
		spade_top_tri_bY = (int) (spade_top + 2.0/5.0 * size);//36 
		spade_bottom = height-spade_top;//280, tip of heart triangle
		spade_LRcrn_tri_bY = (int) (spade_bottom -  2.0/5.0 * cSize);//272, tip of base triangle for spade
		spade_bottom_tri_bY = (int) (spade_bottom - 2.0/5.0 * size);//264 
		spade_centerY = (int) (height/2.0 - ySize/2.0);//130, tip of heart triangle, A,3, 5, 9, and 6,7,8 centerRight
		spade_center_tri_bY = (int) (spade_centerY + 2.0/5.0 * size);//146, tip of base triangle for spade, A,3,5,9, and 6,7,8 center right
		spade_centerL_bY = spade_centerY + size;//170, bottom of heart triangle, 6,7,8 center left
		spade_sixSevEght_tri_bY = (int) (spade_centerL_bY - 2.0/5.0 * size);//tip of base triangle
		spade_sevEght_bY = (int) (spade_top + 4.0*ySize/4.0);//80, top of heart triangle
		spade_sevEght_tri_bY = (int) (spade_sevEght_bY + 2.0/5.0 * size);
		spade_eight_bY = (int) (spade_bottom - 4.0*ySize/4.0);//230, bottom of heart triangle
		spade_eight_tri_bY = (int) (spade_eight_bY - 2.0/5.0 * size);//214, tip of base triangle
		spade_nineTenU_bY = (int) (spade_top + ySize + 1.0*ySize/4.0);//90, top of heart triangle
		spade_nineTenU_tri_bY = (int) (spade_nineTenU_bY + 2.0/5.0* size);//106, tip of base triangle
		spade_nineTenL_bY = (int) (spade_bottom  -ySize - 1.0*ySize/4.0);//210, bottom of heart triangle
		spade_nineTenL_tri_bY = (int) (spade_nineTenL_bY - 2.0/5.0 * size);//194, tip of base triangle
		spade_tenU_bY = (int) (spade_top + 3.0*ySize/4.0);//50, top of heart triangle
		spade_tenU_tri_bY = (int) (spade_tenU_bY + 2.0/5.0 * size);//66, tip of base triangle
		spade_tenL_bY = (int) (spade_bottom - 3.0*ySize/4.0);//250, bottom of heart triangle
		spade_tenL_tri_bY = (int) (spade_tenL_bY - 2.0/5.0 * size);//234, tip of base triangle
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(Color.black);
		g.setFont(new Font("Times New Roman", Font.BOLD, 10));
		g.drawString(faceAsString, ULnumbX, ULnumbY);
		
		g.setFont(new Font("Times New Roman", Font.BOLD, -10));
		g.drawString(faceAsString, width-ULnumbX, height-ULnumbY);
		
		drawSpade(g, spade_ULcrnL_bX, spade_top, cSize/2, spade_ULcrn_tri_bX, spade_ULcrn_tri_bY, 
		spade_crnDistX, spade_crnDistY, false);//upper left corner not flipped
		
		drawSpade(g, spade_LRcrnL_bX, spade_bottom, cSize/2, spade_LRcrn_tri_bX, spade_LRcrn_tri_bY, 
		spade_crnDistX, spade_crnDistY, true);//lower right corner flipped
		
		if(face == 1 || face == 3 || face == 5 || face == 9)
		{
			drawSpade(g, spade_centerX, spade_centerY, size/2, spade_centerTri_bX, spade_center_tri_bY,  
			spade_distX, spade_distY, false);//upper left corner not flipped		
		}
		
		if(face == 2 || face == 3)
		{
			drawSpade(g, spade_centerX, spade_top, size/2, spade_centerTri_bX, spade_top_tri_bY,  
			spade_distX, spade_distY, false);//top center, not flipped
			
			drawSpade(g, spade_centerX, spade_bottom, size/2, spade_centerTri_bX, spade_bottom_tri_bY,  
			spade_distX, spade_distY, true);//bottom center, flipped
		}
		
		if(face >= 4)
		{
			drawSpade(g, spade_leftX, spade_top, size/2, spade_left_tri_bX, spade_top_tri_bY,  
			spade_distX, spade_distY, false);//top left, not flipped
			
			drawSpade(g, spade_rightX, spade_bottom, size/2, spade_rightTri_bX, spade_bottom_tri_bY,  
			spade_distX, spade_distY, true);//bottom right, flipped
			
			if(face <= 10)
			{
				drawSpade(g, spade_rightX, spade_top, size/2, spade_rightTri_bX, spade_top_tri_bY,  
				spade_distX, spade_distY, false);//top right, not flipped
				
				drawSpade(g, spade_leftX, spade_bottom, size/2, spade_left_tri_bX, spade_bottom_tri_bY,  
				spade_distX, spade_distY, true);//bottom left, flipped
			}
		}
		
		if(face >= 6 && face <= 8)
		{
			drawSpade(g, spade_leftX, spade_centerL_bY, size/2, spade_left_tri_bX, spade_sixSevEght_tri_bY,  
			spade_distX, spade_distY, true);//center left, flipped
			
			drawSpade(g, spade_rightX, spade_centerY, size/2, spade_rightTri_bX, spade_center_tri_bY,  
			spade_distX, spade_distY, false);//center right, not flipped
		}
		
		if(face == 7 || face == 8)
		{
			drawSpade(g, spade_centerX, spade_sevEght_bY, size/2, spade_centerTri_bX, spade_sevEght_tri_bY,  
			spade_distX, spade_distY, false);//center right, not flipped
		}
		
		if(face == 8)
		{
			drawSpade(g, spade_centerX, spade_eight_bY, size/2, spade_centerTri_bX, spade_eight_tri_bY,  
			spade_distX, spade_distY, true);//center right, not flipped
		}

		if(face == 9 || face == 10)
		{
			drawSpade(g, spade_leftX, spade_nineTenU_bY, size/2, spade_left_tri_bX, spade_nineTenU_tri_bY,  
			spade_distX, spade_distY, false);//center right, not flipped
			
			drawSpade(g, spade_rightX, spade_nineTenU_bY, size/2, spade_rightTri_bX, spade_nineTenU_tri_bY,  
			spade_distX, spade_distY, false);//center right, not flipped
			
			drawSpade(g, spade_leftX, spade_nineTenL_bY, size/2, spade_left_tri_bX, spade_nineTenL_tri_bY,  
			spade_distX, spade_distY, true);//center right, not flipped
			
			drawSpade(g, spade_rightX, spade_nineTenL_bY, size/2, spade_rightTri_bX, spade_nineTenL_tri_bY,  
			spade_distX, spade_distY, true);//center right, not flipped
		}
		
		if(face == 10)
		{
			drawSpade(g, spade_centerX, spade_tenU_bY, size/2, spade_centerTri_bX, spade_tenU_tri_bY,  
			spade_distX, spade_distY, false);//center right, not flipped
			
			drawSpade(g, spade_centerX, spade_tenL_bY, size/2, spade_centerTri_bX, spade_tenL_tri_bY,  
			spade_distX, spade_distY, true);//center right, not flipped
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
	
	public void drawSpade(Graphics g, int leftBaseX, int triTipBaseY, int radius, int baseTriX, int baseTriY, 
	int baseTriDistX, int baseTriHeight, boolean flipped)
	{
		if(!flipped)
		{	
			//left base used to make "heart triangle", as well as triTip
			g.fillPolygon(new int [] {leftBaseX, leftBaseX + radius,  leftBaseX + 2*radius }, 
			new int[] {triTipBaseY + radius, triTipBaseY, triTipBaseY +radius},  3);
			g.fillArc(leftBaseX, (int) (triTipBaseY + radius/2.0), radius, radius, -180, 180);//left arc 
			g.fillArc(leftBaseX + radius, (int) (triTipBaseY + radius/2.0), radius, radius, -180, 180);//right arc
			g.fillPolygon(new int[] {baseTriX, (int) (baseTriX -baseTriDistX/2.0), (int) (baseTriX + baseTriDistX/2.0) }, 
			new int[] {baseTriY, baseTriY + baseTriHeight, baseTriY+baseTriHeight }, 3);
		}
		
		else
		{
			//left base used to make "heart triangle", as well as triTip
			g.fillPolygon(new int [] {leftBaseX, leftBaseX + radius,  leftBaseX + 2*radius }, 
			new int[] {triTipBaseY - radius, triTipBaseY, triTipBaseY - radius},  3);
			g.fillArc(leftBaseX, (int) (triTipBaseY - radius - radius/2.0), radius, radius, 180, -180);//left arc 
			g.fillArc(leftBaseX + radius, (int) (triTipBaseY - radius - radius/2.0), radius, radius, 180, -180);//right arc
			g.fillPolygon(new int[] {baseTriX, (int) (baseTriX -baseTriDistX/2.0), (int) (baseTriX + baseTriDistX/2.0) }, 
			new int[] {baseTriY, baseTriY - baseTriHeight, baseTriY - baseTriHeight }, 3);
		}
	}
}