package hamiltonianCycle;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by vm033450 on 1/16/18.
 */
public class Algorithm {

    Set<Integer> isHamiltonianCycle(int[][] graph){
        Set<Integer> visited = new LinkedHashSet<>();
        visited.add(0);
        return checkCycle(graph,visited,0);
    }

    private Set<Integer> checkCycle(int[][] graph, Set<Integer> visited, int pos){
        int[] current = graph[pos];
        if(visited.size() == graph.length){
            if(current[0] == 1)
                return visited;
            else return null;
        }
        for(int i=0;i<current.length;i++){
            if(current[i] == 1 && !visited.contains(i)){
                visited.add(i);
                Set<Integer> result = checkCycle(graph,visited,i);
                if(result!= null) return result;
                // No feasible solution. so back track.
                visited.remove(i);
            }
        }
        return null;
    }
}
