class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int[][] cost = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int len = j-i+1;
                int best = Integer.MAX_VALUE;
                for(int d=1; d<len; d++){
                    if(len % d != 0) continue;
                    int changes = 0;
                    int groupLen = len / d ;
                    for(int r=0; r<d; r++){
                        for(int t=0; t<groupLen/2; t++){
                            int left = i + r + t*d;
                            int right = i + r + (groupLen - 1 - t)*d;

                            if(s.charAt(left) != s.charAt(right)){
                                changes++;
                            }
                        }
                    }
                    best = Math.min(best, changes);
                }
                cost[i][j] = best;
            }
        }
        int INF = 1000000;

        int[][] dp = new int[k + 1][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }

        dp[0][0] = 0;

        for (int p = 1; p <= k; p++) {

            for (int i = 2 * p; i <= n; i++) {

                for (int j = 2 * (p - 1);
                     j <= i - 2; j++) {

                    dp[p][i] = Math.min(
                        dp[p][i],
                        dp[p - 1][j] + cost[j][i - 1]
                    );
                }
            }
        }
        return dp[k][n];
    }
}