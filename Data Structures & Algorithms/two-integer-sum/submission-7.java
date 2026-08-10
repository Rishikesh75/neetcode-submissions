class Solution {
    public int[] twoSum(int[] nums, int target) {
        //TC:O(n) SC:O(n) 
        int[] ans = new int[2];

        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(hashMap.containsKey(target - nums[i])){
                int index1 = hashMap.get(target-nums[i]);

                ans[0] = index1;
                ans[1] = i;

                break;
            }   

            hashMap.put(nums[i],i);
        }

        return ans;
    }
}
