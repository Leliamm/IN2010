import java.util.Arrays;

public class SearchSortTest {
    public static void main(String[] args) {
        Search search = new Search();
        Sort sort = new Sort();

        int[] A = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int[] B = { 23, 22, 13, 4, 55, 16, 7, 28, 0 };
        int[] C = { 23, 22, 13, 4, 55, 16, 7, 28, 0 };
        int[] F = B.clone();
        int[] D = {2,51, 53, 66,67,66,57,83,98,98};

        System.out.println("Insertion sort " + Arrays.toString(sort.insertionSort(D)));
        System.out.println("Binary Search " + search.binarySearch(A, 0));
        System.out.println("Bubble sort " + Arrays.toString(sort.bubbleSort(C.clone())));
        System.out.println("Selection sort " + Arrays.toString(sort.selectionSort(F)));
        System.out.println("Insertion sort " + Arrays.toString(sort.insertionSort(B)));
        System.out.println("Merge sort " + Arrays.toString(sort.mergeSort(C.clone())));
        
    }
}
