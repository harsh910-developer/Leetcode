class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        int result = 0;
        
        Arrays.fill(dp, 1);

        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}