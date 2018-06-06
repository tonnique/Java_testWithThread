/* ��� ��������� ���� �������� ��� �������� ������ � �������� (Thread)
 * ���� ��������� � ��������� - ������������ �������� �� ������ Add � �� ���� ���������� �����,  -
 *  ������� ������ � ����������� �� �����. ����� ������ 2�� �������.
 *
 * TODO � ������� ��� ��� ������� ������ clear - ����� �� ��������� - �� ������ ���� ��������������, 
 * �� ���������� ������������ � ������ ������ 2�� �������. ������ �� ��� ���������� � �������� �� ������ ��� �������.
 * ����� ���� ���� �� ��������� ����������� ������� ����������� ��������� ����� ������� (� ����� ��� ����� ������ � ������). */

package testWithThread.frame;

import java.awt.*;
import javax.swing.*;

import testWithThread.model.Ball;
import testWithThread.model.IModel;
import testWithThread.model.Model;
import testWithThread.controller.BallsListener;


public class BallsFrame extends JFrame implements IBallsFrame {

	private static final long serialVersionUID = 1L;
	
	MyPanel ballPanel = new MyPanel(PANEL_WIDTH, PANEL_HEIGHT);
	
	IModel model = new Model((ICanvas) ballPanel);	
	BallsListener listener = new BallsListener(model);
	
	JButton addButton;	
	JButton clearButton;

	public BallsFrame() {
		super("Fliying balls wth 2 colors");		

		addComponents();		
		pack();
		setFrameOnCenter();		
	}

	private void addComponents(){
		Container c = getContentPane();
		
		addButton = new JButton("Add");
		addButton.setActionCommand("add");
		addButton.addActionListener(listener);
		clearButton = new JButton("Clear");
		clearButton.setActionCommand("clear");
		clearButton.addActionListener(listener);
				
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.add(addButton);
		buttonsPanel.add(clearButton);
		
		c.add(ballPanel, BorderLayout.CENTER);
		c.add(buttonsPanel, BorderLayout.SOUTH);
		
	}
	
	private void setFrameOnCenter() {
				
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds((screenWidth - this.getWidth())/2, (screenHeight-getHeight())/2, this.getWidth(), this.getHeight());		
	}
	
	@Override
	public ICanvas getCanvas() {
		return (ICanvas) ballPanel;
	}

}
