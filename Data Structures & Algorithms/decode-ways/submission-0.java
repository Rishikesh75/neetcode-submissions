class Solution {
    public int numDecodings(String s) {

        int n = s.length();

        // Edge case
        if (s.charAt(0) == '0')
            return 0;

        // dp[i] = number of ways to decode till index i
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {

            // Single digit
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));

            // Two digits
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));

            // Check single digit valid
            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];
            }

            // Check two digit valid
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}