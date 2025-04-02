class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> m=  new HashMap<>();
        int c =0;
        int maxl=0;
        m.put(0, -1);
        for(int i=0;i<nums.length;i++){
            c=c+(nums[i]==1?1:-1);
            if(m.containsKey(c)){
                maxl = Math.max(maxl,i-m.get(c));
            }else{
                m.put(c,i);
            }
        }
        return maxl;
    }
}