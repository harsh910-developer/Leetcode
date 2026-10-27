class Solution {
    public long sumAndMultiply(int n) {
        long num = 0;
        String s = String.valueOf(n);
        int sum = 0;
        for(int i=0; i<s.length(); i++){
            int d = s.charAt(i) - '0';
            if(d!=0){
                num = d + num*10;
                sum += d;
            }
        }
        return num*sum;
    }
}