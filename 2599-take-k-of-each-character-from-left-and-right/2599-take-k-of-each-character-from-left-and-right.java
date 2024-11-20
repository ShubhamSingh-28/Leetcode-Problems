class Solution {
    public int takeCharacters(String s, int k) {
        int left =0;
        int arr[] = new int[3];
        int n=s.length();
        int ans=Integer.MAX_VALUE;
        for(char c : s.toCharArray()){
            arr[c -'a']++;
        }
        if(Math.min(Math.min(arr[0],arr[1]),arr[2])<k) return -1;

        for(int i=0;i<n;i++){
            arr[s.charAt(i) - 'a']--;
            while(Math.min(Math.min(arr[0],arr[1]),arr[2])<k){
                arr[s.charAt(left) - 'a']++;
                left++;
            }
            ans= Math.min(ans, n-(i-left+1));
        }
        return ans;
        
    }
}