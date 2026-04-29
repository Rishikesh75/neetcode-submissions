class Solution {
    public int maxArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        int area = 0;

        int i = 0;
        int j = heights.length - 1;

        while(i<j){

            area = (j - i) * Math.min(heights[i],heights[j]);
            maxArea = Math.max(area,maxArea);

            if(heights[i] > heights[j])
                j--;
            else
                i++;
        }

        return maxArea;
    }
}
