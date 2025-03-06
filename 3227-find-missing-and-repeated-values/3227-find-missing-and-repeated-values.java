class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {

        Map<Integer,Integer> map = new HashMap<>();
        for(int g[]:grid){
            for(int r:g){
                map.put(r,map.getOrDefault(r,0)+1);
            }
        }
        int n=grid.length;
        int repeat=0;
        int miss=0;
        for(int i=1;i<=n*n;i++){
            if(!map.containsKey(i)){
                miss=i;
            }else if(map.get(i)==2){
                repeat=i;
            }
        }
        return new int[]{repeat,miss};

        // cycle sort approach
        // List<Integer> ls= new ArrayList<>();
        // for(int[] g:grid){
        //     for(int r:g){
        //         ls.add(r);
        //     }
        // }
        // cycle(ls);
        // int res[]= new int[2];
        // for(int i=0;i<ls.size();i++){
        //     if(i+1!=ls.get(i)){
        //         res[0]=ls.get(i);
        //         res[1]=i+1;
        //     }
        // }
        // //System.out.println(ls);
        // return res;
    }

    // public void cycle(List<Integer> ls){
    //     int i=0;
    //     int n = ls.size();
        
    //     while(i<n){
    //         int ele = ls.get(i);
    //         int ai = ele-1;
    //         if(ls.get(i)<n && ls.get(i)!=ls.get(ai)){
    //             swap(i,ai,ls);
    //         } else{
    //             i++;
    //         }
    //     }
    // }
    // public void swap(int i,int j, List<Integer> ls){
    //     int temp = ls.get(i);
    //     ls.set(i,ls.get(j));
    //     ls.set(j,temp);
    // }
}