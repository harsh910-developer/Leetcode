class Solution {
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    public int maxLength(int[] nums) {
        int prod = 1, left = 0, best = 2;
        for(int right = 0; right < nums.length; right++){
            int x = nums[right];
            while(gcd(prod, x) > 1){
                prod /= nums[left++];
            }
            prod *= x;
            best = Math.max(best, right - left + 1);
        }
        return best;
    }
}