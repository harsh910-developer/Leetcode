class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stk = new Stack<>();
        stk.push(0);

        for(char ch : s.toCharArray()){
            if(ch == '('){
                stk.push(0);
            }else{
                int inner = stk.pop();
                int score = (inner == 0) ? 1 : 2*inner;

                stk.push(stk.pop() + score);
            }
        }
        return stk.pop();
    }
}