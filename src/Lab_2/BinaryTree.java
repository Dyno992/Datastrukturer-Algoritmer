package Lab_2;

public class BinaryTree {
    Node root;

    class Node{
        Node left;
        Node right;
        int key;

        public Node(int key) {
            this.key = key;
        }
    }

    public void printTreeInOrder() {
        printTreeInOrder(root);
    }

    private void printTreeInOrder(Node tree){
        if(tree == null){
            return;
        }
        printTreeInOrder(tree.left);
        System.out.println(tree.key);
        printTreeInOrder(tree.right);
    }

    public void printTreeInReverseOrder(){
        printTreeInReverseOrder(root);
    }

    private void printTreeInReverseOrder(Node tree) {
        if(tree == null){
            return;
        }
        printTreeInReverseOrder(tree.right);
        System.out.println(tree.key);
        printTreeInReverseOrder(tree.left);
    }

    public void insert(int key){
        root = insertRec(root, key);
    }

    private Node insertRec(Node tree, int key) {
        if(tree == null){
            tree = new Node(key);
            return tree;
        }
        if(key < tree.key){
            tree.left = insertRec(tree.left, key);
        }
        else if (key > tree.key){
            tree.right = insertRec(tree.right, key);
        }
        return tree;
    }

    public static void main(String [] Args){
        BinaryTree bt = new BinaryTree();
        /*
                8
             3     10
           1  6       13


           printTreeInOrder(8)
             printTreeInOrder(3)
               printTreeInOrder(1)
                 printTreeInOrder(null)
                 print 1
                 printTreeInOrder(null)
               print 3
               printTreeInOrder(6)
                 printTreeInOrder(null)
                 print 6
                 printTreeInOrder(null)
             print 8
         */

        bt.insert(8);
        bt.insert(3);
        bt.insert(10);
        bt.insert(1);
        bt.insert(6);
        bt.insert(13);
        bt.insert(13);
        bt.printTreeInOrder();

//        bt.printTreeInReverseOrder();
    }
}