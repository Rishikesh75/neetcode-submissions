class Solution {
    public int[][] merge(int[][] intervals) {

        // Step 1: Sort based on start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> ans = new ArrayList<>();

        // Step 2: Add first interval
        ans.add(intervals[0]);

        // Step 3: Traverse remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            int[] lastInterval = ans.get(ans.size() - 1);
            int[] currentInterval = intervals[i];

            // Overlapping condition
            if (currentInterval[0] <= lastInterval[1]) {

                // Merge intervals
                lastInterval[1] = Math.max(lastInterval[1], currentInterval[1]);

            } else {

                // No overlap
                ans.add(currentInterval);
            }
        }

        // Step 4: Convert List<int[]> to int[][]
        return ans.toArray(new int[ans.size()][]);
    }
}