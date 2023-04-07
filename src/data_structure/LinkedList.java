package data_structure;

public class LinkedList {

    Node head; // head of list

    // Linked list Node.
     class Node {
        int data;
        Node next;
        // Constructor
        Node(int d) {
            data = d;
            next = null;
        }
    }
    public void addNode(int d) {
        //when add node to list, go to last node and change the pointer
        //we know a node is last node if next point to null
        if (head == null) {
            head = new Node(d);
        } else {
            Node curNode = head;
            while (curNode.next != null) {
                curNode = curNode.next;
            }
            curNode.next = new Node(d);
        }
    }

    // Method to insert a new node
    public void insert(Node a, int index) {

    }

    // Method to print the DATA_STRUCTURE.LinkedList.
    public void printList(LinkedList list) {

    }

    // Method to delete a node in the DATA_STRUCTURE.LinkedList by POSITION
    public LinkedList deleteAtPosition(LinkedList list, int index) {

        return list;
    }
    public void main(String[] args)
    {}
}