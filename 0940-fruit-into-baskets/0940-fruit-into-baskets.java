class Solution {
    public int totalFruit(int[] fruits) {
        int res=0,start=0,end=0;
        int n=fruits.length;
        Map<Integer,Integer> map = new HashMap<>();
        while(end<n){
            map.put(fruits[end],map.getOrDefault(fruits[end],0)+1);
            while(map.size()>=3){
                map.put(fruits[start],map.get(fruits[start])-1);
                if(map.get(fruits[start])==0) map.remove(fruits[start]);
                start++;
            }
            int cur=end-start+1;
            res=Math.max(res,cur);
            end++;
        }
        return res;
    }
}