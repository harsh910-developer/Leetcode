class Solution {
    public long[] resultArray(int[] nums, int k) {
        int n = nums.length;
        long[] result = new long[k];
        long[] dp = new long[k];

        for(int num : nums){
            int x = num % k;
            long[] newDp = new long[k];
            newDp[x]++;

            for(int r=0; r<k; r++){
                if(dp[r] != 0){
                    int newRem = (int) ((long) r*x % k);
                    newDp[newRem] += dp[r];
                }
            }
            dp = newDp;

            for(int r=0; r<k; r++){
                result[r] += dp[r];
            }
        }
        return result;
    }
}