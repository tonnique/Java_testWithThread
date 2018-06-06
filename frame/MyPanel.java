package testWithThread.frame;

import java.awt.*;
import javax.swing.*;

import testWithThread.model.Ball;
import testWithThread.model.IModel;


public class MyPanel extends JPanel implements ICanvas {

	private static final long serialVersionUID = 1L;
	private IModel model;
	
	//Color color;
	//Ball ball;
	
	public MyPanel(int width, int height) {
		setPreferredSize(new Dimension(width, height));		
	}
		
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // clears the backgound
		
		if (model == null) {
			return;
		}
		
		for (Ball ball : model.getBalls()) {
			drawBall(g, ball);
		}		
	} 
	
	private void drawBall(Graphics g, Ball ball) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(ball.getActiveColor());
		g2.fill(ball.getShape());
		g2.setColor(Color.BLACK);
		g2.draw(ball.getShape());
	}
	
	@Override
	public Rectangle getCanvasBounds() {
		return getBounds();
	}
	
	
	public void setModel(IModel model) {
		this.model = model;
	}
}
