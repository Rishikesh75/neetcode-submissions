class Solution {
    public int maxProduct(int[] nums) {

        int maxProd = nums[0];
        int minProd = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int curr = nums[i];

            // store because maxProd changes
            int tempMax = maxProd;

            maxProd = Math.max(
                    curr,
                    Math.max(curr * maxProd, curr * minProd)
            );

            minProd = Math.min(
                    curr,
                    Math.min(curr * tempMax, curr * minProd)
            );

            ans = Math.max(ans, maxProd);
        }

        return ans;
    }
}