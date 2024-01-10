public class App_BinaryTree {
    public static void main(String[] args) throws Exception {
        BinaryTree root = new BinaryTree("root", 0);
        BinaryTree a = new BinaryTree("a", 1);
        BinaryTree b = new BinaryTree("b", 1);
        root.setSubtrees(a, b);
        a.setSubtrees(new BinaryTree("aa", 2), new BinaryTree("ab", 2));
        a.getLeft().setSubtrees(new BinaryTree("aaa", 3), new BinaryTree("aab", 3));
        System.out.println("Printing left subtrees iteratively");
        root.printLeftIterative(root);
        System.out.println("Printing left subtrees recursively");
        root.printLeftRecursive(root);
    }
}
