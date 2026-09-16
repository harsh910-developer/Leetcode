class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0;
        int b = 0;
        int c = 0;
        for (int i = 1; i < n; i++) {
            int next1 = dp[a] * 2;
            int next2 = dp[b] * 3;
            int next3 = dp[c] * 5;

            dp[i] = Math.min(next1, Math.min(next2, next3));

            if (dp[i] == next1)
                a++;
            if (dp[i] == next2)
                b++;
            if (dp[i] == next3)
                c++;
        }
        return dp[n-1];
    }
}