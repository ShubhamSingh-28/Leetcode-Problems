// class NumberContainers {
//     Comparator<Integer> reverseComparator = (key1, key2) -> key1.compareTo(key2);
//     TreeMap<Integer, Integer> map = new TreeMap<>(reverseComparator);
//     public NumberContainers() {
//     }
    
//     public void change(int index, int number) {
//         map.put(index,number);
//     }
    
//     public int find(int number) {
//         for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//             if(entry.getValue()==number){
//                 return entry.getKey();
//             }
//         }
//         return -1;
//     }
// }

// /**
//  * Your NumberContainers object will be instantiated and called as such:
//  * NumberContainers obj = new NumberContainers();
//  * obj.change(index,number);
//  * int param_2 = obj.find(number);
//  */

class NumberContainers {

    public NumberContainers() {
        numberToIndices = new HashMap<>();
        indexToNumbers = new HashMap<>();
    }

    public void change(int index, int number) {
        // Update index to number mapping
        indexToNumbers.put(index, number);

        // Add index to the min heap for this number
        numberToIndices
            .computeIfAbsent(number, k -> new PriorityQueue<>())
            .add(index);
    }

    public int find(int number) {
        // If number doesn't exist in our map
        if (!numberToIndices.containsKey(number)) {
            return -1;
        }

        // Get min heap for this number
        PriorityQueue<Integer> minHeap = numberToIndices.get(number);

        // Keep checking top element until we find valid index
        while (!minHeap.isEmpty()) {
            int index = minHeap.peek();

            // If index still maps to our target number, return it
            if (indexToNumbers.get(index) == number) {
                return index;
            }

            // Otherwise remove this stale index
            minHeap.poll();
        }

        return -1;
    }

    // Map to store number -> min heap of indices
    private Map<Integer, PriorityQueue<Integer>> numberToIndices;
    // Map to store index -> number
    private Map<Integer, Integer> indexToNumbers;
}
/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */