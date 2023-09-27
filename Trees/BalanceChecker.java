import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BalanceChecker {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BinarySearchTree tree = new BinarySearchTree();

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            int x = Integer.parseInt(line);
            tree.insert(x);
        }
        if (tree.isBalanced()) {
            System.out.println("Dette treet ser balansert ut!");
        } else {
            System.out.println("Dette treet ser ikke helt balansert ut... prøv igjen!");
        }
    }
}
