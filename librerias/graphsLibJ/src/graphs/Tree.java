package graphs;

public interface Tree<V> {

    int getOrder();

    int getWidth();

    int getHeight();

    int getDepth();

    Vertex<V> getRoot();

    Vertex<V> getVertex(V v);

}
