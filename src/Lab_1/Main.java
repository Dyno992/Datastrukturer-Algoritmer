package Lab_1;

public class Main {

    public static void main(String[] args) {

        MyStack list = new MyStack();

        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list.size());

        list.add(0, 99);

        System.out.println(list.size());

        System.out.println(list.get(0));
        System.out.println(list.get(3));

        list.remove(3);

        System.out.println(list.size());
        System.out.println(list.isEmpty());

        //skapat en printList metod i MyLinkedList för att skriva ut hela listan och låter den vara kvar...
    }
}