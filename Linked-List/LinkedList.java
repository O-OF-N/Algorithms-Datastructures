import java.util.*;

/**
 * Created by vinodm1986 on 8/31/16.
 */
public class LinkedList {

    private String elements;

    private int size;

    private Node head;


    public LinkedList(String elements) {
        this.elements = elements;
        head = new Node(null);
    }

    public void build() {

        String[] elements = this.elements.split("->");
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].equals("null")) break;
            addToTail(new Integer(elements[i]));
        }

    }

    public void addToTail(int data) {
        Node current = this.head;
        if (current.getData() == null) current.setData(data);
        else {
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new Node(data));
        }
        size++;
    }

    public void addToHead(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node n1 = new Node(data, head);
            head = n1;
        }
        size++;
    }

    public void addAtPos(int data, int pos) {
        if (head == null) {
            head = new Node(data);
        } else {
            if (pos >= size) addToTail(data);
            else if (pos == 0) {
                head = new Node(data, head);
            } else {
                Node current = null, next = null;
                int currPos = 0;
                while (currPos <= pos) {
                    if (currPos == 0) next = head;
                    else {
                        current = next;
                        next = next.getNext();
                    }
                    if (currPos == pos) {
                        current.setNext(new Node(data, next));
                        break;
                    }
                    currPos++;
                }
            }
        }

    }

    public void deleteNode(int position) {
        int posTemp = 0;
        Node parent = null;
        Node current = this.head;
        while (posTemp < position) {
            parent = current;
            current = parent.getNext();
            posTemp++;
        }
        parent.setNext(current.getNext());

    }

    public Node reverse() {
        if (this.head == null) return null;
        Node child = this.head;
        Node parent = child.getNext();
        Node sp = parent.getNext();
        parent.setNext(child);
        child.setNext(null);
        while (sp != null){
            child = parent;
            parent = sp;
            sp = parent.getNext();
            parent.setNext(child);
        }
        return parent;
    }

    public List<Integer> print() {
        final List<Integer> elements = new ArrayList<>();
        Node next = this.head;
        while (next != null) {
            elements.add(next.getData());
            next = next.getNext();
        }

        return elements;
    }

    public List<Integer> print(Node node) {
        System.out.println("node = " + node);
        final List<Integer> elements = new ArrayList<>();
        Node next = node;
        while (next != null) {
            elements.add(next.getData());
            next = next.getNext();
        }

        return elements;
    }
}
