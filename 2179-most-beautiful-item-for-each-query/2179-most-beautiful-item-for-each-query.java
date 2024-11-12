class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int max= Integer.MAX_VALUE;
        List<int []> res=  new ArrayList<>();
        res.add(new int[]{0,0,max});
        Arrays.sort(items, Comparator.comparingInt(a -> a[0]));
        for(int a[] : items){
            int price=a[0];
            int beauty=a[1];

            int last[]= res.get(res.size() - 1);
            if(beauty > last[1]){
                last[2]=price;
                res.add(new int[]{price,beauty,max});
            }
        }
        int [] ans= new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int x=queries[i];
            for(int j= res.size()-1;j>=0;j--){
                if(res.get(j)[0]<=x){
                    ans[i]=res.get(j)[1];
                    break;
                }
            }
        }
        return ans;
    }
}