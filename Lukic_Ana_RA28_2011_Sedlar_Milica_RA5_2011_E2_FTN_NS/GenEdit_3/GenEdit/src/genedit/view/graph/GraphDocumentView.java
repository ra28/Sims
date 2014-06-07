/***********************************************************************
 * Module:  GraphDocumentView.java
 * Author:  Maja
 * Purpose: Defines the Class GraphDocumentView
 ***********************************************************************/

package genedit.view.graph;

import genedit.model.Document;
import genedit.model.graph.GraphElement;
import genedit.view.DocumentView;
import genedit.view.SelectionModel;

import java.util.*;

public class GraphDocumentView extends DocumentView {

	private Map<GraphElement, ElementPainter> elementPainters;
	private SelectionModel selection = new SelectionModel();



	public GraphDocumentView(Document document) {
		super(document);
		workArea = new GraphWorkArea(this);
		elementPainters = new HashMap<GraphElement, ElementPainter>();
	}

	public Iterator<ElementPainter> getIteratorElementPainter() {
		if (elementPainters == null)
			elementPainters = new HashMap<GraphElement, ElementPainter>();
		return elementPainters.values().iterator();
	}

	public void addElementPainter(ElementPainter newElementPainter) {
		if (newElementPainter == null)
			return;
		if (elementPainters == null)
			elementPainters = new HashMap<GraphElement, ElementPainter>();
		if (!elementPainters.containsValue(newElementPainter))
			elementPainters.put(newElementPainter.element, newElementPainter);
	}

	public void removeElementPainter(ElementPainter oldElementPainter) {
		if (oldElementPainter == null)
			return;
		if (elementPainters != null)
			if (elementPainters.containsValue(oldElementPainter))
				elementPainters.remove(oldElementPainter.element);
	}

	public void removeAllElementPainter() {
		if (elementPainters != null)
			elementPainters.clear();
	}
	
	public SelectionModel getSelection() {
		return selection;
	}

}