public class Node {
    int data;
    Node parent;
    Node leftChild;
    Node rightChild;

    public Node(int data){
        this.data = data;
        parent = null;
        leftChild = null;
        rightChild = null;
    }

    public int findHeight(Node n){
        int heigth = -1;
        if(n == null) return heigth;
        else{
           int leftHeight = findHeight(n.leftChild);
            int rightHeight = findHeight(n.rightChild);
            heigth= 1 + Math.max(leftHeight, rightHeight);
        }
        return heigth;
    }

    public int findDepth(Node n){
        if (n == null){
            return -1;
        }
        return 1 + findDepth(n.parent); 
    }
}
