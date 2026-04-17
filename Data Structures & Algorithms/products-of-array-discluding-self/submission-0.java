class Solution {
    public int[] productExceptSelf(int[] nums) {
        

        int val = nums[0];
        int[] arr = new int[nums.length];
        arr[0] = 1;
        for(int i = 1;i<nums.length;i++){
            arr[i] = val;
            val = val * nums[i];
        }

        val = nums[nums.length-1];
        for(int i = nums.length-2;i>=0;i--){
            arr[i] = arr[i] * val;
            val = val * nums[i];
        }

        return arr;
    }
}  
