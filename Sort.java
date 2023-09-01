import java.util.Arrays;

public class Sort {
    public int[] bubbleSort(int[] input) {
        System.out.println("Bubble sort input" + Arrays.toString(input));
        int temp;
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = 0; j < input.length - i - 1; j++) {
                if (input[j] > input[j + 1]) {
                    temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
                // System.out.println("Bubble sort" + Arrays.toString(input));
            }
        }
        return input;
    }

    public int[] selectionSort(int[] input) {
        System.out.println("Selection sort input" + Arrays.toString(input));
        int temp;
        for (int i = 0; i < input.length; i++) {
            int k = i;
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] < input[k]) {
                    k = j;
                }
            }
            if (i != k) {
                temp = input[i];
                input[i] = input[k];
                input[k] = temp;
            }

            // System.out.println("Selection sort" + Arrays.toString(input));
        }
        return input;
    }

    public int[] insertionSort(int[] input) {
        System.out.println("Insertion sort input" + Arrays.toString(input));
        for (int i = 1; i < input.length; i++) {
            int j = i;
            int temp;
            while (j > 0 && input[j - 1] > input[j]) {
                temp = input[j - 1];
                input[j - 1] = input[j];
                input[j] = temp;
                j = j - 1;
                // System.out.println("Insertion sort" + Arrays.toString(input));
            }
        }
        return input;
    }

    public int[] merge(int[] A, int[] B, int[] C) {
        int i = 0;
        int j = 0;

        // System.out.println("Array C input " + Arrays.toString(C));
        // System.out.println("Array A input " + Arrays.toString(A));
        // System.out.println("Array B input " + Arrays.toString(B));

        while (i < A.length && j < B.length) {
            if (A[i] <= B[j]) {
                C[i + j] = A[i];
                i = i + 1;
            } else {
                C[i + j] = B[j];
                j = j + 1;
            }
        }
        while (i < A.length) {
            C[i + j] = A[i];
            i = i + 1;
        }
        while (j < B.length) {
            C[i + j] = B[j];
            j = j + 1;
        }
        return C;
    }

    public int[] mergeSort(int[] input) {
        // System.out.println("Merge sort input" + Arrays.toString(input));
        if (input.length <= 1) {
            return input;
        }
        int i = input.length / 2;
        int[] A = new int[i];
        int[] B = new int[input.length - i];
        int index = 0;

        for (int j = 0; j < i; j++) {
            A[j] = input[j];
        }
        for (int j = i; j < input.length; j++) {
            B[index] = input[j];
            index = index + 1;
        }
        mergeSort(A);
        mergeSort(B);

        return merge(A, B, input);
    }

}
