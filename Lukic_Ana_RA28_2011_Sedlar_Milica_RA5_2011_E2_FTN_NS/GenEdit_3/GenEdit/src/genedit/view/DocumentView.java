/***********************************************************************
 * Module:  DocumentView.java
 * Author:  Maja
 * Purpose: Defines the Class DocumentView
 ***********************************************************************/

package genedit.view;

import genedit.model.*;
import java.util.*;

import javax.swing.JComponent;

public class DocumentView implements Observer {

	protected Document document;
	protected JComponent workArea;

	public DocumentView(Document document) {
		super();
		this.document = document;
		document.addObserver(this);
	}

	public int zoom() {
		// TODO: implement
		return 0;
	}

	public int scroll() {
		// TODO: implement
		return 0;
	}

	public int paint() {
		// TODO: implement
		return 0;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		workArea.repaint();
	}

	public JComponent getWorkArea() {
		return workArea;
	}

	public Document getDocument() {
		return document;
	}

}