package lists;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * ©, 2019, Georges Alfaro S.
 *
 * @author Georges Alfaro S.
 * @version 1.0.3
 * @param <T>
 * @since 2019-10-18
 */
public interface List<T> {

    boolean isEmpty();

    int count();

    void clear();

    @XmlElement
    T getFirst();

    @XmlElement
    T getLast();

    void addFirst(T x);

    void addLast(T x);

    void append(List<T> c);

    T removeFirst();

    T removeLast();
    
    @XmlElement
    T get(int position);

    Iterator<T> getIterator();

}
