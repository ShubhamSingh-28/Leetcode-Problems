class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n=s1.length();
        DisJoint dsu=new DisJoint(26);
        for(int i=0;i<n;i++){
            dsu.findUnion(s1.charAt(i)-'a',s2.charAt(i)-'a');
        }
        StringBuilder res= new StringBuilder();
        for(int i=0;i<baseStr.length();i++){
            res.append((char)(dsu.findparent(baseStr.charAt(i)-'a')+'a'));
        }
        return res.toString();
    }
}

    class DisJoint{
        int parent[];
        //int size[];

        DisJoint(int node){
            parent= new int[node];
            //size= new int [node];
            for(int i=0 ;i<node;i++){
                parent[i]=i;
                //size[i]=1;
            }
        }

        public int findparent(int a){
            if(a==parent[a]){
                return a;
            }
            parent[a] = findparent(parent[a]);
            return parent[a];
        }

        public void findUnion(int node1, int node2){
            int rootparent1= findparent(node1);
            int rootparent2= findparent(node2);

            if(rootparent1==rootparent2){
               return ;
            }
            // if(size[rootparent1]<size[rootparent2]){
            //     parent[rootparent1]=rootparent2;
            //     size[rootparent2]+=size[rootparent1];
            // } else{
            //     parent[rootparent2]=rootparent1;
            //     size[rootparent1]+=size[rootparent2];
            // }

            if(rootparent1 < rootparent2){
                parent[rootparent2]=rootparent1;
            } else{
                 parent[rootparent1]=rootparent2;
            }
        }
    }