class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        if(k == 1){
            return n;
        }
        int[] dp = new int[n+1];
        
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];

            for (int len = k; len <= i; len++) {
                int l = i - len;
                int r = i - 1;

                if (Check(s, l, r)) {
                    dp[i] = Math.max(dp[i], dp[l] + 1);
                    break;
                }
            }
        }
        return dp[n];
    }
    public boolean Check(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}