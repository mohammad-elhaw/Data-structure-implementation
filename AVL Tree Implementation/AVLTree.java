public class AVLTree<T extends Comparable<T>> implements Tree<T>{

    private Node<T> root;

    @Override
    public T getRoot() {
        return root.getData();
    }

    @Override
    public void insert(T data) {
        root = insertNode(data, root);
    }

    private Node<T> insertNode(T data, Node<T> node) {
        if(node == null){
            return new Node<>(data);
        }
        if(data.compareTo(node.getData()) < 0){
            node.setLeftNode(insertNode(data, node.getLeftNode()));
        }
        else{
            node.setRightNode(insertNode(data, node.getRightNode()));
        }

        node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);

        return makingBalance(node);
    }

    private Node<T> makingBalance(Node<T> node) {
        int balance = getBalance(node);

        //Case of left heavy
        if(balance > 1){
            //left-right situation
            if(getBalance(node.getLeftNode()) < 0){
                node.setLeftNode(leftRotation(node.getLeftNode()));
            }
            //left-left situation
            return rightRotation(node);
        }

        //Case of Right heavy
        if(balance < -1){
            //right-left situation
            if(getBalance(node.getRightNode()) > 0){
                node.setRightNode(rightRotation(node.getRightNode()));
            }
            //right-right situation
            return leftRotation(node);
        }
        return node;
    }

    @Override
    public void traverse() {
        if(root == null) return;
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node<T> node) {
        if(node.getLeftNode() != null){
            inOrderTraversal(node.getLeftNode());
        }
        System.out.print(node + "    ");
        if(node.getRightNode() != null){
            inOrderTraversal(node.getRightNode());
        }
    }

    private Node<T> rightRotation(Node<T> node){
        System.out.println("Rotating to the right on node: " + node);
        Node<T> tempLeftNode = node.getLeftNode();
        Node<T> temp2 = tempLeftNode.getRightNode();

        tempLeftNode.setRightNode(node);
        node.setLeftNode(temp2);

        node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);
        tempLeftNode.setHeight(Math.max(height(tempLeftNode.getLeftNode()), height(tempLeftNode.getRightNode())) + 1);

        return tempLeftNode;
    }

    private Node<T> leftRotation(Node<T> node){
        System.out.println("Rotating to the left on node: " + node);
        Node<T> tempRightNode = node.getRightNode();
        Node<T> temp2 = tempRightNode.getLeftNode();

        tempRightNode.setLeftNode(node);
        node.setRightNode(temp2);

        node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);
        tempRightNode.setHeight(Math.max(height(tempRightNode.getLeftNode()), height(tempRightNode.getRightNode())) + 1);

        return tempRightNode;
    }
    
    private int height(Node<T> node){
        if(node == null) return -1;
        return node.getHeight();
    }

    private int getBalance(Node<T> node){
        if(node == null) return 0;
        return height(node.getLeftNode()) - height(node.getRightNode());
    }

    @Override
    public void delete(T data) {
        root = deleteNode(root, data);
    }

    private Node<T> deleteNode(Node<T> node, T data) {
        if(root == null) return node;

        if(data.compareTo(node.getData()) < 0){
            node.setLeftNode(deleteNode(node.getLeftNode(), data));
        }
        else if(data.compareTo(node.getData()) > 0){
            node.setRightNode(deleteNode(node.getRightNode(), data));
        }
        else{
            // we have found the node we want to remove
            if(node.getLeftNode() == null && node.getRightNode() == null){
                System.out.println("Removing the leaf node...");
                return null;
            }

            // the node have just right child
            if(node.getLeftNode() == null){
                System.out.println("Removing node with just right child...");
                Node<T> tempNode = node.getRightNode();
                node = null;
                return tempNode;
            }

            // the node have just left child
            else if(node.getRightNode() == null){
                System.out.println("Removing node with just left child...");
                Node<T> tempNode = node.getLeftNode();
                node = null;
                return tempNode;
            }

            // the node have two children
            System.out.println("Removing node with two children...");
            Node<T> tempNode = getPredecessor(node.getLeftNode());
            node.setData(tempNode.getData());
            node.setLeftNode(deleteNode(node.getLeftNode(), tempNode.getData()));
        }
        node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);
        return makingBalance(node);
    }

    private Node<T> getPredecessor(Node<T> node) {
        if(node.getRightNode() != null){
            return getPredecessor(node.getRightNode());
        }
        return node;
    }

    @Override
    public T getMax() {
        if(root.getRightNode() == null){
            return root.getData();
        }
        return getMaxValue(root);
    }

    private T getMaxValue(Node<T> node) {
        if(node.getRightNode() != null){
            return getMaxValue(node.getRightNode());
        }
        return node.getData();
    }

    @Override
    public T getMin() {
        if(root.getLeftNode() == null){
            return root.getData();
        }
        return getMinValue(root);
    }

    private T getMinValue(Node<T> node) {
        if(node.getLeftNode() != null){
            return getMinValue(node.getLeftNode());
        }
        return node.getData();
    }
}
