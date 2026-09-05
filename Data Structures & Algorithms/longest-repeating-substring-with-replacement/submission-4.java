class Solution {
    public int characterReplacement(String s, int k) {

        int i = 0;
        int maxLen = 0;
        int maxFreq = 0;

        int[] freq = new int[26];

        for (int j = 0; j < s.length(); j++) {

            // Add current character
            freq[s.charAt(j) - 'A']++;

            // Maximum frequency in current window
            maxFreq = Math.max(maxFreq, freq[s.charAt(j) - 'A']);

            // Characters that need to be replaced
            int replacements = (j - i + 1) - maxFreq;

            // Shrink window if invalid
            if (replacements > k) {
                freq[s.charAt(i) - 'A']--;
                i++;
            }

            // Current valid window length
            maxLen = Math.max(maxLen, j - i + 1);
        }

        return maxLen;
    }
}