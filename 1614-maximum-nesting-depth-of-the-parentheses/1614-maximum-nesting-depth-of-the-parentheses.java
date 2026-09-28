class Solution {
    public int maxDepth(String s) {
        int len = 0;
        int maxLen = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                len++;
                maxLen = Math.max(maxLen, len);
            } else if(c == ')') {
                len--;
            }
        }
        return maxLen;
    }
}