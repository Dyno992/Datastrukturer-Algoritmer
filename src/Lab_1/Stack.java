package Lab_1;

public class Stack extends MyLinkedList {

    @Override
    public void push(int n) {
        super.addAtStart(n);
    }

    public int pop(int n) {
        head = head.next;
    }
}