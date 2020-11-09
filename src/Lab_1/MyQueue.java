package Lab_1;

public class MyQueue extends MyLinkedList {

    public void enqueue(int x) {
        if (size() == 0) {
            super.add(x);

        } else {
            super.add(size(), x);
        }
    }

    public int dequeue() {
        int tmp = get(0);
        head = head.next;
        return tmp;
    }

    public int peek() {
        return get(0);
    }
}
