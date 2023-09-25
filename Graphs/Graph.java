import java.util.*;

class Node {
    String data;
    String farge;
    boolean visited;
    int inDeg;
    List<Node> naboer;

    public Node(String data) {
        this.data = data;
        this.visited = false;
        this.inDeg = 0;
        this.naboer = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder penStr = new StringBuilder(data + ": [");
        if (!naboer.isEmpty()) {
            for (Node kant : naboer) {
                penStr.append(kant.data).append(", ");
            }
            penStr.delete(penStr.length() - 2, penStr.length()); // Remove trailing comma
        }
        return penStr + "]";
    }
}

class Graph {
    Map<String, Node> graf;
    boolean rettet;

    public Graph(boolean rettet) {
        this.graf = new HashMap<>();
        this.rettet = rettet;
    }

    public void leggTilKant(String u, String v) {
        Node uNode = hentNode(u);
        Node vNode = hentNode(v);

        if (rettet) {
            uNode.naboer.add(vNode);
            vNode.inDeg++;
        } else {
            uNode.naboer.add(vNode);
            vNode.naboer.add(uNode);
        }
    }

    public int nodeCount() {
        return graf.keySet().size();
    }

    public int edgeCount() {
        int edges = 0;
        for (String s : graf.keySet()) {
            Node node = graf.get(s);
            for (Node n : node.naboer) {
                edges++;
            }
        }
        if (rettet) {
            edges = edges / 2;
        }
        return edges;
    }

    public Node hentNode(String data) {
        if (!graf.containsKey(data)) {
            graf.put(data, new Node(data));
        }
        return graf.get(data);
    }

    public void settNoderUbesokt() {
        for (Node node : graf.values()) {
            node.visited = false;
        }
    }

    // Depth first search
    public ArrayList<Node> DFSFull() {
        ArrayList<Node> visitedNodes = new ArrayList<Node>();
        for (String s : graf.keySet()) {
            Node n = graf.get(s);
            if (!n.visited) {
                DFSVisit(n, visitedNodes);
            }
        }
        return visitedNodes;
    }

    public ArrayList<Node> DFSVisit(Node n, ArrayList<Node> visited) {
        n.visited = true;
        visited.add(n);
        for (Node nb : n.naboer) {
            if (!nb.visited) {
                DFSVisit(nb, visited);
            }
        }
        return visited;
    }

    //Dybde først iterativ med stack
    public Stack<Node> DFSFullIter() {
        Stack<Node> dfsIter = new Stack<>();

        for (String s : graf.keySet()) {
            Node n = graf.get(s);
            if (!n.visited) {
                DFSVisitIter(n, dfsIter);
            }
        }
        return dfsIter;
    }

    public void DFSVisitIter(Node n, Stack<Node> stack) {
        Stack<Node> singelton = new Stack<>();
        singelton.push(n);
        while (!singelton.isEmpty()) {
            Node s = singelton.pop();
            if (!s.visited) {
                s.visited = true;
                stack.add(s);
                for (Node nb : s.naboer) {
                    singelton.push(nb);
                }
            }
        }

    }

    public static String stackToString(Stack<Node> stack) {
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            if (!stack.isEmpty()) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    // Bredde først søk
    public ArrayList<Node> BFSFull(){
        ArrayList<Node> breddeNodes = new ArrayList<>();
        for(String s : graf.keySet()){
            Node n = graf.get(s);
            if(!n.visited){
                BFSVisit(n, breddeNodes);
            }
        }
        return breddeNodes;

}

public void BFSVisit(Node n, ArrayList<Node> breddeNodes){
    Stack<Node> stack = new Stack<Node>();
    stack.add(n);
    n.visited = true;
    while(!stack.isEmpty()){
        Node s = stack.pop();
        for( Node nb : s.naboer){
            if(!nb.visited){
                nb.visited = true;
                breddeNodes.add(nb);
                stack.push(nb);

            }
        }
    }


}
    //topological sorting 
public ArrayList<Node> topSort() throws Exception{
    ArrayList<Node> topologicalSort = new ArrayList<>();
    Stack<Node> topoStack = new Stack<Node>();
    for(String s : graf.keySet()){
        Node n = graf.get(s);
       if(n.inDeg == 0) topoStack.push(n);
    }
    while(!topoStack.isEmpty()){
        Node u = topoStack.pop();
        topologicalSort.add(u);
        for(Node n : u.naboer){
            u.naboer.remove(n);
            if(n.inDeg == 0) topoStack.push(n);
        }
    }

    System.out.println("Array size" + topologicalSort.size());
    System.out.println("Total nodes in graph: " + nodeCount());
    if(topologicalSort.size() < nodeCount()) throw new RuntimeException("The graph contains a cycle.");

    return topologicalSort;
}

//Topological sorting with DFS

public Stack<Node> DFSTopSort(){
    Stack<Node> stack = new Stack<>();
    for(String s : graf.keySet()){
        Node n = graf.get(s);
        if(!n.visited){
            DFSVisitB(n, stack);
        }
    }
    return stack;
}

public void  DFSVisitB(Node n, Stack <Node> stack){
    n.visited = true;
    for(Node nb : n.naboer){
        if(!nb.visited){
            DFSVisitB(nb, stack);
        }
    }
    stack.push(n);

}
    //sett farge på node
    public String settFarge(Node n) {

        boolean redNabo = false;
        boolean blueNabo = false;
        if (n.naboer.isEmpty()) {
            n.visited = true;
            n.farge = "Blue";
            return "Blue";
        }
        for (Node fn : n.naboer) {
            if (fn.farge.equals("Red"))
                redNabo = true;
            if (fn.farge.equals("Blue"))
                blueNabo = true;
        }

        if (redNabo && blueNabo)
            return "Kan ikke sette farge.";
        if (redNabo) {
            n.farge = "Blue";
            return "Blue";
        } else {
            n.farge = "Red";
            return "Red";
        }
    }

    @Override
    public String toString() {
        StringBuilder penStr = new StringBuilder();
        for (String v : graf.keySet()) {
            penStr.append(graf.get(v)).append("\n");
        }
        return penStr.toString();
    }
}
