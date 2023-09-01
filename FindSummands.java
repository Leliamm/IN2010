import java.util.ArrayList;

public class FindSummands {
    ArrayList<Integer> usedIndex = new ArrayList<>();
    String output = "";

    public String finnSumm(int[] input, int x) {
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if ((input[j] + input[i] == x) && !(usedIndex.contains(j) || usedIndex.contains(i))) {
                    usedIndex.add(i);
                    usedIndex.add(j);
                    output += "<" + input[i] + "," + input[j] + "> ";
                }
            }
        }
        return output;
    }
}
