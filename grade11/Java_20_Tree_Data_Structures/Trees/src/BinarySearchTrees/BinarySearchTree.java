
public class BinarySearchTree {
  Node root;
  int numNodes;
  boolean ascending;

  // Constructor
  public BinarySearchTree() {
    root = null;
    ascending = true;
    numNodes = 0;
  }

  /**
   * This method mainly calls insertRec()
   * 
   * @param key the integer to insert into the tree.
   */
  public void insert(int key) {
    if (!contains(key)) {
      root = insertRec(root, key);
      numNodes++;
    }
  }

  /* A recursive function to insert a new key in BST */
  public Node insertRec(Node node, int data) {

    /* If the tree is empty, return a new node */
    if (node == null) {
      node = new Node(data);
      return node;
    }

    /* Otherwise, recur down the tree */
    if (data < node.data)
      node.left = insertRec(node.left, data);
    else if (data > node.data)
      node.right = insertRec(node.right, data);

    /* return the (unchanged) node pointer */
    return node;
  }

  /**
   * Returns the number of nodes from the root down to the furthest leaf node,
   * excluding the root node.
   * 
   * @return the number of links from the root node to the farthest node.
   */
  public int height() {
    return maxDepth(root) - 1;
  }

  /**
   * Returns the number of nodes from the specified {@code node} down to the
   * furthest leaf node, excluding the root node.
   * 
   * @return the number of links from the root node to the farthest node.
   */
  public int height(Node node) {
    return maxDepth(root);
  }

  /**
   * Returns the number of nodes from the specified node to the furthest leaf
   * node, including the root node;
   * 
   * @param node
   * @return
   */
  public int maxDepth(Node node) {
    // base case tree is empty
    if (node == null)
      return 0;
    // If tree is not empty then height = 1 + max of left height and right heights
    return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
  }

  /**
   * Returns a String of all the nodes in the binary tree from the root, in-Order
   * with spaces in between. All done via the recursive helper method.
   * 
   * @return the the string data from all the nodes in the left subtree followed
   *         by the string data from the {@code root}, then the string data from
   *         the nodes in the right subtree.
   * @see <a title="In-order tree traversal in 3 minutes" href=
   *      "https://www.youtube.com/watch?v=5dySuyZf9Qg&t=32s">Video on In-Order
   *      tree traversal<a>
   */
  public String printInOrder() {
    return printInOrderRecur(root);
  }

  /**
   * The recursive method used as a helper method for the {@code printInOrder}
   * method.
   * 
   * @param n the the node from which to return the {@code String}.
   * 
   * @return the the string data from all the nodes in the left subtree followed
   *         by the string data from {@code Node n}, then the string data from the
   *         right subtree.
   * @see <a title="In-order tree traversal in 3 minutes" href=
   *      "https://www.youtube.com/watch?v=5dySuyZf9Qg&t=32s">Video on In-Order
   *      tree traversal<a>
   */
  private String printInOrderRecur(Node n) {
    // if the node is null, return nothing
    if (n == null)
      return "";

    // add the resulting string after performing this function on the nodes to the
    // left
    String result = printInOrderRecur(n.left);
    // add the data from the node to the string
    result += n.data + " ";
    // add the resulting string after performing this function on the nodes to the
    // right
    result += printInOrderRecur(n.right);
    // return the string
    return result;
  }

  /**
   * Returns a String of all the nodes in the binary tree from the root, in
   * PreOrder with spaces in between. All done via the recursive helper method.
   * 
   * @return the string data from the {@code root} followed by the string data
   *         from all the nodes in the left subtree, then the right subtree.
   * @see <a title="Pre-Order tree traversal in 3 minutes" href=
   *      "https://www.youtube.com/watch?v=1WxLM2hwL-U">Video on Pre-Order tree
   *      traversal<a>
   */
  public String printPreOrder() {
    return printPreOrderRecur(root);
  }

  /**
   * The recursive method used as a helper method for the {@code printPreOrder}
   * method.
   * 
   * @param n the node from which to return the {@code String}.
   * @return the string data from {@code Node n} followed by the string data from
   *         all the nodes in the left subtree, then the right subtree.
   * @see <a title="Pre-Order tree traversal in 3 minutes" href=
   *      "https://www.youtube.com/watch?v=1WxLM2hwL-U">Video on Pre-Order tree
   *      traversal<a>
   */
  private String printPreOrderRecur(Node n) {
    // if the node is null, return nothing
    if (n == null)
      return "";

    // add the string data from the node
    String result = n.data + " ";
    // add the resulting string after performing this function on the nodes to the
    // left
    result += printPreOrderRecur(n.left);
    // add the resulting string after performing this function on the nodes to the
    // right
    result += printPreOrderRecur(n.right);
    return result;
  }

  /**
   * Returns a String of all the nodes in the binary tree from the root, in
   * PostOrder with spaces in between. All done via the recursive helper method.
   * 
   * @return the string data from data from all the nodes in the left subtree,
   *         followed by the data from the nodes in the right subtree, then the
   *         string data from the {@code root}.
   * @see <a title="In-order tree traversal in 3 minutes" href=
   *      "https://www.youtube.com/watch?v=5dySuyZf9Qg&t=29s">Video on Post-Order
   *      tree traversal<a>
   */
  public String printPostOrder() {
    return printPostOrderRecur(root);
  }

  /**
   * The recursive method used as a helper method for the {@code printPostOrder}
   * method.
   * 
   * @param n the node from which to return the {@code String}.
   * @return the string data from the string data from all the nodes in the left
   *         subtree, followed by the data from the nodes in the right subtree,
   *         then the string data from {@code Node n}.
   * @see <a title="In-order tree traversal in 3 minutes" href=
   *      "https://www.youtube.com/watch?v=5dySuyZf9Qg&t=29s">Video on Post-Order
   *      tree traversal<a>
   */
  private String printPostOrderRecur(Node n) {
    // if the node is null, return nothing
    if (n == null)
      return "";

    // add the resulting string after performing this function on the nodes to the
    // left
    String result = printPostOrderRecur(n.left);
    // add the resulting string after performing this function on the nodes to the
    // right
    result += printPostOrderRecur(n.right);
    // add the string data from the node
    result += n.data + " ";
    return result;
  }

  public void remove(Node n) {
    removeRecur(n.data);
    numNodes--;
  }

  public void remove(int key) {
    removeRecur(key);
    numNodes--;
  }

  // remove the first instance of node that matches the key
  private void removeRecur(int key) {

    Node parent = null;
    Node curr = root;
    boolean onLeft = false;

    while (curr != null) {
      if (curr.data == key)
        break;
      else if (curr.data > key) {
        // indicate that the current node is now to the left of the parent
        onLeft = true;
        parent = curr;
        curr = curr.left;
      } else {
        // indicate that the current node is now to the right of the parent
        onLeft = false;
        parent = curr;
        curr = curr.right;
      }
    }

    // key was not found
    if (curr == null)
      return;

    // Case 1: current is a leaf node
    if (curr.left == null && curr.right == null) {
      if (onLeft)
        parent.left = null;
      else
        parent.right = null;
    }

    // Case 2.1: current node has one child on it's left reference
    else if (curr.left != null && curr.right == null) {
      // if the current node was to the left of the parent
      if (onLeft)
        parent.left = curr.left;
      else
        parent.right = curr.left;
    }
    // Case 2.2: current node has one child on it's right reference
    else if (curr.left == null && curr.right != null) {
      // if the current node was to the left of the parent
      if (onLeft)
        parent.left = curr.right;
      else
        parent.right = curr.right;
    }

    // Case 3: if current node has two children
    else {
      // Save a copy of the node with the (smallest value) in the (right subtree) of
      // the current node.
      // This node will replace the current node.
      Node smallest = getMin(curr.right);
      // remove the node containing that value from the tree
      remove(smallest.data);
      // if the current node was to the left of the parent
      if (onLeft)
        parent.left = smallest;
      else
        parent.right = smallest;
      // make the smallest node contain the same references as the current node
      smallest.left = curr.left;
      smallest.right = curr.right;
    }
  }

  /**
   * Clears all nodes from the BinaryTree.
   */
  public void clear() {
    root = null;
    numNodes = 0;
  }

  /**
   * Removes the fisrt occurrence of thesmallest value from the entire tree.
   */
  public void removeMin() {
    removeMin(root);
  }

  /**
   * remove the first occurrence of the smallest value in the tree starting from
   * node
   * 
   * @param the node to treat as the root of a tree
   */
  public void removeMin(Node node) {
    remove(getMin(node).data);
    numNodes--;
  }

  /**
   * Finds the smallest value in the entire tree.
   * 
   * @return the smallest value with from the tree.
   */
  public Node getMin() {
    return getMin(root);
  }

  /**
   * Finds the smallest value in the tree with {@code node} as the root.
   * 
   * @param node the node to treat as the root of a tree.
   * @return the smallest value in the tree.
   */
  public Node getMin(Node node) {
    Node curr = node;
    if (node != null) {
      while (curr.left != null) {
        curr = curr.left;
      }
    }
    System.out.println(curr.data);
    return curr;
  }

  /**
   * Removes the first occurrence of the greatest value from the entire tree.
   */
  public void removeMax() {
    removeMax(root);
  }

  /**
   * Removes the first occurrence the largest value in the tree starting from the
   * specified node.
   * 
   * @param node the node to treat as the root of a tree.
   */
  public void removeMax(Node node) {
    remove(getMax(node).data);
    numNodes--;
  }

  /**
   * Finds the greatest value in the tree and returns it.
   * 
   * @return the greatest value in the Binary tree.
   */
  public Node getMax() {
    return getMax(root);
  }

  /**
   * Finds the greatest value in the tree with {@code node} as the root.
   * 
   * @param node the node to treat as the root of a tree.
   * @return the smallest value in the tree.
   */
  public Node getMax(Node node) {
    Node curr = node;
    if (node != null) {
      while (curr.right != null) {
        curr = curr.right;
      }
    }
    return curr;
  }

  public boolean isBalanced() {
    if (root == null)
      return true;
    return isBalencedRecur(root);
  }

  private boolean isBalencedRecur(Node node) {
    // An empty tree is height-balanced.
    if (node.left == null && node.right == null)
      return true;
    else if (node.left == null && node.right != null)
      return maxDepth(node.right) <= 1;
    else if (node.left != null && node.right == null)
      return maxDepth(node.left) <= 1;

    return Math.abs(maxDepth(node.left) - maxDepth(node.right)) <= 1 && isBalencedRecur(node.left)
        && isBalencedRecur(node.right);

  }

  /**
   * This method calls the rebalanceTreeRecur method with the Binary Search Tree
   * converted to an array.
   */
  public void rebalanceTree() {
    int[] array = this.toArray(root);
    root = rebalanceTreeRecur(array, 0, array.length - 1);
  }

  /**
   * This method takes in an ordered array of integers, and returns the root node
   * of the corresponding balenced Binary Search Tree.
   * 
   * @param array an ordered array of type int.
   * @param L     the leftmost index of the array to from which to form into a
   *              Binary Search Tree.
   * @param R     the rightmost index of the array to from which to form into a
   *              Binary Search Tree.
   * @return the root node of the data as a balenced Binary Search Tree.
   */
  public Node rebalanceTreeRecur(int[] array, int L, int R) {
    if (L > R)
      return null;
    else if (R == L)
      return new Node(array[L]);
    else if (R - L == 1) {
      Node a = new Node(array[L]);
      a.right = new Node(array[R]);
      return a;
    } else if (R - L == 2) {
      Node b = new Node(array[(R + L) / 2]);
      b.left = new Node(array[L]);
      b.right = new Node(array[R]);
      return b;
    } else {
      Node result = new Node(array[(R + L) / 2]);
      result.left = rebalanceTreeRecur(array, L, ((R + L) / 2 - 1));
      result.right = rebalanceTreeRecur(array, ((R + L) / 2 + 1), R);
      return result;
    }
  }

  /**
   * Returns the Binary Search Tree as an array in order.
   * 
   * @param node the root of the BST.
   * 
   * @return an ordered int array containing all the values in the Binary Tree
   *         from the specified {@code node}, inclusive.
   */
  public int[] toArray(Node node) {
    int[] array = new int[numNodes];
    String[] split = printInOrderRecur(node).split("\\D+");
    for (int i = 0; i < numNodes; i++)
      array[i] = Integer.parseInt(split[i]);
    return array;
  }

  public void mirror() {

  }

  /**
   * Searches the Binary tree for the specified integer {@code item}.
   * 
   * @param item the integer to search for.
   * @return true if the number was found, false otherwise.
   */
  public boolean contains(int item) {
    Node curr = root;

    while (curr != null) {
      if (curr.data == item)
        return true;
      else if (curr.data > item) {
        curr = curr.left;
      } else {
        curr = curr.right;
      }
    }
    return false;
  }

  public int count() {
    return countRecur(root);
  }

  private int countRecur(Node n) {
    // if node is null return 0
    if (n == null) {
      return 0;
    } // if not null return 1 +
      // (the count of all the nodes in the left subtree) +
      // (the count of all the nodes in the right subtree).
    else {
      int count = 1;
      if (n.left != null)
        count += countRecur(n.left);
      if (n.right != null)
        count += countRecur(n.right);
      return count;
    }
  }

}