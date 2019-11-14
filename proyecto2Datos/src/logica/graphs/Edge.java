package logica.graphs;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

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

      @XmlElement(name = "info")
    public E getInfo() {
        return info;
    }
    
    @XmlElement(name = "tail")
    public GVertex<V> getTail() {
        return tail;
    }

    @XmlElement(name = "head")
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
