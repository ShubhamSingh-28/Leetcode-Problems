class Solution {
    public int[] closestPrimes(int left, int right) {
       
        List<Integer> res=new ArrayList<>();
        for(int i=left;i<=right;i++){
            if(isPrime(i)){
                res.add(i);
            }
        }
        if(res.size()<2){
            return new int[]{-1,-1};
        }
        int ans[]= new int[2];
        int min = Integer.MAX_VALUE;
        for(int i=1;i<res.size();i++){
            int diff = res.get(i) - res.get(i - 1);
            if (diff < min) {
                min = diff;
                ans[0] = res.get(i - 1);
                ans[1] = res.get(i);
            }
        }
        return ans;
    }
    public boolean isPrime(int val){
         if (val <= 1) {
            return false; // Numbers less than or equal to 1 are not prime
        }
        for(int i=2;i<=Math.sqrt(val);i++){
            if(val%i ==0) return false;
        }
        return true;
    }
}