class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> hashMap = new HashMap<>();

        for (String str : strs) {

            int[] count = new int[26];

            for (char ch : str.toCharArray()) {
                count[ch - 'a']++;
            }

            StringBuilder keyBuilder = new StringBuilder();

            for (int i = 0; i < 26; i++) {
                keyBuilder.append('#');
                keyBuilder.append(count[i]);
            }

            String key = keyBuilder.toString();

            hashMap
                .computeIfAbsent(key, k -> new ArrayList<>())
                .add(str);
        }

        return new ArrayList<>(hashMap.values());
    }
}
