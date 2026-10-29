class Solution {
    public int calculate(String s) {
        Stack<Integer> stk = new Stack<>();
        int res = 0;
        int num = 0;
        int sign = 1;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }else if(ch == '+'){
                res += sign * num;
                num = 0;
                sign = 1;
            }else if(ch == '-'){
                res += sign * num;
                num = 0;
                sign = -1;
            }else if(ch == '('){
                stk.push(res);
                stk.push(sign);

                res = 0;
                num = 0;
                sign = 1;
            }else if(ch == ')'){
                res += num * sign;
                num = 0;

                res *= stk.pop();
                res += stk.pop();
            }
        }
        return res + sign*num;

    }
}