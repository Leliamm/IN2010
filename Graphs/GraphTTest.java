import java.util.ArrayList;
import java.util.Stack;

public class GraphTTest {
    public static void main(String[] args) throws Exception {

        Graph graf = new Graph(false);
        graf.leggTilKant("A", "D");
        graf.leggTilKant("E", "F");
        graf.leggTilKant("D", "E");
        graf.leggTilKant("F", "G");
        graf.leggTilKant("A", "B");
        graf.leggTilKant("A", "C");
        graf.leggTilKant("B", "C");
        graf.leggTilKant("C", "D");
        graf.leggTilKant("C", "F");
        graf.leggTilKant("X", "Y");
        graf.leggTilKant("X", "Z");
        graf.leggTilKant("Y", "Z");
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

        Graph morgen = new Graph(true);
        // Add edges to 'morgen' graph here

        morgen.leggTilKant("A", "D");
        morgen.leggTilKant("A", "C");
        morgen.leggTilKant("C", "H");
        morgen.leggTilKant("C", "G");
        morgen.leggTilKant("D", "E");
        morgen.leggTilKant("E", "F");
        System.out.println("Rettet graf: " + morgen);

        // ArrayList<Node> topologicalSort = morgen.topSort();
        // System.out.println("\n---( Calling Topological Sorting )---" + topologicalSort);
        // // Call topological sorting here...

        morgen.settNoderUbesokt();
        ArrayList<Node> DFSTopSort  = morgen.DFSTopSort();
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

}