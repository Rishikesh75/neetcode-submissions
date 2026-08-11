class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //TC: O(N * LlogL) and SC:O(N * L)
        HashMap<String,List<String>> hashMap = new HashMap<>();
        for(var str : strs){
            char[] arr = str.toCharArray(); //O(1)
            Arrays.sort(arr); //O(len*log(len))

            String key = new String(arr);

            if(hashMap.containsKey(key)){
               hashMap.get(key).add(str);
            }
            else{
               hashMap.put(key,new ArrayList<String>(List.of(str)));
            }

        }

        List<List<String>> ans = new ArrayList<>();

        for(var value : hashMap.values()){
            ans.add(value);
        }

        return ans;

    }
}
