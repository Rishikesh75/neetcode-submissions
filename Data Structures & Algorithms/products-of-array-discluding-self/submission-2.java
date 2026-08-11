class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] ans = new int[nums.length];
        Arrays.fill(ans,1);

        int product = nums[0];
        for(int i=1;i<nums.length;i++){
            ans[i] = ans[i] * product;
            product = product * nums[i];
        }

        product = nums[nums.length-1];
        for(int i= nums.length-2;i>=0;i--){
            ans[i] = ans[i] * product;
            product = product * nums[i];
        }

        return ans;
        
    }
}  
