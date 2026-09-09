class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;
        int max = 0;
        int min = nums[0];
        for(int i=0; i<n; i++){
            set.add(nums[i]);
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        for(int i=min; i<max; i++){
            if(!set.contains(i)){
                ans.add(i);
            }
        }
        return ans;
    }
}