package testWithThread.model;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Ball {
	private final int MINIMUM_DIAMETER_VALUE = 10;
	private final int MAXIMUM_DIAMETER_VALUE = 25;
	
	private double x;	
	private double y;
	
	private double dx = 1;
	private double dy = 1;
	
	private int diameter;
	
	private Rectangle bounce;
	
	private Color color1;
	private Color color2;
	private Color activeColor;
	
	//int colornumber = 0;
	
	Random random = new Random();
	
	/**
	 * Creates a ball with random 2 Colors and random Diameter (in Certain Range)
	 */
	public Ball(Rectangle bounce) {
		this.bounce = bounce;
		initBall();
		setPosition(bounce);
	}
		
	private void initBall() {
		// Define random diameter value from minimum to maximum
		diameter = MINIMUM_DIAMETER_VALUE + 	(int) (Math.random() * (MAXIMUM_DIAMETER_VALUE - MINIMUM_DIAMETER_VALUE));
				
		int r1 = random.nextInt(255);
		int r2 = random.nextInt(255);
		int g1 = random.nextInt(255);
		int g2 = random.nextInt(255);
		int b1 = random.nextInt(255);
		int b2 = random.nextInt(255);
		
		color1 = new Color(r1, g1, b1);
		color2 = new Color(r2, g2, b2);
		activeColor = color1;		
	}
	
	// move a ball on a scene
	public void move() {
		x += dx;
		y += dy;
		
		if (x <= 0) {
            dx = -dx;
            x = 0;
        }

        if  (x + diameter >= bounce.getMaxX()) {
            dx = -dx;
            x = bounce.getMaxX() - diameter;
        }
        		
        if (y <= 0) {
            dy = -dy;
            y = 0;
        }
		
		if (y + diameter >= bounce.getMaxY()) {
			dy = -dy;
			y = bounce.getMaxY() - diameter;
		}		
	}
		
	// set a ball on a scene randomly
    private void setPosition(Rectangle bounce) {    	
        x = random.nextInt((int) bounce.getMaxX());
        y = random.nextInt((int) bounce.getMaxY());
    }
	
        
    public Color getActiveColor() {
    	return activeColor;
    }
    
    public void changeColor() {
    	/*
		if (colornumber % 2 != 0) {
    		activeColor = color1;
    		colornumber = 1;
    	}
    	else {
    		activeColor = color2;
    		colornumber = 2;
    	} 
    	colornumber++;
    	*/
    	
    	if (activeColor == color1) {
    		activeColor = color2;
    	} else {
    		activeColor = color1;
    	}
    }
    
	public Ellipse2D getShape() {		
		return new Ellipse2D.Double(x, y, diameter, diameter);
	}
}
