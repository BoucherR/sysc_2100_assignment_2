import java.*;

public class Node {
    private Object item;
    private Node next;

    // Constructors
    public Node() {
        this.item = null;
        this.next = null;
    }
    public Node(Object o) {
        this.item = o;
        this.next = null;
    }
    public Node(Object o, Node n) {
        this.item = o;
        this.next = n;
    }

    // Accessors
    public Object getItem() {
        return this.item;
    }
    public Node getNext() {
        return this.next;
    }

    // Mutators
    public void setItem(Object o) {
        this.item = o;
    }
    public void setNext(Node n) {
        this.next = n;
    }
}
