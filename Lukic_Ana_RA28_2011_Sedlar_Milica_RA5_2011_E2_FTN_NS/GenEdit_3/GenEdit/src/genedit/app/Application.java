package genedit.app;


import genedit.gui.MainFrame;

import javax.swing.WindowConstants;

public class Application {

	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
	}

}
