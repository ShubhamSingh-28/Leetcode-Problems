class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<nums.length;i++){
           for(int j=i+1;j<nums.length;j++){
               int res=nums[i]*nums[j];
               map.put(res,map.getOrDefault(res,0)+1);
           }
        }
        int ans=0;
        for(Map.Entry<Integer,Integer> r:map.entrySet()){
            int prod= r.getKey();
            int count= r.getValue();
            if(count>=2){
                int comb= (count*(count-1))/2;
                ans=ans+comb*8;
            }
        }
        return ans;
    }
}