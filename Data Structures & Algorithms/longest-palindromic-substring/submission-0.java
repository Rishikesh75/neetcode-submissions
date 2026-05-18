class Solution {
    public String longestPalindrome(String s) {

        int n = s.length();

        // Edge case
        if (n <= 1)
            return s;

        // dp[i][j] = true if substring from i to j is palindrome
        boolean[][] dp = new boolean[n][n];

        int start = 0;
        int maxLen = 1;

        // Every single character is palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Check for length 2 substrings
        for (int i = 0; i < n - 1; i++) {

            if (s.charAt(i) == s.charAt(i + 1)) {

                dp[i][i + 1] = true;

                start = i;
                maxLen = 2;
            }
        }

        // Check for length >= 3
        for (int len = 3; len <= n; len++) {

            for (int i = 0; i <= n - len; i++) {

                int j = i + len - 1;

                // Current chars should match
                // Inside substring should also be palindrome
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {

                    dp[i][j] = true;

                    if (len > maxLen) {
                        start = i;
                        maxLen = len;
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);
    }
}