/***********************************************************************
 * Module:  GraphElement.java
 * Author:  Maja
 * Purpose: Defines the Class GraphElement
 ***********************************************************************/

package genedit.model.graph;

import genedit.model.Element;

import java.awt.Dimension;
import java.awt.geom.Point2D;

public class GraphElement implements Element {
   protected Dimension size;
   protected Point2D position;
   protected String name;
   
   public GraphElement(Point2D newPosition, Dimension newSize) {
		position = newPosition;
		size = newSize;
   }
   
   public void setSize(Dimension newSize) {
      size = newSize;
   }
   
   public Dimension getSize() {
      return size;
   }
   
   public void setPosition(Point2D newPosition) {
      position = newPosition;
   }
   
   public Point2D getPosition() {
      return position;
   }
   
   public void setName(String newName) {
      name = newName;
   }
   
   public String getName() {
      return name;
   }

}