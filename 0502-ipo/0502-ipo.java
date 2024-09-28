class Number implements Comparable<Number>{
    int profits;
    int capitals;
    Number( int profits, int capitals){
         this.capitals=capitals;
         this.profits =profits;
    }
    public int compareTo(Number that){
        return this.capitals-that.capitals;
    }
}
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Number> minpq= new PriorityQueue<>();
        int n= capital.length;
        for(int i=0;i<n;i++){
            minpq.offer(new Number(profits[i], capital[i]));
        }
        PriorityQueue<Integer> maxpq= new PriorityQueue<>(Collections.reverseOrder());
        while(k>0){
            while(!minpq.isEmpty() && minpq.peek().capitals<=w){
                maxpq.offer(minpq.poll().profits);
            }
            if(maxpq.isEmpty()) break;
            w+=maxpq.poll();
            k--;
        }
        return w;
    }
}