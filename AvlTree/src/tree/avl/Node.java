package tree.avl;

/**
 * Created by vm033450 on 11/12/17.
 */
public class Node {
    private int value;
    private Node left;
    private Node right;
    private Node parent;
    private int height;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight(Node node) {
        if (node == null)
            return 0;
        else
            return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    public int getBalanceFactor() {
        return getHeight(this.left) - getHeight(this.right);
    }

    @Override
    public String toString() {
        return "" + this.value + " height = "+ this.getHeight() + "balance " +
                "factor = "+ this.getBalanceFactor();
    }
}
