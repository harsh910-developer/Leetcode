class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();

        String rev = new StringBuilder(s).reverse().toString();

        return s.equals(rev);
    }
}