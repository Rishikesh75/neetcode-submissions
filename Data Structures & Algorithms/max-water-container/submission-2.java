class Solution {
    public int maxArea(int[] heights) {
        
        int i = 0;
        int j = heights.length-1;
        int maxArea = Integer.MIN_VALUE;

        while(i<j){
            int area = (j-i)*Math.min(heights[i],heights[j]);
            maxArea = Math.max(maxArea,area);
            if(heights[i]>heights[j])
                j--;
            else
                i++;
        }

        return maxArea;
    }   
}
