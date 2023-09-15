public class App {
    public static void main(String[] args) {
        Tree<Integer> bst = new BinarySearchTree<>();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(20);

        bst.traverse();
        System.out.println();
        bst.delete(10);
        bst.traverse();
    }
}
