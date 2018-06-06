package testWithThread.model;

import java.util.LinkedList;

public interface IModel {
	
	LinkedList<Ball> getBalls();

	void addBall();
	
	void stopAllThreads();
	

}
