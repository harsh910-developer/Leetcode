class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }

        String s = String.valueOf(x);
        String rev = new StringBuilder(s).reverse().toString();

        return s.equals(rev);
    }
}