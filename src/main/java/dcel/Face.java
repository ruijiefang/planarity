package dcel;

import java.util.ArrayList;

public class Face<T extends Comparable> {

    ArrayList<HalfEdge<T>> cycle;
    ArrayList<PlanarVertex<T>> vertices;

    public Face(HalfEdge<T> start) {
        this.cycle = new ArrayList<HalfEdge<T>>();
        this.vertices = new ArrayList<PlanarVertex<T>>();
        HalfEdge<T> e = start, eReversed;

        // compute cycle
        do {
            // theta*(e) = theta(bar e);
            this.cycle.add(e);
            eReversed = e.involve();
            e = eReversed.getNext();
            if (e == null || e.marked())
                throw new IllegalArgumentException("Face: start edge does not form a cycle.");
        } while (!e.equals(start));

        // compute vertices
        for (HalfEdge<T> he : this.cycle) {
            this.vertices.add(he.getSrcVertex());
        }
     }

     public ArrayList<HalfEdge<T>> getCycle() {
        return this.cycle;
     }

     public ArrayList<PlanarVertex<T>> getEnclosingVertices() {
        return this.vertices;
     }
}
