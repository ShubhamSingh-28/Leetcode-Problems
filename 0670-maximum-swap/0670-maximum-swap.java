class Solution {
    public int maximumSwap(int num) {
        char arr[]= Integer.toString(num).toCharArray();
        int n= arr.length;
        char max=arr[n-1];
        int m= n-1;
        int s1=-1;
        int s2=-1;
        for(int i=n-2;i>=0;i--){
            if(arr[i]>max){
                max=arr[i];
                m=i;
            } else if(arr[i]<max){
                s1=i;
                s2=m;
            }
        }

        if(s1 != -1){
            char temp=arr[s1];
            arr[s1]=arr[s2];
            arr[s2]=temp;
        } 
        return Integer.parseInt(new String(arr)) ;



        // int res = num, place = 10, n = num / 10;
        // int maxDigit = num % 10, maxPlace = 1;
        // while (n != 0){
        //     int d = n % 10;
        //     if (maxDigit > d)
        //         res = (num - d * place) + (maxDigit * place) - (maxDigit * maxPlace) + (d * maxPlace);
        //     else if (d != maxDigit) {
        //         maxDigit = d;
        //         maxPlace = place;
        //     }
        //     place *= 10;
        //     n /= 10;
        // }
        // return res;  
    }
}