//https://www.geeksforgeeks.org/find-the-largest-subtree-in-a-tree-that-is-also-a-bst/
class LargestBST{
  private int largest = 0;
  private Tree largestTree = null;

  private int largestBst(Tree t) {
    if(t == null) return 0;
    if(t.left == null && t.right == null) return 1;
    int left = largestBst(t.left);
    int right = largestBst(t.right);
    if(left == 0 || right == 0) return 0;
    if(t.left.value < t.value && t.value < t.right.value){
      if(left+right+1 > largest) {
        largest = left+right+1;
        largestTree = t;
        return left+right+1;
      } else return left+right+1;
    } else return 0;
  }

  public static void main(String[] args) {
    LargestBST l = new LargestBST();
    Tree t = l.createTree1();
    l.inorder(t);
    l.largestBst(t);
    System.out.println("largest = " + l.largest);
    l.inorder(l.largestTree);

    l.largest = 0;
    l.largestTree = null;

    Tree t1 = l.createTree2();
    l.inorder(t1);
    l.largestBst(t1);
    System.out.println("largest = " + l.largest);
    l.inorder(l.largestTree);
  }

  private void inorder(Tree t) {
    if(t == null) return;
    inorder(t.left);
    System.out.println(t.value);
    inorder(t.right);
  }

  private Tree createTree1(){
    Tree t = new Tree(50);
    Tree t1 = new Tree(30);
    Tree t2 = new Tree(60);
    Tree t11 = new Tree(5);
    Tree t12 = new Tree(20);
    Tree t21 = new Tree(45);
    Tree t22 = new Tree(70);
    Tree t221 = new Tree(65);
    Tree t222 = new Tree(80);
    t.left = t1;
    t.right = t2;
    t1.left = t11;
    t1.right = t12;
    t2.left = t21;
    t2.right = t22;
    t22.left = t221;
    t22.right = t222;
    return t;
  }

  private Tree createTree2(){
    Tree t = new Tree(5);
    Tree t1 = new Tree(2);
    Tree t2 = new Tree(4);
    Tree t11 = new Tree(1);
    Tree t12 = new Tree(3);
    t.left = t1;
    t.right = t2;
    t1.left = t11;
    t1.right = t12;
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