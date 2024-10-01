

//import net.datastructures.*; //copied LinkedPositionalList from net.datastructures.*

/**
 * 
 * An implementation of Sequence based on LinkedPositionalList
 * Only List methods and bridge methods in Sequence interface need to be provided
 * 
 * Created for csi2110 Lab3, Fall 2021
 * 
 * @author Lucia Moura
 *
 */

public class LinkedSequence<E> extends LinkedPositionalList<E> implements Sequence<E> {
		
	/**
	 * returns position corresponding to index
	 * since need to traverse this LinkedPositionalList to get to index i time is O(n)
	 * @param i the index or rank of the element in the list (first has index 0, second has index 1,etc
	 * @return position of the element or null if index does not exist
	 * @throws IndexOutOfBoundsException if the index is negative or greater than size()-1
	 */
         public Position<E> positionAtIndex(int i) throws IndexOutOfBoundsException { 
                 checkIndex(i,size()); // checks whether the given index is in the range [0, size()-1].

                 /******* add your code here **********/
				 Position<E> current = first();

				 for (int j = 0; j < i+1; j++) {
					current = after(current);
				 }

                 return current; //dummy return
          } 
	
      /**
        * returns index corresponding to position
        * since need to hop through elements of this LinkedPositionalList to get to position pos time is O(n)
        * @param pos - the position or cell you must located in this LinkedPositionalList
        * @return index (also called rank) in the list or -1 if position not found
        * 
        */
	public int indexAtPosition(Position<E> pos) {
		
                  /******* add your code here **********/
		Position<E> current = first();
		int i = 0;

		while (current != null) {
			if (current == pos) {
				return i;
			}
			current = after(current);
			i++;
		}

		 return -1; //dummy return
	} 

       /**
	 * Returns (but does not remove) the element at index i.
	 * @param  i   the index of the element to return
	 * @return the element at the specified index
         * @throws IndexOutOfBoundsException if the index is negative or greater than size()-1
	 */
	public E get(int i) throws IndexOutOfBoundsException { // gets element at index i
		
                 /******* add your code here **********/
				 Position<E> pos = positionAtIndex(i);

		 return pos.getElement();
	}
	
	/**
	  * Replaces the element at the specified index, and returns the element previously stored.
	  * @param  i   the index of the element to replace
	  * @param  e   the new element to be stored
	  * @return the previously stored element
	  * @throws IndexOutOfBoundsException if the index is negative or greater than size()-1
	  */
	public E set(int i, E e) throws IndexOutOfBoundsException { // replaces the element at index i with e

               /******* add your code here **********/

				Position<E> pos = positionAtIndex(i); //Get position at index i
				E prev = pos.getElement(); //Store current element
				add(i, e); //Add new element at index i
				remove(i+1); //Remove previous element

               return prev; //Return previously stored element
	}
	
	/**
	  * Inserts the given element at the specified index of the list, shifting all
	  * subsequent elements in the list one position further to make room
	  * Note: when i=size() it correspond to an addLast when i<size it correspond to addBefore the i-th position
	  * @param  i   the index at which the new element should be stored
	  * @param  e   the new element to be stored
	  * @throws IndexOutOfBoundsException if the index is negative or greater than size()
	  */
	public void add(int i, E e){ // insert a new element which will have index i 
		 /******* add your code here **********/
		 Position<E> prev = positionAtIndex(i-1);
		 addAfter(prev, e);
	}
	
	/**
	  * Removes and returns the element at the given index, shifting all subsequent
	  * elements in the list one position closer to the front.
	  * @param  i   the index of the element to be removed
	  * @return the element that had be stored at the given index
	  * @throws IndexOutOfBoundsException if the index is negative or greater than size()
	  */
	public E remove(int i) throws IndexOutOfBoundsException { // remove element with index i

		/******* add your code here **********/

                E el=null;    // dummy commands to be removed 
                return el; // dummy commands to be removed
	}
	
	  // utility methods
	  /** Checks whether the given index is in the range [0, n-1]. */
	  protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
	    if (i < 0 || i >= n)
	      throw new IndexOutOfBoundsException("Illegal index: " + i);
	  }
}
