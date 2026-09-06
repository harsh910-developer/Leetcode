class Solution {
    // public int helper(String s, String t, int i, int j, int[][] dp){
    //     if(i == t.length()) return 1;
    //     if(j == s.length()) return 0;
    //     if(dp[i][j] != -1) return dp[i][j];

    //     int take = 0;

    //     if(s.charAt(j) == t.charAt(i)){
    //         take = helper(s,t,i+1,j+1,dp);
    //     }
    //     int skip = helper(s,t,i,j+1,dp);
    //     return take+skip;
    // }
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length()+1][s.length()+1];
        for (int j = 0; j <= s.length(); j++) {
            dp[t.length()][j] = 1;
        }
        for(int i=t.length()-1; i>=0; i--){
            for(int j=s.length()-1; j>=0; j--){
                if(s.charAt(j) == t.charAt(i)){
                    dp[i][j] = dp[i+1][j+1];
                }
                dp[i][j] += dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}