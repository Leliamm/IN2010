import java.util.ArrayList;
import java.util.Stack;

public class GraphTest {
    public static void main(String[] args) throws Exception {

        Graph graf = new Graph(false, false);
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");
        Node G = new Node("H");
        Node H = new Node("I");
        Node J = new Node("J");
        Node K = new Node("K");
        graf.leggTilEdge(A, D);
        graf.leggTilEdge(E, F);
        graf.leggTilEdge(D, E);
        graf.leggTilEdge(F, G);
        graf.leggTilEdge(A, B);
        graf.leggTilEdge(A, C);
        graf.leggTilEdge(B, C);
        graf.leggTilEdge(C, D);
        graf.leggTilEdge(C, F);
        graf.leggTilEdge(H, J);
        graf.leggTilEdge(H, K);
        graf.leggTilEdge(J, K);
        System.out.println(graf);

        // Call DFS here...
        ArrayList<Node> DFSFull = graf.DFSFull();
        System.out.println("\n---( Calling DFS )---" + DFSFull);

        // Call DFSIter
        graf.settNoderUbesokt();
        System.out.println(graf);
        Stack<Node> DFSFullIter = graf.DFSFullIter();
        System.out.println("\n---( Calling DFSIter )---" + Graph.stackToString(DFSFullIter));

        // Call BFS
        graf.settNoderUbesokt();
        ArrayList<Node> BFSFull = graf.BFSFull();
        System.out.println("\n---( Calling BFS )---" + BFSFull);

        //call shortest path
        System.out.println("\n---( Calling shortest path )---");
        System.out.println(graf.sorthestPath(A, F));

        Graph morgen = new Graph(true, false);
        graf.leggTilEdge(A, D);
        graf.leggTilEdge(E, F);
        graf.leggTilEdge(D, E);
        graf.leggTilEdge(F, G);
        graf.leggTilEdge(A, B);
        graf.leggTilEdge(A, C);
        System.out.println("Rettet graf: " + morgen);

        // ArrayList<Node> topologicalSort = morgen.topSort();
        // System.out.println("\n---( Calling Topological Sorting )---" + topologicalSort);
        // // Call topological sorting here...

        morgen.settNoderUbesokt();
        Stack<Node> DFSTopSort = morgen.DFSTopSort();
        System.out.println("\n---( Calling DFSTopSort )---" + DFSTopSort);

        // Object of graph is created.
        GraphT<Integer> g = new GraphT<Integer>();

        // edges are added.
        // Since the graph is bidirectional,
        // so boolean bidirectional is passed as true.
        g.addEdge(0, 1, true);
        g.addEdge(0, 4, true);
        g.addEdge(1, 2, true);
        g.addEdge(1, 3, true);
        g.addEdge(1, 4, true);
        g.addEdge(2, 3, true);
        g.addEdge(3, 4, true);

        // Printing the graph
        System.out.println("Graph:\n"
                + g.toString());

        // Gives the no of vertices in the graph.
        g.getVertexCount();

        // Gives the no of edges in the graph.
        g.getEdgesCount(true);

        // Tells whether the edge is present or not.
        g.hasEdge(3, 4);

        // Tells whether vertex is present or not
        g.hasVertex(5);
    }

    private static Node addNode(String string) {
        return null;
    }

}