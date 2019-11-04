package graphs;

import lists.Iterator;
import lists.List;
import lists.SimpleLinkedList;

public class TBVertex<V> implements Vertex<V> {

    public TBVertex(V info, TBVertex<V> antecessor, TBVertex<V> firstChild, TBVertex<V> nextSibling) {
        this.info = info;
        this.antecessor = antecessor;
        this.firstChild = firstChild;
        this.nextSibling = nextSibling;
    }

    public TBVertex(V info, TBVertex<V> antecessor) {
        this(info, antecessor, null, null);
    }

    @Override
    public int getOrder() {
        int r = getChildren().count();
        Iterator<Vertex<V>> i = getChildren().getIterator();
        while (i.hasNext()) {
            r = Math.max(r, i.getNext().getOrder());
        }
        return r;
    }

    @Override
    public int getWidth() {
        int r = 1;
        if (!getChildren().isEmpty()) {
            r = 0;
            Iterator<Vertex<V>> i = getChildren().getIterator();
            while (i.hasNext()) {
                r += i.getNext().getWidth();
            }
        }
        return r;
    }

    @Override
    public int getHeight() {
        int r = 0;
        if (!getChildren().isEmpty()) {
            Iterator<Vertex<V>> i = getChildren().getIterator();
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

    public TBVertex<V> getVertex(V v, boolean depthFirst) {
        TBVertex<V> r = null;
        if (getInfo().equals(v)) {
            r = this;
        } else {
            if (depthFirst) {
                if (getFirstChild() != null) {
                    r = getFirstChild().getVertex(v);
                }
                if ((r == null) && (getNextSibling() != null)) {
                    r = getNextSibling().getVertex(v);
                }
            } else {
                if (getNextSibling() != null) {
                    r = getNextSibling().getVertex(v);
                }
                if ((r == null) && (getFirstChild() != null)) {
                    r = getFirstChild().getVertex(v);
                }
            }
        }
        return r;
    }

    @Override
    public TBVertex<V> getVertex(V v) {
        return getVertex(v, true);
    }

    public int getChildrenCount() {
        return getChildren().count();
    }

    @Override
    public List<Vertex<V>> getChildren() {
        List<Vertex<V>> r = new SimpleLinkedList<>();
        if (getFirstChild() != null) {
            r.addLast(getFirstChild());
            r.append(getFirstChild().getSiblings());
        }
        return r;
    }

    public List<Vertex<V>> getSiblings() {
        List<Vertex<V>> r = new SimpleLinkedList<>();
        TBVertex<V> cursor = this.getNextSibling();
        while (cursor != null) {
            r.addLast(cursor);
            cursor = cursor.getNextSibling();
        }
        return r;
    }

    public List<Vertex<V>> getAllVertices() {
        List<Vertex<V>> r = new SimpleLinkedList<>();
        r.addLast(this);
        if (getFirstChild() != null) {
            TBVertex<V> cursor = getFirstChild();
            while (cursor != null) {
                r.append(cursor.getAllVertices());
                cursor = cursor.getNextSibling();
            }
        }
        return r;
    }

    @Override
    public void clearSuccessors() {
        firstChild = null;
    }

    @Override
    public void add(V v) {
        appendChild(new TBVertex<>(v, this));
    }

    @Override
    public V getInfo() {
        return info;
    }

    @Override
    public void setInfo(V info) {
        this.info = info;
    }

    public TBVertex<V> getAntecessor() {
        return antecessor;
    }

    private void setAntecessor(TBVertex<V> antecessor) {
        this.antecessor = antecessor;
    }

    public TBVertex<V> getFirstChild() {
        return firstChild;
    }

    public TBVertex<V> appendChild(TBVertex<V> child) {
        child.setAntecessor(this);
        if (getFirstChild() == null) {
            firstChild = child;
        } else {
            firstChild.appendSibling(child);
        }
        return this;
    }

    public TBVertex<V> appendChild(V v) {
        return appendChild(new TBVertex<>(v, this));
    }

    public TBVertex<V> getNextSibling() {
        return nextSibling;
    }

    public void appendSibling(TBVertex<V> sibling) {
        if (getNextSibling() == null) {
            nextSibling = sibling;
        } else {
            nextSibling.appendSibling(sibling);
        }
    }

    @Override
    public String toString() {
        return String.format("(%s, %s, %s)",
                getInfo(),
                getFirstChild(), getNextSibling());
    }

    public String toString(int n) {
        StringBuilder r = new StringBuilder();

        String fmt = String.format("%%%ds%%s%%n", NODE_INDENT * n + 1);
        r.append(String.format(fmt, " ", getInfo()));
        if (getFirstChild() != null) {
            r.append(getFirstChild().toString(n + 1));
        }
        if (getNextSibling() != null) {
            r.append(getNextSibling().toString(n));
        }

        return r.toString();
    }

    private static final int NODE_INDENT = 4;

    private V info;
    private TBVertex<V> antecessor;
    private TBVertex<V> firstChild;
    private TBVertex<V> nextSibling;

}
