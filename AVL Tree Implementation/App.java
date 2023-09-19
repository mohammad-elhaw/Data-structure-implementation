public class App {
    public static void main(String[] args) {
        Tree<Integer> avl = new AVLTree<>();
        avl.insert(10);
        avl.insert(20);
        avl.insert(30);
        avl.insert(40);
        avl.insert(50);
        avl.insert(60);
        avl.insert(70);


        System.out.println(avl.getRoot());
        avl.traverse();

        avl.delete(40);
        System.out.println(avl.getRoot());
        avl.traverse();
        System.out.println();
        System.out.println(avl.getMax());
        System.out.println(avl.getMin());

    }
}
