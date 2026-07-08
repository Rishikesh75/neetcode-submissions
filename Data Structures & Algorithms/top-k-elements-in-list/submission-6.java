class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       
       Map<Integer,Integer>hashMap = new HashMap<Integer,Integer>();

       for(var num : nums){
            hashMap.put(num,hashMap.getOrDefault(num,0)+1);
       }

       List<Integer> keys = new ArrayList<>(hashMap.keySet());

       keys.sort((Integer a,Integer b) -> hashMap.get(b) - hashMap.get(a));

      return keys.subList(0,k).stream().mapToInt(x ->x.intValue()).toArray();

    }
}