class Solution {
    public int[] twoSum(int[] nums, int target) {
    int[] ans = new int[]{-1,-1};
    Map<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
    int n = nums.length;

    for(int i=0;i<n;i++){
        if(hashMap.containsKey(target - nums[i])){
            ans[0] = hashMap.get(target - nums[i]);
            ans[1] = i;
            break;
        }

        hashMap.put(nums[i],i);
    }

    return ans;

    }
}
