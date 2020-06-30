import dcel.Face;
import dcel.HalfEdge;
import dcel.PlanarVertex;

import java.util.HashMap;
import java.util.LinkedList;

public class PlanarGraph<T extends Comparable> {

    private LinkedList<HalfEdge<T>> E;
    private HashMap<T, PlanarVertex<T>> V; // membership queries in log(n) at log(n) overhead
    private LinkedList<Face<T>> faces; // cache the faces.

    // constructs an empty graph.
    public PlanarGraph() {
        this.E = new LinkedList<HalfEdge<T>>();
        this.V = new HashMap<T, PlanarVertex<T>>();
    }

    // copy-constructs an existing DCEL graph.
    // TODO: this is wrong. We need to deep-copy-construct the graph
    // by copy-constructing _every_ edge instance and _every_ PlanarVertex instance.
    public PlanarGraph(PlanarGraph<T> g) {
        this.E = new LinkedList<HalfEdge<T>>(g.E());
        this.V = new HashMap<T, PlanarVertex<T>>(g.V());
    }

    public void addVertex(PlanarVertex<T> v) {
        this.V.put(v.getName(), v);
    }

    public void addVertex(T vertName) {
        PlanarVertex<T> v = new PlanarVertex<T>(vertName);
        addVertex(v);
    }

    public void addEdge(PlanarVertex<T> u, PlanarVertex<T> v) {
        this.V.get(u.getName()).addEdge(v);
    }

    public HashMap<T, PlanarVertex<T>> V() {
        return V;
    }

    public LinkedList<HalfEdge<T>> E() {
        return E;
    }

    public Iterable<Face<T>> computePlanarDual() {
        if (this.faces != null) return this.faces;
        LinkedList<Face<T>> faces = new LinkedList<Face<T>>();
        for(HalfEdge<T> e : E()) {
            try {
                Face<T> f = new Face(e);
                faces.add(f);
            } catch (IllegalArgumentException ignored) {}
        }
        return  this.faces = faces;
    }
}
