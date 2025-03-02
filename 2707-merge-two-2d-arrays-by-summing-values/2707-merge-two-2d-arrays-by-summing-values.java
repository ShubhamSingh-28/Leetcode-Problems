class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer,Integer> map= new HashMap<>();
        for(int num[]:nums1){
            map.put(num[0],num[1]);
        }
        for(int num[]:nums2){
            int a= num[0];
            int b=num[1];
           if(map.containsKey(a)){
            int temp=b+map.get(a);
            map.put(a,temp);
           } else{
            map.put(a,b);
           }
        }
        int n=map.size();
        int res[][]= new int[n][2];
        int i=0;
        for(Map.Entry<Integer,Integer> ele:map.entrySet()){
            int key=ele.getKey();
            int val= ele.getValue();
            res[i][0]=key;
            res[i][1]=val;
            i++;
        }
        Arrays.sort(res,(a,b)->a[0]-b[0]);
        return res;
    }
}