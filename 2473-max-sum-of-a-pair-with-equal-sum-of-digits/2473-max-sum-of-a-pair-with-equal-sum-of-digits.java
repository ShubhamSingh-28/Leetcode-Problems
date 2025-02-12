class Solution {
    public int isDigit(int num){
        int ans=0;
        while(num>0){
            ans+=num%10;
            num=num/10;
        }
        return ans;
    }
    public int maximumSum(int[] nums) {
        Map<Integer,Integer> map= new HashMap<>();
        int ans=-1;
        for(int num:nums){
            int d= isDigit(num);
            if(map.containsKey(d)){
                int prev = map.get(d);
                ans=Math.max(ans,prev+num);
                map.put(d,Math.max(prev,num));
            }else{
                map.put(d,num);
            }
        }
        return ans;
    }
}