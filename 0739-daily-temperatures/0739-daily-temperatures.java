class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int res[]= new int[n];
        Stack<Integer> st= new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int ind=st.pop();
                res[ind]=i-ind;
            }
            st.push(i);
        }
        //  47/48 test case pass
        // for(int i=0;i<n;i++){
        //     int a=1;
        //     for(int j=i+1;j<n;j++){
        //         if(temperatures[j]>temperatures[i]){
        //             res[i]=a;
        //             break;
        //         }
        //         a++;
        //     }
        // }
        return res;
    }
}