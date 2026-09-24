class Solution {
    public int sumD(int n){
        int o = n;
        int sum = 0;
        while(o != 0){
            int d = o % 10;
            sum += d;
            o /= 10;
        }
        return sum;
    }
    public int smallestIndex(int[] nums) {
        for(int i=0; i<nums.length; i++){
            int n = nums[i];
            if(sumD(n) == i){
                return i;
            }
        }
        return -1;
    }
}