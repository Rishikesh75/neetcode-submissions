class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];

        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(hashMap.containsKey(target - nums[i])){
                int index1 = hashMap.get(target-nums[i]);
                int index2 = i;

                if(index1>index2){
                    ans[0] = index2;
                    ans[1] = index1;
                }
                else{
                    ans[0] = index1;
                    ans[1] = index2;
                }
                break;
            }   

            hashMap.put(nums[i],i);
        }

        return ans;
    }
}
