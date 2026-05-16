class Solution {
    public boolean isAnagram(String s, String t) {
        //Decalare HashMap
        Map<Character,Integer> hashMap = new HashMap<>();

        //Add Elements into HashMap from s
        for(var ch : s.toCharArray()){
            hashMap.put(ch,hashMap.getOrDefault(ch,0)+1);
        }

        //remvoe Elements from HashMap using t
        for(var ch : t.toCharArray()){
            if(hashMap.containsKey(ch)){
                
                if(hashMap.get(ch) == 1) hashMap.remove(ch);
                
                else hashMap.replace(ch,hashMap.get(ch)-1);
                continue;
            }
            return false;
        }

        //Check the size of the Hashmap
        return hashMap.size() == 0 ? true : false;
    }
}
