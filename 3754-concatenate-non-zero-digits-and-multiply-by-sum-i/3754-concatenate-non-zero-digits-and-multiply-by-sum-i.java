class Solution {
    public long sumAndMultiply(int n) {
        long num = 0, sum = 0, rev = 0;
        while(n > 0){
            int d = n % 10;
            if(d != 0){
                num = num*10 + d;
                sum += d;
            }
            n = n / 10;
        }
        while(num > 0){
            long d = num % 10;
            rev = rev * 10 + d;
            num = num / 10;
        }
        return rev*sum;
    }
}