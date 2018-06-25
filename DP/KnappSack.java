import java.util.*;


class KnappSack{

  private int findMaxValuePossible(int[] weights, int[] values, int maxWeight){
    int[][] maxValues = new int[maxWeight+1][maxWeight+1];
    
    for(int i=1;i<weights.length+1;i++){
      for(int j=1;j<maxWeight+1;j++){
        int prev = maxValues[i-1][j];
        int pos = ( j- weights[i-1] ) >=0? j-weights[i-1] :-1;
        
        int possibleCurr = pos>=0? maxValues[i-1][pos]+values[i-1]: 0;
        maxValues[i][j] = Math.max(prev, possibleCurr);
      }
    }
    return maxValues[weights.length][maxWeight];
  }

  public static void main(String[] args) {
    int[] weights = new int[]{4,2,3};
    int[] values = new int[]{10, 4, 7};
    int maxWeight = 5;
    KnappSack k = new KnappSack();
    int maxValue = k.findMaxValuePossible(weights, values, maxWeight);
    System.out.println("max value = "+ maxValue);
  }
}