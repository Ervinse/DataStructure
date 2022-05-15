package linearList.linkedList;


public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        addTestData(integerLinkedList);

        integerLinkedList.insert(4, 100);
        integerLinkedList.delete(2);

        integerLinkedList.printValue();
        System.out.println();

        integerLinkedList.reserve();
        integerLinkedList.printValue();

    }

    static public void addTestData(LinkedList<Integer> integerLinkedList){
        integerLinkedList.add(4);
        integerLinkedList.add(19);
        integerLinkedList.add(24);
        integerLinkedList.add(144);
        integerLinkedList.add(47);
        integerLinkedList.add(28);
        integerLinkedList.add(46);
        integerLinkedList.add(98);
    }
}
