import java.util.Arrays;

public class SearchSortTest {
    public static void main(String[] args) {
        Search search = new Search();
        Sort sort = new Sort();

        int[] A = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int[] B = { 23, 22, 13, 4, 55, 16, 7, 28, 0 };
        int[] C = { 23, 22, 13, 4, 55, 16, 7, 28, 0 };

        System.out.println("Binary Search " + search.binarySearch(A, 0));
        System.out.println("Bubble sort " + Arrays.toString(sort.bubbleSort(C.clone())));
        int[] F = B.clone();
        System.out.println("Selection sort " + Arrays.toString(sort.selectionSort(F)));
        System.out.println("Insertion sort " + Arrays.toString(sort.insertionSort(B)));
         System.out.println("Merge sort " + Arrays.toString(sort.mergeSort(C.clone())));
    }
}
