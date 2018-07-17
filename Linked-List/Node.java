import java.util.*;
/**
 * Created by vinodm1986 on 8/31/16.
 */
public class Node {
    private Integer data;
    private Node next;

    public Node(){

    }

    public Node(Integer data){
        this.data = data;
    }

    public Node(Integer data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Integer getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return (this.data!=null)? this.data.toString():null;
    }
}
