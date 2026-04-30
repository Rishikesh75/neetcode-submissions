class Solution {
    public int maxProfit(int[] prices) {
        int rightMax = Integer.MIN_VALUE;
        int maxProfit = 0;
        
        for(int i = prices.length-1;i>=0;i--){
            if(prices[i]>rightMax)
                rightMax = prices[i];
            else
                maxProfit = Math.max(rightMax - prices[i],maxProfit);
        }

        return maxProfit;
    }
}
