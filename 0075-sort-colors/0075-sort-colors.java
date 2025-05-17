class Solution {
    public void sortColors(int[] nums) {
       Map<Integer,Integer> map= new HashMap<>();
       for(int n:nums){
        map.put(n,map.getOrDefault(n,0)+1);
       }
       int i=0; 
       int m= nums.length;
       while(i<m && map.containsKey(0)){
        nums[i]=0;
        map.put(0,map.get(0)-1);
        if(map.get(0)==0) map.remove(0);
        i++;
       }
       while(i<m && map.containsKey(1)){
        nums[i]=1;
        map.put(1,map.get(1)-1);
        if(map.get(1)==0) map.remove(1);
        i++;
       }
       while(i<m && map.containsKey(2)){
        nums[i]=2;
        map.put(2,map.get(2)-1);
        if(map.get(2)==0) map.remove(2);
        i++;
       }
    }
}