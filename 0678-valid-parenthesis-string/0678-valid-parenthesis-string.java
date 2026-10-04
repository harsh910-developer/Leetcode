class Solution {
    public boolean checkValidString(String s) {
        int maxOpen = 0;
        int minOpen = 0;

        for(char ch : s.toCharArray()){
            if(ch == '('){
                maxOpen++;
                minOpen++;
            }else if(ch == ')'){
                maxOpen--;
                minOpen--;
            }else{
                maxOpen++;
                minOpen--;
            }
            if(maxOpen < 0){
                return false;
            }
            minOpen = Math.max(minOpen, 0);
        }
        return minOpen == 0;
    }
}