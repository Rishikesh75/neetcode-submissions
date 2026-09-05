class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length -1;
        int minValue = Integer.MAX_VALUE;
        while(start<=end){
            int mid = start + (end - start)/2;

            if(start == end){
                minValue = Math.min(nums[mid],minValue);
                break;
            }
            if(nums[mid]>nums[start] || nums[mid]>nums[end]){
                minValue = Math.min(minValue,nums[start]);
                start = mid + 1;
            }

            else if(nums[mid]<nums[end] || nums[mid]<nums[start]){
                minValue = Math.min(minValue,nums[mid]);
                end = mid-1;
            }
        }

        return minValue;
    }
}
