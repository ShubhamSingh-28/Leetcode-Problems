class MedianFinder {
    PriorityQueue<Integer> maxh;
    PriorityQueue<Integer> minh;
    public MedianFinder() {
        maxh=new PriorityQueue<>(Collections.reverseOrder());
        minh=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
         if (maxh.isEmpty() || num <= maxh.peek()) {
            maxh.offer(num);
        } else {
            minh.offer(num);
        }
        // If maxh has more than one extra element, move the root to minh
        if (maxh.size() > minh.size() + 1) {
            minh.add(maxh.poll());
        }

        // If minh has more elements than maxh, move the root of minh to maxh
        if (minh.size() > maxh.size()) {
            maxh.add(minh.poll());
        }
    }
    
    public double findMedian() {
         if (maxh.size() > minh.size()) {
            // If maxh has more elements, the median is the root of maxh
            return maxh.peek();
        } else {
            // If both heaps are of equal size, the median is the average of the roots
            return (maxh.peek() + minh.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */