class SLL{
    
    Node front, end;
    private int numNodes;
    
    public SLL(){
        front = null;   
        end = null;
        numNodes = 0;
    }
    /* This method will return the node at the front of the list.
     */
    public Node peekFirst(){
        return front;
    }
    
    /* This method will return the node at the end of the list.
     */
    public Node peekLast(){
        return end;
    }
   
    /**
     * This method checks wheter the list contains a string s, it returns the
     * location if it does, -1 otherwise.
     * 
     * @param s the string to search for
     * @return the integer location of the element if found, {@code -1} otherwise
     */
    public int containsInt(String s){
        Node curr = front;
        int i = 0;
        while(curr!=null){
            if(curr.getData().equals(s))
                return i;
            i++;
            curr = curr.getNext();
        }
        return -1;
    }

    /**
     * This method checks wheter the list contains a string s, it returns {@code true} if
     * found, {@code false} otherwise.
     * 
     * @param s the string to search for.
     * @return {@code true} if the string was found, {@code false} otherwise.
     */
    public boolean contains(String s){
        Node curr = front;
        while(curr!=null){
            if(curr.getData().equals(s))
                return true;
            curr = curr.getNext();
        }
        return false;
    }

    
    /* This method will add a node to the start of the list
     * it will return its success (true)
     */
    public boolean addFirst(Node n) {
        if (front == null) {
            // If list is empty
            end = n;
        } else {
            n.setNext(front);
        }
        front = n;
        numNodes++;
        return true;
    }
    
    /**This method will remove and return the first node in the list.
     */
    public Node removeFirst() {
        // If list is empty
        if (front == null) {
            return null;
        }
        // If removing the only node
        else if (front.getNext() == null) {
            Node temp = front;
            front = null;
            end = null;
            return temp;
        } else {
            Node temp = front;
            numNodes--;
            front = front.getNext();
            return temp;
        }
    }
    
    // inserts Node node after key in my list
    public boolean insertAfter(String key, Node node) {
        Node curr = front;
        // traverse the list until the end
        while (curr != null) {
            if (curr.getData().equals(key)) {
                node.setNext(curr.getNext());
                curr.setNext(node);
                // special case if the the insertion occurred at the end
                if (curr == end) {
                    end = node;
                }
                // stop the checks and return to the calling method
                numNodes++;
                return true;
            } // if
            curr = curr.getNext();
        }
        return false;
    }
    
    // remove the node with specified String key
    public boolean remove(String key) {
        // If key is first node, change link in header
        if (front.getData().equals(key)) {
            front = front.getNext();
            numNodes--;
            return true;
        }
        // find predecessor and change its link
        else {
            Node prev = front;
            Node curr = prev.getNext();
            while (curr != null) {
                if (curr.getData().equals(key)) {
                    prev.setNext(curr.getNext());
                    if (curr.getData().equals(end.getData())){
                        end = prev;
                    }
                    numNodes--;
                    return true;
                }
                else {
                    prev = curr;
                    curr = curr.getNext();
                }
            }
            return false;
        }
    } 
    
    /**This method will return true if the list is empty, false if otherwise.
     */
    public boolean isEmpty(){
        return front==null; //Front is null when list is empty
    }    
    
    /**This method will print data of all the nodes in the list, neatly.
     * It does not return anything, and prints it to the standard output.
     */
    public void printFirstToLast(){
        Node curr = front;
        if(curr==null){
            System.out.println("[]"); //If list is empty
        }
        else{
            System.out.print("[");
            while(curr != null){
                System.out.print(curr.getData());
                if(curr==end){
                    System.out.println("]");
                }else{
                    System.out.print(", ");
                }
                curr = curr.getNext();
            }
        }
    }
    
    /**This method will clear the contents of a list.
     */
    public void clear(){
        front=null;
        end=null;
        numNodes = 0;
    }

    /**This method will add a node to the end of the list.
     * it will return true
     * 
     * @param n the node to add
     * @return true after completing
     */
    public boolean addLast(Node n){
        if(isEmpty()) {
        front = n;
        end = n;
        numNodes++;
        return true;
        }
        end.setNext(n);
        end = n;
        numNodes++;
        return true;
    }

    /** This method will remove and return the last node in the list.
     * 
     * @return the node removed
     */
    public Node removeLast(){
        Node result;
        if(front.getNext()==null) {
            result = front;
            front = null;
            end = null;
            numNodes = 0;
            return result;
        }
        Node prev = front;
        Node curr = prev.getNext();
        for (int i = 0; i < numNodes; i++) {
            if(curr.getNext()==null) {
                result = curr;
                prev.setNext(curr.getNext());
                end = prev;
                numNodes--;
                return result;
            }
            prev = curr;
            curr = curr.getNext();
        }
        return null;
    }

    /** This method will remove the first occurrence of a {@code node} containing
     *  data equal to an input string {@code s}, and return true if successful,
     *  false if otherwise.
     * 
     * @param s the tartget data
     * @return true if data was found and removed, false otherwise
     */
    public boolean removeFirstOccurrence(String s) {
        // if there are no nodes, return false, to avoid null pointer exception 
        if (numNodes < 1)
            return false;
        // if there is only one node
        if(numNodes == 1) {
            // clear the list if the one node matches
            if(front.getData().equals(s)) {
                clear();
                return true;
            }
            // otherwise return false
            return false;
        }
        // if front.data matches the target string (s) 
        if (front.getData().equals(s)) {
            // set the front to be the second node
            // the node that "front" used to point to now has no reference. 
            // Therfore, it is available for garbage collection and is removed from the list
            front = front.getNext();
            // decrement the number of nodes in order to keep track of the size of the list
            numNodes--;
            return true;
            // return true because the correct node was found
        }
        // keep track of the previous node
        Node prev = front;
        // the node who's string is compared to s
        Node curr = prev.getNext();
        // now loop until curr is null
        while (curr != null) {
            // if curr.data matches the target string (s) 
            // delete curr from the list
            if (curr.getData().equals(s)) {
                // make prev.next to point to the node after curr (curr.next)
                // now nothing has a reference to the Node curr
                // Therfore, curr is available for garbage collection and is removed from the list
                prev.setNext(curr.getNext());
                // if the node removed (curr) was the end node, we need to change what end points to
                if (curr.getNext() == null)
                // make end point to prev
                    end = prev;
                // decrement the number of nodes in order to keep track of the size of the list
                numNodes--;
                // return true because the node was removed
                return true;
            }
            // if curr.data did not match String s, go to the next node
            prev = curr;
            curr = curr.getNext();
        }
        // return false because no node conatained the string data equal to string s
        return false;
    }
    
    /**This method will remove the last occurrence of a node containing 
     * data equal to an input string s, and return true if successful,
     * false if otherwise.
     * 
     * @param s the tartget data
     * @return true if data was found, false otherwise
     */
    public boolean removeLastOccurrence(String s){
        if(numNodes <= 1) {
            if(front.getData().equals(s)) {
                clear();
                return true;
            }
            return false;
        }

        int locationLast=-1;
        int occurences=0;
        Node prev = front;
        Node curr = prev.getNext();
        if (front.getData().equals(s)) {
            locationLast=0;
            occurences++;
        } 
        for (int i = 1; i < numNodes; i++) {
            if (curr.getData().equals(s)) {
                occurences++;
                locationLast=i;
            }
            prev = curr;
            curr = curr.getNext();
        }
        if(locationLast==-1)//if String was not found, return false
            return false;
        if (occurences==1 || locationLast==0)//if String only occured once, just remove first occurrence
            return removeFirstOccurrence(s);

            // Now, remove the last occurrence
        prev = front;
        curr = prev.getNext();
        for (int index = 1; index < numNodes; index++) {
            if(index == locationLast) {
                prev.setNext(curr.getNext());
                if (curr.getNext() == null)
                    end = prev;
                numNodes--;
                return true;
            }
            prev = curr;
            curr = curr.getNext();
        }
        return false;
    }
    
    /** This method will return the number of nodes in the list.
     * 
     * @return numNodes - the number of nodes in the list
     */
    public int size(){   
        return numNodes;
    }

    public String printBackwardsTo(Node head) {
        if (head == null) return ""; 
  
        // print list of head node 
        String s = printBackwardsTo(head.getNext()); 
  
        // After everything else is printed 
        return s + head.getData() + " "; 
    }

    /**
     * This method prints the linked list in reversed order from the node at the
     * specified location to the first node.
     * 
     * @param index the {@code location} of the node in the linked list, {@code 0} being the first node
     * @return A string of the data starting at the specified index each element separated by spaces
     */
    public String printBackwardsFrom(int index) {
        Node curr = front;
        int i = 0; 
        String s = "";
        if(index < 0 || index > numNodes-1)
            return "Index Out Of Bounds";
        if( index == 0)
            return curr.getData() + " ";
        for (i = 0; i <= index; i++) {
            s = curr.getData();
            curr = curr.getNext();
        }
        return s + ", " + printBackwardsFrom(index-1);

    }
    
    /**
     * This method prints the linked list in reversed order from the specified
     * element (the first occurrence) to the first node.
     * 
     * @param s the string to return the list from
     * @return A string of the data from each element separated by spaces
     */
    public String printBackwardsFrom(String s) {
        int index = containsInt(s);
        if (index == -1) {
            System.out.println("ERROR: The String to print from is not in the list");
            return "";
        }
        return printBackwardsFrom(index);
    }

}
