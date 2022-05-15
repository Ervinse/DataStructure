package linearList.linkQueue;

public class LinkQueueTest {

    public static void main(String[] args) {

        LinkQueue<Integer> integerLinkQueue = new LinkQueue<>();
        addTestData(integerLinkQueue);
        integerLinkQueue.printValue();
        System.out.println();

        integerLinkQueue.deQueue();
        integerLinkQueue.printValue();
        System.out.println();

        integerLinkQueue.enQueue(100);
        integerLinkQueue.printValue();
        System.out.println();

    }

    static public void addTestData(LinkQueue<Integer> linkQueue){
        for (int i = 1; i < 20; i++) {
            linkQueue.enQueue(i);
        }
    }
}
