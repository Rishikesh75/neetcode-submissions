class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        int n = s.length();

        boolean[] dp = new boolean[n + 1];

        // Base case
        dp[n] = true;

        // Traverse from back
        for (int i = n - 1; i >= 0; i--) {

            for (String word : wordDict) {

                // Check bounds
                if (i + word.length() <= n &&
                    s.substring(i, i + word.length()).equals(word)) {

                    dp[i] = dp[i + word.length()];
                }

                // Optimization
                if (dp[i]) {
                    break;
                }
            }
        }

        return dp[0];
    }
}