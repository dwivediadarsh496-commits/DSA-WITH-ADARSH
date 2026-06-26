public class BinarySearchTree {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public void insert(int data) {
        root = insertHelper(root, data);
    }

    private Node insertHelper(Node node, int data) {
        if (node == null) return new Node(data);
        if (data < node.data) node.left = insertHelper(node.left, data);
        else if (data > node.data) node.right = insertHelper(node.right, data);
        return node;
    }

    public boolean search(int key) {
        return searchHelper(root, key);
    }

    private boolean searchHelper(Node node, int key) {
        if (node == null) return false;
        if (node.data == key) return true;
        return key < node.data ? searchHelper(node.left, key) : searchHelper(node.right, key);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        System.out.println("Search 30: " + bst.search(30));
    }
}
