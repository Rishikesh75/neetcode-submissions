class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int[] ans = new int[k];
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for(var num : nums){
            hashMap.put(num,hashMap.getOrDefault(num,0)+1);
        }

        List<Integer> keys = new ArrayList<>(hashMap.keySet());

        keys.sort((a,b) -> hashMap.get(b)-hashMap.get(a));

        for(int i=0;i<k;i++){
            ans[i] = keys.get(i);
        }

        Arrays.sort(ans);
        return ans; 
    }
}
