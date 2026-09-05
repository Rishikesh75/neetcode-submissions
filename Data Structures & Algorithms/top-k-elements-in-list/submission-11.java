class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int n = nums.length;

        for(var num : nums){
            hashMap.put(num,hashMap.getOrDefault(num,0)+1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];

        for(var val : hashMap.entrySet()){
            int bucketIndex = val.getValue();
            if(buckets[bucketIndex] == null){
                buckets[bucketIndex] = new ArrayList<Integer>();
            }
            buckets[bucketIndex].add(val.getKey());
        }
        
        int[] ans = new int[k];
        int ansIndex = 0;
        for(int i = n;i>=0;i--){
            if(buckets[i] == null)
                continue;

            for (int num : buckets[i]) {
                ans[ansIndex++] = num;

                if (ansIndex == k) {
                    return ans;
                }
            }
        }

        return ans;
    }
}
