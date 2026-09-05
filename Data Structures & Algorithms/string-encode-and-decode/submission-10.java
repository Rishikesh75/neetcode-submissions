class Solution {

    HashMap<Integer,String> hashMap1 = new HashMap<>();
    HashMap<String,Integer> hashMap2 = new HashMap<>();
    public String encode(List<String> strs) {
        int id = 1; 
        StringBuilder sb = new StringBuilder("");
        for(var str : strs){
            int stringId = id;
            if(hashMap2.containsKey(str))
                stringId = hashMap2.get(str);
            else
            {
                hashMap2.put(str,id);
                hashMap1.put(id,str);
                id++;
            }
            sb.append(hashMap2.get(str)).append(",");
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans= new ArrayList<>();

        if(str.isEmpty())
            return ans;

        String[] ids = str.split(",");

        for(var id : ids){
            int key = Integer.parseInt(id);
            ans.add(hashMap1.get(key));
        }

        return ans;
    }
}
