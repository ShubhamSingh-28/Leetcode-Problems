class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int price[]= new int[n];
        Arrays.fill( price, Integer.MAX_VALUE);
        price[src]=0;
        for(int i=0;i<k+1;i++){
            int temp[]=Arrays.copyOf(price,n);
            for(int a[]: flights){
                int u= a[0];
                int v=a[1];
                int w=a[2];
                if(price[u] != Integer.MAX_VALUE && price[u] + w < temp[v]){
                    temp[v] = price[u] + w;
                }
            }
            price=temp;
        }
        return (price[dst]==Integer.MAX_VALUE)?-1:price[dst];
    }
}