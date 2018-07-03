import java.util.*;

class Graph {

  private void dfsSearch(int[][] graph, Stack<Integer> stack, LinkedHashSet<Integer> visited){
    if(stack.isEmpty()) return;
    int curr = stack.pop();
    int[] nodes = graph[curr];
    visited.add(curr);
    for(int i= 0;i<nodes.length; i++) {
      if(nodes[i] == 1 && !visited.contains(i)) stack.add(i);
      dfsSearch(graph, stack, visited);
    }
  }
  private void dfs(int[][] graph, int start) {
    Stack<Integer> stack = new Stack<>();
    stack.add(start);
    LinkedHashSet<Integer> visited = new LinkedHashSet<>();
    dfsSearch(graph, stack, visited);

    System.out.print("DFS visited order = ");
    System.out.println(visited);
  }

  private void bfsSearch(int[][] graph, Queue<Integer> queue, LinkedHashSet<Integer> visited) {
    if(queue.isEmpty()) return;
    int curr = queue.poll();
    visited.add(curr);
    int[] nodes = graph[curr];
    for(int i =0;i<nodes.length; i++) {
      if(nodes[i] == 1 && !visited.contains(i)) queue.add(i);
    }
    bfsSearch(graph, queue, visited);
  }
  private void bfs(int[][] graph, int start) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    LinkedHashSet<Integer> visited = new LinkedHashSet<>();
    bfsSearch(graph, queue, visited);
    System.out.print("BFS visited order = ");
    System.out.println(visited);
  }

  public static void main(String[] args) {
    int[][] graph = {{0,1,1,0},{0,0,0,1},{1,0,0,0},{0,0,0,1}};
    Graph g = new Graph();
    g.dfs(graph, 0);
    g.bfs(graph,0);
  }
}