//https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/

class SumTree{

  private int sum(Tree t) {
    if(t == null) return 0;
    if(t.left == null && t.right == null) return t.value;
    int left = sum(t.left);
    int right = sum(t.right);
    if(left+right != t.value) return -1;
    return 2*t.value; 
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

  public static void main(String[] args) {
    SumTree s = new SumTree();
    Tree t = s.createTree();
    s.inorder(t);
    int sum = s.sum(t);
    System.out.println("sum = "+ sum);
    if(sum/2 == t.value) System.out.println(true);
    else System.out.println(false);
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

