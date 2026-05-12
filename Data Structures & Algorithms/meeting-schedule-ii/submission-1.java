class Solution {
    public int minMeetingRooms(List<Interval> intervals) {

        if (intervals == null || intervals.size() == 0) {
            return 0;
        }

        // 1. Sort by start time
        intervals.sort((i1, i2) -> i1.start - i2.start);

        // 2. Min heap to track end times
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 3. Add first meeting's end time
        minHeap.add(intervals.get(0).end);

        // 4. Process remaining intervals
        for (int i = 1; i < intervals.size(); i++) {

            Interval curr = intervals.get(i);

            // If a room is free (earliest end <= current start), reuse it
            if (minHeap.peek() <= curr.start) {
                minHeap.poll();
            }

            // Allocate current meeting
            minHeap.add(curr.end);
        }

        // Heap size = number of rooms needed
        return minHeap.size();
    }
}