/**
 * <p>
 * A4 Mini - Deck of Cards
 * 
 * <p>
 * This class is an implementation of a doubly linked list. Each {@code node}
 * will have a reference to the <i>previous</i> and <i>next</i> node. The node
 * will also store a reference to element and in this implementation, of type
 * string.
 * <p>
 * The doubly linked list only stores the references to the {@code front node}
 * and the {@code end node} of the list, as well as the number of nodes. This is
 * possible because each node stores references to the <i>previous</i> and the
 * <i>next</i> node.
 * <p>
 * <blockquote>
 * 
 * <pre>
 * Node front, end;
 * int numNodes;
 * </pre>
 * 
 * </blockquote>
 * <p>
 * 
 * 
 * @author Hendrix Gryspeerdt
 * @Date_created 2020/10/21
 */

public class DLL {
	// create a reference to the front and the end of the list
	Node front, end;
	// creates a variable to store the number of nodes in the list
	int numNodes;

	/**
	 * Inserts the specified element at the front of this deck.
	 */
	public void addFirst(Node node) {
		if (isEmpty()) {
			end = node;
		} else {
			node.setNext(front);
			node.setPrevious(null);
			front.setPrevious(node);
		}
		front = node;
		++numNodes;
	}

	/**
	 * Inserts the specified element at the end of this deck unless it would violate
	 * capacity restrictions. Returns true if successful. False otherwise.
	 */
	public boolean addLast(Node node) {
		if (isEmpty()) {
			front = node;
		} else {
			node.setPrevious(end);
			node.setNext(null);
			end.setNext(node);
		}
		end = node;
		++numNodes;
		return true;
	}

	/**
	 * Inserts node before specified value key. Returns true if successfully
	 * inserted, false otherwise (ie key was not found)
	 */
	public boolean insertBefore(String key, Node node) {
		Node curr = front;
		// traverse the list until the end
		while (curr != null) {
			if (curr.getData().equals(key)) {
				// special case if the the insertion occurred at the front, (you cannot setNext
				// on curr.getPrevious() if curr.getPrevious() is null)
				if (curr.getPrevious() == null) {
					addFirst(node);
				} else {
					node.setNext(curr);
					node.setPrevious(curr.getPrevious());
					curr.getPrevious().setNext(node);
					curr.setPrevious(node);
					numNodes++;
				}
				// stop the checks and return to the calling method
				return true;
			} // if
			curr = curr.getNext();
		}
		return false;
	}

	/**
	 * Inserts node after specified value key.
	 * 
	 * @param key - the specific string to insert after
	 * @param node - the node to be inserted into the list
	 * @return {@code true} if successfully inserted, {@code false} otherwise (ie key was
	 *         not found).
	 */
	public boolean insertAfter(String key, Node node) {
		Node curr = front;
		// traverse the list until the end
		while (curr != null) {
			if (curr.getData().equals(key)) {
				// special case if the the insertion occurred at the end, (you cannot
				// setPrevious on curr.getNext() if curr.getNext() is null)
				if (curr.getNext() == null) {
					addLast(node);
				} else {
					node.setPrevious(curr);
					node.setNext(curr.getNext());
					curr.getNext().setPrevious(node);
					curr.setNext(node);
					numNodes++;
				}
				// stop the checks and return to the calling method
				return true;
			} // if
			curr = curr.getNext();
		}
		return false;
	}

	/**
	 * Delete the first instance of a node that matches the key.
	 * 
	 * @param key
	 * @return Returns true if successful deletion, false otherwise (ie key was not
	 *         found).
	 */
	public boolean delete(String key) {
		// special case if there is only one or no nodes in the list
		if(numNodes==0) {
			return false;
		} else if (numNodes==1) {
			if (front.getData().equals(key)) {
				clear();
				return true;
			}
			return false;
		}
		// test if front item matches the key and removes it if true
		if (front.getData().equals(key)) {
			removeFront();
			return true;
		}
		Node curr = front.getNext();
		// searches for an item that matches the key and removes it if item is found
		while (curr != null) {
			if (curr.getData().equals(key)) {
				curr.getPrevious().setNext(curr.getNext());
				if (curr.getNext() == null) {
					end = curr.getPrevious();
				} else {
					curr.getNext().setPrevious(curr.getPrevious());
				}
				curr.setPrevious(null);
				numNodes--;
				return true;
			}
			curr = curr.getNext();
		}
		return false;

	}

	/**
	 * Deletes element at specified index.
	 * 
	 * @param index
	 * @return Returns true if successfully deleted, false otherwise (ie index out
	 *         of range).
	 */
	public boolean deleteElementAt(int index) {
		//special case if index out of bounds
		if (index < 0 || index > numNodes-1) {
			return false;
		} //special case if 1 node in the list,
		else if (numNodes == 1) {
            clear();
		} // if index 0, just remove front
		 else if (index == 0) {
			removeFront();
		} else if (index == numNodes-1) {
			removeEnd();
		} else {
            Node curr = front.getNext();
            for (int i = 1; i < index; ++i)
                curr = curr.getNext();
            curr.getPrevious().setNext(curr.getNext());
            curr.getNext().setPrevious(curr.getPrevious());
            curr = null;
            --numNodes;
        }        
		return true;
	}

	/**
	 * Retrieves and removes the first element of this deck.
	 * 
	 * @return Returns the node removed, or null if this deck is empty.
	 */
	public Node removeFront() {
        if (isEmpty())
            return null;

        Node retrievedNode = front;
		if (numNodes == 1) {
			clear();
            return retrievedNode;
		}
        front = retrievedNode.getNext();
        retrievedNode.setNext(null);
        front.setPrevious(null);
        --numNodes;// decrement the variable that keeps track of the number of nodes
		return retrievedNode;
	}

	/**
	 * Retrieves and removes the last element of this deck.
	 * 
	 * @return Returns the node removed, or null if this deck is empty.
	 */
	public Node removeEnd() {
        if(isEmpty()) 
            return null;

        Node retrievedNode = end;
        if(numNodes == 1) {
			clear();
			return retrievedNode;
		}
        end = retrievedNode.getPrevious();
        retrievedNode.setPrevious(null);
        end.setNext(null);
        --numNodes;// decrement the variable that keeps track of the number of nodes
		return retrievedNode;
	}

	/**
	 * Clears all the elements of the deck.
	 */
	public void clear() {
		front = null;
		end = null;
		numNodes = 0;
	}

	/**
	 * Returns the number of elements in this deck.
	 * 
	 * @return numNodes - the number of nodes in the list.
	 */
	public int size() {
		return numNodes;
	}

	/**
	 * Retrieves, but does not remove, the first element of this deck.
	 * 
	 * @return Returns the front node, or null if this deck is empty.
	 */
	public Node peekFirst() {
		return front;
	}

	/**
	 * Retrieves, but does not remove, the last element of this deck.
	 * 
	 * @return The end node (the last element of this deck), or null if this deck is
	 *         empty.
	 */
	public Node peekLast() {
		return end;
	}

	/**
	 * 
	 * @param s
	 * @return true if this deck contains the specified element. false otherwise.
	 */
	public boolean contains(String s) {
		Node curr = front;
		while(curr != null) {
			if(curr.getData().equals(s)) {
				return true;
			}
			curr = curr.getNext();
		}
		return false;
	}

	/**
	 * Returns a string representation of the elements in the list, from the first
	 * element to the last element
	 * 
	 * @return String result as [element(0), element(1), ..., element(n-1)]
	 */
	public String toString() {
        if (isEmpty())
            return "[]"; // If list is empty
		String result = "[";
        Node curr = front;
        while (curr != end) {
            result += curr.getData() + ", ";
            curr = curr.getNext();
        }
		return result + end.getData() + "]";
	}

	/**
	 * Returns a string representation of the elements in the list, from the last
	 * element to the first element.
	 * 
	 * @return String result as [element(n-1), element(n-2), ..., element(0)]
	 */
	public String toReverseString() {
        if (isEmpty())
            return "[]"; // If list is empty
        String result = "[";
        Node curr = end;
        while (curr != front) {
            result += curr.getData() + ", ";
            curr = curr.getPrevious();
        }
		return result + front.getData() + "]";
	}

	/**
	 * 
	 * @return true if deck has no elements. False otherwise.
	 */
	public boolean isEmpty() {
		return front == null;
	}
}