class Solution {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> stk = new Stack<>();
        stk.push(new StringBuilder());

        for(char ch : s.toCharArray()){
            if(ch == '('){
                stk.push(new StringBuilder());
            }else if(ch == ')'){
                StringBuilder curr = stk.pop();
                curr.reverse();
                stk.peek().append(curr);
            }else{
                stk.peek().append(ch);
            }
        }
        return stk.peek().toString();
    }
}