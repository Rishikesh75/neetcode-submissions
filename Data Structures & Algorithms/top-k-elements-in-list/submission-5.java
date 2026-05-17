class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //create the Hashmap
        Map<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
        
        //intialize the hashmap..
        for(var num:nums){
            hashMap.put(num,hashMap.getOrDefault(num,0)+1);
        }

        //sort the hashmap..
        List<Integer> keys = new ArrayList<Integer>(hashMap.keySet());
        keys.sort((a,b)->hashMap.get(b)-hashMap.get(a));

        //select the kmost elements..
        List<Integer>ans = new ArrayList<Integer>();
        for(int i=0;i<k;i++){
            ans.add(keys.get(i));
        }

        //Convert to array...
        return ans.stream().mapToInt(Integer::intValue).toArray();

    }
}