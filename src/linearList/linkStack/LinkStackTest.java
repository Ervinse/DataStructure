package linearList.linkStack;


public class LinkStackTest {
    public static void main(String[] args) {
        LinkStack<Integer> integerLinkStack = new LinkStack<>();
        addTestData(integerLinkStack);

        integerLinkStack.printValue();
        System.out.println();

        integerLinkStack.push(100);
        integerLinkStack.printValue();
        System.out.println();

        integerLinkStack.pop();
        integerLinkStack.printValue();
    }

    static public void addTestData(LinkStack<Integer> linkStack){
        for (int i = 1; i < 20; i++) {
            linkStack.push(i);
        }
    }
}
