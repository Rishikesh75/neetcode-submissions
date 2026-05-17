class Solution {
    public int maxProfit(int[] prices) {
        int rightMax = Integer.MIN_VALUE;
        int maxProfit = 0;
        for(int i=prices.length-1;i>=0;i--){
            if(rightMax<prices[i]){
                rightMax = Math.max(prices[i],rightMax);
                continue;
            }

            maxProfit = Math.max(maxProfit,rightMax-prices[i]);
        }

        return maxProfit;
    }
}
