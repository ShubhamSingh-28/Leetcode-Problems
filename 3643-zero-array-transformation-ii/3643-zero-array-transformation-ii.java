class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length, left = 0, right = queries.length;

        // Zero array isn't formed after all queries are processed
        if (!currentIndexZero(nums, queries, right)) return -1;

        // Binary Search
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (currentIndexZero(nums, queries, middle)) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        // Return earliest query that zero array can be formed
        return left;
    }

    private boolean currentIndexZero(int[] nums, int[][] queries, int k) {
        int n = nums.length, sum = 0;
        int[] differenceArray = new int[n + 1];

        // Process query
        for (int queryIndex = 0; queryIndex < k; queryIndex++) {
            int left = queries[queryIndex][0], right =
                queries[queryIndex][1], val = queries[queryIndex][2];

            // Process start and end of range
            differenceArray[left] += val;
            differenceArray[right + 1] -= val;
        }

        // Check if zero array can be formed
        for (int numIndex = 0; numIndex < n; numIndex++) {
            sum += differenceArray[numIndex];
            if (sum < nums[numIndex]) return false;
        }
        return true;
    }

    // brute force
    // public boolean hasZero(int [] nums){
    //     for(int n:nums){
    //         if(n>0){
    //             return false;
    //         }
    //     }
    //    return true;
    // }
    // public int minZeroArray(int[] nums, int[][] queries) {
    //     // brute force pass 624/627 test case.
    //    int count=0;
    //    if(hasZero(nums)) return count;
    //    for(int q[]:queries){
    //     int l=q[0];
    //     int r=q[1];
    //     int val= q[2];
    //     for(int i=l;i<=r;i++){
    //         nums[i]=Math.max(0,nums[i]-val);
    //     }
    //     count++;
    //     if(hasZero(nums)) return count;
    //    }  
    //    return -1;
    // }
}