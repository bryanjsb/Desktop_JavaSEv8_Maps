package logica.graphs;

import java.awt.geom.Point2D;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Bryan
 * @param <V>
 */
//@XmlRootElement(name="GVertex")
//@XmlType(propOrder = {"info","posicion"})
public class GVertex<V> {

    public GVertex(V info, Point2D.Float position) {
        this.info = info;
        this.position = position;
    }

    public GVertex() {
        this(null);
    }

    public GVertex(V info) {
        this(info, new Point2D.Float(0f, 0f));
    }

//    @XmlAnyElement(lax = true)
    @XmlElement//(name = "info")    
    public V getInfo() {
        return info;
    }

    public void setInfo(V info) {
        this.info = info;
    }

    @XmlElement//(name = "posicion")
    public Point2D.Float getPosition() {
        return position;
    }

    public void setPosition(Point2D.Float position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return String.format("|%s|", getInfo());
    }

    private V info;
    private Point2D.Float position;
}
