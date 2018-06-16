class Solution {
  public static int coinChange(int[] coins, int amount) {
      int[][] map = new int[coins.length+1][amount+1];
      Arrays.fill(map[0], Integer.MAX_VALUE);
      // i = 1 to amount
      // j = each coin
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