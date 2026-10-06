class Solution {
    // public boolean isValid(String s){

    // }
    public int minAddToMakeValid(String s) {
        int open = 0;
        int amb = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                } else {
                    amb++;
                }
            }
        }
        return amb + open;
    }
}