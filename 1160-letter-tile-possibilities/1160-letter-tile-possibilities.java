class Solution {
    public int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<>();
        boolean used[]= new boolean[tiles.length()];
        backtrack(tiles,set,used,"");
        return set.size()-1;
    }
    public void backtrack(String tiles,Set<String> set ,boolean used[], String cur){
        if(set.contains(cur)){
            return ;
        }
        set.add(cur);
        for(int i=0;i<tiles.length();i++){
            if(used[i])continue;
            used[i]=true;
            backtrack(tiles,set,used,cur+tiles.charAt(i));
            used[i]=false;
        }
    }
}