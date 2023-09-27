import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;
    int size;
    int heigthTree = findHeight(root);
    int heigth;

    public BinaryTree() {
        root = null;
        size = 0;
    }

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
            size++;
        } else {
            insertNode(null, root, value);
        }
    }

    private Node insertNode(Node parent, Node n, int value) {
        if (n == null) {
            n = new Node(value);
            n.parent = parent;
            size++;
        } else if (value < n.data) {
            n.leftChild = insertNode(n, n.leftChild, value);
        } else if (value > n.data) {
            n.rightChild = insertNode(n, n.rightChild, value);
        }
        return n;
    }


        public boolean contains(int value) {
           return containsValue(root, value);
    }

    private boolean containsValue(Node n, int value) {
        if (n == null)
            return false;
        if (n.data == value)
            return true;
        if (value < n.data) {
            return containsValue(n.leftChild, value);
        } else {
            return containsValue(n.rightChild, value);
        }
    }



    public Node findMin(Node n) {
        while (n.leftChild != null) {
            n = n.leftChild;
        }
        System.out.println("minst er nå: " + n);
        return n;
    }

    public Node remove(int i) {
        if (!contains(i))
            return null;
        size--;
        return removeValue(null, root, i);
    }

    public Node removeValue(Node parent, Node n, int value) {
        if (n == null)
            return null;
        if (size == 0) {
            root = null;
            return null;
        }
        if (value < n.data) {
            n.leftChild = removeValue(n, n.leftChild, value);
            return n;
        }
        if (value > n.data) {
            n.rightChild = removeValue(n, n.rightChild, value);
            return n;
        }

        if (n.leftChild == null)
            return n.rightChild;
        if (n.rightChild == null)
            return n.leftChild;

        Node min = findMin(n.rightChild);
        n.data = min.data;
        n.rightChild = removeValue(n, n.rightChild, min.data);
        return n;
    }

    public int findSize(){
        return size;
    }

    public static int findHeight(Node n) {
       int heigth = -1;
        if (n == null)
            return heigth;
        else {
            int leftHeight = findHeight(n.leftChild);
            int rightHeight = findHeight(n.rightChild);
            heigth = 1 + Math.max(leftHeight, rightHeight);
        }
        return heigth;
    }

    int minHeight(Node v) {
        if (v == null) {
            return -1;
        }
        return 1 + Math.min(minHeight(v.leftChild), minHeight(v.rightChild));
    }

    public static int findDepth(Node n) {
        if (n == null) {
            return -1;
        }
        return 1 + findDepth(n.parent);
    }

    //************************************************ */
    ///Printing the tree
    public static String levelOrderToString(Node root) {
        if (root == null) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int currentLevelSize = queue.size(); // Number of nodes in the current level

            while (currentLevelSize > 0) {
                Node current = queue.poll();
                // System.out.println("Current: " + current.data);
                // // System.out.println("Current depth: " + findDepth(current));
                // // // System.out.println("Current heigth: " + findHeight(current));
                // // int potens = findHeight(root) - findDepth(current);
                // // System.out.println("Current: " + potens);

                // // String spaces = "";
                // // int rom = (int) (Math.pow(2, findHeight(root) - findDepth(current)));
                // // for (int i = 0; i < rom; i++) {
                // //     spaces += "__";
                // // }

                // if (current.parent != null && current.parent.leftChild == null && current.parent.rightChild != null) {
                //     result.append(spaces + " " + spaces + " ");
                // }
                // if (current.parent != null && current.parent.leftChild != null && current.parent.rightChild == null) {
                //     result.append(spaces + " " + spaces + " ");
                // }
                // if (current.parent != null && current.parent.parent != null && current == current.parent.leftChild) {
                //     if (current.parent.parent.leftChild == null) {
                //         result.append(spaces + " " + spaces + " ");
                //     }
                // }

                // if (current.parent != null && current.parent.parent != null && current.parent.parent.parent != null
                //         && current == current.parent.leftChild) {
                //     if (current.parent.parent.parent.leftChild == null) {
                //         result.append(spaces + " " + spaces + " " + spaces + " " + spaces + " ");
                //     }
                // }

                // // if (current.parent != null && current.parent.parent != null && current.parent.parent.parent != null
                //         && current == current.parent.rightChild &&  current.parent.leftChild == null) {
                //     if (current.parent.parent.parent.leftChild == null) {
                //         result.append(spaces + " " + spaces + " " + spaces + " " + spaces + " " + spaces + " " + spaces + " " + spaces + " " + spaces + " ");
                //     }
                // }
                result.append(current.data + " ");

                if (current.leftChild != null) {
                    queue.offer(current.leftChild);
                }

                if (current.rightChild != null) {
                    queue.offer(current.rightChild);

                }
                
                currentLevelSize--;

                if (currentLevelSize > 0) {
                    result.append(" ");
                }
            }

            result.append("\n"); // Add a new line for the next level
        }

        return result.toString();
    }

}
