class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int m= queries.length;
        int n= nums.length;
        boolean res[] = new boolean[m];
        int count[]= new int[n];
        count[0]=0;
        for(int j=1;j<n;j++){
            // int q[]= queries[j];
            // int s = q[0];
            // int e = q[1];
            // res[j]=isSpecial(nums,s,e);
            int parity= (nums[j]%2==nums[j-1]%2)?1:0;
            count[j]= count[j-1]+parity;
        }

        for(int i=0;i<m;i++){
            int start= queries[i][0];
            int end= queries[i][1];
            res[i]=count[end]-count[start]==0;
        }
        return res;
    }

    // brute force
//     // Debugging code with print statements
// public boolean isSpecial(int[] nums, int s, int e) {
//     if (e - s == 1) {
//         return true;
//     }

//     for (int i = s; i <=e - 1; i++) {
//        // System.out.println("Checking pair: " + nums[i] + ", " + nums[i + 1]);
//         if ((nums[i] % 2 == 0 && nums[i + 1] % 2 == 0) || 
//             (nums[i] % 2 != 0 && nums[i + 1] % 2 != 0)) {
//             //System.out.println("Same parity found: " + nums[i] + ", " + nums[i + 1]);
//             return false;
//         }
//     }
//     return true;
// }

}