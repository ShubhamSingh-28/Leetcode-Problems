class Solution {
    private static final int MOD = 1000000007;

    public int[] productQueries(int n, int[][] queries) {
        List<Integer> bins = new ArrayList<>();
        int rep = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                bins.add(rep);
            }
            n /= 2;
            rep *= 2;
        }
        int nt=queries.length;
        int arr [] = new int [nt];
        for(int i =0;i<nt;i++){
            long ans=1;
            int a = queries[i][0];
            int b = queries[i][1];
            for(int j=a;j<=b;j++){
                ans = (ans * bins.get(j)%MOD);
            }
            arr[i]=(int)ans;
        }
        return arr;
    }
}