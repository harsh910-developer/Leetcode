class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        Stack<Integer> stk = new Stack<>();
        int max = 0;
        stk.push(-1);
        for(int i=0; i<n; i++){
            if(s.charAt(i) == '('){
                stk.push(i);
            }else{
                stk.pop();
                if(stk.isEmpty()){
                    stk.push(i);
                }else{
                    max = Math.max(max, i - stk.peek());
                }
            }
        }
        return max;
    }
    // public boolean isValid(String s) {
    //     int n = s.length();
    //     Stack<Integer> st = new Stack<>();
    //     int max = 0;
    //     st.push(-1);

    //     for(int i=0; i<n; i++){
    //         if(s.charAt(i) == '('){
    //             st.push(i);
    //         }else{
    //             st.pop();
    //             if(!st.isEmpty()){
    //                 st.push(i);
    //             }else{
    //                 max = Math.max(max, i - st.peek());
    //             }
    //         }
    //     }
    //     return max;

    // }
}
