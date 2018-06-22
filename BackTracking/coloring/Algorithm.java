package coloring;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vm033450 on 1/23/18.
 */
public class Algorithm {

    private String[] colorMap = new String[] { "yellow", "blue", "green", "red" };

    String[] colorGraph(int[][] graph) {
        int[] colorInt = color(graph, new int[graph.length], 0);
        String[] colorString = new String[colorInt.length];
        for (int i = 0; i < colorInt.length; i++)
            colorString[i] = colorMap[colorInt[i] - 1];
        return colorString;
    }

    private int[] color(int[][] graph, int[] vertexColors, int pos) {
        if (pos >= graph.length)
            return vertexColors;
        int[] adjPos = graph[pos];
        Set<Integer> adjColors = new HashSet<>();
        for (int i = 0; i < adjPos.length; i++)
            if (adjPos[i] != 0)
                adjColors.add(vertexColors[i]);
        for (int i = 1; i < graph.length; i++) {
            if (!adjColors.contains(i)) {
                vertexColors[pos] = i;
                int[] c = color(graph, vertexColors, pos + 1);
                if (c != null)
                    return c;
                else
                    vertexColors[pos] = 0;
            }
        }
        return null;
    }

}
