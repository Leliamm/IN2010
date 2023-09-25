public class TreeTest {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.insert( 16);
                System.out.println("Binary Tree root:" + tree.root);
        System.out.println("Binary Tree root left child:" + tree.root.leftChild);
        System.out.println("Binary Tree root right child:" + tree.root.rightChild);
        System.out.println("root heigth :" + BinaryTree.findHeight(tree.root) + " root depth: " + BinaryTree.findDepth(tree.root) );
        tree.insert( 16);
                System.out.println("Binary Tree root:" + tree.root);
        System.out.println("Binary Tree root left child:" + tree.root.leftChild);
        System.out.println("Binary Tree root right child:" + tree.root.rightChild);
                System.out.println("root heigth :" + BinaryTree.findHeight(tree.root) + " root depth: " + BinaryTree.findDepth(tree.root) );

        tree.insert( 13);
                System.out.println("Binary Tree root:" + tree.root);
        System.out.println("Binary Tree root left child:" + tree.root.leftChild);
        System.out.println("Binary Tree root right child:" + tree.root.rightChild);
        tree.insert( 13);
                System.out.println("Binary Tree root:" + tree.root);
        System.out.println("Binary Tree root left child:" + tree.root.leftChild);
        System.out.println("Binary Tree root right child:" + tree.root.rightChild);
                System.out.println("root heigth :" + BinaryTree.findHeight(tree.root) + " root depth: " + BinaryTree.findDepth(tree.root) );

        tree.insert( 100);
                System.out.println("Binary Tree root:" + tree.root);
        System.out.println("Binary Tree root left child:" + tree.root.leftChild);
        System.out.println("Binary Tree root right child:" + tree.root.rightChild);
        tree.insert( 21);
        System.out.println("Binary Tree root:" + tree.root);
        System.out.println("Binary Tree root left child:" + tree.root.leftChild);
        System.out.println("Binary Tree root right child:" + tree.root.rightChild);
        System.out.println("root heigth :" + BinaryTree.findHeight(tree.root) + " root depth: " + BinaryTree.findDepth(tree.root) );
          tree.insert( 12);
            tree.insert( 22);
              tree.insert( 101);
                System.out.println("root heigth :" + BinaryTree.findHeight(tree.root) + " root depth: " + BinaryTree.findDepth(tree.root) );
                 System.out.println("siste nod : " +   tree.root.rightChild.rightChild.rightChild);
         System.out.println("siste node heigth: " +   BinaryTree.findHeight(tree.root.rightChild.rightChild.rightChild) +" siste node depth: " +   BinaryTree.findDepth(tree.root.rightChild.rightChild.rightChild) );

        System.out.println(BinaryTree.levelOrderToString(tree.root));
        

        // Les input og utfør operasjoner på treet her

        // Stdin
        // Stdin på Java kan implementeres ved å bruke Scanner-klassen.

        // Stdout
        // Stdout på Java kan implementeres ved å bruke System.out.println() for utskrift.
    }
}
