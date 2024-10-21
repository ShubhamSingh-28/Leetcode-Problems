class Solution {
    public int maxUniqueSplit(String s) {
        HashSet<String> set = new HashSet<>();
        return backTrack(0,s,set);
    }

    public int backTrack(int start, String s,HashSet<String> set){
        if(start == s.length()){
            return 0;
        }
        int max=0;
        for(int end=start+1; end<=s.length(); end++){
            String sh= s.substring(start,end);
            if(!set.contains(sh)){
                set.add(sh);
                max= Math.max(max,1+backTrack(end,s,set));
                set.remove(sh);
            }
        }
        return max;
    }
}