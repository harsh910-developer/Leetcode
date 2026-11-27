class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] freeFrom = new int[n];
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int fi = items[i][0];
            minPrice = Math.min(minPrice, items[i][1]);
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % fi == 0) {
                    cnt++;
                }
            }
            freeFrom[i] = cnt;
        }

        int[] dp = new int[budget + 1];
        for (int i = 0; i < n; i++) {
            int price = items[i][1];
            int val = 1 + freeFrom[i];
            for (int c = budget; c >= price; c--) {
                dp[c] = Math.max(dp[c], dp[c - price] + val);
            }
        }

        int ans = 0;
        for (int c = 0; c <= budget; c++) {
            ans = Math.max(ans, dp[c] + (budget - c) / minPrice);
        }
        return ans;
    }
}