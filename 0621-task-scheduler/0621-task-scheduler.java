class Solution {
    public int leastInterval(char[] tasks, int n) {
        int max =0;
        int freq[]= new int[26];
        for(char c:tasks){
            freq[c-'A']++;
            max=Math.max(max,freq[c-'A']);
        }
        int time=(max-1)*(n+1);
        for(int f:freq){
            if(f==max){
                time++;
            }
        }
        return Math.max(tasks.length,time);
    }
}