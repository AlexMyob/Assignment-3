import java.util.EmptyStackException;

public class LinkedStack<T> implements Stack<T> {

    Node<T> head;

    public void push(T item) throws CannotAddException {
        if (head == null) {
            // The stack is empty
            Node<T> newNode = new Node<T>(item, null);
            head = newNode;
        } else {
            // Stack is not empty, create a new node at the top of the stack
            // The new item's next link goes to the "old" head
            Node<T> newNode = new Node<T>(item, head);

            // Now we can re-assign the link to the new head
            head = newNode;
        }
    }

    public T pop() {
        if (head == null) {
            //The stack is empty
            throw new EmptyStackException();
        } else {
            T returnValue = head.data;
            head = head.next;
            return returnValue;
        }

    }

    public T peek() {
        if (head == null) {

            //The stack is empty
            throw new EmptyStackException();
        } else {
            return head.data;
        }

    }

    public int length() {
        Node<T> n = head;
        int length = 0;
        while (n != null) {
            length++;
            n = n.next;
        }
        return length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> temp = head;
        while (temp != null) {
            sb.append(temp.data);
            sb.append(' ');
            temp = temp.next;
        }
        return sb.toString();
    }

}