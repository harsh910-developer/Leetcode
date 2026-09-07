class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();

        Stack<Integer> st = new Stack<>();
        int max = 0;
        st.push(-1);

        for(int i=0; i<n; i++){
            if(s.charAt(i) == '('){
                st.push(i);
            }else{
                st.pop();
                if(st.isEmpty()){
                    st.push(i);
                }else{
                    max = Math.max(max, i - st.peek());
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
