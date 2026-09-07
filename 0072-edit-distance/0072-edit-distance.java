class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m][n];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(word1, word2, 0, 0, dp);
    }
    public int solve(String s1, String s2, int i, int j, int[][] dp){
        if(s1.length() == i){
            return s2.length()-j;
        }
        if(s2.length() == j){
            return s1.length()-i;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j)){
            dp[i][j] = solve(s1, s2, i+1, j+1, dp);
        } else {
            int a = solve(s1, s2, i, j+1, dp);
            int b = solve(s1, s2, i+1, j, dp);
            int c = solve(s1, s2, i+1, j+1, dp);

            dp[i][j] = 1 + Math.min(a, Math.min(b ,c));
        }
        return dp[i][j];
    }
}