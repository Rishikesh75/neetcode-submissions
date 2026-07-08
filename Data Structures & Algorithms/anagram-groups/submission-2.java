class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>>hashMap = new HashMap<String,List<String>>();

        for(var str : strs){

            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            var key = String.valueOf(charArr);
            if(hashMap.containsKey(key)){
                hashMap.get(key).add(str);
            }

            else hashMap.put(key,new ArrayList<String>(List.of(str)));
        }

        List<List<String>> ans = new ArrayList<List<String>>();

        for(var entry : hashMap.entrySet()){
            ans.add(entry.getValue());
        }

        return ans;
    }
}
