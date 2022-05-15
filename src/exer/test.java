package exer;

public class test {
    public static void main(String[] args) {
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        integerLinkedList.add(1);
        integerLinkedList.add(2);
        integerLinkedList.add(3);
        integerLinkedList.add(4);
        integerLinkedList.printValue();
        System.out.println();

        integerLinkedList.insertAfter(2, 10);
        integerLinkedList.printValue();
        System.out.println();

        integerLinkedList.insertTail(0);
        integerLinkedList.printValue();
        System.out.println();

        integerLinkedList.deleteBefore(5);
        integerLinkedList.printValue();
        System.out.println();

        integerLinkedList.deleteTail();
        integerLinkedList.printValue();
        System.out.println();

        integerLinkedList.addBefore(23);
        integerLinkedList.printValue();
        System.out.println();
    }
}
