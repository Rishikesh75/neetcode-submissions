class Solution {
    private int[] dp;
    
    public int hR(int[] nums,int n){
        
        if(dp[n]!=-1) return dp[n];


        if(n == 1){
            dp[n] = nums[n-1];
            return dp[n];
        }

        if(n == 2){
            dp[n] = Math.max(nums[n-1],nums[n-2]);
            return dp[n];
        }


        dp[n] = Math.max(hR(nums,n-1) , nums[n-1] + hR(nums,n-2));


        return dp[n];

    }

    public int rob(int[] nums) {
       
       int n = nums.length;
       dp = new int[n+1];

       Arrays.fill(dp,-1);

       return hR(nums,n);
    }
}
