class Solution {
    
    private int[] productArr;
    public int[] productExceptSelf(int[] nums) {
        productArr = new int[nums.length];

        //Put Prefix product into productArr
        int prefixProduct = nums[0];
        for(int i=1;i<nums.length;i++){
            productArr[i] = prefixProduct;
            prefixProduct = prefixProduct*nums[i];
        }

        //Put Suffix product into productArr
        int suffixProduct = nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            if(i == 0){
                productArr[i] = suffixProduct;
                continue;
            }
            productArr[i] = productArr[i]*suffixProduct;
            suffixProduct = suffixProduct*nums[i];
        }

        return productArr;
    }
}  
