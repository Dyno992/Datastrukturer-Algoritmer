package Final_Lab_1;

public class MyLinkedList {

    MyNode head;

    public void add(int x) {

        if (head == null) {
            head = new MyNode(x);

        } else {
            MyNode n = head;

            while (n.next != null) {
                n = n.next;
            }

            n.next = new MyNode(x);
        }
    }

    public void add(int i, int x) {

        if (i >= 0 && i < size()+1) {

            if (head == null) {
                add(x);

            }
            if (i == 0) {

                addAtStart(x);

            } else {
                MyNode node = new MyNode(x);
                MyNode n = head;

                for (int j = 0; j < i - 1; j++) {
                    n = n.next;
                }
                node.next = n.next;
                n.next = node;
            }
        } else {
            throw new ArrayIndexOutOfBoundsException("Not a valid index position.");
        }
    }

    public void remove(int i) {

        if (i >= 0 && i < size()) {

            if (i == 0) {
                head = head.next;

            } else {
                MyNode n = head;
                MyNode n1;

                for (int j = 0; j < i - 1; j++) {
                    n = n.next;
                }

                n1 = n.next;
                n.next = n1.next;
            }
        } else {
            throw new ArrayIndexOutOfBoundsException("Not a valid index position.");
        }
    }

    public int get(int i) {

        if (i > size()-1) {
            throw new ArrayIndexOutOfBoundsException("Not a valid index position.");

        } else {

            int j = 0;

            MyNode n = head;

            while (j < i) {
                n = n.next;
                j++;
            }
            return n.v;
        }
    }

    public int size() {

        if (head == null) {
            return 0;

        } else {
            int i = 1;
            MyNode n = head;

            while (n.next != null) {
                n = n.next;
                i++;
            }
            return i;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean contains(int x) {

        boolean b = false;

        for (int i = 0; i < size(); i++) {

            if (get(i) == x) {
                b = true;
            }
        }
        return b;
    }

    private void addAtStart(int x) {

        MyNode n = new MyNode(x);
        n.next = head;
        head = n;
    }

    public void printList() {

        for (int i = 0; i < size(); i++) {
            System.out.println(get(i));
        }
    }
}