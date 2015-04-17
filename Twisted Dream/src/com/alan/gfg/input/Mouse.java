package com.alan.gfg.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseListener, MouseMotionListener{

	public static int mouseX = -1;
	public static int mouseY = -1;
	private static int mouseB = -1;
	
	public static int MouseDX;
	public static int MouseDY;
	public static int MousePX;
	public static int MousePY;
	
	public static boolean dragged = false;
	
	public static int getX(){
		return mouseX;
	}
	
	public static int getY(){
		return mouseY;
	}
	
	public static int getButton(){
		return mouseB;
	}
	
	public void mouseDragged(MouseEvent arg0) {
		MouseDX = arg0.getX();
		MouseDY = arg0.getY();
	}

	public void mouseMoved(MouseEvent arg0) {
		mouseX = arg0.getX();
		mouseY = arg0.getY();
	}

	public void mouseClicked(MouseEvent arg0) {
		
	}

	public void mouseEntered(MouseEvent arg0) {
		
	}

	public void mouseExited(MouseEvent arg0) {
		
	}

	public void mousePressed(MouseEvent arg0) {
		mouseB = arg0.getButton();
		MousePX = arg0.getX();
		MousePY = arg0.getY();
		dragged = true;
	}

	public void mouseReleased(MouseEvent arg0) {
		mouseB = -1;
		dragged = false;
	}

}
