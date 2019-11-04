package graphs;

import lists.List;

public interface Vertex<V> {

    int getOrder();

    int getWidth();

    int getHeight();

    int getDepth();

    Vertex<V> getVertex(V v);

    List<Vertex<V>> getChildren();

    void clearSuccessors();

    void add(V v);

    V getInfo();

    void setInfo(V v);

}
