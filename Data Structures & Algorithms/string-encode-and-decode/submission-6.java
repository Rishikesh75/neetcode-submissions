class Solution {

    //Delacare the HashMap
    private Map<Integer,String> hashMap = new HashMap<Integer,String>();
    
    public String encode(List<String> strs) { 
       StringBuilder sb = new StringBuilder("");

        int id = 1;
        
        for(var str : strs){
            hashMap.put(id,str);
            sb.append(id).append("#");
            id++;
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        
        List<String>ans = new ArrayList<>();
        //Split the String
        String[] subStrings = str.split("#");

        //foreach char we get the string from the Map
       for(var subString:subStrings){
            
            if(subString.length() == 0)
                continue;

            int key = Integer.parseInt(subString);
            ans.add(hashMap.get(key));
       }

       return ans;

    }
}