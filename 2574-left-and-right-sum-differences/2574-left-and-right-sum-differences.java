class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int leftSum = 0;
        int total = 0;
        int[] ans = new int[n];
        for(int num : nums){
            total += num;
        }
        for(int i=0; i<n; i++){
            int rightSum = total - leftSum - nums[i];
            ans[i] = Math.abs(rightSum - leftSum);
            leftSum += nums[i];
        }
        return ans;
    }
}