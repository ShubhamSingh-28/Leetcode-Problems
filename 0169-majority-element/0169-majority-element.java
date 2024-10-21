class Solution {
    public int majorityElement(int[] nums) {
        // 1st way
        // HashMap<Integer,Integer> map= new HashMap<>();
        // int ans=-1;
        // for(int i: nums){
        //     map.put(i,map.getOrDefault(i,0)+1);
        //     if(map.get(i)>m){
        //         ans=  i;
        //     }
        // }
        // return ans;

       // 2nd way 
       int count =0;
       int ans=0;
       for(int n:nums){
        if(count==0){
            ans=n;
        }
        if(ans==n){
            count++;
        } else{
            count--;
        }
       }

       return ans;
    }
}