package dcel;

import java.util.ArrayList;

public class PlanarVertex<T extends Comparable> implements Comparable<PlanarVertex<T>> {

    private final T name;
    private HalfEdge<T> head;
    private HalfEdge<T> tail;

    // constructs a vertex with id "name"
    public PlanarVertex(T name) {
        this.name = name;
    }

    // adds halfEdge to edgeList.
    public void addHalfEdge(PlanarVertex<T> to) {
        // e has to be standalone.
        HalfEdge<T> ptail = this.tail;
        this.tail = new HalfEdge<T>(this, to, null, ptail);
        ptail.changeNext(this.tail);
    }

    // retrieves the head.
    public HalfEdge<T> getHead() {
        return this.head;
    }

    // retrieves the tail.
    public HalfEdge<T> getTail() {
        return this.tail;
    }

    // adds bidirectional edge to list.
    public void addEdge(PlanarVertex<T> dst)  {
        addHalfEdge(dst);
        dst.addHalfEdge(this);
    }

    // returns name of this vertex.
    public T getName() {
        return this.name;
    }

    // returns iterable list of HalfEdges.
    public Iterable<HalfEdge<T>> getOutEdges() {
        return this.head;
    }

    // compare names of two vertices.
    public int compareTo(PlanarVertex<T> that) {
        return this.getName().compareTo(that.getName());
    }

    // equality test for names of two vertices.i
    @Override
    public boolean equals(Object o) {
        PlanarVertex<T> that = (PlanarVertex<T>) o;
        return this.compareTo(that) == 0;
    }
}
