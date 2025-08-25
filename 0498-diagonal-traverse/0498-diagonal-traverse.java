class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n=mat.length;
         int m=mat[0].length;
         int res[]= new int[n*m];
         Map<Integer,List<Integer>> mp = new HashMap<>();

         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if (!mp.containsKey(i + j)) {
                    mp.put(i + j, new ArrayList<>());
                }
                mp.get(i+j).add(mat[i][j]);
            }
         }
         int index=0;
         for (int k = 0; k <= n + m - 2; k++) {
            List<Integer> diagonal = mp.get(k);
            if (k % 2 == 0) {
                Collections.reverse(diagonal);
            }
            for (int val : diagonal) {
                res[index++] = val;
            }
        }
        return res;
    }
}