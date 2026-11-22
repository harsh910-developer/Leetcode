class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        if(k == nums.length){
            int maxValue = Integer.MIN_VALUE;
            for(int num : nums){
                maxValue = Math.max(maxValue, num);
            }
            return maxValue;
        }
        if(k == 1){
            int maxValue = -1;
            for(int num : nums){
                if(map.get(num) == 1 && num > maxValue){
                    maxValue = num;
                }
            }
            return maxValue;
        }
        n = n - 1;
        if(nums[0] == nums[n])
            return -1;
        if(map.get(nums[0]) == 1 && map.get(nums[n]) == 1)
            return Math.max(nums[0], nums[n]);
        if(map.get(nums[0]) == 1 && map.get(nums[n]) > 1)
            return nums[0];
        if(map.get(nums[n]) == 1 && map.get(nums[0]) > 1)
            return nums[n];

        return -1;
    }
}