package graphs;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import lists.List;
import lists.SimpleLinkedList;

public class BSTree<T extends Comparable<T>> {

    public BSTree() {
        this.root = null;
    }

    public boolean search(T x) {
        return (root != null) && root.search(x);
    }

    public void add(T x) {
        if (root == null) {
            root = new BVertex<>(x);
        } else {
            root.add(x);
        }
    }

    public BVertex<T> delete(T x) throws Exception {
        return (root != null) ? (root = root.delete(x)) : null;
    }

    @Override
    public String toString() {
        return String.format("BST: {%s}", root);
    }

    public String toString(int n) {
        return root.toString(n);
    }

    public List<T> preorder() {
        List<T> r = new SimpleLinkedList<>();
        if (root != null) {
            r.append(root.preorder());
        }
        return r;
    }

    public List<T> inorder() {
        List<T> r = new SimpleLinkedList<>();
        if (root != null) {
            r.append(root.inorder());
        }
        return r;
    }

    public List<T> postorder() {
        List<T> r = new SimpleLinkedList<>();
        if (root != null) {
            r.append(root.postorder());
        }
        return r;
    }

    public void load(InputStream in) throws IOException {
        throw new UnsupportedOperationException();
    }

    public void save(OutputStream out) throws IOException {
        throw new UnsupportedOperationException();
    }

    private BVertex<T> root;
}
