class Solution {
    public String minWindow(String s, String t) {

        int[] need = new int[128];
        int[] window = new int[128];

        // Count characters required from t
        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int left = 0;
        int count = 0;

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);
            window[c]++;

            // This character is required and we haven't
            // exceeded the required frequency
            if (need[c] > 0 && window[c] <= need[c]) {
                count++;
            }

            // Window is valid
            while (count == t.length()) {

                // Update answer
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                window[leftChar]--;

                // Removing this character makes window invalid
                if (need[leftChar] > 0 &&
                    window[leftChar] < need[leftChar]) {
                    count--;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}