class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); mask++) {
            List<Integer> subset = new ArrayList<>();
            boolean valid = true;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {

                    if (i > 0 && nums[i] == nums[i - 1] && (mask & (1 << (i - 1))) == 0) {

                        valid = false;
                        break;
                    }
                    subset.add(nums[i]);
                }
            }
            if (valid) {
                ans.add(subset);
            }
        }
        return ans;
    }
}