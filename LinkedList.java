public class LinkedList {

    private Node head;
    private int listSize;


    // Constructors
    public LinkedList() {
        this.head = null;
        this.listSize = 0;
    }

    public LinkedList(Node n) {
        this.head = n;
        this.listSize = 1;
    }


    // Methods
    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        } else {
            return false;
        }
    }

    public void increaseListSize() {
        listSize++;
    }

    public void decreaseListSize() {
        listSize--;
    }

    // More efficient than iterating through entire list
    public int size() {
        return listSize;
    }

    public void add(Node node) {
        if (size() == 0) {
            head = node;
            increaseListSize();
        }
        else {
            Node finalNode = new Node();
            for (Node curr = head; curr.getNext() != null; curr = curr.getNext()) {
                finalNode = curr;
            }
            finalNode.setNext(node);
            increaseListSize();
        }
    }

    public void displayList() {

        if (size() == 0) {
            System.out.println("The list is empty.");
            return;
        }

        System.out.println(size() + " items in the linked list: ");

        for (Node curr = head; curr.getNext() != null; curr = curr.getNext()) {
            System.out.print(curr.getItem() + " ");
        }
    }

    public boolean remove(int index) {

        if ((index - 1) >= listSize) {
            return false;
        }

        int count = 0;

        for (Node curr = head; curr.getNext() != null; curr = curr.getNext()) {

            if (index == 0) {
                curr = null;
                return true;
            }

            else if ((count == index-1) && (curr.getNext() != null)) {
                curr.setNext(curr.getNext().getNext());
                curr = null;
                return true;
            }

            else if ((count == index-1) && (curr.getNext() == null)) {
                curr = null;
                return true;
            }

            else {
                count++;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        LinkedList testList = new LinkedList(new Node(8));

        testList.add(new Node(3));
        testList.add(new Node(5));

        testList.displayList();

    }

}