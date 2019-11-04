package graphs;

import lists.AbstractList;
import lists.Iterator;
import lists.List;
import lists.SimpleLinkedList;

public class TVertex<V> implements Vertex<V> {

    public TVertex(V info, TVertex<V> antecessor) {
        this.info = info;
        this.antecessor = antecessor;
        this.successors = new SimpleLinkedList<>();
    }

    public TVertex(V info) {
        this(info, null);
    }

    @Override
    public int getOrder() {
        int r = successors.count();
        Iterator<TVertex<V>> i = successors.getIterator();
        while (i.hasNext()) {
            r = Math.max(r, i.getNext().getOrder());
        }
        return r;
    }

    @Override
    public int getWidth() {
        int r = 1;
        if (!successors.isEmpty()) {
            r = 0;
            Iterator<TVertex<V>> i = successors.getIterator();
            while (i.hasNext()) {
                r += i.getNext().getWidth();
            }
        }
        return r;
    }

    @Override
    public int getHeight() {
        int r = 0;
        if (!successors.isEmpty()) {
            Iterator<TVertex<V>> i = successors.getIterator();
            while (i.hasNext()) {
                r = Math.max(r, (i.getNext().getHeight() + 1));
            }
        }
        return r;
    }

    @Override
    public int getDepth() {
        return (antecessor == null) ? 0 : antecessor.getDepth() + 1;
    }

    @Override
    public Vertex<V> getVertex(V v) {
        TVertex<V> r = null;
        if (getInfo().equals(v)) {
            r = this;
        } else {
            Iterator<TVertex<V>> i = successors.getIterator();
            while (i.hasNext()) {
                TVertex<V> t = i.getNext();
                TVertex<V> z = (TVertex<V>) t.getVertex(v);
                if (z != null) {
                    r = z;
                    break;
                }
            }
        }
        return r;
    }

    public int getChildrenCount() {
        return successors.count();
    }

    @Override
    public List<Vertex<V>> getChildren() {
        List<Vertex<V>> r = new SimpleLinkedList<>();
        Iterator<TVertex<V>> i = successors.getIterator();
        while (i.hasNext()) {
            r.addLast(i.getNext());
        }
        return r;
    }

    public List<Vertex<V>> getAllVertices(int n) {
        List<Vertex<V>> r = new SimpleLinkedList<>();
        r.addLast(this);

        if (n != 0) {

            Iterator<TVertex<V>> i = successors.getIterator();
            while (i.hasNext()) {
                TVertex<V> t = i.getNext();

                List<Vertex<V>> succv = t.getAllVertices(n > 0 ? n - 1 : n);

                Iterator<Vertex<V>> j = succv.getIterator();
                while (j.hasNext()) {
                    r.addLast(j.getNext());
                }
            }
        }

        return r;
    }

    @Override
    public void clearSuccessors() {
        successors.clear();
    }

    public void add(TVertex<V> succ) {
        successors.addLast(succ);
    }

    @Override
    public void add(V v) {
        add(new TVertex<>(v, this));
    }

    @Override
    public V getInfo() {
        return info;
    }

    @Override
    public void setInfo(V info) {
        this.info = info;
    }

    @Override
    public String toString() {
        StringBuilder r = new StringBuilder("{");
        r.append(getInfo());
        if (!successors.isEmpty()) {
            r.append(String.format(", %s", successors));
        }
        r.append("}");
        return r.toString();
    }

    public String toString(int n) {
        StringBuilder r = new StringBuilder();
        String fmt = String.format("%%%ds%%s%%n", NODE_INDENT * n + 1);
        r.append(String.format(fmt, " ", getInfo()));
        Iterator<TVertex<V>> i = successors.getIterator();
        while (i.hasNext()) {
            r.append(i.getNext().toString(n + 1));
        }
        return r.toString();
    }

    private static final int NODE_INDENT = 4;

    private V info;
    private TVertex<V> antecessor;
    private final AbstractList<TVertex<V>> successors;
}
