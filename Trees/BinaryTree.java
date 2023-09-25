import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;
    int size;
    int heigth = findHeight(root);
    ArrayList<Node> nodes = new ArrayList<>();

    public BinaryTree() {
        root = null;
        size = 0;
    }

    public Node insertNode(Node parent, Node n, int value) {
        if (n == null) {
            n = new Node(value);
            n.parent = parent;
        } else if (value < n.data) {
            n.leftChild = insertNode(n, n.leftChild, value);
        } else {
            n.rightChild = insertNode(n, n.rightChild, value);
        }
        return n;
    }

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            insertNode(null, root, value);
        }
    }

    public boolean contains(Node n, int value) {
        if (n == null)
            return false;
        if (n.data == value)
            return true;
        if (value < n.data) {
            return contains(n.leftChild, value);
        } else {
            return contains(n.rightChild, value);
        }
    }

    public Node findMin(Node n) {
        while (n != null) {
            n = n.leftChild;
        }
        return n;
    }

    public Node remove(Node n, int value) {
        if (n == null)
            return null;
        if (value < n.data) {
            n.leftChild = remove(n.leftChild, value);
            return n;
        }
        if (value >= n.data) {
            n.rightChild = remove(n.rightChild, value);
            return n;
        }

        if (n.leftChild == null)
            return n.rightChild;
        if (n.rightChild == null)
            return n.leftChild;

        Node min = findMin(n.rightChild);
        n.data = min.data;
        n.rightChild = remove(n.rightChild, min.data);
        return n;
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

    public static int findDepth(Node n) {
        if (n == null) {
            return -1;
        }
        return 1 + findDepth(n.parent);
    }

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
                // System.out.println("teller: " + teller);
                // System.out.println("Current depth: " + findDepth(current));
                // System.out.println("Current heigth: " + findHeight(current));

                String spaces = "";
                int rom = (int) (Math.pow(2, findHeight(root) - findDepth(current)));
                for (int i = 0; i < rom; i++) {
                    spaces += "__";
                }

                  if (current != root && current.parent.leftChild == null && current.parent.rightChild != null) {
                    result.append(spaces + " " + spaces + " ");
                }
                 if (current != root && current.parent.leftChild != null && current.parent.rightChild == null) {
                    result.append(spaces + " " + spaces + " ");
                }
    
                result.append(spaces + current.data + spaces + " ");

              

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
