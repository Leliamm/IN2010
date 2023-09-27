public class AVLTree extends BinaryTree {

    public AVLTree() {
        super();
    }

    int minHeight(Node v) {
        if (v == null) {
            return -1;
        }
        return 1 + Math.min(minHeight(v.leftChild), minHeight(v.rightChild));
    }

    boolean isBalanced() {
        return findHeight(root) - minHeight(root) <= 1;
    }

    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return findHeight(node.leftChild) - findHeight(node.rightChild);
    }

    private Node leftRotate(Node z) {

        Node y = z.rightChild;
        Node t1 = y.leftChild;

        y.leftChild = z;
        z.rightChild = t1;
        z.parent = y;
        if (z == root)
            root = y;

        System.out.print("Left rotate: " + levelOrderToString(root));
        return y;
    }

    private Node rightRotate(Node z) {
        Node y = z.leftChild;
        Node t2 = y.rightChild;

        y.rightChild = z;
        z.leftChild = t2;
        z.parent = y;
        if (z == root)
            root = y;
        System.out.print("Rigth rotate: " + levelOrderToString(root));
        return y;
    }

    private Node balanceTree(Node n) {
        int balanceFactor = getBalanceFactor(n);
        System.out.println("balance factor " + balanceFactor);

        if (balanceFactor < -1) {
            if (getBalanceFactor(n.rightChild) > 0) {
                n.rightChild = rightRotate(n.rightChild);
            }
            System.out.println("noden jeg sender til left rotate er: " + n);

            return leftRotate(n);
        }

        if (balanceFactor > 1) {
            if (getBalanceFactor(n.leftChild) < 0) {
                n.leftChild = leftRotate(n.leftChild);
            }
            return rightRotate(n);
        }

        return n;
    }

    @Override
    public void insert(int value) {
        size++;
        if (root == null) {
            root = new Node(value);
        } else {
            insertAVL(null, root, value);
        }
    }

    public Node insertAVL(Node parent, Node n, int value) {
        if (n == null) {
            n = new Node(value);
            n.parent = parent;
        } else if (value < n.data) {
            n.leftChild = insertAVL(n, n.leftChild, value);
        } else {
            n.rightChild = insertAVL(n, n.rightChild, value);
        }
        return balanceTree(n);
    }

    @Override
    public Node removeValue(Node parent, Node n, int value) {

        if (n == null)
            return null;
        if (size == 0) {
            root = null;
            return null;
        }
        if (value < n.data) {
            n.leftChild = removeValue(n, n.leftChild, value);
            return balanceTree(n);
        }
        if (value > n.data) {
            n.rightChild = removeValue(n, n.rightChild, value);
            return balanceTree(n);
        }

        if (n.leftChild == null)
            return n.rightChild;
        if (n.rightChild == null)
            return n.leftChild;

        Node min = findMin(n.rightChild);
        n.data = min.data;
        n.rightChild = removeValue(n, n.rightChild, min.data);
        return balanceTree(n);
    }

    public void traverse(Node root) {
        // Implement traversal here
    }

}
