package linearList.sequenceList;

public class SequenceListTest {
    public static void main(String[] args) {
        SequenceList<Integer> integerSequenceList = new SequenceList<Integer>();
        addTestData(integerSequenceList);

        integerSequenceList.remove(4);
        integerSequenceList.insert(2, 100);

        integerSequenceList.printValue();
    }

    static public void addTestData(SequenceList<Integer> sequenceList){
        sequenceList.add(4);
        sequenceList.add(19);
        sequenceList.add(24);
        sequenceList.add(144);
        sequenceList.add(47);
        sequenceList.add(28);
        sequenceList.add(46);
        sequenceList.add(98);
    }
}
