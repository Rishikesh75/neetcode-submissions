class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<String,List<String>>();

        for(String s : strs){

            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sortedStr = new String(arr);

            if(map.containsKey(sortedStr)){
                map.get(sortedStr).add(s);
                continue;
            }
        
            map.put(sortedStr,new ArrayList<String>(List.of(s)));
        }

        return new ArrayList<>(map.values());
    }
}
