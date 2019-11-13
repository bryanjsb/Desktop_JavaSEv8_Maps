package logica.graphs;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Bryan
 * @param <V>
 * @param <E>
 */
public class Edge<V, E> {

    public Edge(GVertex<V> tail, GVertex<V> head, E info) {
        this.tail = tail;
        this.head = head;
        this.info = info;
    }

    public GVertex<V> getTail() {
        return tail;
    }

    public GVertex<V> getHead() {
        return head;
    }

    public E getInfo() {
        return info;
    }

    @XmlElement(name = "tail")
    public void setTail(GVertex<V> tail) {
        this.tail = tail;
    }

    @XmlElement(name = "head")
    public void setHead(GVertex<V> head) {
        this.head = head;
    }

    @XmlElement(name = "info")
    public void setInfo(E info) {
        this.info = info;
    }

    
    @Override
    public String toString() {
        return String.format("{(%s, %s), %s}", getTail(), getHead(), getInfo());
    }

    private GVertex<V> tail;
    private GVertex<V> head;
    private E info;
}
