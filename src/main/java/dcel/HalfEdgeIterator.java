package dcel;

import java.util.Iterator;

public class HalfEdgeIterator<T extends Comparable> implements Iterator<HalfEdge<T>> {

    private HalfEdge<T> curr;

    public HalfEdgeIterator(HalfEdge<T> curr) {
        this.curr = curr;
    }

    public boolean hasNext() {
        return curr.getNext() != null;
    }

    public HalfEdge<T> next() {
        return curr.getNext();
    }

    public void remove() {
        throw new UnsupportedOperationException("remove() operation unsupported in HalfEdgeIterator");
    }
}
