class Solution {
    public int characterReplacement(String s, int k) {

        int i = 0;
        int maxLen = 0;
        int maxFreq = 0;

        int[] freq = new int[26];

        for (int j = 0; j < s.length(); j++) {

            char ch = s.charAt(j);
            freq[ch - 'A']++;

            // Highest frequency character in current window
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);

            // Number of replacements needed
            int replacements = (j - i + 1) - maxFreq;

            // Window is invalid
            if (replacements > k) {
                freq[s.charAt(i) - 'A']++;
                freq[s.charAt(i) - 'A']--; // wrong
            }

            if (replacements > k) {
                freq[s.charAt(i) - 'A']--;
                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
        }

        return maxLen;
    }
}