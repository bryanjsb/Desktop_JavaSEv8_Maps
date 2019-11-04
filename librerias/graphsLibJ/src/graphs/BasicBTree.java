package graphs;

import lists.List;

public class BasicBTree<V> implements Tree<V> {

    public BasicBTree(V v) {
        this.root = new TBVertex<>(v, null);
    }

    @Override
    public int getOrder() {
        return root.getOrder();
    }

    @Override
    public int getWidth() {
        return root.getWidth();
    }

    @Override
    public int getHeight() {
        return root.getHeight();
    }

    @Override
    public int getDepth() {
        int d = root.getDepth();
        assert d == 0;
        return d;
    }

    @Override
    public TBVertex<V> getRoot() {
        return root;
    }

    @Override
    public Vertex<V> getVertex(V v) {
        throw new UnsupportedOperationException();
    }

    public TBVertex<V> getVertex(V v, boolean depthFirst) {
        return root.getVertex(v, depthFirst);
    }

    public List<Vertex<V>> getAllVertices() {
        return root.getAllVertices();
    }

    public TBVertex<V> appendChild(V v0, V v1) {
        return root.getVertex(v0).appendChild(v1);
    }

    public boolean add(V v0, V v1) {
        return appendChild(v0, v1) == null;
    }

    @Override
    public String toString() {
        return String.format("T: {%s}", root);
    }

    public String toString(int n) {
        return root.toString(n);
    }

    private final TBVertex<V> root;

}
