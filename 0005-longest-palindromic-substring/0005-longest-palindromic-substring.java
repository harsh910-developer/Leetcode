class Solution {
    public int isPalindrome(String s, int i, int j, int[][] dp){
        int n = s.length();
        if(i>=j){
            return 1;
        }
        if(s.charAt(i) != s.charAt(j)){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        return dp[i][j] = isPalindrome(s, i+1, j-1, dp);
    }
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        int n = s.length();
        int[][] dp = new int[n][n];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(isPalindrome(s, i, j, dp) == 1 && (j-i+1 > end-start+1)){
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end+1);
    }
}