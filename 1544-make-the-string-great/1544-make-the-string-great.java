class Solution {
    public String makeGood(String s) {
        StringBuilder str = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            int n = str.length();
            if(n > 0 && Math.abs(str.charAt(n-1) - s.charAt(i)) == 32){
                str.deleteCharAt(n-1);
            }
            else{
                str.append(s.charAt(i));
            }
        }
        return str.toString();
    }
}