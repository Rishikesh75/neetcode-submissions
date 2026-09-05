class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String,List<String>> hashMap = new HashMap<>(); 
        List<List<String>> ans =  new ArrayList<>();       
        
        for(var str : strs){
            Character[] arr = new Character[str.length()];
            for(int i=0;i<str.length();i++){
                arr[i] = str.charAt(i);
            }
            Arrays.sort(arr,(a,b)->a.compareTo(b));
            var keyBuilder = new StringBuilder();
            for(var ch : arr){
                keyBuilder.append(ch);
            }
            var key = keyBuilder.toString();
            hashMap.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        var values = hashMap.values();
        for(var val : values){
            ans.add(val);
        }
        return ans;
    }
}
