/***********************************************************************
 * Module:  MyEllipsePainter.java
 * Author:  Maja
 * Purpose: Defines the Class MyEllipsePainter
 ***********************************************************************/

package genedit.view.graph;

import genedit.model.graph.GraphElement;


public class MyEllipsePainter extends ElementPainter {
	
	public MyEllipsePainter(GraphElement element) {
		super(element);
		shape = new java.awt.geom.Ellipse2D.Double 
				(element.getPosition().getX(), element.getPosition().getY(),
				element.getSize().getWidth(), element.getSize().getHeight());
	}
}