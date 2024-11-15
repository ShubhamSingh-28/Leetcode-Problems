class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n= arr.length;
        int l=0;
        int r=n-1;

        // prefix code for longest non-decreasing subarray
        while(l<n-1 && arr[l+1]>=arr[l]) ++l;
        if(l==n-1) return 0;
        // suffix code for longest non-decreasing subarray
        while(r>l && arr[r-1]<=arr[r]) --r;
        int ans = Math.min(n-1-l,r);
        for(int i=0, j=r; i<=l && j<n;){
            if(arr[i]<= arr[j]) ans =Math.min(ans, j-i++ -1);
            else ++j;
        }
        return ans;

    }
}