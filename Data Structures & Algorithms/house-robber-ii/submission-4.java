class Solution {

    int[] dp;

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

    public int dfs(int[] nums, int start, int index) {

        // Base case
        if (index < start)
            return 0;

        if (dp[index] != -1)
            return dp[index];

        // Pick current house
        int pick = nums[index] + dfs(nums, start, index - 2);

        // Skip current house
        int notPick = dfs(nums, start, index - 1);

        dp[index] = Math.max(pick, notPick);

        return dp[index];
    }
}