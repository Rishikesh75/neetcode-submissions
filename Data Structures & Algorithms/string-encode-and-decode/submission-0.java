class Solution {

    public String encode(List<String> strs) {
        String result = "";

        for (String str : strs) {
            result = result + str.length() + "#" + str;
        }

        return result;
    }

    public List<String> decode(String str) {

        List<String> ans = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {

            int j = i;

            // Find '#'
            while (str.charAt(j) != '#') {
                j++;
            }

            // Extract length correctly
            int length = Integer.parseInt(str.substring(i, j));

            int start = j + 1;
            int end = start + length;

            String word = str.substring(start, end);
            ans.add(word);

            i = end;
        }

        return ans;
    }
}