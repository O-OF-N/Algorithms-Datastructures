package tree.avl;

/**
 * Created by vm033450 on 10/17/17.
 */
public class AvlTree {

    private Node root;

    public void add(int value) {
        if (root == null) {
            root = new Node(value);
            root.setHeight(root.getHeight(root));
        } else {
            root = addChild(value, root);
        }
    }

    private Node addChild(int value, Node parent) {
        if (parent == null) {
            Node child = new Node(value);
            child.setHeight(child.getHeight(child));
            return child;
        } else if (parent.getValue() < value) {
            Node child = addChild(value, parent.getRight());
            parent.setRight(child);
        } else {
            Node child = addChild(value, parent.getLeft());
            parent.setLeft(child);
        }
        parent = parent.getBalanceFactor() < -1 ? rotateLeft(parent) : parent.getBalanceFactor() > 1 ? rotateRight(parent) : parent;
        parent.setHeight(parent.getHeight(parent));
        return parent;
    }

    private Node rotateLeft(Node n) {
        Node right = n.getRight();
        if (right.getBalanceFactor() > 0)
            right = rotateRight(right);
        n.setRight(right.getLeft());
        right.setLeft(n);
        n.setHeight(n.getHeight(n));
        right.setHeight(right.getHeight(right));
        return right;
    }

    private Node rotateRight(Node n) {
        Node left = n.getLeft();
        if (left.getBalanceFactor() < 0)
            left = rotateLeft(left);
        n.setLeft(left.getRight());
        left.setRight(n);
        n.setHeight(n.getHeight(n));
        left.setHeight(left.getHeight(left));
        return left;
    }

    public void print() {
        System.out.println("root = " + this.root);
        this.inOrder(root);
    }

    private void inOrder(Node t1) {
        if (t1 != null) {
            System.out.println(t1);
            System.out.println("left= ");
            inOrder(t1.getLeft());
            System.out.println("right= ");
            inOrder(t1.getRight());
        }
    }

}
