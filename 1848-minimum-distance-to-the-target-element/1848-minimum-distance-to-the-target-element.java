class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int n = nums.length;
        int dis = n;
        for(int i=0; i<n; i++){
            if(nums[i] == target){
                dis = Math.min(dis, Math.abs(i-start));
            }
        }
        return dis;
    }
}