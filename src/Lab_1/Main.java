package Lab_1;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MyLinkedList list = new Stack();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));

        System.out.println("-------------");
        list.push(11);

        list.printList();
    }
}