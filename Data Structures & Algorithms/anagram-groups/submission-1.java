class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //declare the hashMap
        Map<String,List<String>>hashMap = new HashMap<String,List<String>>();
        //Traverse to the array
        for(var str : strs){
            
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String sortedVal = new String(charArr);
            
            if(hashMap.containsKey(sortedVal)){
                hashMap.get(sortedVal).add(str);
                continue;
            }

            hashMap.put(sortedVal,new ArrayList<String>(List.of(str)));
            
        }
        //return the ans
        List<List<String>> ans = new ArrayList<List<String>>();

        for(var set : hashMap.entrySet()){
            ans.add(set.getValue());
        }

        return ans;
    }
}
