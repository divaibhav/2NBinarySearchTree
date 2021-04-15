package implementation;

public class Node<E extends Comparable<E>> {
    private E data;
    private Node<E> left;
    private Node<E> right;

    public Node(E data) {
        this.data = data;
        left = null;
        right = null;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getLeft() {
        return left;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }
}
