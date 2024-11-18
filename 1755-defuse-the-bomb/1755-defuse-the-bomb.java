class Solution {
    public int[] decrypt(int[] code, int k) {
        int j=0;
        int n=code.length;
        int arr[]= new int[n];
        for(int i=0;i<n;i++){
            int a=Math.abs(k);
            int sum=0;
            if(k==0){
                arr[i]=0;
            } else if(k>0){
                while(a>0){
                    sum+=code[(i+a)%n];
                    a--;
                }
                arr[i]=sum;
            } else{
                while(a>0){
                    sum+=code[(i-a+n)%n];
                    a--;
                }
                arr[i]=sum;
            }
        }
        return arr;
    }
}