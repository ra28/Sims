/***********************************************************************
 * Module:  Document.java
 * Author:  Maja
 * Purpose: Defines the Class Document
 ***********************************************************************/

package genedit.model;

import java.util.*;

public abstract class Document extends Observable {
   
	protected String name;
	protected List<Element> elements = new ArrayList<Element>();
   
   public int save(String fileName) {
      // TODO: implement
      return 0;
   }
   
   public Iterator<Element> getIteratorElements() {
      if (elements == null)
         elements = new ArrayList<Element>();
      return elements.iterator();
   }
   
   public void addElement(Element newElement) {
      if (newElement == null)
         return;
      if (elements == null)
         elements = new ArrayList<Element>();
      if (!elements.contains(newElement))
         elements.add(newElement);
      
      setChanged();				// postavljanje flag-a da je doslo do izmene
      notifyObservers();		// obavestavanje observera o izmeni
   }
   
   public void removeElement(Element oldElement) {
      if (oldElement == null)
         return;
      if (elements != null)
         if (elements.contains(oldElement))
            elements.remove(oldElement);
   }
   
   public void removeAllElements() {
      if (elements != null)
         elements.clear();
   }

}