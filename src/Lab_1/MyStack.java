package Lab_1;

public class MyStack extends MyLinkedList {

    public void push(int x) {
        if (size() == 0) {
            super.add(x);

        } else {
            super.add(size(), x);
        }
    }

    public int peek() {
        return get(size()-1);
    }

    public int pop() {
        int tmp = get(size()-1);
        super.remove(size()-1);
        return tmp;
    }
}
