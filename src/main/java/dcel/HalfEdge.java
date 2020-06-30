package dcel;

import java.util.Iterator;

public class HalfEdge<T extends Comparable>
        implements Comparable<HalfEdge<T>>, Iterable<HalfEdge<T>> {

    private PlanarVertex<T> u;
    private PlanarVertex<T> v;

    private HalfEdge<T> next;
    private HalfEdge<T> prev;

    private boolean marked;

    // constructs half edge going from u --> v.
    public HalfEdge(PlanarVertex<T> u, PlanarVertex<T> v) {
        this.u = u;
        this.v = v;
        this.next = null;
        this.prev = null;
        this.marked = false;
    }

    public HalfEdge(PlanarVertex<T> u, PlanarVertex<T> v,
                    HalfEdge<T> next, HalfEdge<T> prev) {
        assert next.getSrcVertex().equals(u);
        assert prev.getDstVertex().equals(v);
        this.u = u;
        this.v = v;
        this.next = next;
        this.prev = prev;
        this.marked = false;
    }

    // for faces construction.
    protected void mark() {
        this.marked = true;
    }

    // for faces construction.
    protected boolean marked() {
        return this.marked;
    }

    // returns source vertex.
    public PlanarVertex<T> getSrcVertex() {
        return this.u;
    }

    // returns destination vertex.
    public PlanarVertex<T> getDstVertex() {
        return this.v;
    }

    // changes the nxet edge in sequence.
    public void changeNext(HalfEdge<T> next) {
        this.next = next;
    }
    // returns the next edge in sequence.
    public HalfEdge<T> getNext() {
        return next;
    }

    // changes the previous edge in sequence.
    public void changePrev(HalfEdge<T> prev) {
        this.prev = prev;
    }

    // returns the previous edge in sequence.
    public HalfEdge<T> getPrev() {
        return prev;
    }

    // are we a head vertex?
    public boolean isHead() {
        return this.prev == null;
    }

    // are we a tail vertex?
    public boolean isTail() {
        return this.next == null;
    }

    // gets the half edge going in opposite direction.
    public HalfEdge<T> involve() {
        return new HalfEdge(this.v, this.u);
    }

    // compares two halfEdges pointwise.
    public int compareTo(HalfEdge<T> that) {
        // pointwise order.
        int first = this.getSrcVertex().compareTo(that.getSrcVertex());
        int second = this.getDstVertex().compareTo(that.getDstVertex());
        return first == 0 ? second : first;
    }

    @Override
    public boolean equals(Object o) {
        HalfEdge<T> that = (HalfEdge<T>) o;
        return this.compareTo(that) == 0;
    }

    // returns iterator from this edge.
    public Iterator<HalfEdge<T>> iterator() {
        return new HalfEdgeIterator<T>(this);
    }
}
