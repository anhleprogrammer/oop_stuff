package data_structure;

public class LinkedList {
    // Linked list Node.
    static class Node {
        int data;
        Node next;
        // Constructor
        Node(int d) {
            data = d;
            next = null;
        }
    }
    Node head; // head of list


    public void addNode(int d) {
        //when add node to list, go to last node and change the pointer
        //we know a node is last node if next point to null
        if(head == null) {
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
        if(head == null) {
            head = a;
        } else {
            if(index == 0) {
                a.next = head;
            } else {
                //to insert a node at index x we have to traverse to the node before that index
                //create a node to point at head node so we can use this node to traverse the list
                Node cur = head;
                int x = 0;
                while(x < index - 1) {
                    cur = cur.next;
                    x++;
                }
                a.next = cur.next;
                cur.next = a;
            }
        }
    }

    // Method to print the DATA_STRUCTURE.LinkedList.
    public void printList(LinkedList list) {
         Node cur = list.head;
        while(cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

    // Method to delete a node in the DATA_STRUCTURE.LinkedList by POSITION
    public void deleteAtPosition(int index) {
         //to delete at index we have to get pointer to the index previous the input index
        Node cur = head;
        int x = 0;
        while(x < index - 1) {
            cur = cur.next;
            x++;
        }
        if(cur.next.next == null) { //this mean the node we want to delete is the last node
            cur.next = null; // our index stop at the node immediate precede the node we want to delete
            //so we just need to point to null to delete the last node
        } else {
            Node delete = cur.next;
            cur.next = delete.next;
            delete.next = null;
        }
    }
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();

        // Add some nodes to the list
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);

        // Insert a node at index 2
        Node newNode = new Node(5);
        list.insert(newNode, 2);

        // Delete node at index 3
        list.deleteAtPosition(3);

        // Print the resulting list
        list.printList(list);
    }
}