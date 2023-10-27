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

    public String naboString() {
        StringBuilder penStr = new StringBuilder(data + ": [");
        if (!naboer.isEmpty()) {
            for (Node kant : naboer) {
                penStr.append(kant.data).append(", ");
            }
            penStr.delete(penStr.length() - 2, penStr.length()); // Remove trailing comma
        }
        return penStr + "]";
    }

    @Override
    public String toString() {
        return this.data;
    }
}

class Edge implements Comparable<Edge> {
    Node n, v;
    int vekt;

    public Edge(Node n, Node v, int vekt) {
        this.n = n;
        this.v = v;
        this.vekt = vekt;
    }

    public Edge(Node n, Node v) {
        this.n = n;
        this.v = v;
    }

    @Override
    public int compareTo(Edge e) {
        return e.vekt - this.vekt;
    }

}

class Graph {
    Map<Node, Edge> graf;
    int nodes, edges;
    boolean rettet;
    boolean vektet;

    public Graph(boolean rettet, boolean vektet) {
        this.graf = new HashMap<>();
        this.rettet = rettet;
        this.vektet = vektet;
    }

    public void leggTilEdge(Node u, Node v) {
        Node uNode = hentNode(u);
        Node vNode = hentNode(v);
        Edge egde = new Edge(uNode, vNode);
        if (rettet) {
            uNode.naboer.add(vNode);
            vNode.inDeg++;
        } else {
            uNode.naboer.add(vNode);
            vNode.naboer.add(uNode);
        }

    }

    public void leggTilEdge(Node u, Node v, int vekt) {
        Node uNode = hentNode(u);
        Node vNode = hentNode(v);
        Edge edge = new Edge(uNode, vNode, vekt);

        if (rettet) {
            uNode.naboer.add(vNode);
            vNode.inDeg++;
            edges++;
        } else {
            uNode.naboer.add(vNode);
            vNode.naboer.add(uNode);
            edges = edges + 2;
        }
    }

    public int nodeCount() {
        return graf.keySet().size();
    }

    public int edgeCount() {
        return edges;
    }

    public Node hentNode(Node n) {
        if (!graf.containsKey(n)) {
            graf.put(n, null);
        }
        return n;
    }

    public void addNode(String data) {
        if (!graf.containsKey(data)) {
            graf.put(new Node(data), null);
        } else {
            System.out.println("The graph already contains a node " + data);
        }
    }

    public void settNoderUbesokt() {
        for (Node node : graf.keySet()) {
            node.visited = false;
        }
    }

    //find parent nodes

    public HashMap<Node, Node> parents(Node n) {
        HashMap<Node, Node> parents = new HashMap<>();
        parents.put(n, null);
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(n);

        while (!queue.isEmpty()) {
            Node u = queue.poll();
            for (Node v : u.naboer) {
                if (!parents.containsKey(v)) {
                    parents.put(v, u);
                    queue.offer(v);
                }
            }
        }

        return parents;
    }

    // Depth first search
    public ArrayList<Node> DFSFull() {
        ArrayList<Node> visitedNodes = new ArrayList<Node>();
        for (Node n : graf.keySet()) {
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

        for (Node n : graf.keySet()) {
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
    public ArrayList<Node> BFSFull() {
        ArrayList<Node> breddeNodes = new ArrayList<>();
        for (Node n : graf.keySet()) {
            if (!n.visited) {
                BFSVisit(n, breddeNodes);
            }
        }
        return breddeNodes;

    }

    public void BFSVisit(Node n, ArrayList<Node> breddeNodes) {
        Stack<Node> stack = new Stack<Node>();
        stack.add(n);
        n.visited = true;
        while (!stack.isEmpty()) {
            Node s = stack.pop();
            for (Node nb : s.naboer) {
                if (!nb.visited) {
                    nb.visited = true;
                    breddeNodes.add(nb);
                    stack.push(nb);

                }
            }
        }

    }

    public ArrayList<String> visitFraTil(Node fra, Node til) {
        settNoderUbesokt();
        Stack<Node> stack = new Stack<>();
        ArrayList<String> pathList = new ArrayList<>();
        stack.push(fra);

        while (!stack.isEmpty()) {
            Node s = stack.pop();
            s.visited = true;
            for (Node f : s.naboer) {
                if (f == til) {
                    pathList.add(" ==> " + f.toString() + " ");
                    return pathList;
                }
                if (!f.visited) {
                    f.visited = true;
                    stack.push(f);
                    pathList.add(" ==> " + f.toString() + " ");
                }
            }
        }

        Collections.reverse(pathList);
        System.out.println("Shortest path fra " + fra.toString() + " til " + til.toString());
        return pathList;

    }

    public ArrayList<String> shortestPathFraTil(Node fra, Node til) {
         settNoderUbesokt();
        Map<Node, Node> parents = parents(fra);
        Node v = til;
        List<Node> path = new ArrayList<>();
        ArrayList<String> pathString = new ArrayList<>();

        if (!parents.containsKey(til)) {
            return pathString;
        }

        while (v != null) {
            path.add(v);
            if(v!=fra)
            pathString.add("==> " + v);
            v = parents.get(v);
        }

        Collections.reverse(pathString);
        return pathString ;

    }

    public String pathFraTil(Node from, Node to) {
        StringBuilder result = new StringBuilder();
        ArrayList<String> path = visitFraTil(from, to);
        result.append(from.toString() + "---> ");
        for (String s : path) {
            result.append(s);
        }
        return result.toString();
    }

    public String sorthestPath(Node from, Node to) {
        StringBuilder result = new StringBuilder();
        List<String> path = shortestPathFraTil(from, to);
        result.append(from.toString() + "---> ");
        for (String s : path) {
            result.append(s);
        }
        return result.toString();
    }

    //topological sorting 
    public ArrayList<Node> topSort() throws Exception {
        ArrayList<Node> topologicalSort = new ArrayList<>();
        Stack<Node> topoStack = new Stack<Node>();
        for (Node n : graf.keySet()) {
            if (n.inDeg == 0)
                topoStack.push(n);
        }
        while (!topoStack.isEmpty()) {
            Node u = topoStack.pop();
            topologicalSort.add(u);
            for (Node n : u.naboer) {
                u.naboer.remove(n);
                if (n.inDeg == 0)
                    topoStack.push(n);
            }
        }

        System.out.println("Array size" + topologicalSort.size());
        System.out.println("Total nodes in graph: " + nodeCount());
        if (topologicalSort.size() < nodeCount())
            throw new RuntimeException("The graph contains a cycle.");

        return topologicalSort;
    }

    //Topological sorting with DFS

    public Stack<Node> DFSTopSort() {
        Stack<Node> stack = new Stack<>();
        for (Node n : graf.keySet()) {
            if (!n.visited) {
                DFSVisitB(n, stack);
            }
        }
        return stack;
    }

    public void DFSVisitB(Node n, Stack<Node> stack) {
        n.visited = true;
        for (Node nb : n.naboer) {
            if (!nb.visited) {
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
        for (Node n : graf.keySet()) {
            penStr.append(n.toString()).append("\n");
        }
        return penStr.toString();
    }
}
