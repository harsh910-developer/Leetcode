class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder str = new StringBuilder();
        int open = 0;
        for(char ch :  s.toCharArray()){
            if(ch == '('){
                if(open > 0){
                    str.append(ch);
                }
                open++;
            }else{
                open--;
                if(open > 0){
                    str.append(ch);
                }
            }
        }
        return str.toString();
    }
}