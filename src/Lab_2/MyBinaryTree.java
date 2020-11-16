package Lab_2;

public class MyBinaryTree {

    MyNode root;

    public void insert(int x) {
        root = insertRec(root, x);
    }

    private MyNode insertRec(MyNode tree, int x) {

        if (tree == null) {
            tree = new MyNode(x);
            return tree;
        }

        if (x > tree.key) {
            tree.right = insertRec(tree.right, x);

        } else {
            tree.left = insertRec(tree.left, x);
        }
        return tree;
    }

    public void remove(int x) {
        root = removeNode(this.root, x);
    }

    private MyNode removeNode(MyNode tree, int x) {

        if (x < tree.key) {
            tree.left = removeNode(tree.left, x);

        } else if (x > tree.key) {
            tree.right = removeNode(tree.right, x);

        } else {

            if (tree.left == null && tree.right == null) {
                return null;

            } else if (tree.left == null) {
                return tree.right;

            } else if (tree.right == null) {
                return tree.left;

            } else {

                if (tree.left.right != null) {

                    int temp = getHighestValueOfTheSubTree(tree.left.right);
                    tree.key = temp;
                    tree.left.right = removeNode(tree.left.right, temp);

                } else {
                    tree.key = tree.left.key;
                    tree.left = tree.left.left;
                }
            }
        }
        return tree;
    }

    private int getHighestValueOfTheSubTree(MyNode tree) {

        if (tree.right == null) {
            return tree.key;

        } else {
            return getHighestValueOfTheSubTree(tree.right);
        }
    }

    public void printPreOrder() {
        printPreOrder(root);
    }
    private void printPreOrder(MyNode tree) {

        if (tree == null) {
            return;
        }
        System.out.print(tree.key + " ");
        printPreOrder(tree.left);
        printPreOrder(tree.right);
    }

    public void printInOrder() {
        printInOrder(root);
    }
    private void printInOrder(MyNode tree) {

        if (tree == null) {
            return;
        }
        printInOrder(tree.left);
        System.out.print(tree.key + " ");
        printInOrder(tree.right);
    }

    public void printPostOrder() {
        printPostOrder(root);
    }
    private void printPostOrder(MyNode tree) {

        if (tree == null) {
            return;
        }
        printPostOrder(tree.left);
        printPostOrder(tree.right);
        System.out.print(tree.key + " ");
    }

    public void printReverseInOrder() {
        printReverseInOrder(root);
    }
    private void printReverseInOrder(MyNode tree) {

        if (tree == null) {
            return;
        }
        printReverseInOrder(tree.right);
        System.out.print(tree.key + " ");
        printReverseInOrder(tree.left);
    }

    public boolean contains(int x) {

        boolean b = false;

        try {
            if (contains(root, x).key == x) {
                b = true;
            }

        } catch (Exception e) {
            System.err.println("Not a value in this tree.");
        }
        return b;
    }

    private MyNode contains(MyNode tree, int x) {

        if (x < tree.key) {
            return contains(tree.left, x);

        } else if (x > tree.key) {
            return contains(tree.right, x);

        }

        return tree;
    }

}