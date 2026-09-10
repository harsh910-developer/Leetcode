class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();
        int[][] dp = new int[n+1][n+1];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(checkPalindrome(s, i, j, dp)){
                    count++;
                }
            }
        }
        return count;
    }
    public boolean checkPalindrome(String s, int left, int right, int[][] dp){
        if (left >= right) {
            return true;
        }
        if (dp[left][right] != -1) {
            return dp[left][right] == 1;
        }
        if (s.charAt(left) != s.charAt(right)) {
            dp[left][right] = 0;
            return false;
        }
        boolean result = checkPalindrome(s, left + 1, right - 1, dp);
        dp[left][right] = result ? 1 : 0;
        return result;
    }
}