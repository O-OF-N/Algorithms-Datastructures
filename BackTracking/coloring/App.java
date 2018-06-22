package coloring;

import java.util.Arrays;

/**
 * Created by vm033450 on 1/23/18.
 */
public class App {

    public static void main(String[] args) {


        int[][] g = new int[][] {
                { 0, 1, 1, 1, 0, 0 },
                { 1, 0, 1, 0, 1, 1 },
                { 1, 1, 0, 1, 0, 1 },
                { 1, 0, 1, 0, 0, 1 },
                { 0, 1, 0, 0, 1, 0 },
                { 0, 1, 1, 1, 1, 0 }
        };
        Algorithm algorithm = new Algorithm();
        String[] result = algorithm.colorGraph(g);
        Arrays.stream(result).forEach(System.out::println);
    }
}
