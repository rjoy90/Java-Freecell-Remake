package com.freecell.models;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Club extends DynamicCardRefined
{
	//clubs locations here
	private int club_ULcrnL_bX, club_LRcrnL_bX; //where the left and right most circles of upperLeft, lower right corners will start
	private int club_ULcrnC_bX; //center circle location of upper left corner 
	private int club_ULcrn_triC_bX;
	private int club_LRcrnC_bX;
	private int club_LRcrn_triC_bX;
	private int club_crnCircRad;
	private int club_circRad;
	private int club_crn_triDistX;
	private int club_triDistX;
	private int club_circDistX;
	private int club_crnCircDistX;
	
	private int club_leftL_bX;
	private int club_leftC_bX;
	private int club_centerL_bX;
	private int club_centerC_bX;
	private int club_rightL_bX;
	private int club_rightC_bX;
	
	private int club_center_tri_bX;
	private int club_left_tri_bX;
	private int club_right_tri_bX;
	private int club_top;
	private int club_ULcrn_triTop;
	private int club_crnTri_distY;
	private int club_bottom;
	private int club_LRcrn_tri_bottom;
	private int club_center;
	private int club_tri_distY;
	private int club_center_triTop;
	private int club_top_triTop;
	private int club_bottom_triBottom;
	private int club_centerLeft;
	private int club_centerRight;
	private int club_centerLeft_triBottom;
	private int club_seven_top;
	private int club_seven_tri_top;
	private int club_eight_bottom;
	private int club_eight_tri_bottom;
	private int club_nineTen_upperTop;
	private int club_nineTen_tri_top;
	private int club_nineTen_lowerBottom;
	private int club_nineTen_tri_bottom;
	private int club_ten_top;
	private int club_ten_tri_top;
	private int club_ten_bottom;
	private int club_ten_tri_bottom;
	
	public Club(int suit, int face, int size)
	{
		super(suit,face, size);
		//clubs section
		//Xs: leftMost circle
		club_crnCircRad = (int) (cSize/2.0);	//10
		club_circRad = (int) (size/2.0); //20
		club_ULcrnL_bX = 2;
		club_crnCircDistX = (int) Math.round(2.0*club_crnCircRad/3.0);	//7, distance from start of one circle to the next
		club_circDistX = (int) Math.round(2.0/3.0 * club_circRad);// 13 when rounded
		club_ULcrnC_bX = club_ULcrnL_bX + club_crnCircDistX; //where the center (top/bottom) circle of club starts
		club_LRcrnC_bX = (int) (width - club_crnCircRad - club_ULcrnL_bX - club_crnCircDistX); //181, lower right corner center circle x
		club_LRcrnL_bX = club_LRcrnC_bX - club_crnCircDistX;//lower right corner
				
		club_ULcrn_triC_bX =  (int) ((club_ULcrnC_bX + club_ULcrnC_bX + club_crnCircRad)/2.0); //center of upper left triangle x
		club_LRcrn_triC_bX = (int) ((club_LRcrnC_bX + club_LRcrnC_bX + club_crnCircRad)/2.0);//center of lower right triangle x
		
		club_crn_triDistX = (int) (2.0/5.0 * cSize); //8
		
		club_leftL_bX = (int) (club_ULcrnC_bX + club_crnCircDistX + club_crnCircRad + cSize/4.0); //31, leftMost circle of left column clubs
		club_leftC_bX = club_leftL_bX + club_circDistX; //center circle
		club_centerL_bX = (int) (width/2.0 - club_circRad/2 - club_circDistX);//77, this is left circle center clubs x
		club_centerC_bX = club_centerL_bX + club_circDistX; //90, center club center circle x
		
		club_rightC_bX = (int) (club_LRcrnL_bX - cSize/4.0 - club_circRad - club_circDistX);//140, center circle x
		club_rightL_bX = club_rightC_bX - club_circDistX; //127, where left most circle in right column starts x
		
		club_triDistX = (int) (2.0/5.0 * size); //16
		club_center_tri_bX = (int) ((club_centerC_bX +club_centerC_bX + club_circRad)/2.0); //100, center x of center club triangles
		club_left_tri_bX = (int) ((club_leftC_bX + club_leftC_bX + club_circRad)/2.0); //54, center x of left club triangles
		club_right_tri_bX = (int) ((club_rightC_bX + club_rightC_bX + club_circRad)/2.0); //150, center x of right club triangles
			
		//Ys
		club_top = 20; //top circle of top clubs
		club_ULcrn_triTop = (int) (club_top + 4.0/5.0 * club_crnCircRad);//28, hiding tip 1/5 into the center circle
		club_crnTri_distY = (int) (3.0/5.0 * cSize); //12
		club_bottom = height - club_top; //280, bottom of bottom circle
		club_LRcrn_tri_bottom = (int) (club_bottom - 4.0/5.0 * club_crnCircRad); //272, hiding tip 1/5 into center circle
		club_center = (int) (height/2.0 - cSize); //130, top circle
		club_tri_distY = (int) (3.0/5.0 * size); //24
		club_center_triTop = (int) (club_center + 4.0/5.0 * club_circRad); //146, tip of triangle
		club_top_triTop = (int) (club_top + 4.0/5.0 *club_circRad); //36, tip of triangle 
		club_bottom_triBottom = (int) (club_bottom - 4.0/5.0 * club_circRad);//264, tip of triangle
		club_centerLeft = (int) (height/2.0 + cSize);//170, bottom of bottom circle
		club_centerRight = (int) (height/2.0 - cSize);//130, top of top circle
		club_centerLeft_triBottom = (int) (club_centerLeft - 4.0/5.0 * club_circRad); //154, tip of triangle
		
		club_seven_top = (int) (club_top + 4.0*ySize/4.0);//80, top of top circle
		club_seven_tri_top = (int) (club_seven_top + 4.0/5.0 * club_circRad);//96, tip of triangle
		club_eight_bottom = (int) (club_bottom - 4.0*ySize/4.0 );//230, bottom of bottom circle
		club_eight_tri_bottom = (int) (club_eight_bottom - 4.0/5.0 * club_circRad);//214, tip of triangle
		club_nineTen_upperTop = (int) (club_top + ySize + 1.0*ySize/4.0);//90, top of top circle
		club_nineTen_tri_top =	(int) (club_nineTen_upperTop + 4.0/5.0*club_circRad);//106, tip of triangle
		club_nineTen_lowerBottom = (int) (club_bottom - ySize - 1.0*ySize/4.0);//210, bottom of bottom circle
		club_nineTen_tri_bottom = (int) (club_nineTen_lowerBottom - 4.0/5.0*club_circRad);//194, tip of triangle
		club_ten_top = (int) (club_top + 3.0*ySize/4.0);//50, top of center "5" top circle
		club_ten_tri_top = (int) (club_ten_top + 4.0/5.0 * club_circRad);//66, tip of triangle
		club_ten_bottom = (int) (club_bottom - 3.0*ySize/4.0);//250, bottom of bottom circle
		club_ten_tri_bottom = (int) (club_ten_bottom - 4.0/5.0 * club_circRad);//234, tip of triangle
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(Color.black);
		
		g.setFont(new Font("Times New Roman", Font.BOLD, 10));
		g.drawString(faceAsString, ULnumbX, ULnumbY);
		
		g.setFont(new Font("Times New Roman", Font.BOLD, -10));
		g.drawString(faceAsString, width-ULnumbX, height-ULnumbY);
		
		drawClub(g, club_ULcrnL_bX, club_ULcrnC_bX, club_top, club_crnCircRad, club_crnCircDistX,
		club_crn_triDistX, club_crnTri_distY, club_ULcrn_triC_bX, club_ULcrn_triTop, false);
		
		drawClub(g, club_LRcrnL_bX, club_LRcrnC_bX, club_bottom, club_crnCircRad, club_crnCircDistX,
		club_crn_triDistX, club_crnTri_distY, club_LRcrn_triC_bX, club_LRcrn_tri_bottom, true);
		
		if(face == 1 || face == 3 || face == 5 || face == 9)
		{
			drawClub(g, club_centerL_bX, club_centerC_bX, club_center, club_circRad, club_circDistX,
			club_triDistX, club_tri_distY, club_center_tri_bX, club_center_triTop, false); //center not flipped
		}
		
		if(face == 2 || face == 3)
		{
			drawClub(g, club_centerL_bX, club_centerC_bX, club_top, club_circRad, club_circDistX,
			club_triDistX, club_tri_distY, club_center_tri_bX, club_top_triTop, false); //top center not flipped
			
			drawClub(g, club_centerL_bX, club_centerC_bX, club_bottom, club_circRad, club_circDistX,
			club_triDistX, club_tri_distY, club_center_tri_bX, club_bottom_triBottom, true); //bottom center flipped
		}
		
		if(face >= 4)
		{
			drawClub(g, club_leftL_bX, club_leftC_bX, club_top, club_circRad, club_circDistX,
			club_triDistX, club_tri_distY, club_left_tri_bX, club_top_triTop, false); //top left not flipped
			
			drawClub(g, club_rightL_bX, club_rightC_bX, club_bottom, club_circRad, club_circDistX,
			club_triDistX, club_tri_distY, club_right_tri_bX, club_bottom_triBottom, true); //bottom right flipped
			
			if(face <= 10)
			{
				drawClub(g, club_rightL_bX, club_rightC_bX, club_top, club_circRad, club_circDistX,
				club_triDistX, club_tri_distY, club_right_tri_bX, club_top_triTop, false); //top right not flipped
						
				drawClub(g, club_leftL_bX, club_leftC_bX, club_bottom, club_circRad, club_circDistX,
				club_triDistX, club_tri_distY, club_left_tri_bX, club_bottom_triBottom, true); //bottom left flipped
			}
		}
		
		if(face >= 6 && face <= 8)
		{
			drawClub(g, club_leftL_bX, club_leftC_bX, club_centerLeft, club_circRad, club_circDistX,
			club_triDistX, club_tri_distY, club_left_tri_bX, club_centerLeft_triBottom, true); //center left, flipped
		
			drawClub(g, club_rightL_bX, club_rightC_bX, club_centerRight, club_circRad, club_circDistX,
			club_triDistX, club_tri_distY, club_right_tri_bX, club_center_triTop, false); //center right, not flipped
		}
		
		if(face == 7 || face == 8)
		{
			drawClub(g, club_centerL_bX, club_centerC_bX, club_seven_top, club_circRad, club_circDistX,
			club_triDistX, club_tri_distY, club_center_tri_bX, club_seven_tri_top, false); //seven "5" center, not flipped
		}
		
		if(face == 8)
		{
			drawClub(g, club_centerL_bX, club_centerC_bX, club_eight_bottom, club_circRad, club_circDistX,
			club_triDistX, club_tri_distY, club_center_tri_bX, club_eight_tri_bottom, true); //8 "5" center, flipped
		}
		
		if(face == 9 || face == 10)
		{
			drawClub(g, club_leftL_bX, club_leftC_bX, club_nineTen_upperTop, club_circRad, club_circDistX,
			club_triDistX, club_tri_distY, club_left_tri_bX, club_nineTen_tri_top, false); // MU left, not flipped
		
			drawClub(g, club_rightL_bX, club_rightC_bX, club_nineTen_lowerBottom, club_circRad, club_circDistX,
			club_triDistX, club_tri_distY, club_right_tri_bX, club_nineTen_tri_bottom, true); //ML right, flipped
		
			drawClub(g, club_rightL_bX, club_rightC_bX, club_nineTen_upperTop, club_circRad, club_circDistX,
			club_triDistX, club_tri_distY, club_right_tri_bX, club_nineTen_tri_top, false); // MU right, not flipped
				
			drawClub(g, club_leftL_bX, club_leftC_bX, club_nineTen_lowerBottom, club_circRad, club_circDistX,
			club_triDistX, club_tri_distY, club_left_tri_bX, club_nineTen_tri_bottom, true); //ML left, flipped
		
			if(face == 10)
			{
				drawClub(g, club_centerL_bX, club_centerC_bX, club_ten_top, club_circRad, club_circDistX,
				club_triDistX, club_tri_distY, club_center_tri_bX, club_ten_tri_top, false); //10 upper "5" center, not flipped
			
				drawClub(g, club_centerL_bX, club_centerC_bX, club_ten_bottom, club_circRad, club_circDistX,
				club_triDistX, club_tri_distY, club_center_tri_bX, club_ten_tri_bottom, true); //10 lower "5" center, flipped
			}
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
	
	public void drawClub(Graphics g, int leftBaseX, int centerBaseX, int BaseY, int radius, int circleDistance, int triDistanceX, 
	int triDistY, int triBaseX,int triBaseY, boolean flipped)
	{
		if(flipped)
		{
			g.fillOval(leftBaseX, (int) (BaseY-radius-radius/2.0), radius, radius);//left circle
			g.fillOval(centerBaseX, BaseY-radius, radius, radius);//bottom circle
			g.fillOval(centerBaseX+ circleDistance, (int) (BaseY - radius - radius/2.0), radius, radius);//right circle
			g.fillPolygon(new int [] {triBaseX, (int) (triBaseX - triDistanceX/2.0), (int) (triBaseX + triDistanceX/2.0)}, 
			new int [] {triBaseY, (int) (triBaseY - triDistY), (int) (triBaseY - triDistY)  }, 3); //base triangle
		}
		
		else
		{
			g.fillOval(leftBaseX, (int) (BaseY+radius/2.0), radius, radius); //left circle
			g.fillOval(centerBaseX, BaseY, radius, radius);//top circle
			g.fillOval(centerBaseX+circleDistance, (int) (BaseY+radius/2.0), radius, radius);//right circle
			g.fillPolygon(new int [] {triBaseX, (int) (triBaseX - triDistanceX/2.0), (int) (triBaseX + triDistanceX/2.0)}, 
			new int [] {triBaseY, (int) (triBaseY + triDistY), (int) (triBaseY + triDistY)  }, 3);//base triangle
		}
	}
}