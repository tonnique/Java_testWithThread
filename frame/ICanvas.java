package testWithThread.frame;

import java.awt.Rectangle;

import testWithThread.model.IModel;

public interface ICanvas {

	void repaint();
	
	void setModel(IModel model);
	
	Rectangle getCanvasBounds();


}
