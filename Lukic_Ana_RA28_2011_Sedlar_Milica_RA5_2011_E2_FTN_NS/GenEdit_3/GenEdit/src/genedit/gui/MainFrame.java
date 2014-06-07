package genedit.gui;


import genedit.model.graph.GraphDocument;
import genedit.view.graph.GraphDocumentView;

import javax.swing.*;


@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	
	public MainFrame() {
		super();
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		GraphDocument doc1 = new GraphDocument();
		GraphDocumentView view = new GraphDocumentView(doc1);
		add(view.getWorkArea());
	}

}
