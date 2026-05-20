class Solution {

    private int[] dp;

    public int rob(int[] nums) {

        int n = nums.length;

        // If only one house
        if (n == 1)
            return nums[0];

        // Case 1:
        // Rob from 0 to n-2
        dp = new int[n];
        Arrays.fill(dp, -1);

        int case1 = dfs(nums, 0, n - 2);

        // Case 2:
        // Rob from 1 to n-1
        dp = new int[n];
        Arrays.fill(dp, -1);

        int case2 = dfs(nums, 1, n - 1);

        return Math.max(case1, case2);
    }

    public int dfs(int[] nums, int start, int currIndex) {
        
        if (start == currIndex) {
            return nums[start];
        }

        dp[start] = nums[start];
        dp[start+1] = Math.max(nums[start],nums[start+1]);
        
        for(int i = start+2;i<=currIndex;i++){
            dp[i] = Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        
        return dp[currIndex];
    }
}