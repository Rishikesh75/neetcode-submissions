class Solution {
    public int maxProfit(int[] prices) {
        
        int minValue = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for(int i=0;i<prices.length;i++){
            minValue = Math.min(prices[i],minValue);
            int profit = prices[i] - minValue;
            maxProfit = Math.max(maxProfit,profit);
        }

        return maxProfit;
    }
}
