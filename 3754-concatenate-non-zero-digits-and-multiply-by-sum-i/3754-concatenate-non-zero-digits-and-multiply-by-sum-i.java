class Solution {
    public long sumAndMultiply(int n) {
        long num = 0, sum = 0, d = 1;
        while(n > 0){
            int i = n%10;
            if(i != 0){
                num += i*d; 
                d *= 10; 
            }
            sum += i;
            n /= 10;
        }
        return num*sum;
    }
}