class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        int len = 0;
        int max = 0;
        for(int i=0; i<seq.length(); i++){
            if(seq.charAt(i) == '('){
                len++;
                ans[i] = len % 2;
            }else if(seq.charAt(i) == ')'){
                ans[i] = len % 2;
                len--;
            }
        }
        return ans;
    }
}