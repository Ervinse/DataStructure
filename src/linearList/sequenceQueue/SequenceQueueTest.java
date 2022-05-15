package linearList.sequenceQueue;


public class SequenceQueueTest {
    public static void main(String[] args) {

        SequenceQueue<Integer> integerSequenceQueue = new SequenceQueue<>();
        addTestData(integerSequenceQueue);
        integerSequenceQueue.printValue();
        System.out.println();

        integerSequenceQueue.deQueue();
        integerSequenceQueue.printValue();
        System.out.println();

        integerSequenceQueue.enQueue(100);
        integerSequenceQueue.printValue();
        System.out.println();

    }

    static public void addTestData(SequenceQueue<Integer> sequenceQueue){
        for (int i = 1; i < 20; i++) {
            sequenceQueue.enQueue(i);
        }
    }
}
