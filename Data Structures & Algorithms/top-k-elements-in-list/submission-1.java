class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> hashMap = new HashMap<>();

        // Step 1: Frequency count
        for(int i = 0; i < nums.length; i++){
            if(hashMap.containsKey(nums[i])){
                hashMap.replace(nums[i], hashMap.get(nums[i]) + 1);
                continue;
            }
            hashMap.put(nums[i], 1);
        }

        // Step 2: Sort keys based on frequency (DESC)
        List<Integer> keys = new ArrayList<>(hashMap.keySet());
        keys.sort((a, b) -> hashMap.get(b) - hashMap.get(a));

        // Step 3: Take top k elements
        for(int i = 0; i < k; i++){
            list.add(keys.get(i));
        }

        int[] result = list.stream().mapToInt(Integer::intValue).toArray();

        return result;
    }
}