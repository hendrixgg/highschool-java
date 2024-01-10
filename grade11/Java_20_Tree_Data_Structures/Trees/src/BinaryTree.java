public class BinaryTree {

    // instance variables
    private String name;
    private int value;
    private BinaryTree left;
    private BinaryTree right;

    /**
     * Default {@code BinaryTree} constructor
     */
    BinaryTree() {
        name = "default";
        value = 0;
        left = null;
        right = null;
    }

    /**
     * Binary Tree constructor with {@code name} and {@code value} specification.
     * 
     * @param n the {@code String} name of the binary tree
     * @param v the {@code integer} value of the tree
     */
    BinaryTree(String n, int v) {
        name = n;
        value = v;
        left = null;
        right = null;
    }

    /**
     * Binary Tree constructor with {@code name}, {@code value}, {@code left}, and
     * {@code right} specification.
     * 
     * @param n the {@code String} name of the binary tree
     * @param v the {@code integer} value of the tree
     * @param L the left child {@code BinaryTree}
     * @param R the right child {@code BinaryTree}
     */
    BinaryTree(String n, int v, BinaryTree L, BinaryTree R) {
        name = n;
        value = v;
        left = L;
        right = R;
    }

    public void setSubtrees(BinaryTree L, BinaryTree R) {
        this.left = L;
        this.right = R;
    }

    public void printLeftIterative(BinaryTree r) {
        BinaryTree temp = r;
        while (temp != null) {
            System.out.println(temp.name);
            temp = temp.left;
        }
    }

    /**
     * Prints all left nodes of a {@code BinaryTree} from the specified root.
     * 
     * @param r the root to traverse from.
     */
    public void printLeftRecursive(BinaryTree r) {
        if (r != null) {
            System.out.println(r.name);
            printLeftRecursive(r.left);
        }
    }

    public void printTreePreorder() {
        
    }

    public BinaryTree getLeft() {
        return this.left;
    }

    public BinaryTree getRight() {
        return this.right;
    }

    public int getDepth() {
        return this.value;
    }

}