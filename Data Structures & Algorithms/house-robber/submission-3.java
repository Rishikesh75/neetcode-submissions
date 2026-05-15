class Solution {
    private int[] dp;
    
    public int hR(int[] arr,int n){
        if(dp[n]!=-1)
            return dp[n];
        
        if(n==1){
            dp[n] = arr[n-1];
            return dp[n];
        }

        if(n == 2){
            dp[n] = Math.max(arr[n-2],arr[n-1]);
            return dp[n];
        }

        dp[n] = Math.max(arr[n-1]+hR(arr,n-2),hR(arr,n-1));

        return dp[n];
    }

    public int rob(int[] nums) {
        dp = new int[nums.length+1];
        Arrays.fill(dp,-1);

        return hR(nums,nums.length);
    }
}
