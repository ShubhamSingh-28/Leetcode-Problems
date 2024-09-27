class Number implements Comparable<Number>{
    int el;
    int freq;
    Number(int el ,  int freq){
        this.el=el;
        this.freq=freq;
    }
    public int compareTo(Number that){
        return that.freq-this.freq;  //decresing order
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Number> pq= new PriorityQueue<>();
        HashMap<Integer, Integer> map =new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            Number num = new Number(entry.getKey(), entry.getValue());
            pq.offer(num);
        }
        int res[]= new int[k];
       int index=0;
        while(index<k){
            Number num= pq.poll();
            res[index]= num.el;
            index++;
        }
        return res;
    }
}