class Solution {
    public boolean checkDivisibility(int n) {
        int o = n;
        int sum = 0;
        int prd = 1;
        while(n != 0){
            int digit = n % 10;
            sum += digit;
            prd *= digit;

            n /= 10;
        }
        return o % (sum+prd) == 0;
    }
}