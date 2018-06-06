package testWithThread.model.thread;

import testWithThread.frame.ICanvas;
import testWithThread.model.Ball;

/**
 * Поток ждет 30 млс и затем перемещает свой шарик и вызывает метод repaint у панели 
 */
public class MovingBallThread extends Thread {
	
	private ColorsThread colorsThread;
	
	private Ball ball;
	private ICanvas canvas;
	     		
	public MovingBallThread(Ball b, ICanvas canvas) {
        ball = b;
        this.canvas = canvas;
    }
	
	@Override
	public void run() {
		if (colorsThread == null) {
			colorsThread = new ColorsThread(ball);
			colorsThread.start();
		}
		        			
		while(!Thread.currentThread().isInterrupted()) {
							
			try {
				Thread.sleep(30);
				
				ball.move();					
				canvas.repaint();
                
			} catch (InterruptedException e) {
				colorsThread.interrupt();
                Thread.currentThread().interrupt();
            }
		}
		
		colorsThread.interrupt();
		colorsThread = null;
	}
}