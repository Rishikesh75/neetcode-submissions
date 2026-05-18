class Solution {

    private int[] dp;
    public int coinChange(int[] coins, int amount) {
        
        if(amount == 0) return 0;
        dp = new int[amount+1];
        dp[0] = 0;
        Arrays.fill(dp,-1);

        for(int i=0;i<coins.length;i++){
            if(coins[i]<=amount){
                dp[coins[i]] = 1;
            }
        }

        for(int i=1;i<=amount;i++){
            if(dp[i] == -1){
                int minCoins = Integer.MAX_VALUE;
                for(int j=0;j<coins.length;j++){
                    if(i-coins[j]>=0 && dp[i-coins[j]]!=-1){
                        minCoins = Math.min(minCoins,dp[i-coins[j]]+1);
                    }
                }
                dp[i] = minCoins == Integer.MAX_VALUE ? -1 : minCoins;
            }
        }

        return dp[amount];
    }
}
