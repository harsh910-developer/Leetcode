class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                nums[i] = -1 * nums[i];
            }
        }
        Arrays.sort(nums);
        long negSum = 0;
        for (int i = 0; i < n / 2; i++) {
            negSum += (long) (nums[i] * nums[i]);
        }
        long posSum = 0;
        for (int i = n / 2; i < n; i++) {
            posSum += (long) (nums[i] * nums[i]);
        }
        long ans = posSum - negSum;
        return ans;
    }
}