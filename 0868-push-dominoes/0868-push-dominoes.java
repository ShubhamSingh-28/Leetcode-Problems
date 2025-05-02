class Solution {
    public String pushDominoes(String dominoes) {
        char arr[]= dominoes.toCharArray();
        int N = arr.length;
        int[] forces = new int[N];
        int f=0;
        for(int i=0;i<N;i++){
            if(arr[i]=='L') f=0;
            else if(arr[i]=='R') f=N;
            else f=Math.max(f-1,0);
            forces[i]+=f;
        }

        for(int i=N-1;i>=0;i--){
            if(arr[i]=='L') f=N;
            else if(arr[i]=='R') f=0;
            else f=Math.max(f-1,0);
            forces[i]-=f;
        }
        StringBuilder st=new StringBuilder();
        for(int fr:forces){
            st.append(fr>0 ? 'R':fr<0 ? 'L':'.');
        }
        return st.toString();
    }
}