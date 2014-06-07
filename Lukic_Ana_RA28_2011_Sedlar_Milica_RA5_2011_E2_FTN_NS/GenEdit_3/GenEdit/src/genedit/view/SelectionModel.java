package genedit.view;


import genedit.model.graph.GraphElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SelectionModel {

	private List<GraphElement> elements = new ArrayList<GraphElement>();
	
	public Iterator<GraphElement> getIteratorElements() {
	      if (elements == null)
	         elements = new ArrayList<GraphElement>();
	      return elements.iterator();
	}
	
	public void addElement(GraphElement newGraphElement) {
	      if (newGraphElement == null)
	         return;
	      if (elements == null)
	         elements = new ArrayList<GraphElement>();
	      elements.add(newGraphElement);
	}
	
	public void removeAllElements() {
		elements.clear();
	}
}
