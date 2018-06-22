package hamiltonianCycle;

/**
 * Created by vm033450 on 1/16/18.
 */
public class App {
    //Can you traverse through every vertix and get back to the starting point.
    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {0,1,1,1,0,0},
                {1,0,1,0,1,1},
                {1,1,0,1,0,1},
                {1,0,1,0,0,1},
                {0,1,0,0,1,0},
                {0,1,1,1,1,0}
        };
        int[][] graph1 = new int[][]{
                {0,1,0,0,0,0},
                {0,0,1,0,0,0},
                {0,0,0,1,0,0},
                {0,0,0,0,1,1},
                {0,0,0,0,0,0},
                {0,1,0,0,0,0}
        };
        int[][] graph2 = new int[][]{
                {0,1,0},
                {1,0,1},
                {0,1,0}
        };
        Algorithm algorithm = new Algorithm();
        System.out.println(algorithm.isHamiltonianCycle(graph));
        System.out.println(algorithm.isHamiltonianCycle(graph1));
        System.out.println(algorithm.isHamiltonianCycle(graph2));
    }
}
