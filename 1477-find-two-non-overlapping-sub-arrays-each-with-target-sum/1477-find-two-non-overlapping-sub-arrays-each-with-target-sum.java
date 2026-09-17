class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        int i = 0, sum = 0, ans = n + 1;

        Arrays.fill(dp, n);

        for (int j = 0; j < n; j++) {
            sum += arr[j];

            while (sum > target) {
                sum -= arr[i];
                i++;
            }

            dp[j + 1] = dp[j];

            if (sum == target) {
                ans = Math.min(ans, j - i + 1 + dp[i]);
                dp[j + 1] = Math.min(dp[j], j - i + 1);
            }
        }
        return ans == n + 1 ? -1 : ans;
    }
}