import java.util.*;

class SubsetSum {

  List<List<Integer>> sumSubsets(int[] arr, int num) {
      
    int[][] dp = new int[arr.length+1][num+1];
    
    for(int i=0;i<dp.length;i++){
        dp[i][0] =1;
    }
    for(int i=1;i<=arr.length;i++){
        for(int j=1;j<=num;j++){
            dp[i][j] = getCount(dp,i,j,arr);
        }
    }
    
    for(int i=0;i<dp.length;i++) {
        System.out.println(Arrays.toString(dp[i]));
    }
    List<List<Integer>> r = getCombinations(dp,num, arr);
    System.out.println(r);
    return r;
  }


  int getCount(int[][] graph, int row, int column, int[] arr) {
    int currRow = arr[row-1];
    int prevRowCount = graph[row-1][column];
    if(currRow == column) return  prevRowCount+1;
    else if(currRow > column) return prevRowCount;
    else return prevRowCount+graph[row-1][column - currRow];
  }

  public static void main(String[] args) {
    SubsetSum s = new SubsetSum();
    int[] arr = {1, 2, 3, 4, 5};
    int num = 5;
    s.sumSubsets(arr, num);
  }
}
