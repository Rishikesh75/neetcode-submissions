class Solution {
    
    private int[] dp;
    public int climbStairsRecurssion(int n){
         if(dp[n]!=-1) 
            return dp[n];

        if(n==0){
            dp[n] = 1;
            return dp[n];
        }

        if(n == 1){
            dp[n]=1;
            return dp[n];
        }

        dp[n] = climbStairsRecurssion(n-1) + climbStairsRecurssion(n-2);
        return dp[n];
            
    }
    
    
    public int climbStairs(int n) {
        dp = new int[n+1];

        Arrays.fill(dp, -1);

        return climbStairsRecurssion(n);
    }

}
