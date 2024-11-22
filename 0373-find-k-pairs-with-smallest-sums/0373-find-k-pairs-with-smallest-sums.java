class Solution {
    class Pair implements Comparable<Pair>{
        int a;
        int b;
        int c;
        Pair(int x, int y, int z){
            this.a=x;
            this.b=y;
            this.c=z;
        }
        public int compareTo(Pair that){
        //     int sumThis = this.a + this.b;  // Sum of current Pair's a and b
        //     int sumThat = that.a + that.b;  // Sum of the other Pair's a and b

        // // Compare the sums
        //     if (sumThis < sumThat) {
        //         return -1;  // this object is smaller
        //     } else if (sumThis > sumThat) {
        //         return 1;   // this object is greater
        //     } else {
        //         return 0;   // both objects have the same sum
        //     }
               return this.a-that.a;
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> list = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // for(int i=0;i<nums1.length;i++){
        //     for(int j=0;j<nums2.length;j++){
        //         Pair p= new Pair(nums1[i], nums2[j]);
        //         pq.add(p);
        //     }
        // }

        for(int i=0;i<Math.min(k,nums1.length);i++){
            pq.add(new Pair(nums1[i]+nums2[0],i,0));
        }

        int counter=0;
        while(!pq.isEmpty()&& counter<k){
            Pair pair = pq.poll();
            int i = pair.b;
            int j = pair.c;
            list.add(Arrays.asList(nums1[i],nums2[j]));
            int next = j+1;
            if(nums2.length>next){
                pq.add(new Pair(nums1[i]+nums2[next],i,next));
            }
            counter++;
        }
        return list;
    }
}