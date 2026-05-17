class Solution {
    public int maxArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;

        int start = 0;
        int end = heights.length-1;

        while(start<end){
            int currArea = (end - start) * Math.min(heights[start],heights[end]);
            maxArea = Math.max(currArea,maxArea);

            if(heights[start]>heights[end]) end--;
            
            else start++;
        }

        return maxArea;
    }
}
