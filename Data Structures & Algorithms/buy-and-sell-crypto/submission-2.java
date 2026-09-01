class Solution {
    public int maxProfit(int[] prices) {
        
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;

        for(var price : prices){
            minPrice = Math.min(price,minPrice);
            int profit = price - minPrice;
            maxProfit = Math.max(maxProfit,profit);
        }

        return maxProfit;
    }
}
