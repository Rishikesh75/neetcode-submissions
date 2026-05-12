class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals.length == 0) return 0;

        // Step 1: Sort by end time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 0; // number of intervals removed
        int prevEnd = intervals[0][1];

        // Step 2: Traverse intervals
        for (int i = 1; i < intervals.length; i++) {

            // Overlap condition
            if (intervals[i][0] < prevEnd) {
                count++; // remove this interval
            } else {
                // no overlap → update end
                prevEnd = intervals[i][1];
            }
        }

        return count;
    }
}