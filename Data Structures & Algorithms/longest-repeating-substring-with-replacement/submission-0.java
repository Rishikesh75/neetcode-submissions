class Solution {
    public int characterReplacement(String s, int k) {

        int i = 0;
        int j = 0;
        int maxLen = 0;
        int maxFreq = 0;

        int n = s.length();

        int[] freq = new int[26];

        while (j < n) {

            // Expand Window
            while (j < n) {

                freq[s.charAt(j) - 'A']++;

                maxFreq = Math.max(maxFreq, freq[s.charAt(j) - 'A']);

                // window becomes invalid
                if ((j - i + 1) - maxFreq > k)
                    break;

                maxLen = Math.max(maxLen, j - i + 1);

                j++;
            }

            // Compress Window
            while (i <= j && j < n && ((j - i + 1) - maxFreq > k)) {

                freq[s.charAt(i) - 'A']--;
                i++;
            }

            j++;
        }

        return maxLen;
    }
}