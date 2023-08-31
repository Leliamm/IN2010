import java.util.Arrays;

public class SearchSortTest {
    public static void main(String[] args){
        Search search = new Search();
        Sort sort = new Sort();

        int[] A = {1,2, 3, 4, 5, 6 , 7, 8};
        int[] B = {23,22, 13, 4, 55,16 , 7, 28, 0};

        System.out.println("Binary Search " + search.binarySearch(A, 0));
        // System.out.println("Bubble sort " + Arrays.toString(sort.bubbleSort(B)));
        System.out.println("Selection sort " + Arrays.toString(sort.selectionSort(B)));
    }
}
