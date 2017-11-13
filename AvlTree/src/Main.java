import tree.avl.AvlTree;

/**
 * Created by vm033450 on 10/17/17.
 */
public class Main {

    public static void main(String[] args) {
        AvlTree t1 = new AvlTree();
        t1.add(1);
        t1.add(2);
        t1.add(3);
        t1.add(4);
        t1.add(5);
        t1.add(-1);
        t1.add(-2);
        t1.add(-3);
        t1.print();
        System.out.println(">>>>>>>>>>>");

    }
}
