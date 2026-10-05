class Solution {
    public int scoreOfParentheses(String s) {
        int open = 0, count = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)== '('){
                open++;
            }else{
                open--;
                if(s.charAt(i-1) == '('){
                    count += (1 << open);
                }
            }
            if(open < 0){
                return 0;
            }
        }
        return count;
    }
}