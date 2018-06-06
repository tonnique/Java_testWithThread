package testWithThread;

import java.awt.EventQueue;
import javax.swing.JFrame;

import testWithThread.frame.BallsFrame;

public class Launch {

	public static void main(String[] args) {
		
		BallsFrame frame = new BallsFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				frame.setVisible(true);				
			}
		});
	}
}
