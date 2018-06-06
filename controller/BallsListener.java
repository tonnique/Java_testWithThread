package testWithThread.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import testWithThread.frame.IBallsFrame;
import testWithThread.frame.ICanvas;
import testWithThread.model.*;

public class BallsListener implements ActionListener {

	private IModel model;

	public BallsListener(IModel model) {
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() instanceof JButton) {
			
			JButton srcButton = (JButton) e.getSource();
			
			if (srcButton.getActionCommand().equals("add")) {
				if (model == null) { 
					System.out.println("Model is null");									
				} else {
					model.addBall();					
				}
			} 
			else if (srcButton.getActionCommand().equals("clear"))  
			{
				if (model == null) {
					return;
				}
				model.stopAllThreads();				
			}
		}
	}	
}
