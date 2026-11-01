class Solution {
    public int minMergedInteger(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i+=2){
            String merge = "" + nums[i] + nums[i+1];
            int value = Integer.parseInt(merge);
            min = Math.min(value, min);
        }
        return min;
    }
}