class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer,Boolean> hashMap = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            
            if(hashMap.containsKey(nums[i])) 
                return true;

            hashMap.put(nums[i],true);
        }
        return false;
    }
}