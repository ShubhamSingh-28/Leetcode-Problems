class Solution {
    public int countLargestGroup(int n) {
        Map<Integer,Integer> map= new HashMap<>();
        for(int i=1;i<=n;i++){
            int sum=digitsum(i);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        int c=1;
        int max=0;
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            int val=m.getValue();
            if(val>max){
                max=val;
                c=1;
            }else if(val==max)c++;
        }
        return c;
    }
    public int digitsum(int val){
        int sum=0;
        while(val!=0){
            sum+=val%10;
            val/=10;
        }
        return sum;
    }
}