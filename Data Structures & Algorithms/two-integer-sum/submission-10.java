class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
        int n = nums.length;

        for(int i=0;i<nums.length;i++){
            hashMap.put(nums[i],i);
        }

        for(int i=0;i<n;i++){
            if(hashMap.containsKey(target - nums[i])){
                int j = hashMap.get(target - nums[i]);
                if(i == j) 
                    continue;
                return new int[]{i,j};
            }
        }

        return new int[]{-1,-1};
    }
}
