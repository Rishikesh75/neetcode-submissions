class Solution {
    public int lengthOfLIS(int[] nums) {

        int n = nums.length;

        // dp[i] = length of LIS ending at index i
        int[] dp = new int[n];

        // Every element alone forms LIS of length 1
        Arrays.fill(dp, 1);

        int maxLen = 1;

        for (int i = 1; i < n; i++) {

            for (int j = 0; j < i; j++) {

                // Increasing condition
                if (nums[j] < nums[i]) {

                    // Extend previous subsequence
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }
}