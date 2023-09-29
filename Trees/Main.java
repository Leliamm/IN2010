import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        BinaryTree AVL = new AVLTree();
        Set<Integer> reference = new TreeSet<>();

        Scanner scanner = new Scanner(System.in);
        String filePath = args[0];
        // String filePath = "inputs/eksempel_input";
        scanner.close();

        try {
            File file = new File(filePath);
            Scanner fileScanner = new Scanner(file);
            int antallKommandoer = fileScanner.nextInt();

            for (int i = 0; i < antallKommandoer; i++) {

                // if (AVL.findSize() != reference.size()) {
                //     for (int j : reference) {
                //         AVL.remove(j);
                //     }
                //     System.out.println("TEST " + BinaryTree.levelOrderToString(AVL.root));
                //     return;
                // }

                String line = fileScanner.next();
                if (line.contains("insert")) {
                    int tall = fileScanner.nextInt();
                    // tree.insert(tall);
                    AVL.insert(tall);
                    reference.add(tall);
                    // System.out.println(BinaryTree.levelOrderToString(tree.root));

                }
                if (line.contains("contains")) {
                    int tall = fileScanner.nextInt();
                    // System.out.println(tree.contains(tall));
                    System.out.println(AVL.contains(tall));
                }
                if (line.contains("remove")) {
                    // System.out.println("Remove ");

                    int tall = fileScanner.nextInt();
                    // tree.remove(tall);
                    AVL.remove(tall);
                    reference.remove(tall);
                    // System.out.println(BinaryTree.levelOrderToString(tree.root));

                }
                if (line.contains("size")) {
                    // System.out.println(tree.findSize());
                    System.out.println(AVL.findSize());
                    
                    // System.out.println("Size " + tree.findSize());
                    // System.out.println(BinaryTree.levelOrderToString(tree.root));

                }

                if (line.contains("print")) {

                    // System.out.println("Print \n" +  BinaryTree.levelOrderToString(AVL.root));
                    System.out.println("SIZE TEST AVL " + AVL.findSize());
                    System.out.println("SIZE TEST REF  " + reference.size());
                    System.out.println("ROOT " + AVL.root);
                    System.out.println("Contains 776159 " + AVL.contains(776159));

                }
            }
            fileScanner.close();
        } catch (

        FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
        }

        // tree.remove(1);
        //  System.out.println(BinaryTree.levelOrderToString(tree.root));

    }

}
