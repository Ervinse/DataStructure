package linearList.sequenceStack;

public class SequenceStackTest {
    public static void main(String[] args) {
        SequenceStack<Integer> integerSequenceStack = new SequenceStack<>(5);
        addTestData(integerSequenceStack);

        integerSequenceStack.printValue();

    }

    static public void addTestData(SequenceStack<Integer> sequenceStack){
        for (int i = 1; i < 20; i++) {
            sequenceStack.push(i);
        }
    }
}
