class Solution {
    public boolean primeSubOperation(int[] nums) {
        int k=getMaxElement(nums);
        boolean [] sieve= new boolean[k+1];
        for(int i=0;i<sieve.length;i++){
            sieve[i]=true;
        }
        sieve[1]=false;
        for (int i = 2; i <= Math.sqrt(k + 1); i++) {
            if (sieve[i]) {
                for (int j = i * i; j <= k; j += i) {
                    sieve[j] = false;
                }
            }
        }
        // Check if array can be made strictly increasing by subtracting prime numbers
        int currValue = 1;
        int i = 0;
        while (i < nums.length) {
            int difference = nums[i] - currValue;

            // Return false if current number is already smaller than required value
            if (difference < 0) {
                return false;
            }

            // Move to next number if difference is prime or zero
            if (sieve[difference] == true || difference == 0) {
                i++;
                currValue++;
            } else {
                currValue++;
            }
        }
        return true;

    }

   private int getMaxElement(int[] nums) {
        int max = -1;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

}