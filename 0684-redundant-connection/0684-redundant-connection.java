class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n= edges.length;
        int[] res = new int[2];
        DisjointSet dsu= new DisjointSet(n);
        for(int[] edge : edges){
            if(!dsu.findUnion(edge[0]-1,edge[1]-1)){
                res=edge;
            }
        }
        return res;
    }
}

public class DisjointSet{
    int parent[];
    int size[];
    
    DisjointSet(int node){
        this.parent=new int[node];
        this.size=new int[node];
        for(int i=0; i<node;i++){
            parent[i]=i;
            size[i]=1;
        }
    }

    public int findParent(int node){
        if(node==parent[node]){
            return node;
        }
        parent[node]=findParent(parent[node]);
        return parent[node];
    }

    public boolean findUnion(int node1, int node2){
       int rootparent1= findParent(node1);
       int rootparent2= findParent(node2);

       if(rootparent1==rootparent2){
        return false;
       }

       if(size[rootparent1]<size[rootparent2]){
           parent[rootparent1]=rootparent2;
           size[rootparent2]+=size[rootparent1];
       } else{
           parent[rootparent2]=rootparent1;
           size[rootparent1]+=size[rootparent2];
       }
       return true;
    }

}