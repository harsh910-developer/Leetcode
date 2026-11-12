class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int desc = 1;
        int inc = 1;
        int ans = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                desc++;
                inc = 1;
            } else if (nums[i] > nums[i - 1]) {
                desc = 1;
                inc++;
            } else {
                desc = inc = 1;
            }
            ans = Math.max(ans, Math.max(desc, inc));
        }
        return ans;
    }
}