class Solution {
    public int findChampion(int n, int[][] edges) {
        boolean isundefeated[]= new boolean[n];
        //Arrays.fill(isundefeated,true);
        for(int edge[] : edges){
            int w= edge[0];
            int l= edge[1];
            isundefeated[l]=true;
        }
        int champ = -1;
        int count = 0;
        for(int i=0;i<n;i++){
            if(!isundefeated[i]){
                champ=i;
                count++;
            }
        }
        return count==1 ? champ :-1;
    }
}