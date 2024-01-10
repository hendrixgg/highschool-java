
// import java.util.Iterator;
import java.util.ArrayList;
// import java.util.Random;
// import java.util.Arrays;

public class LinkedListTester {
    
    public static Node[] createForwardArray(Node front, int limit) throws Exception
    {        
        ArrayList<Node> list = new ArrayList<Node>();
        int count=0;
        while(front!=null){
            list.add(front);            
            front = front.getNext();
            count++;
            if (count > limit){
              throw new Exception();   
            }
                
        }
        return list.toArray(new Node[list.size()]);       
    }
    
    
    public static Node[] createBackwardsArray(Node end, int limit) throws Exception
    {        
        ArrayList<Node> list = new ArrayList<Node>();
        int count =0;
        while(end!=null){
            list.add(end);            
            end = end.getPrevious();
            count++;
            if (count > limit){
              throw new Exception();   
            }
               
                
        }
        return list.toArray(new Node[list.size()]);       
    }
    
    public static Node[] reverseArray(Node[] expected){
        
        Node[] result = new Node[expected.length];
        
        for(int i=0; i<expected.length;i++){
            result[i] = expected[expected.length-1-i];            
        }
        return result;      
    }
    
    
    public static void main(String[] args) {
        
        int sum = 0;
        int total = 0;
        /* Test 1 contains(String s)
         * ****************************
         * Test 1.0 not found on empty list
         * Test 1.1 not found with one node on list
         * Test 1.2 not found more than one node on the list
         * Test 1.3 found at the front
         * Test 1.4 found at the end
         * Test 1.5 found between two nodes
         */
        try{
            DLL list = new DLL();
            // Test 1.0 not found on empty list
            if (!list.contains("data")){
                sum++;           
                System.out.println("Test 1.0 passed");
            }
            else{
                System.err.println("Test 1.0 failed");
            }
            
        }catch(Exception e){
            System.err.println("Exception occurred - node count was greater than list size");
        }
        
        total++;
        System.out.println("Running total is : " + sum + "/" + total);
        
        // Test 1.1 not found with one node on list
        try{
            DLL list = new DLL();
            Node front = new Node(null, "A");
            list.addLast(front);
            
            if (!list.contains("data")){
                sum++;           
                System.out.println("Test 1.1 passed");
            }
            else{
                System.err.println("Test 1.1 failed");
            }
            
        }catch(Exception e){
            System.err.println("Exception occurred - node count was greater than list size");
        }
        total++;
        System.out.println("Running total is : " + sum + "/" + total);
        
        // Test 1.2 not found more than one node on the list
        try{
            DLL list = new DLL();
            Node front = new Node(null, "A");
            list.addLast(front);
            Node middle = new Node(null, "B");
            list.addLast(middle);
            
            if (!list.contains("data")){
                sum++;           
                System.out.println("Test 1.2 passed");
            }
            else{
                System.err.println("Test 1.2 failed");
            }
        }catch(Exception e){
            System.err.println("Exception occurred - node count was greater than list size");
        }
        total++;
        System.out.println("Running total is : " + sum + "/" + total);
        
        // Test 1.3 found at the front
        try{
            DLL list = new DLL();
            Node front = new Node(null, "A");
            list.addLast(front);
            Node middle = new Node(null, "B");
            list.addLast(middle);
            if (list.contains("A") && list.peekFirst()==front){
                sum++;           
                System.out.println("Test 1.3 passed");
            }
            else{
                System.err.println("Test 1.3 failed");
            }
        }catch(Exception e){
            System.err.println("Exception occurred - node count was greater than list size");
        }
        total++;
        System.out.println("Running total is : " + sum + "/" + total);
        
        // Test 1.4 found at the end
        try{
            DLL list = new DLL();
            Node front = new Node(null, "A");
            list.addLast(front);
            Node middle = new Node(null, "B");
            list.addLast(middle);
            Node end = new Node(null, "C");
            list.addLast(end);
            
            if (list.contains("C") && list.peekLast()==end){
                sum++;           
                System.out.println("Test 1.4 passed");
            }
            else{
                System.err.println("Test 1.4 failed");
            }
        }catch(Exception e){
            System.err.println("Exception occurred - node count was greater than list size");
        }
        total++;
        System.out.println("Running total is : " + sum + "/" + total);
        
        // Test 1.4 found between two nodes
        try{
            DLL list = new DLL();
            Node front = new Node(null, "A");
            list.addLast(front);
            Node middle = new Node(null, "B");
            list.addLast(middle);
            Node end = new Node(null, "C");
            list.addLast(end);
            if (list.contains("B") && list.peekFirst().getNext()==middle){
                sum++;           
                System.out.println("Test 1.5 passed");
            }
            else{
                System.err.println("Test 1.5 failed");
            }
        }catch(Exception e){
            System.err.println("Exception occurred - node count was greater than list size");
        }
        total++;
        System.out.println("Running total is : " + sum + "/" + total);
        
        
        /* Test 2 addFirst(Node node) & check size()
         * ******************
         * Test 2.0 check is list is empty upon creation and size is 0
         * Test 2.1 added on an empty list  (check new front and new last) and size is 1
         * Test 2.2 added on a non empty list (check new front and last) and size is one more than before
         * Test 2.3 elements are identical front to back and back to front
         */
        
        // Test 2.0 added on an empty list  (check new front and new last)
        try{
            DLL list = new DLL();
            
            if (list.isEmpty() && list.peekFirst()==null && list.peekLast()==null && list.size()==0){
                sum++;           
                System.out.println("Test 2.0 passed");
            }
            else{
                System.err.println("Test 2.0 failed");
            }
        }catch(Exception e){
            System.err.println("Exception occurred - node count was greater than list size");
        }
        total++;
        System.out.println("Running total is : " + sum + "/" + total);
        
        
        // Test 2.1 added on an empty list  (check new front and new last)
        try{
            DLL list = new DLL();
            
            Node end = new Node(null, "A");
            list.addFirst(end);
            if (!list.isEmpty() && list.peekFirst()==end && list.peekLast()==end && list.size()==1){
                sum++;           
                System.out.println("Test 2.1 passed");
            }
            else{
                System.err.println("Test 2.1 failed");
            }
        }catch(Exception e){
            System.err.println("Exception occurred - node count was greater than list size");
        }
        total++;
        System.out.println("Running total is : " + sum + "/" + total);
        
        
        // Test 2.2 added on a non empty list (check new front and last)
        try{
            DLL list = new DLL();
            Node end = new Node(null, "A");
            list.addFirst(end);
            Node front = new Node(null, "B");
            list.addFirst(front);
            if (!list.isEmpty() && list.peekFirst()==front && list.peekLast()==end && list.size()==2){
                sum++;           
                System.out.println("Test 2.2 passed");
            }
            else{
                System.err.println("Test 2.2 failed");
            }
        }catch(Exception e){
            System.err.println("Exception occurred - node count was greater than list size");
        }
        total++;
        System.out.println("Running total is : " + sum + "/" + total);
        
        // Test 2.3 elements are identical front to back and back to front
        try{
            DLL list = new DLL();
            Node end = new Node(null, "A");
            list.addFirst(end);
            Node front = new Node(null, "B");
            list.addFirst(front);
            Node other1 = new Node(null, "C");
            list.addFirst(other1);
            
            Node other2 = new Node(null, "D");
            list.addFirst(other2);
            
            Node other3 = new Node(null, "E");
            list.addFirst(other3);
            
            Node [] expected = {other3,other2,other1,front,end};
            Node [] expectedReverse = reverseArray(expected);
            
            if (arraysSame(expected, createForwardArray(list.front,5)) && arraysSame(expectedReverse, createBackwardsArray(list.end,5)) && list.size()==5){
                sum++;           
                System.out.println("Test 2.3 passed");
            }
            else{
                System.err.println("Test 2.3 failed");
            } 
        }catch(Exception e){
            System.err.println("Exception occurred - node count was greater than list size - Test 2.3");
        }
        total++;
        System.out.println("Running total is : " + sum + "/" + total);
        
        /* Test 3 insertAfter(String key, Node node) & check size()
         ***********************
         * Test 3.0 insertion occurs at the end (check front and new last)
         * Test 3.1 insertion occurs between two nodes
         * Test 3.2 key not found on non-empty list
         * Test 3.3 key not found on empty list
         */
        
        // Test 3.0 insertion occurs at the end (check front and new last)
        try{ 
            DLL list = new DLL();
            Node end = new Node(null, "A");
            list.addFirst(end);
            Node front = new Node(null, "B");
            list.addFirst(front);
            Node other1 = new Node(null, "C");
            list.addFirst(other1);
            
            Node other2 = new Node(null, "D");
            list.addFirst(other2);
            
            Node other3 = new Node(null, "E");
            list.addFirst(other3);
            
            Node pastEnd = new Node(null,"G");
            
            Node [] expected2 = {other3,other2,other1,front,end, pastEnd};
            Node [] expectedReverse2 = reverseArray(expected2);
            
            if(list.insertAfter("A", pastEnd) && list.front==other3 && list.end==pastEnd && 
               arraysSame(expected2, createForwardArray(list.front,6)) && arraysSame(expectedReverse2, createBackwardsArray(list.end,6)) && list.size()==6)
            {            
                sum++;           
                System.out.println("Test 3.0 passed");
            }
            else{
                System.err.println("Test 3.0 failed");
            } 
        }catch(Exception e){
            System.err.println("Exception occurred - node count was greater than list size - Test 3.0");
        }
        total++;
        System.out.println("Running total is : " + sum + "/" + total);
        
        
        // Test 3.1 insertion occurs between two nodes
        try{
            DLL list = new DLL();
            Node end = new Node(null, "A");
            list.addFirst(end);
            Node front = new Node(null, "B");
            list.addFirst(front);
            Node other1 = new Node(null, "C");
            list.addFirst(other1);
            
            Node other2 = new Node(null, "D");
            list.addFirst(other2);
            
            Node other3 = new Node(null, "E");
            list.addFirst(other3);
            
            Node pastEnd = new Node(null,"G");
            list.addLast(pastEnd);
            Node inserted = new Node(null, "R");
            
            Node [] expected3 = {other3,other2,inserted, other1,front,end, pastEnd};
            Node [] expectedReverse3 = reverseArray(expected3);
            
            boolean ans = list.insertAfter("D", inserted);
            if(list.size()==7 && ans && arraysSame(expected3, createForwardArray(list.front,7)) 
                   && arraysSame(expectedReverse3, createBackwardsArray(list.end,7)) )
            {            
                sum++;           
                System.out.println("Test 3.1 passed");
            }
            else{
                System.err.println("Test 3.1 failed");
                if(list.size()==7 ){
                    System.err.println("Wrong length");
                }
                if(!ans){
                       System.err.println("insertions failed length");
                }
                
                
            } 
        }catch(Exception e){
            System.err.println("Exception occurred - node count was greater than list size");
        }
        total++;
        System.out.println("Running total is : " + sum + "/" + total);
        
        
        // Test 3.2 key not found on non-empty list
        try{
            DLL list = new DLL();
            Node end = new Node(null, "A");
            list.addFirst(end);
            Node front = new Node(null, "B");
            list.addFirst(front);
            Node other1 = new Node(null, "C");
            list.addFirst(other1);
            
            Node other2 = new Node(null, "D");
            list.addFirst(other2);
            
            Node other3 = new Node(null, "E");
            list.addFirst(other3);
            
            Node pastEnd = new Node(null,"G");
            list.addLast(pastEnd);
            
            
            Node inserted2 = new Node(null, "Q");
            
            if(!list.insertAfter("Z", inserted2) && list.size()==6)
            {            
                sum++;           
                System.out.println("Test 3.2 passed");
            }
            else{
                System.err.println("Test 3.2 failed");
            }   
        }catch(Exception e){
            System.err.println("Exception occurred - node count was greater than list size");
        }
        total++;
        System.out.println("Running total is : " + sum + "/" + total);
        
        // Test 3.3 key not found on empty list
        try{
            DLL list = new DLL();
            Node inserted = new Node(null, "Q");
            
            if(!list.insertAfter("D", inserted) && list.size()==0)
            {            
                sum++;           
                System.out.println("Test 3.3 passed");
            }
            else{
                System.err.println("Test 3.3 failed");
            } 
        }catch(Exception e){
            System.err.println("Exception occurred - node count was greater than list size");
        }
        total++;
        System.out.println("Running total is : " + sum + "/" + total);
        
        
        /* 4 addLast (Node n) & check size()
         ****************
         * Test 4.0 added on an empty list (check new front and new last)
         * Test 4.1 added on a non-empty list (check front a new last)
         * Test 4.2 elements are identical front to back and back to front
         */
        // Test 4.0 added on an empty list (check new front and new last)
        try{
            DLL list = new DLL();
            
            Node front = new Node(null, "A");
            
            list.addLast(front);
            if (!list.isEmpty() && list.peekFirst()==front && list.peekLast()==front && list.size()==1){
                sum++;           
                System.out.println("Test 4.0 passed");
            }
            else{
                System.err.println("Test 4.0 failed");
            }
        }catch(Exception e){
            System.err.println("Exception occurred - node count was greater than list size");
        }
        total++;
        System.out.println("Running total is : " + sum + "/" + total);
        
        
        // Test 4.1 added on a non-empty list (check front a new last)
        try{
            DLL list = new DLL();
            
            Node front = new Node(null, "A");
            list.addLast(front);
            Node end = new Node(null, "B");
            list.addLast(end);
            if (!list.isEmpty() && list.peekFirst()==front && list.peekLast()==end && list.size()==2){
                sum++;           
                System.out.println("Test 4.1 passed");
            }
            else{
                System.err.println("Test 4.1 failed");
            }
        }catch(Exception e){
            System.err.println("Exception occurred - node count was greater than list size");
        }
        total++;
        System.out.println("Running total is : " + sum + "/" + total);
        
        // Test 4.2 elements are identical front to back and back to front
        try{
            DLL list = new DLL();
            
            Node front = new Node(null, "A");
            list.addLast(front);
            Node end = new Node(null, "B");
            list.addLast(end);
            Node other1 = new Node(null, "C");
            list.addLast(other1);
            
            Node other2 = new Node(null, "D");
            list.addLast(other2);
            
            Node other3 = new Node(null, "E");
            list.addLast(other3);
            
            Node [] expected4 = {front, end, other1, other2, other3};
            Node [] expectedReverse4 = reverseArray(expected4);
            
            if (list.size()==5 && arraysSame(expected4, createForwardArray(list.front, 5)) && arraysSame(expectedReverse4, createBackwardsArray(list.end, 5))){
                sum++;           
                System.out.println("Test 4.2 passed");
            }
            else{
                System.err.println("Test 4.2 failed");
            } 
        }catch(Exception e){
            System.err.println("Exception occurred - node count was greater than list size");
        }
        total++;
        System.out.println("Running total is : " + sum + "/" + total);
        
        
        /* 5 delete(String key) & check size()
         ******************
         * Test 5.0 deletion occurs at the front (check new front and last)
         * Test 5.1 deletion occurs at the end (check front and new last)
         * Test 5.2 deletion occurs between two nodes
         * Test 5.3 key not found on empty list
         * Test 5.4 key not found on a non-empty list
         */
        
        // Test 5.0 deletion occurs at the front (check new front and last)
        try{
            DLL list = new DLL();
            Node front = new Node(null, "A");
            list.addLast(front);
            
            Node other1 = new Node(null, "B");
            list.addLast(other1);
            
            Node other2 = new Node(null, "C");
            list.addLast(other2);
            
            Node other3 = new Node(null, "D");
            list.addLast(other3);
            
            Node end = new Node(null, "E");
            list.addLast(end);
            
            Node [] expected5 = {other1, other2, other3, end};
            Node [] expectedReverse5 = reverseArray(expected5);
            
            boolean ans = list.delete("A");
            
            
            if (ans && list.peekFirst()== other1 && list.peekLast()==end && list.size()==4 && arraysSame(expected5, createForwardArray(list.front,4)) 
                    && arraysSame(expectedReverse5, createBackwardsArray(list.end,4)))
            {
                sum++;           
                System.out.println("Test 5.0 passed");
            }
            else{
                System.err.println("Test 5.0 failed");
            } 
        }catch(Exception e){
            System.err.println("Exception occurred - node count was greater than list size");
        }
        total++;
        System.out.println("Running total is : " + sum + "/" + total);
        
        // Test 5.1 deletion occurs at the end (check front and new last)
        try{
            DLL list = new DLL();
            Node front = new Node(null, "A");
            list.addLast(front);
            
            Node other1 = new Node(null, "B");
            list.addLast(other1);
            
            Node other2 = new Node(null, "C");
            list.addLast(other2);
            
            Node other3 = new Node(null, "D");
            list.addLast(other3);
            
            Node end = new Node(null, "E");
            list.addLast(end);
            
            Node [] expected51 = {front, other1, other2, other3};
            Node [] expectedReverse51 = reverseArray(expected51);
            
            boolean ans = list.delete("E");
            if (ans && list.peekFirst()== front && list.peekLast()==other3 && list.size()==4 && arraysSame(expected51, createForwardArray(list.front,4))
                    && arraysSame(expectedReverse51, createBackwardsArray(list.end,4))){
                sum++;           
                System.out.println("Test 5.1 passed");
            }
            else{
                System.err.println("Test 5.1 failed");
            }  
        }catch(Exception e){
            System.err.println("Exception occurred - node count was greater than list size");
        }
        total++;
        System.out.println("Running total is : " + sum + "/" + total);      
        
        
        // Test 5.2 deletion occurs between two nodes
        try{
            DLL list = new DLL();
            Node front = new Node(null, "A");
            list.addLast(front);
            
            Node other1 = new Node(null, "B");
            list.addLast(other1);
            
            Node other2 = new Node(null, "C");
            list.addLast(other2);
            
            Node other3 = new Node(null, "D");
            list.addLast(other3);
            
            Node end = new Node(null, "E");
            list.addLast(end);
            
            Node [] expected52 = {front, other1, other3, end};
            Node [] expectedReverse52 = reverseArray(expected52);
            
            boolean ans = list.delete("C");
            if (ans && list.peekFirst()== front && list.peekLast()==end && list.size()==4 && arraysSame(expected52, createForwardArray(list.front,4))
                    && arraysSame(expectedReverse52, createBackwardsArray(list.end,4))){
                sum++;           
                System.out.println("Test 5.2 passed");
            }
            else{
                System.err.println("Test 5.2 failed");
            }   
        }catch(Exception e){
            System.err.println("Exception occurred - node count was greater than list size");
        }
        total++;
        System.out.println("Running total is : " + sum + "/" + total);      
        
        // Test 5.3 key not found on empty list
        try{
            DLL list = new DLL();
            boolean ans = list.delete("C");
            if (!ans && list.peekFirst()== null && list.peekLast()==null && list.size()==0 &&  list.isEmpty()){
                sum++;           
                System.out.println("Test 5.3 passed");
            }
            else{
                System.err.println("Test 5.3 failed");
            }   
        }catch(Exception e){
            System.err.println("Exception occurred - node count was greater than list size");
        }
        total++;
        System.out.println("Running total is : " + sum + "/" + total);      
        
        
        // Test 5.4 key not found on a non-empty list
        try{
            DLL list = new DLL();
            Node front = new Node(null, "A");
            list.addLast(front);
            
            Node other1 = new Node(null, "B");
            list.addLast(other1);
            
            Node other2 = new Node(null, "C");
            list.addLast(other2);
            
            Node other3 = new Node(null, "D");
            list.addLast(other3);
            
            Node end = new Node(null, "E");
            list.addLast(end);
            
            Node [] expected54 = {front, other1, other2, other3, end};
            Node [] expectedReverse54 = reverseArray(expected54);
            
            boolean ans = list.delete("F");
            if (!ans && list.peekFirst()== front && list.peekLast()==end && list.size()==5 && arraysSame(expected54, createForwardArray(list.front,5))
                    && arraysSame(expectedReverse54, createBackwardsArray(list.end,5))){
                sum++;           
                System.out.println("Test 5.2 passed");
            }
            else{
                System.err.println("Test 5.2 failed");
            }   
        }catch(Exception e){
            System.err.println("Exception occurred - node count was greater than list size");
        }
        total++;
        System.out.println("Running total is : " + sum + "/" + total);   
        
        
        /* Test 6 removeFront() & check size()
         *************
         * Test 6.0 invoked on an empty list
         * Test 6.1 invoked on a single node (check new front and new last)
         * Test 6.2 invoked on a non empty list with 2+ nodes (check new front) 
         */
        
        // Test 6.0 invoked on an empty list
        try{
            DLL list = new DLL();
            Node f = list.removeFront();
            if (f == null && list.peekFirst()== null && list.peekLast()==null && list.size()==0 ){
                sum++;           
                System.out.println("Test 6.0 passed");
            }
            else{
                System.err.println("Test 6.0 failed");
            }   
        }catch(Exception e){
            System.err.println("Exception occurred - node count was greater than list size");
        }
        total++;
        System.out.println("Running total is : " + sum + "/" + total);   
        
        
        // Test 6.1 invoked on a single node (check new front and new last)
        try{
            DLL list = new DLL();
            Node front = new Node(null, "A");
            list.addLast(front);
            Node f = list.removeFront();
            if (f == front && list.peekFirst()== null && list.peekLast()==null && list.size()==0 ){
                sum++;           
                System.out.println("Test 6.1 passed");
            }
            else{
                System.err.println("Test 6.1 failed");
            }  
        }catch(Exception e){
            System.err.println("Exception occurred - node count was greater than list size");
        }
        total++;
        System.out.println("Running total is : " + sum + "/" + total);   
        
        
        // Test 6.2 invoked on a non empty list with 2+ nodes (check new front)
        try{
            DLL list = new DLL();
            Node front = new Node(null, "A");
            list.addLast(front);
            
            Node other1 = new Node(null, "B");
            list.addLast(other1);
            
            Node other2 = new Node(null, "C");
            list.addLast(other2);
            
            Node other3 = new Node(null, "D");
            list.addLast(other3);
            
            Node end = new Node(null, "E");
            list.addLast(end);
            
            Node [] expected62 = {other1, other2, other3, end};
            Node [] expectedReverse62 = reverseArray(expected62);
            
            Node f = list.removeFront();
            if (f == front && list.peekFirst()== other1 && list.peekLast()==end && list.size()==4 && arraysSame(expected62, createForwardArray(list.front,4))
                    && arraysSame(expectedReverse62, createBackwardsArray(list.end,4))){
                sum++;           
                System.out.println("Test 6.2 passed");
            }
            else{
                System.err.println("Test 6.2 failed");
            }   
        }catch(Exception e){
            System.err.println("Exception occurred - node count was greater than list size");
        }
        total++;
        System.out.println("Running total is : " + sum + "/" + total);   
        
        
        
        /* Test 7 removeEnd() & check size()
         ***********
         * Test 7.0 invoked on an empty list
         * Tets 7.1 invoked on a single node (check front and new last)
         * Test 7.2 invoked on a non empty list with 2+ nodes (check new end)
         */
        
        // Test 7.0 invoked on an empty list
        try{
            DLL list = new DLL();
            Node f = list.removeEnd();
            if (f == null && list.peekFirst()== null && list.peekLast()==null && list.size()==0 ){
                sum++;           
                System.out.println("Test 7.0 passed");
            }
            else{
                System.err.println("Test 7.0 failed");
            }  
        }catch(Exception e){
            System.err.println("Exception occurred - node count was greater than list size");
        }
        total++;
        System.out.println("Running total is : " + sum + "/" + total);   
        
        
        // Test 7.1 nvoked on a single node (check front and new last)
        try{
            DLL list = new DLL();
            Node end = new Node(null, "A");
            list.addLast(end);
            Node e = list.removeEnd();
            if (e == end && list.peekFirst()== null && list.peekLast()==null && list.size()==0 ){
                sum++;           
                System.out.println("Test 7.1 passed");
            }
            else{
                System.err.println("Test 7.1 failed");
            }   
        }catch(Exception e){
            System.err.println("Exception occurred - node count was greater than list size");
        }
        total++;
        System.out.println("Running total is : " + sum + "/" + total);   
        
        
        // Test 7.2 invoked on a non empty list with 2+ nodes (check new end)
        try{
            DLL list = new DLL();
            Node front = new Node(null, "A");
            list.addLast(front);
            
            Node other1 = new Node(null, "B");
            list.addLast(other1);
            
            Node other2 = new Node(null, "C");
            list.addLast(other2);
            
            Node other3 = new Node(null, "D");
            list.addLast(other3);
            
            Node end = new Node(null, "E");
            list.addLast(end);
            
            Node [] expected72 = {front, other1, other2, other3};
            Node [] expectedReverse72 = reverseArray(expected72);
            
            Node e = list.removeEnd();
            if (e == end && list.peekFirst()== front && list.peekLast()==other3 && list.size()==4 && arraysSame(expected72, createForwardArray(list.front,4))
                    && arraysSame(expectedReverse72, createBackwardsArray(list.end,4))){
                sum++;           
                System.out.println("Test 7.2 passed");
            }
            else{
                System.err.println("Test 7.2 failed");
            }  
        }catch(Exception e){
            System.err.println("Exception occurred - node count was greater than list size");
        }
        total++;
        System.out.println("Running total is : " + sum + "/" + total);   
        
        
        /* Test 8 insertBefore(String key, Node node) & check size()
         ***********************
         * Test 8.0 insertion occurs at the front(check new front and last)
         * Test 8.1 insertion occurs between two nodes
         * Test 8.2 key not found on empty list
         * Test 8.3 key not found on non-empty list
         */
        
        //Test 8.0 insertion occurs at the front(check new front and last)
        try{
            DLL list = new DLL();
            
            Node other1 = new Node(null, "C");
            list.addFirst(other1);
            
            Node other2 = new Node(null, "D");
            list.addFirst(other2);
            
            Node other3 = new Node(null, "E");
            list.addFirst(other3);
            
            Node front = new Node(null, "A");
            list.addFirst(front);
            
            Node beforeFront = new Node(null,"G");
            
            Node [] expected80 = {beforeFront, front, other3, other2, other1};
            Node [] expectedReverse80 = reverseArray(expected80);
            
            if(list.insertBefore("A", beforeFront) && list.front==beforeFront && list.end==other1 && 
               arraysSame(expected80, createForwardArray(list.front,7)) && arraysSame(expectedReverse80, createBackwardsArray(list.end,7)) && list.size()==5)
            {            
                sum++;           
                System.out.println("Test 8.0 passed");
            }
            else{
                System.err.println("Test 8.0 failed");
            }  
        }catch(Exception e){
            System.err.println("Exception occurred - node count was greater than list size");
        }
        total++;
        System.out.println("Running total is : " + sum + "/" + total);
        
        // Test 8.1 insertion occurs between two nodes
        try{
            DLL list = new DLL();
            
            Node other1 = new Node(null, "C");
            list.addFirst(other1);
            
            Node other2 = new Node(null, "D");
            list.addFirst(other2);
            
            Node other3 = new Node(null, "E");
            list.addFirst(other3);
            
            Node front = new Node(null, "A");
            list.addFirst(front);
            
            Node beforeFront = new Node(null,"G");
            list.addFirst(beforeFront);
            
            Node inserted = new Node(null, "R");
            
            Node [] expected81 = {beforeFront, front, other3,inserted,other2, other1};
            Node [] expectedReverse81 = reverseArray(expected81);
            
            if(list.insertBefore("D", inserted) && arraysSame(expected81, createForwardArray(list.front,6)) 
                   && arraysSame(expectedReverse81, createBackwardsArray(list.end,6)) && list.size()==6)
            {            
                sum++;           
                System.out.println("Test 8.1 passed");
            }
            else{
                System.err.println("Test 8.1 failed");
            }   
        }catch(Exception e){
            System.err.println("Exception occurred - node count was greater than list size");
        }
        total++;
        System.out.println("Running total is : " + sum + "/" + total);
        
        
        // Test 8.2 key not found on non-empty list
        try{
            DLL list = new DLL();
            
            Node other1 = new Node(null, "C");
            list.addFirst(other1);
            
            Node other2 = new Node(null, "D");
            list.addFirst(other2);
            
            Node other3 = new Node(null, "E");
            list.addFirst(other3);
            
            Node front = new Node(null, "A");
            list.addFirst(front);
            
            Node beforeFront = new Node(null,"G");
            list.addFirst(beforeFront);
            
            Node inserted2 = new Node(null, "Q");
            
            if(!list.insertBefore("Z", inserted2) && list.size()==5)
            {            
                sum++;           
                System.out.println("Test 8.2 passed");
            }
            else{
                System.err.println("Test 8.2 failed");
            }  
        }catch(Exception e){
            System.err.println("Exception occurred - node count was greater than list size");
        }
        total++;
        System.out.println("Running total is : " + sum + "/" + total);
        
        // Test 8.3 key not found on empty list
        try{
            DLL list = new DLL();
            Node inserted = new Node(null, "Q");
            
            if(!list.insertBefore("D", inserted) && list.size()==0)
            {            
                sum++;           
                System.out.println("Test 8.3 passed");
            }
            else{
                System.err.println("Test 8.3 failed");
            }   
        }catch(Exception e){
            System.err.println("Exception occurred - node count was greater than list size");
        }
        total++;
        System.out.println("Running total is : " + sum + "/" + total);
        
        
        
        /* Test 9 deleteElementAt(int index) & check size()
         **************************
         * Test 9.0 deletion occurs at the front/end with one item (check new front and new last)
         * Test 9.1 deletion occurs at the front with 2+ items (check new front and last)
         * Test 9.2 deletion occurs at the end with 2+ items (check front and new last)
         * Test 9.3 deletion occurs between two nodes
         * Test 9.4 index not found on empty list
         * Test 9.5 index not found on a non-empty list
         */ 
        
        // Test 9.0 deletion occurs at the front with one item(check new front and last)
        try{
            DLL list = new DLL();
            Node front = new Node(null, "A");
            list.addLast(front);
            boolean ans = list.deleteElementAt(0);
            if (ans && list.peekFirst()== null && list.peekLast()==null && list.size()==0 ){
                sum++;           
                System.out.println("Test 9.0 passed");
            }
            else{
                System.err.println("Test 9.0 failed");
            }   
        }catch(Exception e){
            System.err.println("Exception occurred - node count was greater than list size");
        }
        total++;
        System.out.println("Running total is : " + sum + "/" + total);   
        
        
        // Test 9.1 deletion occurs at the front with 2+ items (check new front and last)
        try{
            DLL list = new DLL();
            Node front = new Node(null, "A");
            list.addLast(front);
            
            Node other1 = new Node(null, "B");
            list.addLast(other1);
            
            Node other2 = new Node(null, "C");
            list.addLast(other2);
            
            Node other3 = new Node(null, "D");
            list.addLast(other3);
            
            Node end = new Node(null, "E");
            list.addLast(end);
            
            Node [] expected91 = {other1,other2,other3,end};
            Node [] expectedReverse91 = reverseArray(expected91);
            
            boolean  ans = list.deleteElementAt(0);
            if (ans && list.peekFirst()== other1 && list.peekLast()==end && list.size()==4 && arraysSame(expected91, createForwardArray(list.front,4))
                    && arraysSame(expectedReverse91, createBackwardsArray(list.end,4))){
                sum++;           
                System.out.println("Test 9.1 passed");
            }
            else{
                System.err.println("Test 9.1 failed");
            }   
        }catch(Exception e){
            System.err.println("Exception occurred - node count was greater than list size");
        }
        total++;
        System.out.println("Running total is : " + sum + "/" + total);   
        
        
        // Test 9.2 deletion occurs at the end with 2+ items (check front and new last)
        try{
            DLL list = new DLL();
            Node front = new Node(null, "A");
            list.addLast(front);
            
            Node  other1 = new Node(null, "B");
            list.addLast(other1);
            
            Node other2 = new Node(null, "C");
            list.addLast(other2);
            
            Node  other3 = new Node(null, "D");
            list.addLast(other3);
            
            Node  end = new Node(null, "E");
            list.addLast(end);
            
            Node [] expected92 = {front, other1,other2,other3};
            Node [] expectedReverse92 = reverseArray(expected92);
            
            boolean ans = list.deleteElementAt(4);
            if (ans && list.peekFirst()== front && list.peekLast()==other3 && list.size()==4 && arraysSame(expected92, createForwardArray(list.front,4))
                    && arraysSame(expectedReverse92, createBackwardsArray(list.end,4))){
                sum++;           
                System.out.println("Test 9.2 passed");
            }
            else{
                System.err.println("Test 9.2 failed");
            }   
        }catch(Exception e){
            System.err.println("Exception occurred - node count was greater than list size");
        }
        total++;
        System.out.println("Running total is : " + sum + "/" + total);   
        
        
        // Test 9.3 deletion occurs between two nodes
        try{
            DLL list = new DLL();
            Node front = new Node(null, "A");
            list.addLast(front);
            
          Node other1 = new Node(null, "B");
            list.addLast(other1);
            
          Node other2 = new Node(null, "C");
            list.addLast(other2);
            
         Node other3 = new Node(null, "D");
            list.addLast(other3);
            
         Node end = new Node(null, "E");
            list.addLast(end);
            Node [] expected93 = {front, other1, other3, end};
            Node [] expectedReverse93 = reverseArray(expected93);
         boolean ans = list.deleteElementAt(2);
            if (ans && list.peekFirst()== front && list.peekLast()==end && list.size()==4 && arraysSame(expected93, createForwardArray(list.front,4)) && arraysSame(expectedReverse93, createBackwardsArray(list.end,4))){
                sum++;           
                System.out.println("Test 9.3 passed");
            }
            else{
                System.err.println("Test 9.3 failed");
            }   
        }catch(Exception e){
            System.err.println("Exception occurred - node count was greater than list size");
        }
        total++;
        System.out.println("Running total is : " + sum + "/" + total);   
        
        
        //Test 9.4 index not found on empty list
        try{
            DLL list = new DLL();
            boolean ans = list.deleteElementAt(0);
            if (!ans && list.peekFirst()== null && list.peekLast()==null && list.size()==0 ){
                sum++;           
                System.out.println("Test 9.4 passed");
            }
            else{
                System.err.println("Test 9.4 failed");
            }   
        }catch(Exception e){
            System.err.println("Exception occurred - node count was greater than list size");
        }
        total++;
        System.out.println("Running total is : " + sum + "/" + total); 
        
        
        // Test 9.5 index not found on a non-empty list
        try{
            DLL list = new DLL();
           Node front = new Node(null, "A");
            list.addLast(front);
            
           Node other1 = new Node(null, "B");
            list.addLast(other1);
            
           Node other2 = new Node(null, "C");
            list.addLast(other2);
            
           Node other3 = new Node(null, "D");
            list.addLast(other3);
            
           Node end = new Node(null, "E");
            list.addLast(end);
            
            Node [] expected95 = {front, other1, other2, other3, end};
            Node [] expectedReverse95 = reverseArray(expected95);
            
           boolean ans = list.deleteElementAt(20);
            if (!ans && list.peekFirst()== front && list.peekLast()==end && list.size()==5 && arraysSame(expected95, createForwardArray(list.front,5))
                    && arraysSame(expectedReverse95, createBackwardsArray(list.end,5))){
                sum++;           
                System.out.println("Test 9.5 passed");
            }
            
            else{
                System.err.println("Test 9.5 failed");
            }  
        }catch(Exception e){
            System.err.println("Exception occurred - node count was greater than list size");
        }
        total++;
        System.out.println("Running total is : " + sum + "/" + total); 
        
        /* Test 10 toString(), toReverseString()
         * ****************
         * Test 10.0 call toString()/toReverseString on non empty list
         * Test 10.1 call toString()/toReverseString on empty list
         */
        
//Test 10.0 call toString()/toReverseString on non empty list
        DLL list = new DLL();
       Node front = new Node(null, "A");
        list.addLast(front);
        
       Node other1 = new Node(null, "B");
        list.addLast(other1);
        
       Node other2 = new Node(null, "C");
        list.addLast(other2);
        
       Node other3 = new Node(null, "D");
        list.addLast(other3);
        
       Node end = new Node(null, "E");
        list.addLast(end);
        System.out.println("Forward Expected : [A, B, C, D, E]");
        System.out.println("Forward Received : "+ list.toString());
        
        System.out.println("Reverse Expected : [E, D, C, B, A]");
        System.out.println("Reverse Received : "+ list.toReverseString());        
        
//Test 10.1 call toString()/toReverseString on empty list
        list = new DLL();
        System.out.println("Forward Expected : []");
        System.out.println("Forward Received : "+ list.toString());
        
        System.out.println("Reverse Expected : []");
        System.out.println("Reverse Received : "+ list.toReverseString()); 
        
    }
    
    
    
    
    
//pre: none
    private static boolean arraysSame(Object[] one, Object[] two)  {
        boolean same;
        if( one == null || two == null ) {
            same = (one == two);
        }
        else {
            //neither one or two are null
            assert one != null && two != null;
            same = one.length == two.length;
            if( same ) {
                int index = 0;
                while( index < one.length && same ) {
                    same = ( one[index]==(two[index]) );
                    index++;
                }
            }
        }
        return same;
    }
    
    
    
}
