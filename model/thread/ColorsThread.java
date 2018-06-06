package testWithThread.model.thread;

import testWithThread.frame.ICanvas;
import testWithThread.model.Ball;

class ColorsThread extends Thread {
	
	private Ball ball;
	
     		
	ColorsThread(Ball b) {
        ball = b;       
    }
	
	@Override
	public void run() {			
        			
		while(!Thread.currentThread().isInterrupted()) {
							
			try {
				Thread.sleep(750);				
				ball.changeColor();
				
			} catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
		}				
	}
}