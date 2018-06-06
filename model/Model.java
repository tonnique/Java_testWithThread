package testWithThread.model;

import java.util.ArrayList;
import java.util.LinkedList;

import testWithThread.frame.ICanvas;
import testWithThread.model.thread.MovingBallThread;

public class Model implements IModel {
	
	private ICanvas canvas;
	private LinkedList<Ball> balls;
	private LinkedList<Thread> ballThreads;
		
	public Model(ICanvas canvas) {
		balls = new LinkedList<>();
		ballThreads = new LinkedList<>();
		this.canvas = canvas;
		canvas.setModel(this);
	} 
	
	private MovingBallThread movingBallThread;

	@Override
	public LinkedList<Ball> getBalls() {		
		return balls;
	}

	@Override
	public void addBall() {
		Ball ball = new Ball(canvas.getCanvasBounds());
		balls.add(ball);
		
		movingBallThread = new MovingBallThread(ball, canvas);
		movingBallThread.start();
		ballThreads.add(movingBallThread);
	}
	
	public void stopAllThreads() {
		
		for (Thread thread : ballThreads) {
			thread.interrupt();
			thread = null;	
		}
		
		ballThreads.clear();
		balls.clear();
		
		canvas.repaint();
	}
}
