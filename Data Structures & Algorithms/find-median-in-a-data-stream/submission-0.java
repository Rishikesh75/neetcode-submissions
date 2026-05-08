class MedianFinder {

    // Max Heap -> stores smaller half
    private PriorityQueue<Integer> left;

    // Min Heap -> stores larger half
    private PriorityQueue<Integer> right;

    public MedianFinder() {

        // Max Heap
        left = new PriorityQueue<>((a, b) -> b - a);

        // Min Heap
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {

        // Step 1: Add to max heap
        left.offer(num);

        // Step 2: Move largest from left to right
        right.offer(left.poll());

        // Step 3: Balance heaps
        if (right.size() > left.size()) {
            left.offer(right.poll());
        }
    }
    
    public double findMedian() {

        // If both heaps have same size
        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        }

        // Max heap has one extra element
        return left.peek();
    }
}