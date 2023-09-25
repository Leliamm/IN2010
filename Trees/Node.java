public class Node implements Comparable<Node> {
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


    @Override
    public int compareTo(Node o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

    @Override
    public String toString(){
        return ""+this.data;
    }
}
