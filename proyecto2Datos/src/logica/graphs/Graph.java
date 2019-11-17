package logica.graphs;

import java.awt.geom.Point2D;
import java.util.LinkedList;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Bryan
 * @param <V>
 * @param <E>
 */
//@XmlRootElement(name="Graph")
public class Graph<V, E> {

    public Graph() {
        this(new LinkedList<>(), new LinkedList<>());
    }

    public Graph(LinkedList<GVertex<V>> vertices, LinkedList<Edge<V, E>> edges) {
        this.vertex = vertices;
        this.edges = edges;
    }

    public GVertex<V> getVertex(V v) {
        GVertex<V> r = null;

        for (GVertex<V> e : vertex) {

            if (e.getInfo().equals(v)) {
                r = e;
                break;
            }
        }

        return r;
    }

    public LinkedList<GVertex<V>> getAdjacent(GVertex<V> v) {
        LinkedList<GVertex<V>> r = new LinkedList<>();
        for (Edge<V, E> e : edges) {
            if (e.getHead().getInfo().equals(v.getInfo())) {
                r.addLast(e.getTail());
            }
            if (e.getTail().getInfo().equals(v.getInfo())) {
                r.addLast(e.getHead());
            }
        }
        return r;
    }

    public Edge<V, E> getEdge(V v1, V v2) {
        Edge<V, E> ptr = null;

        for (Edge<V, E> i : this.edges) {

            if (i.getTail().getInfo().equals(v1)
                    && i.getHead().getInfo().equals(v2)) {

                ptr = i;
            }
        }

        return ptr;
    }

    public void add(V v, Point2D.Float position) {
        vertex.addLast(new GVertex<>(v, position));
    }

    public void add(V v) {
        vertex.addLast(new GVertex<>(v, new Point2D.Float(DX + df.x, DY + df.y)));

        if (px < MX) {
            df.x += DX;
            px++;
        } else {
            df.x = 0;
            df.y += DY;
            px = 0;
        }
    }

    public void add(GVertex<V> tail, GVertex<V> head, E w) {
        if ((tail == null) || (head == null)) {
            throw new NullPointerException("No existe el vértice.");
        }
        edges.addLast(new Edge<>(tail, head, w));
    }

    public void add(V t, V h, E w) {
        add(Graph.this.getVertex(t), Graph.this.getVertex(h), w);
    }

    public void add(V t, V h) {
        add(t, h, null);
    }

    @Override
    public String toString() {
        return String.format("G: (%n   V: %s,%n   E: %s%n)",
                vertex, edges);
    }

    @XmlElement//(name = "Vertex")
    public LinkedList<GVertex<V>> getVertex() {
        return vertex;
    }

    @XmlElement//(name = "Edges")
    public LinkedList<Edge<V, E>> getEdges() {
        return edges;
    }

    public void setEdges(LinkedList<Edge<V, E>> edges) {
        this.edges = edges;
    }

    public void setVertex(LinkedList<GVertex<V>> vertex) {
        this.vertex = vertex;
    }

    private static final int DX = 72;
    private static final int DY = 64;
    private static final int MX = 6;
    private int px = 0;
    private final Point2D.Float df = new Point2D.Float(0, 0);
    private LinkedList<GVertex<V>> vertex;
    private LinkedList<Edge<V, E>> edges;

}
