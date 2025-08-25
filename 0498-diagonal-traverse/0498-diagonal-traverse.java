class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n=mat.length;
         int m=mat[0].length;
         int res[]= new int[n*m];
         Map<Integer,List<Integer>> mp = new LinkedHashMap<>();

         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if (!mp.containsKey(i + j)) {
                    mp.put(i + j, new ArrayList<>());
                }
                mp.get(i+j).add(mat[i][j]);
            }
         }
         int index=0;
         for (Map.Entry<Integer, List<Integer>> entry : mp.entrySet()) {
             int key = entry.getKey();
             List<Integer> diagonal = entry.getValue();
            if (key % 2 == 0) {
                Collections.reverse(diagonal);
            }
            for (int val : diagonal) {
                res[index++] = val;
            }
        }
        return res;
    }
}