class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int s= 0;
        int e=arr.length-1;
        while(e-s>=k){
            if(Math.abs(x-arr[s])>Math.abs(arr[e]-x)){
                s++;
            } else{
                e--;
            }
        }
        for(int i=s;i<=e;i++){
            res.add(arr[i]);
        }
        return res;
    }
}