import sort.*;


public class Test {
    public static void main(String[] args) {

        Integer[] arr = {1,4,6,3,2,9,5};

        HeapSort.sort(arr);

        for (int i : arr) {
            System.out.print(i);
        }
    }
}
