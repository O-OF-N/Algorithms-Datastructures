import java.util.*;
class Main {

  // Add
  private static void addToTree(int n, Node prev, Node current){
    if(current == null){
      if(prev.value<n) prev.right = new Node(n);
      else prev.left = new Node(n); 
    }else {
      if(current.value < n ) addToTree(n, current, current.right);
      else addToTree(n, current,current.left);
    }
  }

  private static Node add(int n, Node root){
    if(root == null) return new Node(n);
    else {
      addToTree(n, root, root);
      return root;
    }
  }

  // Search - DFS
  private static void inOrder(Node root){
    if(root == null) return;
    inOrder(root.left);
    System.out.println(root.value);
    inOrder(root.right);
  }
  
  private static void preOrder(Node root){
    if(root == null) return;
    System.out.println(root.value);
    preOrder(root.left);
    preOrder(root.right);
  }
  
  private static void postOrder(Node root){
    if(root == null) return;
    postOrder(root.left);
    postOrder(root.right);
    System.out.println(root.value);
  }

  // Search - BFS
  private static void search(Queue<Node> nodes){
    if(nodes.isEmpty()) return;
    Node current = nodes.poll();    
    System.out.println(current.value);
    if(current.left!=null) nodes.add(current.left);
    if(current.right!=null) nodes.add(current.right);
    search(nodes);

  }
  private static void bfs(Node root){
    Queue<Node> list = new LinkedList<Node>();
    list.add(root);
    search(list);
  }

  // Find - BFS
  private static Node[] find(Node prev, Node curr, int value){
    if(curr.value == value) {
      Node[] ret=  {prev,curr};
      return ret;
    }
    if(curr.value > value) return find(curr,curr.left, value);
    return find(curr,curr.right, value);
  }

  // Delete
  // Delete involves 2 steps, 
    // => removing link from the parent.
    // => setting the reference to null.

  // Case 1: If the node to be deleted is a leaf node, simply delete.
  // Case 2: If the node to be deleted has only one child, link the parent of the node and the child. delete the node.
  // Case 3: If the node to be deleted has both children, then:
    // => find the right most value on the left child. 
    // => If the right most value has a left child, set the left child as the right child of the parent of the right most value.
    // => Delete the node to be deleted. Set the right most value in its place.
  private static Node findRightMost(Node prev, Node curr){
    if(curr.right == null){
      prev.right = curr.left;
      curr.left = null;
      return curr;
    } else {
      return findRightMost(curr, curr.right);
    }
  } 
  private static void delete(Node root, int value) {
    Node[] n = find(root, root, value);
    Node prev = n[0];
    Node curr = n[1];
    System.out.println(curr.left);
    System.out.println(curr.right);
    // Case 1:
    if(curr.left == null && curr.right == null){
      if(prev.left!= null && prev.left == curr) prev.left = null;
      else prev.right = null;
    }

    // Case 2:
    else if(curr.left == null) {
      if(prev.left!= null && prev.left == curr) prev.left = curr.right;
      else prev.right = curr.right;
    }
    else if(curr.right == null) {
      if(prev.left!= null && prev.left == curr) prev.left = curr.left;
      else prev.right = curr.left;
    }
    
    // Case 3: 
    else{
      Node rightMost = findRightMost(curr, curr.left);
      System.out.print("rm = " );
      System.out.println(rightMost);
      rightMost.right = curr.right;
      rightMost.left = curr.left;
      if(prev.left!= null && prev.left == curr) prev.left = rightMost;
      else prev.right = rightMost;
    }
    curr = null;

  }


  public static void main(String[] args) {
    /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
    Node root = add(50,null);
    add(30,root);
    add(20,root);
    add(40,root);
    add(70,root);
    add(60,root);
    add(80,root);
    System.out.println("----- Inorder ---------");
    inOrder(root);
    System.out.println("----- Pre-order ---------");
    preOrder(root);
    System.out.println("----- Post-order ---------");
    postOrder(root);
    System.out.println("----- bfs ---------");
    bfs(root);
    System.out.println("----- delete 20 ---------");
    delete(root,20);
    inOrder(root);
    System.out.println("----- delete 30 ---------");
    delete(root,30);
    inOrder(root);
    System.out.println("----- delete 50 ---------");
    delete(root,50);
    inOrder(root);

  }
}

class Node{
  int value;
  Node left;
  Node right;
  public Node(int value) {
    this.value = value;
  } 
  public String toString(){
    return "value = " + value;
  }
}