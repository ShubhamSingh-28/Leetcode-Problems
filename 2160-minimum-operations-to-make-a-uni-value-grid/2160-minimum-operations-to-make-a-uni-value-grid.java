class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m= grid[0].length;
        int [] res=new int[n*m];
        int i=0;
         // Step 1: Check if it's possible to make the grid uni-value
        int baseValue = grid[0][0];
        for (int[] row : grid) {
            for (int val : row) {
                if (Math.abs(val - baseValue) % x != 0) {
                    return -1;
                }
            }
        }
        
        for(int g[]:grid){
            for(int a:g){
                res[i]=a;
                i++;
            }
        }
        Arrays.sort(res);
        int len=(m*n)/2;
        int med=res[len];
        int result=0;
        for(int r:res){
            if(r<med){
                int ans=med-r;
                result+=ans/x;
            }else{
                int ans2=r-med;
                result+=ans2/x;
            }
        }
        return result;
    }
}