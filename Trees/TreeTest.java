public class TreeTest {
        public static void main(String[] args) {
                BinaryTree tree = new BinaryTree();

                tree.insert(16);
                // System.out.println("Binary Tree root:" + tree.root);
                // System.out.println("Binary Tree root left child:" + tree.root.leftChild);
                // System.out.println("Binary Tree root right child:" + tree.root.rightChild);
                // System.out.println("root heigth :" + BinaryTree.findHeight(tree.root) + " root depth: "
                //                 + BinaryTree.findDepth(tree.root));
                tree.insert(17);
                System.out.println("Binary Tree root:" + tree.root);
                tree.insert(13);
                tree.insert(15);
                  tree.insert(15);
                tree.insert(100);               
                tree.insert(21);
                tree.insert(5);
                tree.insert(22);
                tree.insert(101);
                System.out.println(BinaryTree.levelOrderToString(tree.root));
                System.out.println("Size:" + tree.size);

                tree.remove(15);
                System.out.println(BinaryTree.levelOrderToString(tree.root));
                System.out.println("Size:" + tree.size);

                tree.remove(16);

                System.out.println(BinaryTree.levelOrderToString(tree.root));
                System.out.println("Size:" + tree.size);
                System.out.println("Root:" + tree.root);
                 System.out.println("Root høyre barn:" + tree.root.rightChild);
                 System.out.println("Root høyre barn:" + tree.root.leftChild);
                 System.out.println("sISTE:" + tree.root.rightChild.leftChild.rightChild);

                System.out.println(BinaryTree.levelOrderToString(tree.root));
                tree.remove(1);
                System.out.println("Fjern noe som ikke finnes:" + tree.size);
                System.out.println(BinaryTree.levelOrderToString(tree.root));
                tree.remove(22);
                System.out.println("Size:" + tree.size);
                System.out.println(BinaryTree.levelOrderToString(tree.root));
                
                 System.out.println("ROOT TREE:");
                BinaryTree test = new BinaryTree();
                test.insert(2);
                System.out.println(BinaryTree.levelOrderToString(test.root));
                System.out.println("Size:" + test.size);
                System.out.println("Root:" + test.root);
                 System.out.println("Root høyre barn:" + test.root.rightChild);
                 System.out.println("Root høyre barn:" + test.root.leftChild);

                System.out.println("REMOVE:");
                test.remove(2);
                System.out.println(BinaryTree.levelOrderToString(test.root));
                System.out.println("Size:" + test.size);
                System.out.println("Root:" + test.root);

        System.out.println("BINARY TREE:");
                BinaryTree test1 = new BinaryTree();

                test1.insert(16);
                test1.insert(17);
                test1.insert(13);
                test1.insert(100);
                test1.insert(21);
                test1.insert(5);
                test1.insert(22);
                System.out.println("TEST add 101:");
                System.out.println(BinaryTree.levelOrderToString(test1.root));
                test1.insert(101);
                System.out.println(BinaryTree.levelOrderToString(test1.root));
                test1.insert(105);
                System.out.println(BinaryTree.levelOrderToString(test1.root));
                test1.insert(106);
                System.out.println(BinaryTree.levelOrderToString(test1.root));
                test1.insert(110);
                System.out.println(BinaryTree.levelOrderToString(test1.root));
                test1.insert(111);

                System.out.println(BinaryTree.levelOrderToString(test1.root));

                System.out.println("AVL:");
                BinaryTree AVL = new AVLTree();

                AVL.insert(16);
                AVL.insert(17);
                AVL.insert(13);
                AVL.insert(100);
                 System.out.println("TEST add 100:");
                System.out.println(BinaryTree.levelOrderToString(AVL.root));

                System.out.println("TEST add 21:");
                AVL.insert(21);
                System.out.println("endelig tree ");
                System.out.println(BinaryTree.levelOrderToString(AVL.root));


                System.out.println("TEST add 5:");
                AVL.insert(5);
                System.out.println(BinaryTree.levelOrderToString(AVL.root));

                 System.out.println("TEST add 22:");
                AVL.insert(22);
                System.out.println(BinaryTree.levelOrderToString(AVL.root));

                   
                System.out.println("TEST add 101:");
                AVL.insert(101);
             
                System.out.println("Size "+ AVL.findSize());
                System.out.println(BinaryTree.levelOrderToString(AVL.root));

                System.out.println("TEST add 105:");
                AVL.insert(105);
                 System.out.println("Size "+ AVL.findSize());
                System.out.println(BinaryTree.levelOrderToString(AVL.root));

                System.out.println("TEST add 106:");
                AVL.insert(106);
                System.out.println("Size "+ AVL.findSize());

                System.out.println(BinaryTree.levelOrderToString(AVL.root));
                System.out.println("TEST add 110:");
                AVL.insert(110);
                System.out.println("Size "+ AVL.findSize());
                System.out.println(BinaryTree.levelOrderToString(AVL.root));

                System.out.println("TEST add 111:");
                AVL.insert(111);
                System.out.println("Size "+ AVL.findSize());
                System.out.println(BinaryTree.levelOrderToString(AVL.root));

                 System.out.println("TEST add 112:");
                AVL.insert(112);
                System.out.println("Size "+ AVL.findSize());
                System.out.println(BinaryTree.levelOrderToString(AVL.root));


                System.out.println("REMOVE 5:");
                AVL.remove(5);
                System.out.println("Size "+ AVL.findSize());
                System.out.println(BinaryTree.levelOrderToString(AVL.root));

                System.out.println("REMOVE 100:");
                AVL.remove(100);
                System.out.println("Size "+ AVL.findSize());
                System.out.println(BinaryTree.levelOrderToString(AVL.root));

                System.out.println("REMOVE 110:");
                AVL.remove(11-0);
                System.out.println("Size "+ AVL.findSize());
                System.out.println(BinaryTree.levelOrderToString(AVL.root));

                System.out.println("Contains 1? " + AVL.contains(1)); 
                System.out.println("Contains 112? " + AVL.contains(112)); 

                
                

                // Les input og utfør operasjoner på treet her

                // Stdin
                // Stdin på Java kan implementeres ved å bruke Scanner-klassen.

                // Stdout
                // Stdout på Java kan implementeres ved å bruke System.out.println() for utskrift.
        }
}
