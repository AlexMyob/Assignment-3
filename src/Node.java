public class Node<T> {
    T data;
    Node<T> next;
    // this is NOT an object
    // this is a reference variable

    //Constructor
    public Node(T data, Node<T> next) {
        super();
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}