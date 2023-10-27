import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijakstra extends Graph {
    int pathVekt;
    ArrayList<Edge> edges;

    public Dijakstra(boolean rettet, boolean vektet) {
        super(rettet, vektet);
        edges = new ArrayList<>();
        pathVekt = 0;
    }

    public ArrayList<Node> dijakstraPath(Node n) {
        ArrayList<Node> path = new ArrayList<>();
        PriorityQueue<Edge> edges = new PriorityQueue<Edge>();

        for (Node nb : n.naboer) {

        }
        return path;
    }
}
