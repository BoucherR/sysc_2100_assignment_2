public class LinkedList {

    // Fields

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

    /**
     * Returns whether or not the linked list is empty
     * @return true if linked list is empty
     */
    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Increases the value of field listSize by 1
     */
    public void increaseListSize() {
        listSize++;
    }

    /**
     * Decreases the value of field listSize by 1
     */
    public void decreaseListSize() {
        listSize--;
    }

    /**
     * Returns the field, listSize. This is more efficient than iterating through entire list
     * to get a count of elements
     */
    public int size() {
        return listSize;
    }

    /**
     * Adds a node at a specified index in the list. Will not execute if not in current range of linked list
     * @param node Node to be added into list
     * @param index Index at which node will be added
     */
    public void add(Node node, int index) {
        if (index == 0){

            Node temp = head;
            head = node;
            head.setNext(temp);
            increaseListSize();
        }
        else if (index == size()){
            Node curr = head;

            while (curr.getNext() != null){
                curr = curr.getNext();
            }

            curr.setNext(node);
            increaseListSize();
        }
        else if (index <= (size()-1) ) {

            Node curr = head;
            Node temp = node;

            for (int i = 0; i < index-1; i++){
                curr = curr.getNext();
            }

            temp.setNext(curr.getNext());
            curr.setNext(node);
            increaseListSize();
        }
    }

    /**
     * Removes a node at a given index
     * @param index Index of node to be removed
     */
    public void remove(int index) {

        if (index == 0) {
            Node temp = head;
            head = head.getNext();
            temp = null;
            decreaseListSize();
        }
        else if (index <= size()-1){
            Node temp = head;
            Node remove = null;

            for (int i = 0; i < index - 1; i++){
                temp = temp.getNext();
            }

            remove = temp;
            temp.setNext(temp.getNext().getNext());
            remove = null;
            decreaseListSize();
        }
    }

    /**
     * Prints out the number of elements in the Linked List, and what those values are
     */
    public void displayList() {

        if (size() == 0) {
            System.out.println("The list is empty.");
            return;
        }

        System.out.println(size() + " items in the linked list: ");

        for (Node curr = head; curr != null; curr = curr.getNext()) {
            System.out.print(curr.getItem() + " ");
        }

        System.out.println("");
    }

    /**
     * Test cases, showing that the Linked List ABT functions as rubric requires
     */
    public static void main(String[] args) {
        LinkedList testList = new LinkedList(new Node(8));

        // Testing the add function
        // Nodes to add

        Node node1 = new Node(3);
        Node node2 = new Node(25);
        Node node3 = new Node(18);
        Node node4 = new Node(13);
        Node node5 = new Node(17);

        testList.add(node1, 0);
        testList.add(node2, 0);
        testList.add(node3, 0);

        System.out.println("Displaying the items in the linked list:");
        testList.displayList();
        System.out.println();

        System.out.println("Add Integer object valued at 13 at index 0 and displaying the items in the linked list:");
        testList.add(node4, 0);
        testList.displayList();
        System.out.println();

        System.out.println("Add Integer object valued at 17 at index 2 and displaying the items in the linked list:");
        testList.add(node5,2);
        testList.displayList();
        System.out.println();

        System.out.println("Remove Integer object at index 4 and display the items in the linked list:");
        testList.remove(4);
        testList.displayList();
        System.out.println();
    }

}