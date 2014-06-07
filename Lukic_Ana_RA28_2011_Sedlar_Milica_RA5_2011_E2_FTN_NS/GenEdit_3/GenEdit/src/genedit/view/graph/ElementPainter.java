/***********************************************************************
 * Module:  ElementPainter.java
 * Author:  Maja
 * Purpose: Defines the Class ElementPainter
 ***********************************************************************/

package genedit.view.graph;

import genedit.model.graph.GraphElement;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class ElementPainter {

	protected GraphElement element;
	protected Shape shape;

	public ElementPainter(GraphElement element) {
		this.element = element;
	}

	public void paint(Graphics2D g) {
		g.draw(shape);
	}

	public boolean isElementAt(Point2D p) {
		return shape.contains(p.getX(), p.getY());
	}

	public boolean isElementIn(Rectangle2D r) {
		// TODO: implement
		return false;
	}

	public GraphElement getElement() {
		return element;
	}

	public void setElement(GraphElement newElement) {
		this.element = newElement;
	}

}