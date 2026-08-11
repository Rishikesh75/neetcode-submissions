class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length == 0) return 0;

        HashSet<Integer> hashSet = new HashSet<>();
        for(var num : nums){
            hashSet.add(num);
        }

        int maxSize = 1;
        for(int i=0;i<nums.length;i++){
            if(!hashSet.contains(nums[i]-1)){
                int size = 1;
                while(hashSet.contains(nums[i]+size)){
                    size++;
                }
                maxSize = Math.max(maxSize,size);
            }
        }

        return maxSize;
    }
}