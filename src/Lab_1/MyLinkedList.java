package Lab_1;

public abstract class MyLinkedList {

    Node head;

    public abstract void push(int n);

    public void add(int n) {

        if(head == null) {
            head = new Node(n);
        } else {
            Node node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node(n);
        }
    }

    public void addAtStart(int n) {
        Node node = new Node(n);
        node.value = n;
        node.next = null;
        node.next = head;
        head = node;
    }

    public void add (int i, int n) {
        if(head == null) {
            add(n);
        }

        if( i == 0) {
            addAtStart(n);

        } else {
            Node node = new Node(n);
            node.next = null;
            Node node2 = head;
            for(int j = 0; j < i -1; j++) {
                node2 = node2.next;
            }
            node.next = node2.next;
            node2.next = node;
        }
    }

    public int get(int n) {
        int i = 0;
        Node node = head;
        while (i < n) {
            node = node.next;
            i++;
        }
        return node.value;
    }

    public void remove(int n) {
        if(n == 0) {
            head = head.next;
        } else {
            Node node = head;
            Node node1;
            for(int i = 0; i < n -1; i++) {
                node = node.next;
            }
            node1 = node.next;
            node.next = node1;
        }
    }

    public int size() {
        if(head == null) {
            return 0;
        } else {
            int i = 1;
            Node node = head;
            while (node.next != null) {
                node = node.next;
                i++;
            }
            return i;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        for(int i = 0; i<size(); i++) {
            System.out.println(get(i));
        }
    }
}