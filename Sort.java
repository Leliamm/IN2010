import java.util.Arrays;

public class Sort {
    public int[] bubbleSort(int[] input) {
        System.out.println("Bubble sort" + Arrays.toString(input));
        int temp;
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = 0; j < input.length - i - 1; j++) {
                if (input[j] > input[j + 1]) {
                    temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
                System.out.println("Bubble sort" + Arrays.toString(input));
            }
        }
        return input;
    }

    public int[] selectionSort(int[] input) {
        System.out.println("Selection sort" + Arrays.toString(input));
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

            System.out.println("Selection sort" + Arrays.toString(input));
        }
        return input;
    }
}
