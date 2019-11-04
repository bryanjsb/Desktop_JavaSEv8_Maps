package graphs;

import lists.List;
import lists.SimpleLinkedList;

public class BVertex<T extends Comparable<T>> {

    public BVertex(T info, BVertex<T> left, BVertex<T> right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }

    public BVertex(T info) {
        this(info, null, null);
    }

    public boolean search(T x) {
        return (x.compareTo(info) == 0)
                || ((x.compareTo(info) < 0) && (left != null) && (left.search(x)))
                || ((x.compareTo(info) > 0) && (right != null) && (right.search(x)));
    }

    public void add(T x) {
        if (x.compareTo(info) <= 0) {
            if (left == null) {
                left = new BVertex<>(x);
            } else {
                left.add(x);
            }
        } else {
            if (right == null) {
                right = new BVertex<>(x);
            } else {
                right.add(x);
            }
        }
    }

    public BVertex<T> delete(T x) throws Exception {
        System.out.printf("'%s': buscando: '%s'..%n", getInfo(), x);

        // La función regresa una referencia al no que ocupa el
        // lugar del vértice actual cuando éste debe eliminarse..
        BVertex<T> r = this;

        if (x.compareTo(info) == 0) {
            System.out.printf("-> encontrado: '%s'%n", x);

            // Se debe eliminar el vértice actual.
            // Si el vértice contiene algún subárbol, se debe buscar
            // el nuevo valor para el nodo.
            r = null;

            // Si no existe algunos de los subárboles izquierdo o
            // derecho, simplemente se asigna el valor del subárbol
            // que corresponde.
            if ((getLeft() != null) && (getRight() == null)) {
                r = getLeft();
                setLeft(null);
            } else if ((getLeft() == null) && (getRight() != null)) {
                r = getRight();
                setRight(null);

                // Si existen ambos subárboles, se debe buscar el vértice con
                // la llave de mayor valor que sea menor a la actual (el elemento
                // inmediatamente anterior al actual).
            } else if ((getLeft() != null) && (getRight() != null)) {
                if (getLeft().getRight() == null) {

                    // La raíz del subárbol izquierdo no tiene elementos
                    // a la derecha, entonces debe contener el mayor de todos
                    // los valores del subárbol.
                    getLeft().setRight(getRight());
                    r = getLeft();

                } else {

                    // Se busca el elemento de mayor valor a la derecha
                    // del subárbol izquierdo.
                    BVertex<T> cursor = getLeft();
                    while (cursor.getRight().getRight() != null) {
                        cursor = cursor.getRight();
                    }
                    setInfo(cursor.getRight().getInfo());
                    System.out.printf("nueva llave: '%s'%n", getInfo());

                    // El nodo seleccionado puede contener vértices a
                    // la izquierda que deben conservarse.
                    cursor.setRight(cursor.getRight().getLeft());
                    r = this;
                }
            }

            // El nodo actual no contiene la llave que se debe eliminar, por
            // lo que debe encontrarse en alguno de los subárboles correspondientes.
        } else if (x.compareTo(info) < 0) {
            if (getLeft() != null) {
                setLeft(getLeft().delete(x));
            } else {
                throw new Exception(); // No se encontró la llave solicitada..
            }
        } else {
            if (getRight() != null) {
                setRight(getRight().delete(x));
            } else {
                throw new Exception(); // No se encontró la llave solicitada..
            }
        }

        return r;
    }

    @Override
    public String toString() {
        if ((left != null) || (right != null)) {
            return String.format("(%s, %s, %s)",
                    info, left, right);
        } else {
            return String.format("(%s)", info);
        }
    }

    public String toString(int n) {
        StringBuilder r = new StringBuilder();
        String fmt = String.format("%%%ds%%s%%n", NODE_INDENT * n + 1);
        r.append(String.format(fmt, " ", getInfo()));
        if (getLeft() != null) {
            r.append(getLeft().toString(n + 1));
        }
        if (getRight() != null) {
            r.append(getRight().toString(n + 1));
        }
        return r.toString();
    }

    public List<T> preorder() {
        List<T> r = new SimpleLinkedList<>();
        r.addLast(info);
        if (left != null) {
            r.append(left.preorder());
        }
        if (right != null) {
            r.append(right.preorder());
        }
        return r;
    }

    public List<T> inorder() {
        List<T> r = new SimpleLinkedList<>();
        if (left != null) {
            r.append(left.inorder());
        }
        r.addLast(info);
        if (right != null) {
            r.append(right.inorder());
        }
        return r;
    }

    public List<T> postorder() {
        List<T> r = new SimpleLinkedList<>();
        if (left != null) {
            r.append(left.postorder());
        }
        if (right != null) {
            r.append(right.postorder());
        }
        r.addLast(info);
        return r;
    }

    /* public */ T getInfo() {
        return info;
    }

    /* public */ void setInfo(T info) {
        this.info = info;
    }

    /* public */ BVertex<T> getLeft() {
        return left;
    }

    /* public */ void setLeft(BVertex<T> left) {
        this.left = left;
    }

    /* public */ BVertex<T> getRight() {
        return right;
    }

    /* public */ void setRight(BVertex<T> right) {
        this.right = right;
    }

    private static final int NODE_INDENT = 4;

    private T info;
    private BVertex<T> left;
    private BVertex<T> right;

}
