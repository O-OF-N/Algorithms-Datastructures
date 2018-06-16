class Solution {

  /*
  1) Create an empty 2D array with no. of coins+1 rows and amount+1 columns.
  2) Populate the first row with Integer.MAX_VALUE for everything. Because it takes infinite 0 coins to make any value.
  3) Then iterate from amount 1 to amount n for each and every coin.
  4) In each iteration, first set the min value to the value from the previous row but same column. For row 1, col 1, the value in this step will be Integer.MAX_VALUE. This is the minimum value we know at this stage.
  5) Calculate the possible minimum. Possible minimum is the array[current amount - current coin] + 1. If current-current coin is less than 0, then the minimum stays as the value computed in step 4.
  6) The last row last column has the possible minimum value. 
  */
  public static int coinChange(int[] coins, int amount) {
      int[][] map = new int[coins.length+1][amount+1];
      Arrays.fill(map[0], Integer.MAX_VALUE);
      // i = 1 to amount
      // j = coin index 1 to n
      for(int i=1;i<coins.length+1;i++){
          for(int j=1;j<amount+1;j++){
              map[i][j] = map[i-1][j];
              if(j-coins[i-1]>=0){
                  int prev = map[i][j-coins[i-1]];
                  if(prev<Integer.MAX_VALUE){
                      map[i][j] = Math.min(map[i][j],prev+1);
                  }
              }
          }
      }
      return map[map.length-1][amount] == Integer.MAX_VALUE? -1 : map[map.length-1][amount];
  }

  public static void main(String[] args){
   int[] coins = {186,419,83,408};
   int amount = 6249;
   int result = coinChange(coins,amount);
   System.out.println("result= "+ result);
  }
}