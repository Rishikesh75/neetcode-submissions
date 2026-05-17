class Solution {

    private Map<Integer,String>map = new HashMap<Integer,String>();
    public String encode(List<String> strs) {
        
        StringBuilder sb = new StringBuilder("");
        int id = 1;

        for(var str:strs){
            map.put(id,str);
            sb.append(id).append("#");
            id++;
        } 

        return sb.toString();  

    }

    public List<String> decode(String str) {
        
        List<String>ans = new ArrayList<>();
        String[] parts = str.split("#");

        for(var part : parts){
            
            if (part.length() == 0)
                continue;

            Integer key = Integer.parseInt(part);
            ans.add(map.get(key));
        }

        return ans;

    }
}