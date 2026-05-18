class Solution {
    public int countSubstrings(String s) {

        int n = s.length();

        // dp[i][j] = true if substring i to j is palindrome
        boolean[][] dp = new boolean[n][n];

        int count = 0;

        // Length 1 substrings
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            count++;
        }

        // Length 2 substrings
        for (int i = 0; i < n - 1; i++) {

            if (s.charAt(i) == s.charAt(i + 1)) {

                dp[i][i + 1] = true;
                count++;
            }
        }

        // Length >= 3
        for (int len = 3; len <= n; len++) {

            for (int i = 0; i <= n - len; i++) {

                int j = i + len - 1;

                // First and last chars should match
                // Middle substring should already be palindrome
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {

                    dp[i][j] = true;
                    count++;
                }
            }
        }

        return count;
    }
}