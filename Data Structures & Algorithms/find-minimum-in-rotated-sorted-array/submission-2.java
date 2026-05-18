class Solution {
    public int Bs(int[]nums,int start,int end){

        if(start >=end){
            return nums[start];
        }
        
        int mid = start + (end - start)/2;

        if(nums[mid]>nums[end]){
            start = mid + 1;
            return Bs(nums,start,end);
        }


        end = mid;
        return Bs(nums,start,end);
    }
    
    public int findMin(int[] nums) {
        return Bs(nums,0,nums.length-1);
    }
}
