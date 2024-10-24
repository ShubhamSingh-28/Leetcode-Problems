class Solution {
    public boolean equationsPossible(String[] equations) {
        int nodes= equations.length;
        DisjointSet dsu= new DisjointSet(26);
        ArrayList<int[]> res= new ArrayList<>();
        for(int i=0;i<nodes;i++){
            String ch= equations[i];
            int u= ch.charAt(0)-'a';
            int v= ch.charAt(3)-'a';
            if(ch.charAt(1)=='='){
                dsu.findUnion(u,v);
            } else{
                res.add(new int[]{u,v});
            }
        }

        for(int a[]:res){
            int u = a[0];
            int v = a[1];

            if( dsu.findParent(u) == dsu.findParent(v)){
                return false;
            }
        }
        return true;
        
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