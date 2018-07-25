//https://www.geeksforgeeks.org/convert-a-given-tree-to-sum-tree/

class ConvertToSumTree {

  private int sumTree(Tree t){
      if(t == null) return 0;
      if(t.left == null && t.right == null) {
        int value = t.value;
        t.value = 0;
        return value;
      }
      int left = sumTree(t.left);
      int right = sumTree(t.right);
      int value = t.value;
      t.value = left+right;
      return value+left+right;
  }

  private void inorder(Tree t) {
    if(t == null) return;
    inorder(t.left);
    System.out.println(t.value);
    inorder(t.right);
  }

  private Tree createTree(){
    Tree t = new Tree(10);
    Tree t1 = new Tree(-2);
    Tree t2 = new Tree(6);
    Tree t11 = new Tree(8);
    Tree t12 = new Tree(-4);
    Tree t21 = new Tree(7);
    Tree t22 = new Tree(5);
    t.left = t1;
    t.right = t2;
    t1.left = t11;
    t1.right = t12;
    t2.left = t21;
    t2.right = t22;
    return t;
  }

  public static void main(String[] args) {
    ConvertToSumTree c = new ConvertToSumTree();
    Tree t = c.createTree();
    c.inorder(t);
    c.sumTree(t);
    System.out.println("printing sum tree:");
    c.inorder(t);
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
