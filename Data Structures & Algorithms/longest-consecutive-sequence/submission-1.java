class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;

        Arrays.sort(nums);

        int size = 1;
        int maxSize = 1;

        for(int i = 1; i < nums.length; i++) {
            
            if(nums[i] == nums[i-1]) {
                continue; // skip duplicates
            }
            else if(nums[i] == nums[i-1] + 1) {
                size++;
            }
            else {
                maxSize = Math.max(maxSize, size);
                size = 1;
            }
        }

        return Math.max(maxSize, size);
    }
}