class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set=new HashSet<>();
        for(int i:banned){
            set.add(i);
        }
        int ans=0;
        int sum=0;
        for(int i=1;i<=n;i++){
            if(!set.contains(i)){
                if(sum+i<=maxSum){
                 ans++;
                 sum+=i;
                }
            }
        }
        return ans;
    }
}