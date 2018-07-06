/**
 * Created by vinodm1986 on 8/31/16.
 */
public class Main {

    public static void main(String[] args) {
        final LinkedList l1 = new LinkedList("1->2->3->null");
        l1.build();
        System.out.println("l1 = " + l1.print());

        l1.addToHead(0);
        System.out.println("l1 = " + l1.print());

        l1.addAtPos(4,0);
        System.out.println("l1 = " + l1.print());

        l1.deleteNode(2);

        System.out.println("l1 = " + l1.print());

       Node n = l1.reverse();
        System.out.println("l1 = " + l1.print(n));

    }
}
