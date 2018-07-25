//https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/

class BoundaryTree{

  public static void main(String[] args) {
    BoundaryTree b = new BoundaryTree();
  }

  private void inorder(Tree t) {
    if(t == null) return;
    inorder(t.left);
    System.out.println(t.value);
    inorder(t.right);
  }

  private Tree createTree(){
    Tree t = new Tree(26);
    Tree t1 = new Tree(10);
    Tree t2 = new Tree(3);
    Tree t11 = new Tree(4);
    Tree t12 = new Tree(7);
    Tree t21 = new Tree(3);
    t.left = t1;
    t.right = t2;
    t1.left = t11;
    t1.right = t12;
    t2.right = t21;
    return t;
  }

  class Tree {
    int value;
    Tree left;
    Tree right;
    Tree(int value){
      this.value = value;
    }
  }


}