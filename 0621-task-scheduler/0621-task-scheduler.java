class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freq[]= new int[26];
        int max=0;
        for(char t:tasks){
            freq[t-'A']++;
            max=Math.max(max,freq[t-'A']);
        }
        int time =(max-1)*(n+1);
        for(int f:freq){
            if(f==max) time++;
        }
        return Math.max(tasks.length,time);
        
    }
}