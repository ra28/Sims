/***********************************************************************
 * Module:  GraphWorkArea.java
 * Author:  Maja
 * Purpose: Defines the Class GraphWorkArea
 ***********************************************************************/

package genedit.view.graph;

import genedit.model.graph.GraphElement;
import genedit.model.graph.MyEllipse;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GraphWorkArea extends JPanel {
	
	private GraphDocumentView view;

	public GraphWorkArea(GraphDocumentView view) {
		this.view = view;
		GraphDocumentController controller = new GraphDocumentController();
		addMouseListener(controller);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		Iterator<ElementPainter> iter = view.getIteratorElementPainter();
		while (iter.hasNext()) {
			iter.next().paint(g2);
		}
		
		// obelezavanje selekcije:
		g2.setColor(Color.RED);
		g2.setStroke(new BasicStroke(1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, 
				new float[] {2, 2}, 0));
		
		Iterator<GraphElement> iterElem = view.getSelection().getIteratorElements();
		while (iterElem.hasNext()) {
			GraphElement selectedElem = iterElem.next();
			g2.draw(new Rectangle2D.Double(selectedElem.getPosition().getX(), selectedElem.getPosition().getY(), 
					selectedElem.getSize().getWidth(), selectedElem.getSize().getHeight()));
		}
	}

	private class GraphDocumentController implements MouseListener {

		private GraphElement currentElement = null;
		
		
		public void mouseClicked(MouseEvent e) {
			// TODO: implement
		}

		public void mousePressed(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON1) {
				currentElement = getElementAtPosition(e.getPoint());
			}
		}
		
		/** @param e */
		public void mouseReleased(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON1) {
				if (currentElement != null) {
					view.getSelection().removeAllElements();
					view.getSelection().addElement(currentElement);
					repaint();
				} else { // ako nema elementa na poziciji kursora, kreiramo novi
					MyEllipse novi = new MyEllipse(new Point2D.Double(e.getX() - 50, e.getY() - 25), new Dimension(100, 50));
					MyEllipsePainter noviPainter = new MyEllipsePainter(novi);
					view.addElementPainter(noviPainter);
					view.getDocument().addElement(novi);
				}
				currentElement = null;
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}
		
		private GraphElement getElementAtPosition(Point2D position) {
			/* Proveravamo da li se na poziciji kursora nalazi element.
			 * Prolazimo kroz sve elemente u modelu i preko painter-a
			 * proveravamo da li se na zadatoj lokaciji nalazi element.
			*/
			Iterator<ElementPainter> iter = view.getIteratorElementPainter();
			while (iter.hasNext()) {
				ElementPainter painter = iter.next();
				if (painter.isElementAt(position))
					return painter.getElement();
			}
			return null;
		}
		

	}

}