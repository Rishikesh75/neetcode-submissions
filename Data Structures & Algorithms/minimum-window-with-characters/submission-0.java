class Solution {
    public String minWindow(String s, String t) {

        if (t.length() > s.length()) return "";

        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        // Store frequency of characters in t
        for (char ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        int i = 0;
        int j = 0;

        int required = tMap.size();
        int formed = 0;

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (j < s.length()) {

            char ch = s.charAt(j);

            // Expand window
            windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);

            if (tMap.containsKey(ch) &&
                windowMap.get(ch).intValue() == tMap.get(ch).intValue()) {
                formed++;
            }

            // Shrink window
            while (i <= j && formed == required) {

                // Update answer
                if ((j - i + 1) < minLen) {
                    minLen = j - i + 1;
                    start = i;
                }

                char leftChar = s.charAt(i);

                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                if (tMap.containsKey(leftChar) &&
                    windowMap.get(leftChar) < tMap.get(leftChar)) {
                    formed--;
                }

                i++;
            }

            j++;
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}