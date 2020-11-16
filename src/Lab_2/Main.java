package Lab_2;

public class Main {

    public static void main(String[] args) {

        //Working as https://www.cs.usfca.edu/~galles/visualization/BST.html
        //Lagt till en contains method som returnar true eller false om värdet finns i trädet.

        MyBinaryTree bt = new MyBinaryTree();

        bt.insert(11);
        bt.insert(15);
        bt.insert(3);
        bt.insert(12);
        bt.insert(20);
        bt.insert(4);
        bt.insert(9);
        bt.insert(22);
        bt.insert(26);
        bt.insert(24);
        bt.insert(7);
        bt.insert(6);
        bt.insert(8);

        /*
                                11
                           3          15
                             4      12   20
                               9            22
                            7                  26
                          6   8              24
    */

        bt.printPostOrder(); //left, right, root
        System.out.println();
        bt.printInOrder(); //left, root, right
        System.out.println();
        bt.printReverseInOrder(); //right, root, left
        System.out.println();
        bt.printPreOrder(); //root, left, right


        int[] num = {10, 1, 4, 6, 8, 2, 16, -2};
        System.out.println();
        System.out.println();
        testBubbleSortIntegerArray();
    }

    public static void testBubbleSortIntegerArray() {

        int[] num = {10, 1, 4, 6, 8, 2, 16, -2};

        for (int i = 0; i < num.length; i++) {
            for (int j = 1; j < num.length; j++) {
                if (num[j] > num[j - 1]) {
                    int tmp = num[j];
                    num[j] = num[j-1];
                    num[j-1] = tmp;
                }
            }
        }

        for (int x : num) {
            System.out.println(x);
        }
    }
}