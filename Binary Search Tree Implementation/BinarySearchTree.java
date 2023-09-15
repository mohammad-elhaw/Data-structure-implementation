public class BinarySearchTree<T extends Comparable<T>> implements Tree<T>{

    private Node<T> root;

    @Override
    public void traverse() {
        if(root != null){
            inOrderTraversal(root);
        }

    }

    private void inOrderTraversal(Node<T> node) {
        if(node.getLeftChild() != null){
            inOrderTraversal(node.getLeftChild());
        }
        System.out.print(node + "    ");
        if(node.getRightChild() != null){
            inOrderTraversal(node.getRightChild());
        }
    }

    @Override
    public void insert(T data) {
        if(root == null){
            root = new Node<>(data);
        }
        else{
            insertNode(data, root);
        }
    }

    private void insertNode(T newData, Node<T> node) {
        if(newData.compareTo(node.getData()) < 0){
            if(node.getLeftChild() == null){
                Node<T> newNode = new Node<>(newData);
                node.setLeftChild(newNode);
            }
            else{
                insertNode(newData, node.getLeftChild());
            }
        }
        else{
            if(node.getRightChild() == null){
                Node<T> newNode = new Node<>(newData);
                node.setRightChild(newNode);
            }
            else{
                insertNode(newData, node.getRightChild());
            }
        }
    }

    @Override
    public void delete(T data) {
        if(root != null){
            root = delete(root, data);
        }
    }

    private Node<T> delete(Node<T> node, T data) {

        if(node == null) return node;

        if(data.compareTo(node.getData()) < 0){
            node.setLeftChild(delete(node.getLeftChild(), data));
        }

        else if(data.compareTo(node.getData()) > 0){
            node.setRightChild(delete(node.getRightChild(), data));
        }

        else{
            // we have found the node we want to remove!
            if(node.getLeftChild() == null && node.getRightChild() == null){
                System.out.println("Removing the leaf node");
                return null;
            }

            if(node.getLeftChild() == null){
                System.out.println("removing the right child");
                Node<T> tempNode = node.getRightChild();
                node = null;
                return tempNode;
            }else if(node.getRightChild() == null){
                System.out.println("removing the left child");
                Node<T> tempNode = node.getLeftChild();
                node = null;
                return tempNode;
            }

            // this is the node with two children case!
            System.out.println("Removing item with two children");
            Node<T> tempNode = getPredecessor(node.getLeftChild());
            node.setData(tempNode.getData());
            node.setLeftChild(delete(node.getLeftChild(), tempNode.getData()));
        }
        return node;
    }

    private Node<T> getPredecessor(Node<T> node) {
        if(node.getRightChild() != null){
            return getPredecessor(node.getRightChild());
        }
        System.out.println("Predecessor is : " + node);
        return node;
    }

    @Override
    public T getMax() {
        if(root.getRightChild() == null){
            return root.getData();
        }
        return getMaxValue(root);
    }
    private T getMaxValue(Node<T> root){
        if(root.getRightChild() == null){
            return root.getData();
        }
        return getMaxValue(root.getRightChild());
    }

    @Override
    public T getMin() {
        if(root.getLeftChild() == null){
            return root.getData();
        }
        return getMinValue(root);
    }

    private T getMinValue(Node<T> root) {
        if(root.getLeftChild() == null){
            return root.getData();
        }
        return getMinValue(root.getLeftChild());
    }

}
