
class Solution {
    int threshold;
    int count;
    int[][] grid;
    boolean[][] visit;
    Queue<int[]> queue;
    public int[] maxPoints(int[][] grid, int[] queries) {
        this.grid = grid;
        int m = grid.length;
        int n = grid[0].length;

        visit = new boolean[m][n];
        queue = new PriorityQueue<>((c1, c2) -> c1[2]-c2[2]);
        List<int[]> list = new ArrayList<>();

        threshold = 0;
        count = 0;
        visit[0][0] = true;
        queue.offer(new int[] {0, 0, grid[0][0]});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            if (threshold < cell[2]) {
                list.add(new int[] {threshold, count});
                threshold = cell[2];
            }
            count++;
            dfs(cell);
        }
        list.add(new int[] {threshold, count});

        for (int i = 0; i < queries.length; i++) queries[i] = search(list, queries[i]);
        return queries;
    }

    private int search(List<int[]> list, int query) {
        int l = 0;
        int r = list.size();
        while (l < r) {
            int m = (l+r)/2;
            if (list.get(m)[0] >= query) r = m;
            else l = m+1;
        }
        return list.get(l-1)[1];
    }

    private void dfs(int[] cell) {
        int m = grid.length;
        int n = grid[0].length;
        if (cell[0] > 0 && !visit[cell[0]-1][cell[1]]) process(new int[] {cell[0]-1, cell[1], grid[cell[0]-1][cell[1]]});
        if (cell[0] < m-1 && !visit[cell[0]+1][cell[1]]) process(new int[] {cell[0]+1, cell[1], grid[cell[0]+1][cell[1]]});
        if (cell[1] > 0 && !visit[cell[0]][cell[1]-1]) process(new int[] {cell[0], cell[1]-1, grid[cell[0]][cell[1]-1]});
        if (cell[1] < n-1 && !visit[cell[0]][cell[1]+1]) process(new int[] {cell[0], cell[1]+1, grid[cell[0]][cell[1]+1]});
    }

    private void process(int[] cell) {
        visit[cell[0]][cell[1]] = true;
        if (cell[2] > threshold) queue.offer(cell);
        else {
            count++;
            dfs(cell);
        }
    }
}

// dfs aproach 17/21 testcases passed and giving (tle)

// class Solution {
//     public int[] maxPoints(int[][] grid, int[] queries) {
//         int n=grid.length;
//         int m= grid[0].length;
//         int res[]= new int[queries.length];
//         boolean visit[][];
//         for(int i=0;i<queries.length;i++){
//             visit=new boolean[n][m];
//             res[i]=dfs(grid,queries[i],0,0,visit);
//         }
//         return res;
//     }
//     public int dfs(int[][] grid,int val,int i, int j,boolean visit[][]){
//         if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || visit[i][j] || grid[i][j]>=val){
//             return 0;
//         }
//         visit[i][j]=true;
//         int c=1;
//         c+= dfs(grid,val,i+1,j,visit);
//         c+= dfs(grid,val,i-1,j,visit);
//         c+= dfs(grid,val,i,j+1,visit);
//         c+= dfs(grid,val,i,j-1,visit);
//         return c;
//     }
// }
