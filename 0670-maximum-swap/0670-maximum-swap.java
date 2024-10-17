class Solution {
    public int maximumSwap(int num) {
        // char arr[]= Integer.toString(num).toCharArray();
        // int n= arr.length;
        // char max='0';
        // int m= 0;
        // for(int i=0;i<n;i++){
        //     if(arr[i]>max){
        //         max=arr[i];
        //         m=i;
        //     }
        // }
        // if(max==arr[0]){
        //     return Integer.parseInt(new String(arr)) ;
        // } 
        //  char temp=arr[m];
        // arr[m]=arr[0];
        // arr[0]=temp;
        // return Integer.parseInt(new String(arr)) ;
        int res = num, place = 10, n = num / 10;
        int maxDigit = num % 10, maxPlace = 1;
        while (n != 0){
            int d = n % 10;
            if (maxDigit > d)
                res = (num - d * place) + (maxDigit * place) - (maxDigit * maxPlace) + (d * maxPlace);
            else if (d != maxDigit) {
                maxDigit = d;
                maxPlace = place;
            }
            place *= 10;
            n /= 10;
        }
        return res;  
    }
}