package logica.graphs;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Bryan
 * @param <V>
 * @param <E>
 */
//@XmlRootElement(name="Edge")
//@XmlType(propOrder = {"info","tail","head"})
public class Edge<V, E> {

    public Edge(GVertex<V> tail, GVertex<V> head, E info) {
        this.tail = tail;
        this.head = head;
        this.info = info;
    }

    public Edge() {
        this(null, null, null);
    }

//    @XmlAnyElement(lax = true)
    @XmlElement//(name = "info")
    public E getInfo() {
        return info;
    }

    @XmlElement//(name = "tail")
    public GVertex<V> getTail() {
        return tail;
    }

    @XmlElement//(name = "head")
    public GVertex<V> getHead() {
        return head;
    }

    public void setTail(GVertex<V> tail) {
        this.tail = tail;
    }

    public void setHead(GVertex<V> head) {
        this.head = head;
    }

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
